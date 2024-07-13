package com.catfixture.inputbridge.core.utils.android;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Handler;
import com.catfixture.inputbridge.core.utils.types.delegates.Action;
import java.io.File;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Installer$$ExternalSyntheticLambda0 implements Action {
    public final /* synthetic */ Handler f$0;
    public final /* synthetic */ ProgressDialog f$1;
    public final /* synthetic */ Activity f$2;
    public final /* synthetic */ Runnable f$3;
    public final /* synthetic */ File f$4;
    public final /* synthetic */ File f$5;
    public final /* synthetic */ File f$6;

    public /* synthetic */ Installer$$ExternalSyntheticLambda0(Handler handler, ProgressDialog progressDialog, Activity activity, Runnable runnable, File file, File file2, File file3) {
        this.f$0 = handler;
        this.f$1 = progressDialog;
        this.f$2 = activity;
        this.f$3 = runnable;
        this.f$4 = file;
        this.f$5 = file2;
        this.f$6 = file3;
    }

    public final void Invoke(Object obj) {
        Installer.lambda$InstallInputBridge$1(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, (Integer) obj);
    }
}
