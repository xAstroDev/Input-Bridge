package com.catfixture.inputbridge.core.installer;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class InstallerUtils$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ InstallerTempDto f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ InstallerUtils$$ExternalSyntheticLambda1(InstallerTempDto installerTempDto, String str) {
        this.f$0 = installerTempDto;
        this.f$1 = str;
    }

    public final void run() {
        this.f$0.installerFolder = this.f$0.appDir.CreateDir(this.f$1).RemoveAllFiles();
    }
}
