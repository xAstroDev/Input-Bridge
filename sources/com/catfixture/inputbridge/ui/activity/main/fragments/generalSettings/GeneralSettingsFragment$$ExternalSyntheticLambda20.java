package com.catfixture.inputbridge.ui.activity.main.fragments.generalSettings;

import android.widget.CompoundButton;
import com.catfixture.inputbridge.core.input.data.InputConfigData;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class GeneralSettingsFragment$$ExternalSyntheticLambda20 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ InputConfigData f$0;

    public /* synthetic */ GeneralSettingsFragment$$ExternalSyntheticLambda20(InputConfigData inputConfigData) {
        this.f$0 = inputConfigData;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.f$0.ToggleAutoCheckUpdates(z);
    }
}
