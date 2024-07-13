package com.catfixture.inputbridge.ui.activity.main.fragments.generalSettings;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import com.catfixture.inputbridge.core.utils.android.Installer;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class GeneralSettingsFragment$$ExternalSyntheticLambda11 implements View.OnClickListener {
    public final /* synthetic */ Activity f$0;
    public final /* synthetic */ Handler f$1;

    public /* synthetic */ GeneralSettingsFragment$$ExternalSyntheticLambda11(Activity activity, Handler handler) {
        this.f$0 = activity;
        this.f$1 = handler;
    }

    public final void onClick(View view) {
        Installer.InstallInputBridge(this.f$0, this.f$1, (Runnable) null);
    }
}
