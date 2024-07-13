package com.catfixture.inputbridge.ui.activity.main.fragments.touchSettings;

import android.content.Context;
import android.widget.CompoundButton;
import com.catfixture.inputbridge.core.input.data.InputConfigProfile;
import com.catfixture.inputbridge.core.utils.types.delegates.Action;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class TouchSettingsFragment$$ExternalSyntheticLambda2 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ TouchSettingsFragment f$0;
    public final /* synthetic */ Action f$1;
    public final /* synthetic */ InputConfigProfile f$2;
    public final /* synthetic */ Context f$3;

    public /* synthetic */ TouchSettingsFragment$$ExternalSyntheticLambda2(TouchSettingsFragment touchSettingsFragment, Action action, InputConfigProfile inputConfigProfile, Context context) {
        this.f$0 = touchSettingsFragment;
        this.f$1 = action;
        this.f$2 = inputConfigProfile;
        this.f$3 = context;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.f$0.m224lambda$ReinflateAll$10$comcatfixtureinputbridgeuiactivitymainfragmentstouchSettingsTouchSettingsFragment(this.f$1, this.f$2, this.f$3, compoundButton, z);
    }
}
