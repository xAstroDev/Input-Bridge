package com.catfixture.inputbridge.core.service;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.provider.Settings;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.Const;
import com.catfixture.inputbridge.core.GSS.GSS;
import com.catfixture.inputbridge.core.access.TouchEmulatorServic;
import com.catfixture.inputbridge.core.context.ConfigContext;
import com.catfixture.inputbridge.core.debug.D;
import com.catfixture.inputbridge.core.input.data.InputConfigProfile;
import com.catfixture.inputbridge.core.inputbridge.InputBridgeProtocol;
import com.catfixture.inputbridge.core.inputbridge.Marshall;
import com.catfixture.inputbridge.core.localization.Languages;
import com.catfixture.inputbridge.core.overlay.MainControlsOverlayFragment;
import com.catfixture.inputbridge.core.overlay.OverlayManager;
import com.catfixture.inputbridge.core.utils.android.AndroidUtils;
import com.catfixture.inputbridge.core.weakmsg.WeakMsg;
import com.catfixture.inputbridge.ui.activity.main.ErrorH;
import java.util.Arrays;
import java.util.Observable;
import okhttp3.HttpUrl;

public class InputService extends Service {
    public static final int STATE_CONNECTED = 251;
    public static final int STATE_STOPPED = 252;
    public static final int STATE_WAITING_FOR_CONNECTION = 250;
    private final IBinder binder = new LocalBinder();
    private GSS gss;
    private BroadcastReceiver isBrr;
    private Marshall marshall;
    private boolean overlayCreated;
    private OverlayManager overlayManager;
    private int state;

    public OverlayManager GetOverlayManager() {
        return this.overlayManager;
    }

    public IBinder onBind(Intent intent) {
        return this.binder;
    }

    public int GetCurrentState() {
        return this.state;
    }

    private void SetState(int i) {
        this.state = i;
        SendState();
    }

    private void SendState() {
        Intent PrepareMessage = WeakMsg.PrepareMessage(Const.BCAST_ACTION_UPDATE_SERVER_STATE);
        PrepareMessage.putExtra(Const.BCAST_ID_SERVER_STATE, this.state);
        sendBroadcast(PrepareMessage);
    }

    public Marshall GetMarshall() {
        return this.marshall;
    }

    public void TryResetRate() {
        InputConfigProfile GetCurrentProfile;
        if (this.marshall != null && (GetCurrentProfile = ConfigContext.data.GetCurrentProfile()) != null) {
            this.marshall.TryResetPipeRate(GetCurrentProfile.pipeRate);
            this.marshall.TryResetDriverRate(GetCurrentProfile.ibDriverRate);
        }
    }

    public GSS GetGSS() {
        return this.gss;
    }

    public class LocalBinder extends Binder {
        public LocalBinder() {
        }

        public InputService getService() {
            return InputService.this;
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(Languages.CreateLanguageCTXWrapper(context));
    }

    public void EnableProtocol() {
        this.marshall.EnableProtocol();
        TryResetXIEnabledState();
        TrySetFilterActions();
        TrySetForceEvents();
        TryResetRate();
        TrySetMiceState();
    }

    public void DisableProtocol() {
        this.marshall.DisableProtocol();
    }

    public void onCreate() {
        super.onCreate();
        try {
            SetState(STATE_STOPPED);
            this.overlayManager = new OverlayManager(this);
            startForeground(100, new NotificationCompat.Builder((Context) this, Build.VERSION.SDK_INT >= 26 ? AndroidUtils.createNotificationChannel((NotificationManager) getSystemService("notification")) : HttpUrl.FRAGMENT_ENCODE_SET).setOngoing(true).setContentTitle("Input bridge service").setSmallIcon((int) R.drawable.ico_serv).addAction(R.drawable.ico_serv, "STOP", PendingIntent.getBroadcast(this, 100, WeakMsg.PrepareMessage(Const.BCAST_ACTION_STOP_SERVER), 201326592)).setCategory(NotificationCompat.CATEGORY_SERVICE).setPriority(1).build());
            this.isBrr = WeakMsg.CreateListener(getApplicationContext(), new InputService$$ExternalSyntheticLambda0(this));
            TryCreateOverlay();
            RunService();
        } catch (Exception e) {
            D.E((Throwable) e);
            ErrorH.RaiseCrash(this, e.getMessage(), Arrays.toString(e.getStackTrace()));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$0$com-catfixture-inputbridge-core-service-InputService  reason: not valid java name */
    public /* synthetic */ void m109lambda$onCreate$0$comcatfixtureinputbridgecoreserviceInputService(Integer num, Intent intent) {
        if (num.intValue() == 4500) {
            TerminateSelf();
        } else if (num.intValue() == 4506) {
            SendState();
        } else if (num.intValue() == 4507) {
            TerminateServiceOnly();
        } else if (num.intValue() == 4510) {
            this.marshall.ResetConnection();
        } else if (num.intValue() == 4511) {
            this.marshall.SetMiceState(intent.getBooleanExtra("state", false));
        }
    }

    private void TrySetFilterActions() {
        InputConfigProfile GetCurrentProfile;
        if (this.marshall != null && (GetCurrentProfile = ConfigContext.data.GetCurrentProfile()) != null) {
            this.marshall.TrySetFilterActions(GetCurrentProfile.filterActions);
        }
    }

    private void TrySetForceEvents() {
        InputConfigProfile GetCurrentProfile;
        if (this.marshall != null && (GetCurrentProfile = ConfigContext.data.GetCurrentProfile()) != null) {
            this.marshall.TrySetForceEvents(GetCurrentProfile.forceEvents);
        }
    }

    private void TrySetMiceState() {
        InputConfigProfile GetCurrentProfile;
        if (this.marshall != null && (GetCurrentProfile = ConfigContext.data.GetCurrentProfile()) != null) {
            this.marshall.SetMiceState(GetCurrentProfile.miceToggled);
        }
    }

    private void TryResetXIEnabledState() {
        InputConfigProfile GetCurrentProfile;
        if (this.marshall != null && (GetCurrentProfile = ConfigContext.data.GetCurrentProfile()) != null) {
            this.marshall.TryResetXIState(GetCurrentProfile.enableXInput, GetCurrentProfile.enableXInputRumble);
        }
    }

    public void TryCreateOverlay() {
        if (Settings.canDrawOverlays(this) && !this.overlayCreated) {
            this.overlayManager.InitializeWindow();
            this.overlayManager.Add(new MainControlsOverlayFragment(this, this.overlayManager));
            this.overlayManager.SetVisibility(false);
            this.overlayCreated = true;
            D.M("Overlay created!");
        } else if (!this.overlayCreated) {
            D.E("Overlay not created! Not enough rights!");
            TerminateSelf();
        }
    }

    private void RunService() {
        InputConfigProfile GetCurrentProfile = ConfigContext.data.GetCurrentProfile();
        D.M("Input service started!");
        this.marshall = new Marshall(this, InputBridgeProtocol.SERVER_PORT, GetCurrentProfile.pipeRate);
        Handler handler = new Handler();
        this.marshall.onConnected.addObserver(new InputService$$ExternalSyntheticLambda3(this, handler));
        this.marshall.onDisconnected.addObserver(new InputService$$ExternalSyntheticLambda4(this, handler));
        this.gss = new GSS(this, this.overlayManager, GetCurrentProfile);
        D.M("SERVER STARTED!");
        SetState(250);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$RunService$2$com-catfixture-inputbridge-core-service-InputService  reason: not valid java name */
    public /* synthetic */ void m106lambda$RunService$2$comcatfixtureinputbridgecoreserviceInputService(Handler handler, Observable observable, Object obj) {
        handler.post(new InputService$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$RunService$1$com-catfixture-inputbridge-core-service-InputService  reason: not valid java name */
    public /* synthetic */ void m105lambda$RunService$1$comcatfixtureinputbridgecoreserviceInputService() {
        D.M("INPUT BRIDGE SLAVE CONNECTED!");
        HandleConnected();
        TryResetXIEnabledState();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$RunService$4$com-catfixture-inputbridge-core-service-InputService  reason: not valid java name */
    public /* synthetic */ void m108lambda$RunService$4$comcatfixtureinputbridgecoreserviceInputService(Handler handler, Observable observable, Object obj) {
        handler.post(new InputService$$ExternalSyntheticLambda2(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$RunService$3$com-catfixture-inputbridge-core-service-InputService  reason: not valid java name */
    public /* synthetic */ void m107lambda$RunService$3$comcatfixtureinputbridgecoreserviceInputService() {
        D.M("INPUT BRIDGE SLAVE DISCONNECTED!");
        HandleDisconnected();
    }

    private void HandleConnected() {
        SetState(STATE_CONNECTED);
        this.overlayManager.SetVisibility(true);
        this.overlayManager.Show((int) MainControlsOverlayFragment.ID_MAIN_CONTROLS_OVERLAY);
    }

    private void HandleDisconnected() {
        GSS gss2 = this.gss;
        if (gss2 != null) {
            gss2.Reset();
        }
        if (TouchEmulatorServic.HasInstance()) {
            TouchEmulatorServic.GetInstance().Reset();
        }
        SetState(250);
        this.overlayManager.Hide((int) MainControlsOverlayFragment.ID_MAIN_CONTROLS_OVERLAY);
        this.overlayManager.SetVisibility(false);
    }

    private void TerminateSelf() {
        TerminateServiceOnly();
        System.exit(0);
    }

    public void onLowMemory() {
        super.onLowMemory();
        Toast.makeText(this, "Low ram, service will be killed 😈", 1).show();
        TerminateSelf();
    }

    private void TerminateServiceOnly() {
        FreeResources();
        if (Build.VERSION.SDK_INT >= 24) {
            stopForeground(1);
        } else {
            stopSelf();
        }
        stopService(new Intent(getApplicationContext(), InputService.class));
    }

    public void onDestroy() {
        super.onDestroy();
        FreeResources();
    }

    private void FreeResources() {
        OverlayManager overlayManager2 = this.overlayManager;
        if (overlayManager2 != null) {
            overlayManager2.Destroy();
        }
        SetState(STATE_STOPPED);
        Marshall marshall2 = this.marshall;
        if (marshall2 != null) {
            marshall2.Stop();
        }
        GSS gss2 = this.gss;
        if (gss2 != null) {
            gss2.Stop();
        }
        WeakMsg.DestroyListener(this, this.isBrr);
    }
}
