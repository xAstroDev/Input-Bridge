package com.catfixture.inputbridge.ui.activity.main.fragments.touchSettings;

import android.widget.CompoundButton;
import com.catfixture.inputbridge.core.input.data.InputConfigProfile;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class TouchSettingsFragment$$ExternalSyntheticLambda13 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ InputConfigProfile f$0;

    public /* synthetic */ TouchSettingsFragment$$ExternalSyntheticLambda13(InputConfigProfile inputConfigProfile) {
        this.f$0 = inputConfigProfile;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.f$0.SetIcMaximize(z);
    }
}
