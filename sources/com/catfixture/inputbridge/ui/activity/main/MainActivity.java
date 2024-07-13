package com.catfixture.inputbridge.ui.activity.main;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.Settings;
import android.util.Size;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import com.catfixture.inputbridge.BuildConfig;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.Const;
import com.catfixture.inputbridge.core.context.AppContext;
import com.catfixture.inputbridge.core.context.ConfigContext;
import com.catfixture.inputbridge.core.debug.D;
import com.catfixture.inputbridge.core.debug.logging.GlobalExceptions;
import com.catfixture.inputbridge.core.input.codes.KeyCodes;
import com.catfixture.inputbridge.core.input.codes.MouseCodes;
import com.catfixture.inputbridge.core.input.codes.XInputCodes;
import com.catfixture.inputbridge.core.input.core.IKeyEventProvider;
import com.catfixture.inputbridge.core.input.core.IMotionEventProvider;
import com.catfixture.inputbridge.core.input.data.InputConfigData;
import com.catfixture.inputbridge.core.input.data.InputConfigProfile;
import com.catfixture.inputbridge.core.localization.Languages;
import com.catfixture.inputbridge.core.service.InputService;
import com.catfixture.inputbridge.core.updates.Updater;
import com.catfixture.inputbridge.core.utils.android.AndroidUtils;
import com.catfixture.inputbridge.core.utils.android.IActivityLaunchable;
import com.catfixture.inputbridge.core.utils.android.IPermissionGrantable;
import com.catfixture.inputbridge.core.utils.android.ISuspendable;
import com.catfixture.inputbridge.core.utils.datetime.DateTimeUtils;
import com.catfixture.inputbridge.core.utils.files.FileUtils;
import com.catfixture.inputbridge.core.utils.files.IFileAccessAbstraction;
import com.catfixture.inputbridge.core.utils.math.Int2;
import com.catfixture.inputbridge.core.utils.types.AutoResetEvent;
import com.catfixture.inputbridge.core.utils.types.Event;
import com.catfixture.inputbridge.core.utils.types.delegates.Action;
import com.catfixture.inputbridge.core.weakmsg.WeakMsg;
import com.catfixture.inputbridge.ui.activity.main.tabs.MainActivityTabs;
import com.catfixture.inputbridge.ui.common.interactions.ConfirmDialog;
import com.catfixture.inputbridge.ui.common.interactions.InputDialog;
import com.catfixture.inputbridge.ui.utils.GsonUtils;
import com.catfixture.inputbridge.ui.utils.ProfileUtils;
import com.catfixture.inputbridge.ui.utils.Utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements IPermissionGrantable, IActivityLaunchable, IKeyEventProvider, IMotionEventProvider, ISuspendable {
    private View cont;
    private View duplicProf;
    private View editProfileName;
    private Button exportProf;
    private boolean isInflatedOnce;
    private ActivityResultLauncher<Intent> launchSomeActivity;
    private View noProfilesErr;
    private final Event onKey = new Event();
    private final Event onMotion = new Event();
    private Action<ActivityResult> onResult;
    private final AutoResetEvent onSuspend = new AutoResetEvent();
    private ArrayAdapter<String> profilesAdapter;
    Spinner profilesSpinner;
    private Button removeProfile;
    private ViewGroup root;
    private TextView serviceStatusText;
    private Button shareProfile;
    private BroadcastReceiver statusBRR;
    private MainActivityTabs tabsController;

    static /* synthetic */ void lambda$InflateActivity$12() {
    }

    static /* synthetic */ void lambda$InflateActivity$16() {
    }

    static /* synthetic */ void lambda$InflateActivity$18() {
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(Languages.CreateLanguageCTXWrapper(context));
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.launchSomeActivity = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new MainActivity$$ExternalSyntheticLambda23(this));
        if (!Settings.canDrawOverlays(this)) {
            Launch(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + getPackageName())), new MainActivity$$ExternalSyntheticLambda1(this));
        } else {
            InflateActivity();
        }
        if (AppContext.cache.iconManager.iconPacks.size() == 0) {
            AppContext.cache.iconManager.LookupAllIconPacks(this);
        }
        RedirectIntent(getIntent());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$0$com-catfixture-inputbridge-ui-activity-main-MainActivity  reason: not valid java name */
    public /* synthetic */ void m201lambda$onCreate$0$comcatfixtureinputbridgeuiactivitymainMainActivity(ActivityResult activityResult) {
        Action<ActivityResult> action = this.onResult;
        if (action != null) {
            action.Invoke(activityResult);
        } else {
            InflateActivity();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$1$com-catfixture-inputbridge-ui-activity-main-MainActivity  reason: not valid java name */
    public /* synthetic */ void m202lambda$onCreate$1$comcatfixtureinputbridgeuiactivitymainMainActivity(ActivityResult activityResult) {
        InflateActivity();
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        RedirectIntent(intent);
    }

    private void InflateActivity() {
        int intExtra;
        ViewGroup viewGroup = (ViewGroup) View.inflate(this, R.layout.activity_main, (ViewGroup) null);
        this.root = viewGroup;
        setContentView((View) viewGroup);
        this.serviceStatusText = (TextView) this.root.findViewById(R.id.serviceStatus);
        SetCurrentServiceState(InputService.STATE_STOPPED);
        if (getResources().getConfiguration().orientation == 1) {
            ((TextView) this.root.findViewById(R.id.mainAppLabel)).setText(getString(R.string.input_bridge_v_text) + BuildConfig.VERSION_NAME);
        }
        Spinner spinner = (Spinner) this.root.findViewById(R.id.inputProfiles);
        this.profilesSpinner = spinner;
        this.profilesAdapter = Utils.InitSpinner(this, spinner, ConfigContext.data.currentProfile, R.layout.basic_spinner_item);
        Utils.AttachSpinnerAction(this.profilesSpinner, new MainActivity$$ExternalSyntheticLambda4(this));
        ((Button) this.root.findViewById(R.id.addProfile)).setOnClickListener(new MainActivity$$ExternalSyntheticLambda19(this));
        Button button = (Button) this.root.findViewById(R.id.removeProfile);
        this.removeProfile = button;
        button.setOnClickListener(new MainActivity$$ExternalSyntheticLambda20(this));
        View findViewById = this.root.findViewById(R.id.editProfileName);
        this.editProfileName = findViewById;
        findViewById.setOnClickListener(new MainActivity$$ExternalSyntheticLambda21(this));
        Button button2 = (Button) this.root.findViewById(R.id.shareProfile);
        this.shareProfile = button2;
        button2.setOnClickListener(new MainActivity$$ExternalSyntheticLambda22(this));
        this.noProfilesErr = this.root.findViewById(R.id.noProfilesErr);
        this.cont = this.root.findViewById(R.id.cont);
        this.exportProf = (Button) this.root.findViewById(R.id.exportProf);
        this.duplicProf = this.root.findViewById(R.id.dublikProf);
        ((Button) this.root.findViewById(R.id.importProf)).setOnClickListener(new MainActivity$$ExternalSyntheticLambda0(this));
        this.exportProf.setOnClickListener(new MainActivity$$ExternalSyntheticLambda11(this));
        this.duplicProf.setOnClickListener(new MainActivity$$ExternalSyntheticLambda18(this));
        InflateProfiles();
        this.tabsController = new MainActivityTabs(this, this.root);
        this.statusBRR = WeakMsg.CreateListener(this, new MainActivity$$ExternalSyntheticLambda24(this));
        if (ConfigContext.data.autoCheckUpdates) {
            long time = Calendar.getInstance().getTime().getTime();
            if (DateTimeUtils.LongToMinutes(time - ConfigContext.data.appLaunchedDateTime) >= 2880) {
                ConfigContext.data.SetAppLaunchedDate(time);
                Updater updater = new Updater();
                updater.CheckUpdatesAvailable(this, new MainActivity$$ExternalSyntheticLambda7(this, updater), (Runnable) null);
            }
        }
        this.isInflatedOnce = true;
        Intent intent = getIntent();
        if (intent != null && (intExtra = intent.getIntExtra("SetTab", -1)) != -1) {
            this.tabsController.SetTab(intExtra);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$InflateActivity$2$com-catfixture-inputbridge-ui-activity-main-MainActivity  reason: not valid java name */
    public /* synthetic */ void m191lambda$InflateActivity$2$comcatfixtureinputbridgeuiactivitymainMainActivity(Integer num) {
        ConfigContext.data.SetCurrentProfile(num.intValue());
        InflateProfiles();
        this.tabsController.OnResume();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$InflateActivity$4$com-catfixture-inputbridge-ui-activity-main-MainActivity  reason: not valid java name */
    public /* synthetic */ void m195lambda$InflateActivity$4$comcatfixtureinputbridgeuiactivitymainMainActivity(View view) {
        ConfirmDialog.Show(this, getString(R.string.create_profile), getString(R.string.create_profile_text), getString(R.string.yes_text), new MainActivity$$ExternalSyntheticLambda12(this), getString(R.string.no_text), (Runnable) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$InflateActivity$3$com-catfixture-inputbridge-ui-activity-main-MainActivity  reason: not valid java name */
    public /* synthetic */ void m194lambda$InflateActivity$3$comcatfixtureinputbridgeuiactivitymainMainActivity() {
        InputConfigData inputConfigData = ConfigContext.data;
        InputConfigProfile inputConfigProfile = new InputConfigProfile();
        StringBuilder sb = new StringBuilder();
        sb.append(getString(R.string.defaultProfileName));
        sb.append(" ");
        int i = inputConfigData.internalProfileID;
        inputConfigData.internalProfileID = i + 1;
        sb.append(i);
        inputConfigProfile.name = sb.toString();
        Size GetRealDisplaySize = AndroidUtils.GetRealDisplaySize(getWindowManager());
        inputConfigProfile.SetRefResolution(new Int2(GetRealDisplaySize.getWidth(), GetRealDisplaySize.getHeight()));
        inputConfigData.AddProfile(inputConfigProfile);
        inputConfigData.SetCurrentProfile(inputConfigData.profiles.size() - 1);
        this.profilesSpinner.setSelection(inputConfigData.currentProfile);
        InflateProfiles();
        if (inputConfigData.profiles.size() == 1) {
            BindService();
            InflateActivity();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$InflateActivity$6$com-catfixture-inputbridge-ui-activity-main-MainActivity  reason: not valid java name */
    public /* synthetic */ void m197lambda$InflateActivity$6$comcatfixtureinputbridgeuiactivitymainMainActivity(View view) {
        ConfirmDialog.Show(this, getString(R.string.remove_profile), getString(R.string.remove_profile_confirm), getString(R.string.yes_text), new MainActivity$$ExternalSyntheticLambda13(this), getString(R.string.no_text), (Runnable) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$InflateActivity$5$com-catfixture-inputbridge-ui-activity-main-MainActivity  reason: not valid java name */
    public /* synthetic */ void m196lambda$InflateActivity$5$comcatfixtureinputbridgeuiactivitymainMainActivity() {
        InputConfigData inputConfigData = ConfigContext.data;
        inputConfigData.RemoveCurrentProfile();
        InflateProfiles();
        if (inputConfigData.profiles.size() == 0) {
            WeakMsg.Send((Context) this, (int) Const.BCAST_ACTION_STOP_SERVICE_ONLY);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$InflateActivity$8$com-catfixture-inputbridge-ui-activity-main-MainActivity  reason: not valid java name */
    public /* synthetic */ void m199lambda$InflateActivity$8$comcatfixtureinputbridgeuiactivitymainMainActivity(View view) {
        InputDialog.Show(this, getString(R.string.edit_name), ConfigContext.data.GetCurrentProfile().name, getString(R.string.save), new MainActivity$$ExternalSyntheticLambda5(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$InflateActivity$7$com-catfixture-inputbridge-ui-activity-main-MainActivity  reason: not valid java name */
    public /* synthetic */ void m198lambda$InflateActivity$7$comcatfixtureinputbridgeuiactivitymainMainActivity(String str) {
        ConfigContext.data.GetCurrentProfile().SetName(str);
        InflateProfiles();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$InflateActivity$9$com-catfixture-inputbridge-ui-activity-main-MainActivity  reason: not valid java name */
    public /* synthetic */ void m200lambda$InflateActivity$9$comcatfixtureinputbridgeuiactivitymainMainActivity(View view) {
        InputConfigProfile GetCurrentProfile = ConfigContext.data.GetCurrentProfile();
        Intent intent = new Intent("android.intent.action.SEND");
        File file = new File(Environment.getExternalStorageDirectory() + "/" + ConfigContext.data.appFolder + "/InputBridge/Profiles/" + GetCurrentProfile.name + ".ibp");
        intent.setFlags(1);
        if (file.exists()) {
            Context applicationContext = getApplicationContext();
            Objects.requireNonNull(applicationContext);
            Context context = applicationContext;
            Uri uriForFile = FileProvider.getUriForFile(applicationContext, "com.catfixture.inputbridge.provider", file);
            intent.setType("*/*");
            intent.putExtra("android.intent.extra.STREAM", uriForFile);
            startActivity(intent);
            return;
        }
        ConfirmDialog.Show(this, getString(R.string.error_text), getString(R.string.profile_share_error_text), getString(R.string.close_text), (Runnable) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$InflateActivity$11$com-catfixture-inputbridge-ui-activity-main-MainActivity  reason: not valid java name */
    public /* synthetic */ void m185lambda$InflateActivity$11$comcatfixtureinputbridgeuiactivitymainMainActivity(View view) {
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        if (Build.VERSION.SDK_INT >= 26) {
            intent.putExtra("android.provider.extra.INITIAL_URI", Uri.parse(Environment.getExternalStorageDirectory() + "/" + ConfigContext.data.appFolder));
        }
        Launch(intent, new MainActivity$$ExternalSyntheticLambda25(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$InflateActivity$10$com-catfixture-inputbridge-ui-activity-main-MainActivity  reason: not valid java name */
    public /* synthetic */ void m184lambda$InflateActivity$10$comcatfixtureinputbridgeuiactivitymainMainActivity(ActivityResult activityResult) {
        Uri data;
        Intent data2 = activityResult.getData();
        if (data2 != null && (data = data2.getData()) != null) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getContentResolver().openInputStream(data)));
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb.append(readLine);
                    } else {
                        bufferedReader.close();
                        ImportProfile(sb.toString());
                        return;
                    }
                }
            } catch (Exception e) {
                D.E((Throwable) e);
                ConfirmDialog.Show(this, getString(R.string.error_text), getString(R.string.sel_only_ext_err), getString(R.string.close_text), (Runnable) null);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$InflateActivity$15$com-catfixture-inputbridge-ui-activity-main-MainActivity  reason: not valid java name */
    public /* synthetic */ void m188lambda$InflateActivity$15$comcatfixtureinputbridgeuiactivitymainMainActivity(View view) {
        try {
            InputConfigProfile GetCurrentProfile = ConfigContext.data.GetCurrentProfile();
            String json = GsonUtils.Create().toJson((Object) GetCurrentProfile);
            FileUtils.RequestFolderAccess(this, Uri.parse(Environment.getExternalStorageDirectory() + "/" + ConfigContext.data.appFolder), new MainActivity$$ExternalSyntheticLambda6(this, GetCurrentProfile, json), new MainActivity$$ExternalSyntheticLambda9(this));
        } catch (Exception e) {
            D.E((Throwable) e);
            String string = getString(R.string.error_text);
            ConfirmDialog.Show(this, string, getString(R.string.err_occur) + e.getStackTrace().toString());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$InflateActivity$13$com-catfixture-inputbridge-ui-activity-main-MainActivity  reason: not valid java name */
    public /* synthetic */ void m186lambda$InflateActivity$13$comcatfixtureinputbridgeuiactivitymainMainActivity(InputConfigProfile inputConfigProfile, String str, IFileAccessAbstraction iFileAccessAbstraction) {
        if (!ConfigContext.data.appFolder.equals(iFileAccessAbstraction.GetEndSegment())) {
            ConfirmDialog.Show(this, getString(R.string.error_text), getString(R.string.error_use_only_downloads, new Object[]{ConfigContext.data.appFolder}), getString(R.string.close_text), (Runnable) null);
            return;
        }
        IFileAccessAbstraction CreateDir = iFileAccessAbstraction.CreateDir("InputBridge").CreateDir("Profiles");
        CreateDir.Write(inputConfigProfile.name + ".ibp", str.getBytes(StandardCharsets.UTF_8));
        String string = getString(R.string.done_text);
        ConfirmDialog.Show(this, string, getString(R.string.prof_saved_text, new Object[]{ConfigContext.data.appFolder + "/InputBridge/Profiles"}), getString(R.string.close_text), MainActivity$$ExternalSyntheticLambda15.INSTANCE);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$InflateActivity$14$com-catfixture-inputbridge-ui-activity-main-MainActivity  reason: not valid java name */
    public /* synthetic */ void m187lambda$InflateActivity$14$comcatfixtureinputbridgeuiactivitymainMainActivity() {
        ConfirmDialog.Show(this, getString(R.string.error_text), getString(R.string.permissions_not_granted_text));
        D.E("CANT GET PERMS FOR FILE");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$InflateActivity$19$com-catfixture-inputbridge-ui-activity-main-MainActivity  reason: not valid java name */
    public /* synthetic */ void m190lambda$InflateActivity$19$comcatfixtureinputbridgeuiactivitymainMainActivity(View view) {
        ConfirmDialog.Show(this, getString(R.string.duplicateTxt), getString(R.string.duplic_crea_text), getString(R.string.yes_text), new MainActivity$$ExternalSyntheticLambda10(this), getString(R.string.no_text), MainActivity$$ExternalSyntheticLambda17.INSTANCE);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$InflateActivity$17$com-catfixture-inputbridge-ui-activity-main-MainActivity  reason: not valid java name */
    public /* synthetic */ void m189lambda$InflateActivity$17$comcatfixtureinputbridgeuiactivitymainMainActivity() {
        InputConfigData inputConfigData = ConfigContext.data;
        try {
            InputConfigProfile inputConfigProfile = (InputConfigProfile) AndroidUtils.DeepClone(inputConfigData.GetCurrentProfile(), InputConfigProfile.class);
            inputConfigProfile.name += getString(R.string.clone_text);
            inputConfigData.AddProfile(inputConfigProfile);
            inputConfigData.SetCurrentProfile(inputConfigData.profiles.size() - 1);
            this.profilesSpinner.setSelection(inputConfigData.currentProfile);
            InflateProfiles();
            ConfirmDialog.Show(this, getString(R.string.done_text), getString(R.string.duplic_done_text), getString(R.string.close_text), MainActivity$$ExternalSyntheticLambda16.INSTANCE);
        } catch (Exception e) {
            D.E((Throwable) e);
            ConfirmDialog.Show(this, getString(R.string.error_text), getString(R.string.err_occur) + e.getStackTrace().toString());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$InflateActivity$20$com-catfixture-inputbridge-ui-activity-main-MainActivity  reason: not valid java name */
    public /* synthetic */ void m192lambda$InflateActivity$20$comcatfixtureinputbridgeuiactivitymainMainActivity(Integer num, Intent intent) {
        if (num.intValue() == 4505) {
            SetCurrentServiceState(intent.getIntExtra(Const.BCAST_ID_SERVER_STATE, InputService.STATE_STOPPED));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$InflateActivity$21$com-catfixture-inputbridge-ui-activity-main-MainActivity  reason: not valid java name */
    public /* synthetic */ void m193lambda$InflateActivity$21$comcatfixtureinputbridgeuiactivitymainMainActivity(Updater updater, Boolean bool) {
        if (bool.booleanValue()) {
            updater.Update(this, (Runnable) null);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        InputConfigData inputConfigData = ConfigContext.data;
        if (Settings.canDrawOverlays(this) && inputConfigData.HasCurrentProfile()) {
            if (!this.isInflatedOnce) {
                InflateActivity();
            }
            BindService();
            this.tabsController.OnResume();
            D.M("Activity created!");
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        D.M("Activity destroyed!");
        MainActivityTabs mainActivityTabs = this.tabsController;
        if (mainActivityTabs != null) {
            mainActivityTabs.OnDestroy();
        }
        WeakMsg.DestroyListener(this, this.statusBRR);
    }

    private void InflateProfiles() {
        InputConfigData inputConfigData = ConfigContext.data;
        int i = inputConfigData.profiles.size() > 0 ? 0 : 8;
        this.editProfileName.setVisibility(i);
        this.removeProfile.setVisibility(i);
        this.duplicProf.setVisibility(i);
        this.exportProf.setVisibility(i);
        this.shareProfile.setVisibility(i);
        this.profilesAdapter.clear();
        for (InputConfigProfile GetName : inputConfigData.profiles) {
            this.profilesAdapter.add(GetName.GetName());
        }
        this.profilesAdapter.notifyDataSetChanged();
        ToggleCont();
    }

    private void ToggleCont() {
        boolean HasCurrentProfile = ConfigContext.data.HasCurrentProfile();
        int i = 8;
        this.noProfilesErr.setVisibility(HasCurrentProfile ? 8 : 0);
        View view = this.cont;
        if (HasCurrentProfile) {
            i = 0;
        }
        view.setVisibility(i);
    }

    public void BindService() {
        Handler handler = new Handler();
        MouseCodes.Load(this);
        XInputCodes.Load(this);
        KeyCodes.LoadKeyCodes(this);
        GlobalExceptions.Init(this);
        D.M("Application created");
        Intent intent = new Intent(this, InputService.class);
        if (Build.VERSION.SDK_INT >= 26) {
            startForegroundService(intent);
        } else {
            startService(intent);
        }
        handler.postDelayed(new MainActivity$$ExternalSyntheticLambda8(this), 200);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$BindService$22$com-catfixture-inputbridge-ui-activity-main-MainActivity  reason: not valid java name */
    public /* synthetic */ void m180lambda$BindService$22$comcatfixtureinputbridgeuiactivitymainMainActivity() {
        WeakMsg.Send((Context) this, (int) Const.BCAST_ACTION_REQUEST_SERVER_STATE);
    }

    private void SetCurrentServiceState(int i) {
        switch (i) {
            case 250:
                this.serviceStatusText.setText("🔵");
                return;
            case InputService.STATE_CONNECTED:
                this.serviceStatusText.setText("🟢");
                return;
            case InputService.STATE_STOPPED:
                this.serviceStatusText.setText("🔴");
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1457) {
            onGranted.notifyObservers(Integer.valueOf(i2));
        } else {
            onResume();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 1457 && iArr.length > 0) {
            onGranted.notifyObservers(Integer.valueOf(iArr[0]));
        }
    }

    public void Launch(Intent intent, Action<ActivityResult> action) {
        this.onResult = action;
        this.launchSomeActivity.launch(intent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        this.onKey.notifyObservers(keyEvent);
        if (keyEvent.getKeyCode() == 4) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        this.onMotion.notifyObservers(motionEvent);
        return super.dispatchGenericMotionEvent(motionEvent);
    }

    public Event OnKey() {
        return this.onKey;
    }

    public Event OnMotion() {
        return this.onMotion;
    }

    public AutoResetEvent OnSuspend() {
        return this.onSuspend;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.onSuspend.notifyObservers();
    }

    private void RedirectIntent(Intent intent) {
        if (intent != null) {
            if (intent.hasExtra(Const.IEXTRA_IMPORT_PROFILE)) {
                CheckImport(intent);
                return;
            }
            Uri data = intent.getData();
            if (data != null) {
                try {
                    String ReadUri = FileUtils.ReadUri(this, data);
                    finish();
                    Intent intent2 = new Intent(this, MainActivity.class);
                    intent2.putExtra(Const.IEXTRA_IMPORT_PROFILE, ReadUri);
                    intent2.setFlags(32768);
                    startActivity(intent2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void CheckImport(Intent intent) {
        if (intent != null && intent.hasExtra(Const.IEXTRA_IMPORT_PROFILE)) {
            ConfirmDialog.Show(this, getString(R.string.load_profile_text), getString(R.string.load_profile_question_text), getString(R.string.ok), new MainActivity$$ExternalSyntheticLambda14(this, intent), getString(R.string.close_text), (Runnable) null);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$CheckImport$23$com-catfixture-inputbridge-ui-activity-main-MainActivity  reason: not valid java name */
    public /* synthetic */ void m181lambda$CheckImport$23$comcatfixtureinputbridgeuiactivitymainMainActivity(Intent intent) {
        ImportProfile(intent.getStringExtra(Const.IEXTRA_IMPORT_PROFILE));
    }

    private void ImportProfile(String str) {
        ProfileUtils.ImportProfile(str, new MainActivity$$ExternalSyntheticLambda2(this), new MainActivity$$ExternalSyntheticLambda3(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$ImportProfile$24$com-catfixture-inputbridge-ui-activity-main-MainActivity  reason: not valid java name */
    public /* synthetic */ void m182lambda$ImportProfile$24$comcatfixtureinputbridgeuiactivitymainMainActivity(InputConfigData inputConfigData) {
        this.profilesSpinner.setSelection(inputConfigData.currentProfile);
        InflateProfiles();
        ConfirmDialog.Show(this, getString(R.string.done_text), getString(R.string.prof_import_suc), getString(R.string.close_text), (Runnable) null);
        if (inputConfigData.profiles.size() == 1) {
            BindService();
            InflateActivity();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$ImportProfile$25$com-catfixture-inputbridge-ui-activity-main-MainActivity  reason: not valid java name */
    public /* synthetic */ void m183lambda$ImportProfile$25$comcatfixtureinputbridgeuiactivitymainMainActivity(Exception exc) {
        ErrorH.RaiseCrash(this, exc.getMessage(), Arrays.toString(exc.getStackTrace()));
        ConfirmDialog.Show(this, getString(R.string.error_text), getString(R.string.import_profile_error_text), getString(R.string.close_text), (Runnable) null);
    }
}
