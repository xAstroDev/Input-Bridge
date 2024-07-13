package com.catfixture.inputbridge.ui.activity.main.fragments.sensorsSettings;

import android.widget.CompoundButton;
import com.catfixture.inputbridge.core.input.data.InputConfigProfile;
import com.catfixture.inputbridge.core.input.data.PosSensorData;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SensorsFragment$$ExternalSyntheticLambda10 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ SensorsFragment f$0;
    public final /* synthetic */ PosSensorData f$1;
    public final /* synthetic */ InputConfigProfile f$2;

    public /* synthetic */ SensorsFragment$$ExternalSyntheticLambda10(SensorsFragment sensorsFragment, PosSensorData posSensorData, InputConfigProfile inputConfigProfile) {
        this.f$0 = sensorsFragment;
        this.f$1 = posSensorData;
        this.f$2 = inputConfigProfile;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.f$0.m218lambda$ReinflateAll$2$comcatfixtureinputbridgeuiactivitymainfragmentssensorsSettingsSensorsFragment(this.f$1, this.f$2, compoundButton, z);
    }
}
