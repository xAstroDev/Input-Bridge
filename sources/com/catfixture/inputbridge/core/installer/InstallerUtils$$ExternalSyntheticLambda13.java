package com.catfixture.inputbridge.core.installer;

import com.catfixture.inputbridge.core.utils.files.IFileAccessAbstraction;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class InstallerUtils$$ExternalSyntheticLambda13 implements Runnable {
    public final /* synthetic */ InstallerTempDto f$0;
    public final /* synthetic */ IFileAccessAbstraction f$1;
    public final /* synthetic */ String f$2;

    public /* synthetic */ InstallerUtils$$ExternalSyntheticLambda13(InstallerTempDto installerTempDto, IFileAccessAbstraction iFileAccessAbstraction, String str) {
        this.f$0 = installerTempDto;
        this.f$1 = iFileAccessAbstraction;
        this.f$2 = str;
    }

    public final void run() {
        this.f$0.appDir = this.f$1.CreateDir(this.f$2);
    }
}
