package com.catfixture.inputbridge.ui.activity.main.fragments.sensorsSettings;

import com.catfixture.inputbridge.core.input.data.PosSensorData;
import com.google.android.material.slider.RangeSlider;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SensorsFragment$$ExternalSyntheticLambda1 implements RangeSlider.OnChangeListener {
    public final /* synthetic */ PosSensorData f$0;
    public final /* synthetic */ RangeSlider f$1;

    public /* synthetic */ SensorsFragment$$ExternalSyntheticLambda1(PosSensorData posSensorData, RangeSlider rangeSlider) {
        this.f$0 = posSensorData;
        this.f$1 = rangeSlider;
    }

    public final void onValueChange(Object obj, float f, boolean z) {
        this.f$0.clamps = this.f$1.getValues();
    }
}
