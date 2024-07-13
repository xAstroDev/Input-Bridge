package com.catfixture.inputbridge.ui.activity.main.fragments.touchSettings;

import android.content.Context;
import android.view.View;
import com.catfixture.inputbridge.core.utils.android.ActivityActions;
import com.catfixture.inputbridge.ui.activity.editors.touchEditor.TouchEditorActivity;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class TouchSettingsFragment$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ Context f$0;

    public /* synthetic */ TouchSettingsFragment$$ExternalSyntheticLambda0(Context context) {
        this.f$0 = context;
    }

    public final void onClick(View view) {
        ActivityActions.startActivity(this.f$0, TouchEditorActivity.class);
    }
}
