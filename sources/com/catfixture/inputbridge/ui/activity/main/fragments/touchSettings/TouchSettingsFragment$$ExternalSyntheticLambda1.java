package com.catfixture.inputbridge.ui.activity.main.fragments.touchSettings;

import android.widget.CompoundButton;
import com.catfixture.inputbridge.core.input.data.InputConfigProfile;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class TouchSettingsFragment$$ExternalSyntheticLambda1 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ TouchSettingsFragment f$0;
    public final /* synthetic */ InputConfigProfile f$1;

    public /* synthetic */ TouchSettingsFragment$$ExternalSyntheticLambda1(TouchSettingsFragment touchSettingsFragment, InputConfigProfile inputConfigProfile) {
        this.f$0 = touchSettingsFragment;
        this.f$1 = inputConfigProfile;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.f$0.m227lambda$ReinflateAll$4$comcatfixtureinputbridgeuiactivitymainfragmentstouchSettingsTouchSettingsFragment(this.f$1, compoundButton, z);
    }
}