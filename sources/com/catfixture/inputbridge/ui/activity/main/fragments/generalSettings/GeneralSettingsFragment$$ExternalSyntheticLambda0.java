package com.catfixture.inputbridge.ui.activity.main.fragments.generalSettings;

import android.app.Activity;
import android.view.View;
import com.catfixture.inputbridge.core.installer.InstallerUtils;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class GeneralSettingsFragment$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ Activity f$0;

    public /* synthetic */ GeneralSettingsFragment$$ExternalSyntheticLambda0(Activity activity) {
        this.f$0 = activity;
    }

    public final void onClick(View view) {
        InstallerUtils.CopyInstallerToDownload(this.f$0, (Runnable) null);
    }
}
