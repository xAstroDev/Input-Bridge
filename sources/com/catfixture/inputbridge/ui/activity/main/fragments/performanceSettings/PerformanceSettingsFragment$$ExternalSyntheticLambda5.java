package com.catfixture.inputbridge.ui.activity.main.fragments.performanceSettings;

import com.catfixture.inputbridge.core.input.data.InputConfigProfile;
import com.catfixture.inputbridge.core.utils.types.delegates.Action;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class PerformanceSettingsFragment$$ExternalSyntheticLambda5 implements Action {
    public final /* synthetic */ InputConfigProfile f$0;

    public /* synthetic */ PerformanceSettingsFragment$$ExternalSyntheticLambda5(InputConfigProfile inputConfigProfile) {
        this.f$0 = inputConfigProfile;
    }

    public final void Invoke(Object obj) {
        this.f$0.SetPipeRate(((Integer) obj).intValue());
    }
}
