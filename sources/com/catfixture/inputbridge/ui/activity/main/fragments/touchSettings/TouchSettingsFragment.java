package com.catfixture.inputbridge.ui.activity.main.fragments.touchSettings;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.context.ConfigContext;
import com.catfixture.inputbridge.core.input.data.InputConfigData;
import com.catfixture.inputbridge.core.input.data.InputConfigProfile;
import com.catfixture.inputbridge.core.input.data.InputTouchControlElementData;
import com.catfixture.inputbridge.core.utils.android.AndroidUtils;
import com.catfixture.inputbridge.core.utils.android.IActivityLaunchable;
import com.catfixture.inputbridge.core.utils.math.Int2;
import com.catfixture.inputbridge.core.utils.types.delegates.Action;
import com.catfixture.inputbridge.ui.common.interactions.ConfirmDialog;
import com.catfixture.inputbridge.ui.tabs.DefaultTabFragment;
import com.catfixture.inputbridge.ui.utils.Utils;
import java.util.Objects;

public class TouchSettingsFragment extends DefaultTabFragment {
    private CheckBox icHidePanels;
    private CheckBox icMaximize;
    private Spinner icTypeSpinner;
    private View root;

    public void OnDestroy() {
    }

    public TouchSettingsFragment(Activity activity) {
        super(activity);
    }

    private void ReinflateAll() {
        InputConfigData inputConfigData = ConfigContext.data;
        if (inputConfigData.HasCurrentProfile()) {
            Context GetContext = GetContext();
            InputConfigProfile GetCurrentProfile = inputConfigData.GetCurrentProfile();
            CheckBox checkBox = (CheckBox) this.root.findViewById(R.id.showControlsWhenConnected);
            checkBox.setOnCheckedChangeListener(new TouchSettingsFragment$$ExternalSyntheticLambda11(GetCurrentProfile));
            checkBox.setChecked(GetCurrentProfile.showControlsWhenConnected);
            CheckBox checkBox2 = (CheckBox) this.root.findViewById(R.id.hideTouchControls);
            checkBox2.setOnCheckedChangeListener(new TouchSettingsFragment$$ExternalSyntheticLambda12(GetCurrentProfile));
            checkBox2.setChecked(GetCurrentProfile.touchControlsHidden);
            this.icTypeSpinner = (Spinner) this.root.findViewById(R.id.integrateControlsType);
            this.icMaximize = (CheckBox) this.root.findViewById(R.id.icMaximize);
            this.icHidePanels = (CheckBox) this.root.findViewById(R.id.icHidePanels);
            CheckBox checkBox3 = (CheckBox) this.root.findViewById(R.id.integrateControls);
            boolean z = false;
            ArrayAdapter InitSpinner = Utils.InitSpinner(GetContext, this.icTypeSpinner, 0, R.layout.basic_spinner_item);
            InitSpinner.addAll(new String[]{GetContext.getString(R.string.integrate_controls_type_default), GetContext.getString(R.string.integrate_controls_type_nondef)});
            InitSpinner.notifyDataSetChanged();
            this.icTypeSpinner.setSelection(GetCurrentProfile.integrateControlsType);
            Spinner spinner = this.icTypeSpinner;
            Objects.requireNonNull(GetCurrentProfile);
            Utils.AttachSpinnerAction(spinner, new TouchSettingsFragment$$ExternalSyntheticLambda3(GetCurrentProfile));
            CheckBox checkBox4 = (CheckBox) this.root.findViewById(R.id.enableTouchRumble);
            checkBox4.setChecked(GetCurrentProfile.enableTouchRumble);
            checkBox4.setOnCheckedChangeListener(new TouchSettingsFragment$$ExternalSyntheticLambda17(this, GetCurrentProfile));
            ToggleTouchRumbleCont(GetCurrentProfile.enableTouchRumble);
            Utils.InitSeekBar((SeekBar) this.root.findViewById(R.id.rumbleImputusTime), (TextView) this.root.findViewById(R.id.rumbleImputusTimeLabel), GetCurrentProfile.touchRumbleImpetusTime, new TouchSettingsFragment$$ExternalSyntheticLambda4(GetCurrentProfile));
            CheckBox checkBox5 = (CheckBox) this.root.findViewById(R.id.enableXInput);
            checkBox5.setChecked(GetCurrentProfile.enableXInput);
            checkBox5.setOnCheckedChangeListener(new TouchSettingsFragment$$ExternalSyntheticLambda1(this, GetCurrentProfile));
            CheckBox checkBox6 = (CheckBox) this.root.findViewById(R.id.enableXInputRumble);
            checkBox6.setChecked(GetCurrentProfile.enableXInputRumble);
            checkBox6.setOnCheckedChangeListener(new TouchSettingsFragment$$ExternalSyntheticLambda15(GetCurrentProfile));
            CheckBox checkBox7 = (CheckBox) this.root.findViewById(R.id.showXIFPS);
            checkBox7.setChecked(GetCurrentProfile.showXIFPS);
            checkBox7.setOnCheckedChangeListener(new TouchSettingsFragment$$ExternalSyntheticLambda16(GetCurrentProfile));
            ToggleXInputCont(GetCurrentProfile.enableXInput);
            checkBox3.setOnCheckedChangeListener(new TouchSettingsFragment$$ExternalSyntheticLambda2(this, new TouchSettingsFragment$$ExternalSyntheticLambda6(this, GetContext, GetCurrentProfile, checkBox3), GetCurrentProfile, GetContext));
            checkBox3.setChecked(GetCurrentProfile.integrateControls);
            if (!AndroidUtils.IsAccessibilityEnabled(GetContext) && GetCurrentProfile.integrateControls) {
                z = true;
            }
            ((Button) this.root.findViewById(R.id.openAccessSettings)).setOnClickListener(new TouchSettingsFragment$$ExternalSyntheticLambda10(this));
            this.icMaximize.setChecked(GetCurrentProfile.icMaximize);
            this.icHidePanels.setChecked(GetCurrentProfile.icHidePanels);
            this.icMaximize.setOnCheckedChangeListener(new TouchSettingsFragment$$ExternalSyntheticLambda13(GetCurrentProfile));
            this.icHidePanels.setOnCheckedChangeListener(new TouchSettingsFragment$$ExternalSyntheticLambda14(GetCurrentProfile));
            SwitchIntegrateControlsButtons(GetContext, GetCurrentProfile.integrateControls, z);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$ReinflateAll$2$com-catfixture-inputbridge-ui-activity-main-fragments-touchSettings-TouchSettingsFragment  reason: not valid java name */
    public /* synthetic */ void m226lambda$ReinflateAll$2$comcatfixtureinputbridgeuiactivitymainfragmentstouchSettingsTouchSettingsFragment(InputConfigProfile inputConfigProfile, CompoundButton compoundButton, boolean z) {
        ToggleTouchRumbleCont(z);
        inputConfigProfile.enableTouchRumble = z;
        inputConfigProfile.Save();
    }

    static /* synthetic */ void lambda$ReinflateAll$3(InputConfigProfile inputConfigProfile, Integer num) {
        inputConfigProfile.touchRumbleImpetusTime = num.intValue();
        inputConfigProfile.Save();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$ReinflateAll$4$com-catfixture-inputbridge-ui-activity-main-fragments-touchSettings-TouchSettingsFragment  reason: not valid java name */
    public /* synthetic */ void m227lambda$ReinflateAll$4$comcatfixtureinputbridgeuiactivitymainfragmentstouchSettingsTouchSettingsFragment(InputConfigProfile inputConfigProfile, CompoundButton compoundButton, boolean z) {
        inputConfigProfile.enableXInput = z;
        inputConfigProfile.Save();
        ToggleXInputCont(z);
    }

    static /* synthetic */ void lambda$ReinflateAll$5(InputConfigProfile inputConfigProfile, CompoundButton compoundButton, boolean z) {
        inputConfigProfile.enableXInputRumble = z;
        inputConfigProfile.Save();
    }

    static /* synthetic */ void lambda$ReinflateAll$6(InputConfigProfile inputConfigProfile, CompoundButton compoundButton, boolean z) {
        inputConfigProfile.showXIFPS = z;
        inputConfigProfile.Save();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$ReinflateAll$9$com-catfixture-inputbridge-ui-activity-main-fragments-touchSettings-TouchSettingsFragment  reason: not valid java name */
    public /* synthetic */ void m229lambda$ReinflateAll$9$comcatfixtureinputbridgeuiactivitymainfragmentstouchSettingsTouchSettingsFragment(Context context, InputConfigProfile inputConfigProfile, CheckBox checkBox, Boolean bool) {
        if (!AndroidUtils.IsAccessibilityEnabled(context)) {
            ConfirmDialog.Show(context, "Accessibility service", "This feature requires accessibility service, which is used to simulate touches.\nInput Bridge uses this feature only to press buttons in Exagear app, it's doesn't collect any data and interacts only with target Exagear app.", "Open settings", new TouchSettingsFragment$$ExternalSyntheticLambda8(this, inputConfigProfile, bool), "Disable", new TouchSettingsFragment$$ExternalSyntheticLambda7(checkBox));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$ReinflateAll$7$com-catfixture-inputbridge-ui-activity-main-fragments-touchSettings-TouchSettingsFragment  reason: not valid java name */
    public /* synthetic */ void m228lambda$ReinflateAll$7$comcatfixtureinputbridgeuiactivitymainfragmentstouchSettingsTouchSettingsFragment(InputConfigProfile inputConfigProfile, Boolean bool) {
        inputConfigProfile.SetIntegrateControls(bool.booleanValue());
        OpenAccessibilitySettings();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$ReinflateAll$10$com-catfixture-inputbridge-ui-activity-main-fragments-touchSettings-TouchSettingsFragment  reason: not valid java name */
    public /* synthetic */ void m224lambda$ReinflateAll$10$comcatfixtureinputbridgeuiactivitymainfragmentstouchSettingsTouchSettingsFragment(Action action, InputConfigProfile inputConfigProfile, Context context, CompoundButton compoundButton, boolean z) {
        if (z) {
            action.Invoke(Boolean.valueOf(z));
        }
        inputConfigProfile.SetIntegrateControls(z);
        SwitchIntegrateControlsButtons(context, z, false);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$ReinflateAll$11$com-catfixture-inputbridge-ui-activity-main-fragments-touchSettings-TouchSettingsFragment  reason: not valid java name */
    public /* synthetic */ void m225lambda$ReinflateAll$11$comcatfixtureinputbridgeuiactivitymainfragmentstouchSettingsTouchSettingsFragment(View view) {
        OpenAccessibilitySettings();
    }

    private void ToggleXInputCont(boolean z) {
        this.root.findViewById(R.id.xInputCont).setVisibility(z ? 0 : 8);
    }

    private void ToggleTouchRumbleCont(boolean z) {
        this.root.findViewById(R.id.touchRumbleCont).setVisibility(z ? 0 : 8);
    }

    private void OpenAccessibilitySettings() {
        ((IActivityLaunchable) GetActivity()).Launch(new Intent("android.settings.ACCESSIBILITY_SETTINGS"), new TouchSettingsFragment$$ExternalSyntheticLambda5(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$OpenAccessibilitySettings$14$com-catfixture-inputbridge-ui-activity-main-fragments-touchSettings-TouchSettingsFragment  reason: not valid java name */
    public /* synthetic */ void m223lambda$OpenAccessibilitySettings$14$comcatfixtureinputbridgeuiactivitymainfragmentstouchSettingsTouchSettingsFragment(ActivityResult activityResult) {
        ReinflateAll();
    }

    private void SwitchIntegrateControlsButtons(Context context, boolean z, boolean z2) {
        int i;
        int i2 = 0;
        this.root.findViewById(R.id.acsNotLaunchedWarn).setVisibility((!z || !z2) ? 8 : 0);
        if (!z || z2) {
            i2 = 8;
        }
        this.icMaximize.setVisibility(i2);
        this.icHidePanels.setVisibility(i2);
        View findViewById = this.root.findViewById(R.id.icmp);
        if (!z || !z2) {
            i = context.getColor(R.color.transparent);
        } else {
            i = context.getColor(R.color.lightRedHO);
        }
        findViewById.setBackgroundColor(i);
    }

    public View OnCreate() {
        Context GetContext = GetContext();
        View inflate = View.inflate(GetContext, R.layout.fragment_touch_settings, (ViewGroup) null);
        this.root = inflate;
        ((Button) inflate.findViewById(R.id.editControls)).setOnClickListener(new TouchSettingsFragment$$ExternalSyntheticLambda0(GetContext));
        ((Button) this.root.findViewById(R.id.repairOldProfile)).setOnClickListener(new TouchSettingsFragment$$ExternalSyntheticLambda9(this));
        return this.root;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$OnCreate$16$com-catfixture-inputbridge-ui-activity-main-fragments-touchSettings-TouchSettingsFragment  reason: not valid java name */
    public /* synthetic */ void m222lambda$OnCreate$16$comcatfixtureinputbridgeuiactivitymainfragmentstouchSettingsTouchSettingsFragment(View view) {
        RepairThis();
    }

    private void RepairThis() {
        InputConfigData inputConfigData = ConfigContext.data;
        InputConfigProfile GetCurrentProfile = inputConfigData.GetCurrentProfile();
        if (GetCurrentProfile != null) {
            for (InputTouchControlElementData inputTouchControlElementData : GetCurrentProfile.touchControlElements) {
                inputTouchControlElementData.id = GetCurrentProfile.GetInternalId();
            }
            Size GetRealDisplaySize = AndroidUtils.GetRealDisplaySize((WindowManager) GetContext().getSystemService(WindowManager.class));
            GetCurrentProfile.SetRefResolution(new Int2(GetRealDisplaySize.getWidth(), GetRealDisplaySize.getHeight()));
        }
        inputConfigData.Save();
    }

    public void onResume() {
        ReinflateAll();
    }
}
