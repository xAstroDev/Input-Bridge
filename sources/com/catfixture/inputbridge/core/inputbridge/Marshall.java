package com.catfixture.inputbridge.core.inputbridge;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Size;
import android.view.WindowManager;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.context.AppContext;
import com.catfixture.inputbridge.core.context.ConfigContext;
import com.catfixture.inputbridge.core.debug.D;
import com.catfixture.inputbridge.core.input.data.InputConfigProfile;
import com.catfixture.inputbridge.core.service.InputService;
import com.catfixture.inputbridge.core.utils.android.AndroidUtils;
import com.catfixture.inputbridge.core.utils.math.Float2;
import com.catfixture.inputbridge.core.utils.types.Event;
import com.catfixture.inputbridge.ui.activity.main.MainActivity;
import com.catfixture.inputbridge.ui.common.interactions.OverlayDialog;
import com.catfixture.inputbridge.ui.utils.Utils;
import java.net.DatagramPacket;
import java.util.ArrayDeque;
import java.util.Observable;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.jvm.internal.ByteCompanionObject;

public class Marshall {
    static final Object globalMutex = new Object();
    private final long MAX_TIME_TO_LEAVE_PIPE = 1000;
    private final Timer activityChecker;
    /* access modifiers changed from: private */
    public boolean constantMouseShiftWasSet;
    /* access modifiers changed from: private */
    public final Float2 currentConstantMouseShift = new Float2(0.0f, 0.0f);
    /* access modifiers changed from: private */
    public final Float2 currentMousePos = new Float2(0.0f, 0.0f);
    /* access modifiers changed from: private */
    public float currentScroll;
    /* access modifiers changed from: private */
    public float currentSens = 1.0f;
    /* access modifiers changed from: private */
    public final IPipe fastpipe;
    private final InputService inputService;
    /* access modifiers changed from: private */
    public boolean isConnected;
    private boolean isPromptAlreadyShown;
    /* access modifiers changed from: private */
    public long lastBindTime;
    /* access modifiers changed from: private */
    public final Float2 lastMousePos = new Float2(0.0f, 0.0f);
    /* access modifiers changed from: private */
    public float lastScroll;
    public final Event onConnected = new Event();
    public final Event onDisconnected = new Event();
    /* access modifiers changed from: private */
    public final Queue<TempEvent> relEventsQueue = new ArrayDeque();
    /* access modifiers changed from: private */
    public int remoteHeight;
    /* access modifiers changed from: private */
    public int remoteWidth;
    private boolean scrollDirty = true;
    /* access modifiers changed from: private */
    public final IPipe xiPipe;
    /* access modifiers changed from: private */
    public XIState xiState = new XIState();

    public Marshall(Context context, int i, int i2) {
        this.inputService = (InputService) context;
        Handler handler = new Handler();
        int ReadVersion = DriverCheck.ReadVersion(context);
        InputConfigProfile GetCurrentProfile = ConfigContext.data.GetCurrentProfile();
        final Size GetRealDisplaySize = AndroidUtils.GetRealDisplaySize((WindowManager) context.getSystemService(WindowManager.class));
        final InputConfigProfile inputConfigProfile = GetCurrentProfile;
        AnonymousClass1 r4 = new FastPipe(i, i2) {
            public void RequestWrite() {
                if (!inputConfigProfile.miceToggled) {
                    Float2 Mul = Marshall.this.currentMousePos.Sub(Marshall.this.lastMousePos).Mul(Marshall.this.currentSens * inputConfigProfile.GetGlobalSensivity());
                    if (Mul.x < -1.0f || Mul.x > 1.0f || Mul.y < -1.0f || Mul.y > 1.0f) {
                        Marshall.this.fastpipe.Write((byte) InputBridgeProtocol.ACTION_MOUSE_SHIFT).Write((int) Mul.x).Write((int) Mul.y);
                        Marshall.this.lastMousePos.Set(Marshall.this.currentMousePos);
                    }
                } else if (inputConfigProfile.isMiceInRelativeMode) {
                    Float2 Mul2 = Marshall.this.currentMousePos.Sub(Marshall.this.lastMousePos).Mul(Marshall.this.currentSens * inputConfigProfile.GetGlobalSensivity());
                    if (Mul2.x < -1.0f || Mul2.x > 1.0f || Mul2.y < -1.0f || Mul2.y > 1.0f) {
                        Marshall.this.fastpipe.Write((byte) InputBridgeProtocol.ACTION_SET_MOUSE_POSITION).Write((int) Mul2.x).Write((int) Mul2.y);
                        Marshall.this.lastMousePos.Set(Marshall.this.currentMousePos);
                    }
                } else {
                    Float2 Sub = Marshall.this.currentMousePos.Sub(Marshall.this.lastMousePos);
                    if (!(Sub.x == 0.0f && Sub.y == 0.0f)) {
                        Float2 float2 = new Float2(Utils.Map(Marshall.this.currentMousePos.x, 0.0f, (float) GetRealDisplaySize.getWidth(), 0.0f, (float) Marshall.this.remoteWidth), Utils.Map(Marshall.this.currentMousePos.y, 0.0f, (float) GetRealDisplaySize.getHeight(), 0.0f, (float) Marshall.this.remoteHeight));
                        Marshall.this.fastpipe.Write((byte) InputBridgeProtocol.ACTION_SET_MOUSE_POSITION).Write((int) float2.x).Write((int) float2.y);
                        Marshall.this.lastMousePos.Set(Marshall.this.currentMousePos);
                    }
                }
                float access$600 = Marshall.this.lastScroll - Marshall.this.currentScroll;
                if (access$600 != 0.0f) {
                    Marshall.this.fastpipe.Write((byte) InputBridgeProtocol.ACTION_SCROLL).Write(access$600);
                    Marshall marshall = Marshall.this;
                    float unused = marshall.lastScroll = marshall.currentScroll;
                }
                if (Marshall.this.constantMouseShiftWasSet) {
                    float GetGlobalSensivity = inputConfigProfile.GetGlobalSensivity();
                    Marshall.this.fastpipe.Write((byte) InputBridgeProtocol.ACTION_CONSTANT_MOUSE_SHIFT).Write(Marshall.this.currentConstantMouseShift.x * GetGlobalSensivity).Write(Marshall.this.currentConstantMouseShift.y * GetGlobalSensivity);
                    boolean unused2 = Marshall.this.constantMouseShiftWasSet = false;
                }
                for (TempEvent tempEvent : Marshall.this.relEventsQueue) {
                    Marshall.this.fastpipe.Write(tempEvent.cmd).Write(tempEvent.data);
                }
                Marshall.this.relEventsQueue.clear();
            }
        };
        this.fastpipe = r4;
        r4.OnAlive().addObserver(new Marshall$$ExternalSyntheticLambda3(this));
        r4.OnDataReceived().addObserver(new Marshall$$ExternalSyntheticLambda4(this, context, handler, ReadVersion));
        r4.Start();
        AnonymousClass2 r12 = new FastPipe(i + 1, i2) {
            public void RequestWrite() {
                if (Marshall.this.xiState.isDirty) {
                    Marshall.this.xiPipe.Write(Marshall.this.xiState);
                    Marshall.this.xiState.Reset();
                }
            }
        };
        this.xiPipe = r12;
        r12.OnDataReceived().addObserver(new Marshall$$ExternalSyntheticLambda5(this, GetCurrentProfile));
        Timer timer = new Timer();
        this.activityChecker = timer;
        timer.schedule(new TimerTask() {
            public void run() {
                if (System.currentTimeMillis() - Marshall.this.lastBindTime > 1000 && Marshall.this.isConnected) {
                    Marshall.this.ResetConnection();
                }
            }
        }, 0, 1000);
        D.M("FAST PIPE RUNNING!");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$com-catfixture-inputbridge-core-inputbridge-Marshall  reason: not valid java name */
    public /* synthetic */ void m92lambda$new$0$comcatfixtureinputbridgecoreinputbridgeMarshall(Observable observable, Object obj) {
        this.lastBindTime = System.currentTimeMillis();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$new$1$com-catfixture-inputbridge-core-inputbridge-Marshall  reason: not valid java name */
    public /* synthetic */ void m93lambda$new$1$comcatfixtureinputbridgecoreinputbridgeMarshall(Context context, Handler handler, int i, Observable observable, Object obj) {
        DatagramPacket datagramPacket = (DatagramPacket) obj;
        byte[] data = datagramPacket.getData();
        if (datagramPacket.getLength() == 12) {
            int BytesArrayToInt = BitUtil.BytesArrayToInt(data);
            this.remoteWidth = BitUtil.BytesArrayToInt(data, 4);
            this.remoteHeight = BitUtil.BytesArrayToInt(data, 8);
            if (!this.isConnected && PromptError(context, handler, i, BytesArrayToInt)) {
                this.onConnected.notifyObservers();
                this.isConnected = true;
            }
        }
        this.lastBindTime = System.currentTimeMillis();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$new$2$com-catfixture-inputbridge-core-inputbridge-Marshall  reason: not valid java name */
    public /* synthetic */ void m94lambda$new$2$comcatfixtureinputbridgecoreinputbridgeMarshall(InputConfigProfile inputConfigProfile, Observable observable, Object obj) {
        int BytesArrayToShortInt;
        try {
            Vibrator vibrator = AppContext.app.vibrator;
            DatagramPacket datagramPacket = (DatagramPacket) obj;
            byte[] data = datagramPacket.getData();
            if (datagramPacket.getLength() == 6) {
                this.inputService.GetGSS().SetFPS((short) BitUtil.BytesArrayToShortInt(data, 0));
                if (inputConfigProfile.enableXInputRumble && vibrator != null && (BytesArrayToShortInt = (int) (((((float) BitUtil.BytesArrayToShortInt(data, 2)) / 65535.0f) * 200.0f) + ((((float) BitUtil.BytesArrayToShortInt(data, 4)) / 65535.0f) * 200.0f))) > 0) {
                    if (Build.VERSION.SDK_INT >= 26) {
                        vibrator.vibrate(VibrationEffect.createOneShot((long) BytesArrayToShortInt, -1));
                    } else {
                        vibrator.vibrate((long) BytesArrayToShortInt);
                    }
                }
            }
        } catch (Exception e) {
            D.E((Throwable) e);
        }
    }

    private boolean PromptError(Context context, Handler handler, int i, int i2) {
        if (this.isPromptAlreadyShown) {
            return false;
        }
        if (i2 == i) {
            return true;
        }
        this.isPromptAlreadyShown = true;
        handler.post(new Marshall$$ExternalSyntheticLambda2(context, i2, i));
        return false;
    }

    static /* synthetic */ void lambda$PromptError$5(Context context, int i, int i2) {
        String str;
        D.E("PROTOCOL VERSION DOESN'T MATCH! REINSTALL NOW!");
        String string = context.getString(R.string.fatal_error);
        if (i != -1) {
            str = context.getString(R.string.service_wrong, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        } else {
            str = context.getString(R.string.ancient_service, new Object[]{Integer.valueOf(i2)});
        }
        OverlayDialog.Show(context, string, str, context.getString(R.string.open_app), new Marshall$$ExternalSyntheticLambda0(context), context.getString(R.string.exit), new Marshall$$ExternalSyntheticLambda1(context));
    }

    static /* synthetic */ void lambda$PromptError$3(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.setFlags(335544320);
        intent.setAction("AutoInstallRun");
        context.startActivity(intent);
    }

    public void SendKeyDownEvent(int i) {
        synchronized (globalMutex) {
            this.relEventsQueue.add(new TempEvent((byte) 10, i));
        }
    }

    public void SendKeyUpEvent(int i) {
        synchronized (globalMutex) {
            this.relEventsQueue.add(new TempEvent(InputBridgeProtocol.ACTION_KEY_UP, i));
        }
    }

    public void SendMouseButtonDownEvent(int i) {
        synchronized (globalMutex) {
            this.relEventsQueue.add(new TempEvent(InputBridgeProtocol.ACTION_MOUSE_DOWN, i));
        }
    }

    public void SendMouseButtonUpEvent(int i) {
        synchronized (globalMutex) {
            this.relEventsQueue.add(new TempEvent(InputBridgeProtocol.ACTION_MOUSE_UP, i));
        }
    }

    public void Stop() {
        this.fastpipe.Stop();
        this.xiPipe.Stop();
        Timer timer = this.activityChecker;
        if (timer != null) {
            timer.cancel();
            this.activityChecker.purge();
        }
    }

    public void EnableProtocol() {
        this.fastpipe.Write((byte) InputBridgeProtocol.PROTOCOL_ENABLE);
        this.xiPipe.Start();
    }

    public void DisableProtocol() {
        this.fastpipe.Write((byte) InputBridgeProtocol.PROTOCOL_DISABLE);
        this.xiPipe.Stop();
    }

    public void AddMouseShift(float f, float f2) {
        synchronized (globalMutex) {
            this.currentMousePos.x += f;
            this.currentMousePos.y += f2;
        }
    }

    public void SetMousePos(float f, float f2, float f3) {
        synchronized (globalMutex) {
            this.currentMousePos.Set(f, f2);
            this.currentSens = f3;
        }
    }

    public void AddScroll(float f) {
        synchronized (globalMutex) {
            this.currentScroll += f;
        }
    }

    public void SetScroll(float f) {
        synchronized (globalMutex) {
            if (this.scrollDirty) {
                this.lastScroll = f;
                this.scrollDirty = false;
            }
            this.currentScroll = f;
        }
    }

    public void SetScrollDirty() {
        synchronized (globalMutex) {
            this.scrollDirty = true;
        }
    }

    public void SetConstantMouseShiftEvent(float f, float f2) {
        synchronized (globalMutex) {
            if (this.currentConstantMouseShift.x != 0.0f) {
                this.currentConstantMouseShift.x += f;
            }
            this.currentConstantMouseShift.Set(f, f2);
            this.constantMouseShiftWasSet = true;
        }
    }

    public void SendXIKeyDownEvent(int i) {
        XIState xIState = this.xiState;
        xIState.buttons = (short) (i | xIState.buttons);
        this.xiState.SetDirty();
    }

    public void SendXIKeyUpEvent(int i) {
        XIState xIState = this.xiState;
        xIState.buttons = (short) ((~i) & xIState.buttons);
        this.xiState.SetDirty();
    }

    public void TryResetPipeRate(int i) {
        synchronized (globalMutex) {
            this.fastpipe.SetTargetRate(i);
        }
    }

    public void TryResetDriverRate(int i) {
        synchronized (globalMutex) {
            this.fastpipe.Write((byte) InputBridgeProtocol.PROTOCOL_SET_TARGET_DRIVER_RATE).Write(i);
        }
    }

    public void ResetConnection() {
        this.onDisconnected.notifyObservers();
        this.isConnected = false;
    }

    public void SetXIStick(int i, Float2 float2) {
        if (i == 0) {
            this.xiState.thumbLX = (short) ((int) (float2.x * 32767.0f));
            this.xiState.thumbLY = (short) ((int) ((-float2.y) * 32767.0f));
        } else if (i == 1) {
            this.xiState.thumbRX = (short) ((int) (float2.x * 32767.0f));
            this.xiState.thumbRY = (short) ((int) ((-float2.y) * 32767.0f));
        }
        this.xiState.SetDirty();
    }

    public void SetXILeftTriggerDig(float f) {
        this.xiState.leftTrigger = f > 0.0f ? ByteCompanionObject.MAX_VALUE : 0;
        this.xiState.SetDirty();
    }

    public void SetXIRightTriggerDig(float f) {
        this.xiState.rightTrigger = f > 0.0f ? ByteCompanionObject.MAX_VALUE : 0;
        this.xiState.SetDirty();
    }

    public void SetXILeftTrigger(float f) {
        this.xiState.leftTrigger = (byte) ((int) (f * 127.0f));
        this.xiState.SetDirty();
    }

    public void SetXIRightTrigger(float f) {
        this.xiState.rightTrigger = (byte) ((int) (f * 127.0f));
        this.xiState.SetDirty();
    }

    public void TryResetXIState(boolean z, boolean z2) {
        synchronized (globalMutex) {
            int i = 1;
            IPipe Write = this.fastpipe.Write((byte) InputBridgeProtocol.PROTOCOL_SET_XINPUT_ENABLED_STATE).Write((byte) (z ? 1 : 0));
            if (!z2) {
                i = 0;
            }
            Write.Write((byte) i);
        }
    }

    public void TrySetFilterActions(boolean z) {
        this.fastpipe.Write((byte) InputBridgeProtocol.PROTOCOL_SET_FILTER_ACIONS).Write(z ? (byte) 1 : 0);
    }

    public void TrySetForceEvents(boolean z) {
        this.fastpipe.Write((byte) InputBridgeProtocol.PROTOCOL_SET_FORCE_EVENTS).Write(z ? (byte) 1 : 0);
    }

    public void SetMiceState(boolean z) {
        this.fastpipe.Write((byte) InputBridgeProtocol.PROTOCOL_SET_MICE_CONTROL_STATE).Write(z ? (byte) 1 : 0);
    }

    public void ResetMousePos(float f, float f2) {
        synchronized (globalMutex) {
            this.currentMousePos.Set(f, f2);
            this.lastMousePos.Set(f, f2);
        }
    }
}
