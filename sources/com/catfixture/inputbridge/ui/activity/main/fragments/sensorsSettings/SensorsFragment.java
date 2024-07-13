package com.catfixture.inputbridge.ui.activity.main.fragments.sensorsSettings;

import android.app.Activity;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.renderscript.Float3;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.context.AppContext;
import com.catfixture.inputbridge.core.context.ConfigContext;
import com.catfixture.inputbridge.core.input.data.AxisBinding;
import com.catfixture.inputbridge.core.input.data.InputConfigData;
import com.catfixture.inputbridge.core.input.data.InputConfigProfile;
import com.catfixture.inputbridge.core.input.data.PosSensorData;
import com.catfixture.inputbridge.core.input.devices.sensors.PositionSensor;
import com.catfixture.inputbridge.ui.activity.main.fragments.sensorsSettings.TinyRender.TinyRenderer;
import com.catfixture.inputbridge.ui.common.AxisBindingsHelper;
import com.catfixture.inputbridge.ui.tabs.DefaultTabFragment;
import com.catfixture.inputbridge.ui.utils.Utils;
import com.google.android.material.slider.RangeSlider;

public class SensorsFragment extends DefaultTabFragment {
    private final TinyRenderer mainRenderer = new TinyRenderer();
    private PositionSensor posSensor;
    private ViewGroup previewCont;
    private GLSurfaceView previewSurface;
    View root;
    private TextView xRotAxis;
    private TextView yRotAxis;
    private TextView zRotAxis;

    public SensorsFragment(Activity activity) {
        super(activity);
    }

    public View OnCreate() {
        ViewGroup viewGroup = (ViewGroup) View.inflate(GetContext(), R.layout.fragment_sensors_settings, (ViewGroup) null);
        this.root = viewGroup;
        this.previewCont = (ViewGroup) viewGroup.findViewById(R.id.previewCont);
        this.xRotAxis = (TextView) this.root.findViewById(R.id.xRotAxis);
        this.yRotAxis = (TextView) this.root.findViewById(R.id.yRotAxis);
        this.zRotAxis = (TextView) this.root.findViewById(R.id.zRotAxis);
        return this.root;
    }

    private void ReenablePositionSensor(PosSensorData posSensorData) {
        if (!posSensorData.enable) {
            DestroyAll();
            return;
        }
        if (this.previewSurface == null) {
            GLSurfaceView gLSurfaceView = new GLSurfaceView(this.root.getContext());
            this.previewSurface = gLSurfaceView;
            gLSurfaceView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            this.previewSurface.setEGLContextClientVersion(2);
            this.previewSurface.setRenderer(this.mainRenderer);
            this.previewSurface.setRenderMode(0);
            this.previewCont.addView(this.previewSurface);
        }
        PositionSensor GetPositionSensor = AppContext.app.GetPositionSensor();
        this.posSensor = GetPositionSensor;
        GetPositionSensor.SetData(posSensorData);
        this.posSensor.OnChanged = new SensorsFragment$$ExternalSyntheticLambda3(this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$ReenablePositionSensor$0$com-catfixture-inputbridge-ui-activity-main-fragments-sensorsSettings-SensorsFragment  reason: not valid java name */
    public /* synthetic */ void m215lambda$ReenablePositionSensor$0$comcatfixtureinputbridgeuiactivitymainfragmentssensorsSettingsSensorsFragment() {
        this.mainRenderer.SetRotation(this.posSensor.GetXRot() + 90.0f, this.posSensor.GetYRot());
        this.previewSurface.requestRender();
        TextView textView = this.xRotAxis;
        textView.setText("x: " + Utils.DigitsAfterComma(this.posSensor.GetXRot(), 2) + "°");
        TextView textView2 = this.yRotAxis;
        textView2.setText("y: " + Utils.DigitsAfterComma(this.posSensor.GetYRot(), 2) + "°");
        TextView textView3 = this.zRotAxis;
        textView3.setText("z: " + Utils.DigitsAfterComma(this.posSensor.GetZRot(), 2) + "°");
    }

    private void ReinflateAll() {
        Context GetContext = GetContext();
        InputConfigData inputConfigData = ConfigContext.data;
        if (inputConfigData.HasCurrentProfile()) {
            InputConfigProfile GetCurrentProfile = inputConfigData.GetCurrentProfile();
            PosSensorData posSensorData = GetCurrentProfile.posSensorData;
            Spinner spinner = (Spinner) this.root.findViewById(R.id.latencyChooser);
            ArrayAdapter InitSpinner = Utils.InitSpinner(GetContext, spinner, GetCurrentProfile.posSensorData.latency, R.layout.basic_spinner_item_dark);
            InitSpinner.addAll(new String[]{"FASTEST"});
            InitSpinner.addAll(new String[]{"GAME"});
            InitSpinner.addAll(new String[]{"UI"});
            InitSpinner.addAll(new String[]{"NORMAL"});
            Utils.AttachSpinnerAction(spinner, new SensorsFragment$$ExternalSyntheticLambda12(this, posSensorData, GetCurrentProfile));
            CheckBox checkBox = (CheckBox) this.root.findViewById(R.id.enablePositionSensor);
            checkBox.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
            checkBox.setChecked(posSensorData.enable);
            checkBox.setOnCheckedChangeListener(new SensorsFragment$$ExternalSyntheticLambda10(this, posSensorData, GetCurrentProfile));
            ToggleEnabledContainer(posSensorData.enable);
            final TextView textView = (TextView) this.root.findViewById(R.id.gainSliderText);
            SeekBar seekBar = (SeekBar) this.root.findViewById(R.id.gain);
            seekBar.setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener) null);
            seekBar.setProgress(posSensorData.gain);
            textView.setText(GetContext.getString(R.string.gain_text, new Object[]{Integer.valueOf(posSensorData.gain)}));
            final PosSensorData posSensorData2 = posSensorData;
            final Context context = GetContext;
            final InputConfigProfile inputConfigProfile = GetCurrentProfile;
            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                    posSensorData2.gain = seekBar.getProgress();
                    textView.setText(context.getString(R.string.gain_text, new Object[]{Integer.valueOf(i)}));
                }

                public void onStopTrackingTouch(SeekBar seekBar) {
                    inputConfigProfile.Save();
                }
            });
            final TextView textView2 = (TextView) this.root.findViewById(R.id.smoothSliderText);
            SeekBar seekBar2 = (SeekBar) this.root.findViewById(R.id.smooth);
            seekBar2.setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener) null);
            seekBar2.setProgress(posSensorData.smooth);
            textView2.setText(GetContext.getString(R.string.smooth_text, new Object[]{Integer.valueOf(posSensorData.smooth)}));
            final PosSensorData posSensorData3 = posSensorData;
            seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                    posSensorData3.smooth = seekBar.getProgress();
                    textView2.setText(context.getString(R.string.smooth_text, new Object[]{Integer.valueOf(i)}));
                }

                public void onStopTrackingTouch(SeekBar seekBar) {
                    inputConfigProfile.Save();
                }
            });
            final TextView textView3 = (TextView) this.root.findViewById(R.id.sensitivitySliderText);
            SeekBar seekBar3 = (SeekBar) this.root.findViewById(R.id.sensitivity);
            seekBar3.setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener) null);
            seekBar3.setProgress(posSensorData.sensitivity);
            textView3.setText(GetContext.getString(R.string.sensitivity_text, new Object[]{Integer.valueOf(posSensorData.sensitivity)}));
            final PosSensorData posSensorData4 = posSensorData;
            seekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                    posSensorData4.sensitivity = seekBar.getProgress();
                    textView3.setText(context.getString(R.string.sensitivity_text, new Object[]{Integer.valueOf(i)}));
                }

                public void onStopTrackingTouch(SeekBar seekBar) {
                    inputConfigProfile.Save();
                }
            });
            RangeSlider rangeSlider = (RangeSlider) this.root.findViewById(R.id.clampSlider);
            rangeSlider.setOnTouchListener((View.OnTouchListener) null);
            try {
                rangeSlider.setValues(posSensorData.clamps);
            } catch (Exception unused) {
            }
            rangeSlider.addOnChangeListener(new SensorsFragment$$ExternalSyntheticLambda1(posSensorData, rangeSlider));
            rangeSlider.setOnTouchListener(new SensorsFragment$$ExternalSyntheticLambda8(GetCurrentProfile));
            Button button = (Button) this.root.findViewById(R.id.calibratePosSensor);
            button.setOnClickListener(new SensorsFragment$$ExternalSyntheticLambda6(this, GetCurrentProfile));
            button.setOnLongClickListener(new SensorsFragment$$ExternalSyntheticLambda7(posSensorData, GetCurrentProfile));
            UpdateAxesColors(GetContext, this.root, GetCurrentProfile);
            ((Button) this.root.findViewById(R.id.selectXAxis)).setOnClickListener(new SensorsFragment$$ExternalSyntheticLambda4(this, GetContext, GetCurrentProfile));
            ((Button) this.root.findViewById(R.id.selectYAxis)).setOnClickListener(new SensorsFragment$$ExternalSyntheticLambda5(this, GetContext, GetCurrentProfile));
            ((Button) this.root.findViewById(R.id.selectZAxis)).setOnClickListener(new SensorsFragment$$ExternalSyntheticLambda0(this, GetContext, GetCurrentProfile));
            SelectBindingAxis(GetContext, this.root, GetCurrentProfile, GetCurrentProfile.posSensorData.selectedAxis);
            ReenablePositionSensor(posSensorData);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$ReinflateAll$1$com-catfixture-inputbridge-ui-activity-main-fragments-sensorsSettings-SensorsFragment  reason: not valid java name */
    public /* synthetic */ void m216lambda$ReinflateAll$1$comcatfixtureinputbridgeuiactivitymainfragmentssensorsSettingsSensorsFragment(PosSensorData posSensorData, InputConfigProfile inputConfigProfile, Integer num) {
        posSensorData.latency = num.intValue();
        inputConfigProfile.Save();
        this.posSensor.SetData(posSensorData);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$ReinflateAll$2$com-catfixture-inputbridge-ui-activity-main-fragments-sensorsSettings-SensorsFragment  reason: not valid java name */
    public /* synthetic */ void m218lambda$ReinflateAll$2$comcatfixtureinputbridgeuiactivitymainfragmentssensorsSettingsSensorsFragment(PosSensorData posSensorData, InputConfigProfile inputConfigProfile, CompoundButton compoundButton, boolean z) {
        posSensorData.enable = z;
        inputConfigProfile.Save();
        ToggleEnabledContainer(z);
        ReenablePositionSensor(posSensorData);
    }

    static /* synthetic */ boolean lambda$ReinflateAll$4(InputConfigProfile inputConfigProfile, View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 1) {
            return false;
        }
        inputConfigProfile.Save();
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$ReinflateAll$6$com-catfixture-inputbridge-ui-activity-main-fragments-sensorsSettings-SensorsFragment  reason: not valid java name */
    public /* synthetic */ void m219lambda$ReinflateAll$6$comcatfixtureinputbridgeuiactivitymainfragmentssensorsSettingsSensorsFragment(InputConfigProfile inputConfigProfile, View view) {
        this.posSensor.Calibrate(new SensorsFragment$$ExternalSyntheticLambda11(inputConfigProfile));
    }

    static /* synthetic */ boolean lambda$ReinflateAll$7(PosSensorData posSensorData, InputConfigProfile inputConfigProfile, View view) {
        posSensorData.calib = new Float3(0.0f, 0.0f, 0.0f);
        inputConfigProfile.Save();
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$ReinflateAll$8$com-catfixture-inputbridge-ui-activity-main-fragments-sensorsSettings-SensorsFragment  reason: not valid java name */
    public /* synthetic */ void m220lambda$ReinflateAll$8$comcatfixtureinputbridgeuiactivitymainfragmentssensorsSettingsSensorsFragment(Context context, InputConfigProfile inputConfigProfile, View view) {
        SelectBindingAxis(context, this.root, inputConfigProfile, 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$ReinflateAll$9$com-catfixture-inputbridge-ui-activity-main-fragments-sensorsSettings-SensorsFragment  reason: not valid java name */
    public /* synthetic */ void m221lambda$ReinflateAll$9$comcatfixtureinputbridgeuiactivitymainfragmentssensorsSettingsSensorsFragment(Context context, InputConfigProfile inputConfigProfile, View view) {
        SelectBindingAxis(context, this.root, inputConfigProfile, 1);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$ReinflateAll$10$com-catfixture-inputbridge-ui-activity-main-fragments-sensorsSettings-SensorsFragment  reason: not valid java name */
    public /* synthetic */ void m217lambda$ReinflateAll$10$comcatfixtureinputbridgeuiactivitymainfragmentssensorsSettingsSensorsFragment(Context context, InputConfigProfile inputConfigProfile, View view) {
        SelectBindingAxis(context, this.root, inputConfigProfile, 2);
    }

    private void ToggleEnabledContainer(boolean z) {
        int i = z ? 0 : 8;
        this.root.findViewById(R.id.enabledCont).setVisibility(i);
        this.root.findViewById(R.id.previewSetupCont).setVisibility(i);
    }

    private void SelectBindingAxis(Context context, View view, InputConfigProfile inputConfigProfile, int i) {
        PosSensorData posSensorData = inputConfigProfile.posSensorData;
        posSensorData.selectedAxis = i;
        inputConfigProfile.Save();
        AxisBinding GetAxisBindingByIndex = posSensorData.GetAxisBindingByIndex(i);
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.invertAxis);
        checkBox.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        boolean z = true;
        if (GetAxisBindingByIndex.invert != 1) {
            z = false;
        }
        checkBox.setChecked(z);
        checkBox.setOnCheckedChangeListener(new SensorsFragment$$ExternalSyntheticLambda9(GetAxisBindingByIndex, inputConfigProfile));
        UpdateAxesColors(context, view, inputConfigProfile);
    }

    static /* synthetic */ void lambda$SelectBindingAxis$11(AxisBinding axisBinding, InputConfigProfile inputConfigProfile, CompoundButton compoundButton, boolean z) {
        axisBinding.invert = z ? 1 : -1;
        inputConfigProfile.Save();
    }

    private void UpdateAxesColors(Context context, View view, InputConfigProfile inputConfigProfile) {
        Button button = (Button) view.findViewById(R.id.selectXAxis);
        Button button2 = (Button) view.findViewById(R.id.selectYAxis);
        Button button3 = (Button) view.findViewById(R.id.selectZAxis);
        button.setAlpha(0.2f);
        button2.setAlpha(0.2f);
        button3.setAlpha(0.2f);
        PosSensorData posSensorData = inputConfigProfile.posSensorData;
        if (posSensorData.selectedAxis == 0) {
            button.setAlpha(1.0f);
        }
        if (posSensorData.selectedAxis == 1) {
            button2.setAlpha(1.0f);
        }
        if (posSensorData.selectedAxis == 2) {
            button3.setAlpha(1.0f);
        }
        AxisBindingsHelper.LoadSelectedAxisSettings(context, view, R.layout.basic_spinner_item_dark, posSensorData.GetSelectedAxis(), new SensorsFragment$$ExternalSyntheticLambda2(inputConfigProfile));
    }

    public void OnDestroy() {
        DestroyAll();
    }

    private void DestroyAll() {
        this.previewCont.removeAllViews();
        this.previewSurface = null;
        PositionSensor positionSensor = this.posSensor;
        if (positionSensor != null) {
            positionSensor.OnChanged = null;
        }
    }

    public void onResume() {
        GetActivity().setRequestedOrientation(11);
        ReinflateAll();
    }

    public void onSuspend() {
        GetActivity().setRequestedOrientation(2);
        DestroyAll();
    }
}
