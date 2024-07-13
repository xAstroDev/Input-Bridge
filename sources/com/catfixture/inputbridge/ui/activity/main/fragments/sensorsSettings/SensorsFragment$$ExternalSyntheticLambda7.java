package com.catfixture.inputbridge.ui.activity.main.fragments.sensorsSettings;

import android.view.View;
import com.catfixture.inputbridge.core.input.data.InputConfigProfile;
import com.catfixture.inputbridge.core.input.data.PosSensorData;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SensorsFragment$$ExternalSyntheticLambda7 implements View.OnLongClickListener {
    public final /* synthetic */ PosSensorData f$0;
    public final /* synthetic */ InputConfigProfile f$1;

    public /* synthetic */ SensorsFragment$$ExternalSyntheticLambda7(PosSensorData posSensorData, InputConfigProfile inputConfigProfile) {
        this.f$0 = posSensorData;
        this.f$1 = inputConfigProfile;
    }

    public final boolean onLongClick(View view) {
        return SensorsFragment.lambda$ReinflateAll$7(this.f$0, this.f$1, view);
    }
}
