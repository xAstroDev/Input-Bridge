package com.catfixture.inputbridge.ui.activity.main.fragments.performanceSettings;

import android.widget.CompoundButton;
import com.catfixture.inputbridge.core.input.data.InputConfigProfile;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class PerformanceSettingsFragment$$ExternalSyntheticLambda1 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ InputConfigProfile f$0;

    public /* synthetic */ PerformanceSettingsFragment$$ExternalSyntheticLambda1(InputConfigProfile inputConfigProfile) {
        this.f$0 = inputConfigProfile;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.f$0.SetFilterActions(z);
    }
}
