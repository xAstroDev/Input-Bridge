package com.catfixture.inputbridge.core.installer;

import android.app.Activity;
import com.catfixture.inputbridge.core.utils.files.IFileAccessAbstraction;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class InstallerUtils$$ExternalSyntheticLambda5 implements Runnable {
    public final /* synthetic */ Activity f$0;
    public final /* synthetic */ IFileAccessAbstraction f$1;
    public final /* synthetic */ Runnable f$2;

    public /* synthetic */ InstallerUtils$$ExternalSyntheticLambda5(Activity activity, IFileAccessAbstraction iFileAccessAbstraction, Runnable runnable) {
        this.f$0 = activity;
        this.f$1 = iFileAccessAbstraction;
        this.f$2 = runnable;
    }

    public final void run() {
        InstallerUtils.lambda$CopyInstallerToDownload$8(this.f$0, this.f$1, this.f$2);
    }
}
