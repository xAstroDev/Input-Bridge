package com.catfixture.inputbridge.ui.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.GSS.SysDev.SensorsNames;
import com.catfixture.inputbridge.core.GSS.SysDev.SensorsPostfixes;
import com.catfixture.inputbridge.core.GSS.SysDev.core.SensorType;
import com.catfixture.inputbridge.core.GSS.SysDev.core.Sensors;
import com.catfixture.inputbridge.core.GSS.SysDev.discovery.SensorPresence;
import com.catfixture.inputbridge.core.GSS.SysDev.sensors.base.ISensor;
import com.catfixture.inputbridge.core.colorpicker.ColorPickerUtils;
import com.catfixture.inputbridge.core.context.ConfigContext;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.editor.finetune.ColorData;
import com.catfixture.inputbridge.core.utils.types.delegates.Action;
import com.catfixture.inputbridge.ui.utils.Utils;
import okhttp3.HttpUrl;

public class SensorBox extends LinearLayout {
    private SensorPresence baseSensor;
    private ColorData colorData;
    private Spinner displayName;
    private Spinner displayPostfix;
    private CheckBox isEnabled;
    private Action<Boolean> onEnabledStateChanged;
    private TextView path;
    private View pcolorSelector;
    private View scolorSelector;
    private TextView type;
    private TextView valuePreview;

    public SensorBox(Context context) {
        super(context);
        Create(context);
    }

    private void Create(Context context) {
        inflate(context, R.layout.sensor_box, this);
        this.isEnabled = (CheckBox) findViewById(R.id.enableSensor);
        this.type = (TextView) findViewById(R.id.type);
        this.path = (TextView) findViewById(R.id.path);
        this.valuePreview = (TextView) findViewById(R.id.valuePreview);
        this.pcolorSelector = findViewById(R.id.pcolorSelector);
        this.scolorSelector = findViewById(R.id.scolorSelector);
        this.displayName = (Spinner) findViewById(R.id.displayName);
        this.displayPostfix = (Spinner) findViewById(R.id.displayPostfix);
    }

    private void SetCheckedState(boolean z) {
        this.isEnabled.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        this.isEnabled.setChecked(z);
        this.isEnabled.setOnCheckedChangeListener(new SensorBox$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$SetCheckedState$0$com-catfixture-inputbridge-ui-custom-SensorBox  reason: not valid java name */
    public /* synthetic */ void m237lambda$SetCheckedState$0$comcatfixtureinputbridgeuicustomSensorBox(CompoundButton compoundButton, boolean z) {
        this.onEnabledStateChanged.Invoke(Boolean.valueOf(z));
    }

    public SensorBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Create(context);
    }

    public void SetOnEnabledStateChanged(Action<Boolean> action) {
        this.onEnabledStateChanged = action;
    }

    public void InitAsUnused(SensorPresence sensorPresence) {
        InitNames(sensorPresence);
        SetCheckedState(false);
    }

    private void InitNames(SensorPresence sensorPresence) {
        TextView textView = this.type;
        textView.setText(SensorType.TypeToString(sensorPresence.type) + " " + sensorPresence.description);
        this.path.setText(sensorPresence.path);
    }

    private void ToggleStates(boolean z) {
        int i = 0;
        this.pcolorSelector.setVisibility(z ? 0 : 8);
        this.scolorSelector.setVisibility(z ? 0 : 8);
        this.valuePreview.setVisibility(z ? 0 : 8);
        this.displayName.setVisibility(z ? 0 : 8);
        Spinner spinner = this.displayPostfix;
        if (!z) {
            i = 8;
        }
        spinner.setVisibility(i);
    }

    public void InitAsUsed(SensorPresence sensorPresence) {
        this.baseSensor = sensorPresence;
        InitNames(sensorPresence);
        SetCheckedState(true);
        ToggleStates(true);
        ColorPickerUtils.InitColorPicker(getContext(), HttpUrl.FRAGMENT_ENCODE_SET, this.pcolorSelector, sensorPresence.primaryColorData, (Runnable) null);
        ColorPickerUtils.InitColorPicker(getContext(), HttpUrl.FRAGMENT_ENCODE_SET, this.scolorSelector, sensorPresence.secondaryColorData, (Runnable) null);
        Utils.InitSpinner(getContext(), this.displayName, sensorPresence.displayName, R.layout.basic_spinner_item_dark).addAll(SensorsNames.names);
        Utils.AttachSpinnerAction(this.displayName, new SensorBox$$ExternalSyntheticLambda1(sensorPresence));
        Utils.InitSpinner(getContext(), this.displayPostfix, sensorPresence.displayPostfix, R.layout.basic_spinner_item_dark).addAll(SensorsPostfixes.names);
        Utils.AttachSpinnerAction(this.displayPostfix, new SensorBox$$ExternalSyntheticLambda2(sensorPresence));
    }

    static /* synthetic */ void lambda$InitAsUsed$1(SensorPresence sensorPresence, Integer num) {
        sensorPresence.displayName = num.intValue();
        ConfigContext.Save();
    }

    static /* synthetic */ void lambda$InitAsUsed$2(SensorPresence sensorPresence, Integer num) {
        sensorPresence.displayPostfix = num.intValue();
        ConfigContext.Save();
    }

    public void Update() {
        ISensor<?> Get;
        SensorPresence sensorPresence = this.baseSensor;
        if (sensorPresence != null && (Get = Sensors.Get(sensorPresence)) != null) {
            this.baseSensor.cachedValue = Get.Read();
            TextView textView = this.valuePreview;
            textView.setText(this.baseSensor.cachedValue + SensorsPostfixes.GetByIndex(this.baseSensor.displayPostfix));
        }
    }
}
