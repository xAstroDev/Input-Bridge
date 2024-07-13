package com.catfixture.inputbridge.ui.activity.main.fragments.generalSettings;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import com.catfixture.inputbridge.core.utils.files.FileUtils;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class GeneralSettingsFragment$$ExternalSyntheticLambda13 implements View.OnClickListener {
    public final /* synthetic */ Activity f$0;
    public final /* synthetic */ EditText f$1;

    public /* synthetic */ GeneralSettingsFragment$$ExternalSyntheticLambda13(Activity activity, EditText editText) {
        this.f$0 = activity;
        this.f$1 = editText;
    }

    public final void onClick(View view) {
        FileUtils.OpenDirectoryChooser(this.f$0, new GeneralSettingsFragment$$ExternalSyntheticLambda2(this.f$1));
    }
}
