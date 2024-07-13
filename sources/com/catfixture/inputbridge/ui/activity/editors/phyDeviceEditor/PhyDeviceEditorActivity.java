package com.catfixture.inputbridge.ui.activity.editors.phyDeviceEditor;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.context.ConfigContext;
import com.catfixture.inputbridge.core.debug.D;
import com.catfixture.inputbridge.core.input.codes.KeyCodes;
import com.catfixture.inputbridge.core.input.codes.MouseCodes;
import com.catfixture.inputbridge.core.input.codes.XInputCodes;
import com.catfixture.inputbridge.core.input.data.AxisBinding;
import com.catfixture.inputbridge.core.input.data.ControllerConfigData;
import com.catfixture.inputbridge.core.input.data.ControllerRebindRecord;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.buttons.common.BType;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.cross.CrossElementEditable;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.stick.MovementType;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.stick.SSide;
import com.catfixture.inputbridge.core.localization.Languages;
import com.catfixture.inputbridge.core.utils.android.AndroidUtils;
import com.catfixture.inputbridge.core.utils.types.Event;
import com.catfixture.inputbridge.ui.activity.editors.common.IEditor;
import com.catfixture.inputbridge.ui.common.AxisBindingsHelper;
import com.catfixture.inputbridge.ui.common.interactions.ConfirmDialog;
import com.catfixture.inputbridge.ui.utils.Utils;
import java.util.Objects;
import java.util.Observable;

public class PhyDeviceEditorActivity extends AppCompatActivity implements IEditor {
    private ControllerConfigData controllerCfg;
    private GamepadVisualTheme frontTheme;
    private GamepadVisual gv;
    private VisualElement lastSelectedElement;
    private ViewGroup mappingView;
    private TextView noSelectionLabel;
    public final Event onNewAxisInput = new Event();
    public final Event onNewButtonInput = new Event();

    /* access modifiers changed from: private */
    public void OnPhyControlElementSelected(VisualElement visualElement) {
        if (visualElement == null) {
            this.noSelectionLabel.setVisibility(0);
            this.mappingView.setVisibility(8);
            return;
        }
        this.noSelectionLabel.setVisibility(8);
        this.mappingView.setVisibility(0);
        LoadMappingForControlElement(visualElement);
    }

    private void LoadMappingForControlElement(VisualElement visualElement) {
        if (visualElement != this.lastSelectedElement) {
            try {
                this.mappingView.removeAllViews();
                ((TextView) findViewById(R.id.selectedName)).setText(visualElement.name);
                if (visualElement instanceof ButtonVisualElement) {
                    LinearLayout.inflate(this, R.layout.editable_button_common_type, this.mappingView);
                    LoadButtonMapping(visualElement);
                } else if (visualElement instanceof StickVisualElement) {
                    LinearLayout.inflate(this, R.layout.controller_editor_stick_binding, this.mappingView);
                    LoadStickMapping(visualElement);
                } else if (visualElement instanceof AxisFakeElement) {
                    LinearLayout.inflate(this, R.layout.controller_editor_axis_binding, this.mappingView);
                    LoadAxisMapping(visualElement);
                }
            } catch (Exception e) {
                D.E((Throwable) e);
            }
        }
        this.lastSelectedElement = visualElement;
    }

    private void LoadStickMapping(VisualElement visualElement) {
        StickVisualElement stickVisualElement = (StickVisualElement) visualElement;
        int i = stickVisualElement.code;
        ControllerRebindRecord controllerRebindRecord = null;
        for (ControllerRebindRecord next : this.controllerCfg.rebinds) {
            if (next.linkedCode == i) {
                controllerRebindRecord = next;
            }
        }
        if (controllerRebindRecord == null) {
            controllerRebindRecord = new ControllerRebindRecord();
            controllerRebindRecord.linkedCode = i;
            this.controllerCfg.AddRebind(controllerRebindRecord);
        }
        controllerRebindRecord.xAxis = stickVisualElement.xAxis;
        controllerRebindRecord.yAxis = stickVisualElement.yAxis;
        MovementType.Create(this);
        Spinner spinner = (Spinner) findViewById(R.id.movementType);
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) null);
        ArrayAdapter InitSpinner = Utils.InitSpinner(this, spinner, 0, R.layout.touch_controls_list_item);
        InitSpinner.addAll(MovementType.types);
        spinner.setAdapter(InitSpinner);
        spinner.setSelection(controllerRebindRecord.movementType);
        Utils.AttachSpinnerAction(spinner, new PhyDeviceEditorActivity$$ExternalSyntheticLambda3(this, controllerRebindRecord));
        SetupAxisType(controllerRebindRecord);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$LoadStickMapping$0$com-catfixture-inputbridge-ui-activity-editors-phyDeviceEditor-PhyDeviceEditorActivity  reason: not valid java name */
    public /* synthetic */ void m128lambda$LoadStickMapping$0$comcatfixtureinputbridgeuiactivityeditorsphyDeviceEditorPhyDeviceEditorActivity(ControllerRebindRecord controllerRebindRecord, Integer num) {
        if (controllerRebindRecord.movementType != num.intValue()) {
            controllerRebindRecord.SetMovementType(num.intValue());
            SetupAxisType(controllerRebindRecord);
        }
    }

    private void SetupAxisType(ControllerRebindRecord controllerRebindRecord) {
        View findViewById = findViewById(R.id.walkCont);
        View findViewById2 = findViewById(R.id.xiCont);
        findViewById.setVisibility(8);
        findViewById2.setVisibility(8);
        int i = controllerRebindRecord.movementType;
        if (i == 0) {
            findViewById.setVisibility(0);
            ViewGroup viewGroup = this.mappingView;
            int i2 = controllerRebindRecord.codeUp;
            Objects.requireNonNull(controllerRebindRecord);
            CrossElementEditable.InitDir(viewGroup, R.id.codeUp, i2, new PhyDeviceEditorActivity$$ExternalSyntheticLambda9(controllerRebindRecord));
            ViewGroup viewGroup2 = this.mappingView;
            int i3 = controllerRebindRecord.codeDown;
            Objects.requireNonNull(controllerRebindRecord);
            CrossElementEditable.InitDir(viewGroup2, R.id.codeDown, i3, new PhyDeviceEditorActivity$$ExternalSyntheticLambda6(controllerRebindRecord));
            ViewGroup viewGroup3 = this.mappingView;
            int i4 = controllerRebindRecord.codeLeft;
            Objects.requireNonNull(controllerRebindRecord);
            CrossElementEditable.InitDir(viewGroup3, R.id.codeLeft, i4, new PhyDeviceEditorActivity$$ExternalSyntheticLambda7(controllerRebindRecord));
            ViewGroup viewGroup4 = this.mappingView;
            int i5 = controllerRebindRecord.codeRight;
            Objects.requireNonNull(controllerRebindRecord);
            CrossElementEditable.InitDir(viewGroup4, R.id.codeRight, i5, new PhyDeviceEditorActivity$$ExternalSyntheticLambda8(controllerRebindRecord));
        } else if (i == 2) {
            findViewById2.setVisibility(0);
            Spinner spinner = (Spinner) findViewById2.findViewById(R.id.sideSpinner);
            spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) null);
            ArrayAdapter InitSpinner = Utils.InitSpinner(this, spinner, 0, R.layout.touch_controls_list_item);
            InitSpinner.addAll(SSide.sides);
            spinner.setAdapter(InitSpinner);
            spinner.setSelection(controllerRebindRecord.stickSide);
            Utils.AttachSpinnerAction(spinner, new PhyDeviceEditorActivity$$ExternalSyntheticLambda10(controllerRebindRecord));
        }
    }

    static /* synthetic */ void lambda$SetupAxisType$1(ControllerRebindRecord controllerRebindRecord, Integer num) {
        if (controllerRebindRecord.stickSide != num.intValue()) {
            controllerRebindRecord.stickSide = num.intValue();
        }
    }

    private void LoadButtonMapping(VisualElement visualElement) {
        ButtonVisualElement buttonVisualElement = (ButtonVisualElement) visualElement;
        int i = buttonVisualElement.code + buttonVisualElement.dir + buttonVisualElement.axis;
        ControllerRebindRecord controllerRebindRecord = null;
        for (ControllerRebindRecord next : this.controllerCfg.rebinds) {
            if (next.linkedCode == i) {
                controllerRebindRecord = next;
            }
        }
        if (controllerRebindRecord == null) {
            controllerRebindRecord = new ControllerRebindRecord();
            controllerRebindRecord.linkedCode = i;
            this.controllerCfg.AddRebind(controllerRebindRecord);
        }
        BType.Create(this);
        Spinner spinner = (Spinner) findViewById(R.id.buttonType);
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) null);
        ArrayAdapter InitSpinner = Utils.InitSpinner(this, spinner, 0, R.layout.touch_controls_list_item);
        InitSpinner.addAll(BType.types);
        spinner.setAdapter(InitSpinner);
        spinner.setSelection(controllerRebindRecord.buttonType);
        Utils.AttachSpinnerAction(spinner, new PhyDeviceEditorActivity$$ExternalSyntheticLambda2(this, controllerRebindRecord));
        SetupButtonType(controllerRebindRecord);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$LoadButtonMapping$2$com-catfixture-inputbridge-ui-activity-editors-phyDeviceEditor-PhyDeviceEditorActivity  reason: not valid java name */
    public /* synthetic */ void m127lambda$LoadButtonMapping$2$comcatfixtureinputbridgeuiactivityeditorsphyDeviceEditorPhyDeviceEditorActivity(ControllerRebindRecord controllerRebindRecord, Integer num) {
        if (controllerRebindRecord.buttonType != num.intValue()) {
            controllerRebindRecord.buttonType = num.intValue();
            SetupButtonType(controllerRebindRecord);
        }
    }

    private void SetupButtonType(ControllerRebindRecord controllerRebindRecord) {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.kbcodeRow);
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.mscodeRow);
        LinearLayout linearLayout3 = (LinearLayout) findViewById(R.id.xinputcodeRow);
        int i = 0;
        linearLayout.setVisibility(controllerRebindRecord.buttonType == 0 ? 0 : 8);
        linearLayout2.setVisibility(controllerRebindRecord.buttonType == 1 ? 0 : 8);
        if (controllerRebindRecord.buttonType != 2) {
            i = 8;
        }
        linearLayout3.setVisibility(i);
        int i2 = controllerRebindRecord.buttonType;
        if (i2 == 0) {
            Spinner spinner = (Spinner) findViewById(R.id.buttonCode);
            spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) null);
            KeyCodes.PrepareAdapter(spinner, controllerRebindRecord.windowsKeyCode, R.layout.touch_controls_list_item, new PhyDeviceEditorActivity$$ExternalSyntheticLambda11(controllerRebindRecord));
        } else if (i2 == 1) {
            MouseCodes.PrepareAdapter((Spinner) findViewById(R.id.mouseCode), controllerRebindRecord.mouseCode, R.layout.touch_controls_list_item, new PhyDeviceEditorActivity$$ExternalSyntheticLambda12(controllerRebindRecord));
        } else if (i2 == 2) {
            XInputCodes.PrepareAdapter((Spinner) findViewById(R.id.xinputcode), controllerRebindRecord.xinputCode, R.layout.touch_controls_list_item, new PhyDeviceEditorActivity$$ExternalSyntheticLambda13(controllerRebindRecord));
        }
    }

    static /* synthetic */ void lambda$SetupButtonType$3(ControllerRebindRecord controllerRebindRecord, Integer num) {
        if (controllerRebindRecord.windowsKeyCode != num.intValue()) {
            controllerRebindRecord.SetWindowsKeyCode(num.intValue());
        }
    }

    static /* synthetic */ void lambda$SetupButtonType$4(ControllerRebindRecord controllerRebindRecord, Integer num) {
        if (controllerRebindRecord.mouseCode != num.intValue()) {
            controllerRebindRecord.SetMouseCode(num.intValue());
        }
    }

    static /* synthetic */ void lambda$SetupButtonType$5(ControllerRebindRecord controllerRebindRecord, Integer num) {
        if (controllerRebindRecord.xinputCode != num.intValue()) {
            controllerRebindRecord.SetXInputCode(num.intValue());
        }
    }

    private void LoadAxisMapping(VisualElement visualElement) {
        int i = ((AxisFakeElement) visualElement).code;
        AxisBinding axisBinding = null;
        for (AxisBinding next : this.controllerCfg.axesBindings) {
            if (next.owner == i) {
                axisBinding = next;
            }
        }
        if (axisBinding == null) {
            axisBinding = new AxisBinding();
            axisBinding.owner = i;
            this.controllerCfg.axesBindings.add(axisBinding);
        }
        AxisBindingsHelper.LoadSelectedAxisSettings(this, this.mappingView, R.layout.touch_controls_list_item, axisBinding, PhyDeviceEditorActivity$$ExternalSyntheticLambda4.INSTANCE);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AndroidUtils.HideSystemUI(getWindow().getDecorView());
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_controller_editor);
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra("DeviceID", -1);
        int intExtra2 = intent.getIntExtra("VendorID", -1);
        ControllerConfigData GetControllerConfig = ConfigContext.data.GetCurrentProfile().GetControllerConfig(intExtra, intExtra2);
        this.controllerCfg = GetControllerConfig;
        if (GetControllerConfig == null) {
            ConfirmDialog.Show(this, "Error!", " Controller config not found, please remove device and try again!");
            onBackPressed();
            return;
        }
        this.mappingView = (ViewGroup) findViewById(R.id.mappingView);
        this.noSelectionLabel = (TextView) findViewById(R.id.noSelection);
        ((TextView) findViewById(R.id.deviceName)).setText(AndroidUtils.VidPidToDeviceName(this.controllerCfg.vendorID, this.controllerCfg.deviceID, this.controllerCfg.name));
        ((Button) findViewById(R.id.saveExitButton)).setOnClickListener(new PhyDeviceEditorActivity$$ExternalSyntheticLambda0(this));
        ((TextView) findViewById(R.id.deviceProps)).setText("VID:" + this.controllerCfg.vendorID + " PID:" + this.controllerCfg.deviceID);
        LoadTheme(intExtra, intExtra2);
        GamepadVisual gamepadVisual = new GamepadVisual(this);
        this.gv = gamepadVisual;
        gamepadVisual.SetupTheme(intExtra2, intExtra, this.frontTheme);
        this.gv.SetOnTriggersChanged(new PhyDeviceEditorActivity$$ExternalSyntheticLambda5((ProgressBar) findViewById(R.id.ltForce), (ProgressBar) findViewById(R.id.rtForce)));
        this.gv.SetOnSelectionChanged(new PhyDeviceEditorActivity$$ExternalSyntheticLambda1(this));
        ((ViewGroup) findViewById(R.id.view)).addView(this.gv);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$6$com-catfixture-inputbridge-ui-activity-editors-phyDeviceEditor-PhyDeviceEditorActivity  reason: not valid java name */
    public /* synthetic */ void m129lambda$onCreate$6$comcatfixtureinputbridgeuiactivityeditorsphyDeviceEditorPhyDeviceEditorActivity(View view) {
        ConfigContext.Save();
        onBackPressed();
    }

    static /* synthetic */ void lambda$onCreate$7(ProgressBar progressBar, ProgressBar progressBar2, Float f, Float f2) {
        progressBar.setProgress(100 - ((int) (f.floatValue() * 100.0f)));
        progressBar2.setProgress(100 - ((int) (f2.floatValue() * 100.0f)));
    }

    private void LoadTheme(int i, int i2) {
        String VidPidToDeviceName = AndroidUtils.VidPidToDeviceName(i2, i, "Generic gamepad");
        if (VidPidToDeviceName.equals("Dualsense X")) {
            this.frontTheme = GamepadStyles.DualsenseX;
        } else if (VidPidToDeviceName.equals("Dualshock 4")) {
            this.frontTheme = GamepadStyles.Dualshock4;
        } else {
            this.frontTheme = GamepadStyles.DefaultAkax360;
        }
        OnPhyControlElementSelected(this.frontTheme.fakeLtElement);
        OnPhyControlElementSelected(this.frontTheme.fakeRtElement);
        for (StickVisualElement OnPhyControlElementSelected : this.frontTheme.GetSticks()) {
            OnPhyControlElementSelected(OnPhyControlElementSelected);
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(Languages.CreateLanguageCTXWrapper(context));
        MouseCodes.Load(this);
        XInputCodes.Load(this);
    }

    public Observable OnNewAxisInput() {
        return this.onNewAxisInput;
    }

    public Observable OnNewButtonInput() {
        return this.onNewButtonInput;
    }
}
