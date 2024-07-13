package com.catfixture.inputbridge.ui.activity.main.fragments.sensorsSettings;

import android.widget.CompoundButton;
import com.catfixture.inputbridge.core.input.data.AxisBinding;
import com.catfixture.inputbridge.core.input.data.InputConfigProfile;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SensorsFragment$$ExternalSyntheticLambda9 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ AxisBinding f$0;
    public final /* synthetic */ InputConfigProfile f$1;

    public /* synthetic */ SensorsFragment$$ExternalSyntheticLambda9(AxisBinding axisBinding, InputConfigProfile inputConfigProfile) {
        this.f$0 = axisBinding;
        this.f$1 = inputConfigProfile;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        SensorsFragment.lambda$SelectBindingAxis$11(this.f$0, this.f$1, compoundButton, z);
    }
}
