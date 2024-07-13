package com.catfixture.inputbridge.core.installer;

import android.app.Activity;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class InstallerUtils$$ExternalSyntheticLambda8 implements Runnable {
    public final /* synthetic */ Activity f$0;
    public final /* synthetic */ Runnable f$1;

    public /* synthetic */ InstallerUtils$$ExternalSyntheticLambda8(Activity activity, Runnable runnable) {
        this.f$0 = activity;
        this.f$1 = runnable;
    }

    public final void run() {
        InstallerUtils.ShowFall(this.f$0, this.f$1);
    }
}
