package com.catfixture.inputbridge.core.utils.android;

import android.app.Activity;
import android.app.ProgressDialog;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Installer$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ ProgressDialog f$0;
    public final /* synthetic */ Integer f$1;
    public final /* synthetic */ Activity f$2;
    public final /* synthetic */ Runnable f$3;

    public /* synthetic */ Installer$$ExternalSyntheticLambda1(ProgressDialog progressDialog, Integer num, Activity activity, Runnable runnable) {
        this.f$0 = progressDialog;
        this.f$1 = num;
        this.f$2 = activity;
        this.f$3 = runnable;
    }

    public final void run() {
        Installer.lambda$InstallInputBridge$0(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}
