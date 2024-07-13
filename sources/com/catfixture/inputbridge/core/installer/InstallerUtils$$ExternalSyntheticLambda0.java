package com.catfixture.inputbridge.core.installer;

import android.app.Activity;
import com.catfixture.inputbridge.core.utils.files.IFileAccessAbstraction;
import com.catfixture.inputbridge.core.utils.types.delegates.Action;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class InstallerUtils$$ExternalSyntheticLambda0 implements Action {
    public final /* synthetic */ Activity f$0;
    public final /* synthetic */ Runnable f$1;
    public final /* synthetic */ String f$2;
    public final /* synthetic */ String f$3;
    public final /* synthetic */ String f$4;
    public final /* synthetic */ String f$5;

    public /* synthetic */ InstallerUtils$$ExternalSyntheticLambda0(Activity activity, Runnable runnable, String str, String str2, String str3, String str4) {
        this.f$0 = activity;
        this.f$1 = runnable;
        this.f$2 = str;
        this.f$3 = str2;
        this.f$4 = str3;
        this.f$5 = str4;
    }

    public final void Invoke(Object obj) {
        InstallerUtils.lambda$CopyInstallerToDownload$10(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, (IFileAccessAbstraction) obj);
    }
}
