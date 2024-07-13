package com.catfixture.inputbridge.ui.activity.main.fragments.generalSettings;

import android.content.Context;
import android.view.View;
import com.catfixture.inputbridge.core.utils.android.ActivityActions;
import com.catfixture.inputbridge.ui.activity.iconmanager.IconManagerActivity;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class GeneralSettingsFragment$$ExternalSyntheticLambda15 implements View.OnClickListener {
    public final /* synthetic */ Context f$0;

    public /* synthetic */ GeneralSettingsFragment$$ExternalSyntheticLambda15(Context context) {
        this.f$0 = context;
    }

    public final void onClick(View view) {
        ActivityActions.startActivity(this.f$0, IconManagerActivity.class);
    }
}
