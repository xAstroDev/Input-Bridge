package com.catfixture.inputbridge.core.installer;

import android.app.Activity;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.utils.android.AndroidUtils;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class InstallerUtils$$ExternalSyntheticLambda11 implements Runnable {
    public final /* synthetic */ InstallerTempDto f$0;
    public final /* synthetic */ Activity f$1;

    public /* synthetic */ InstallerUtils$$ExternalSyntheticLambda11(InstallerTempDto installerTempDto, Activity activity) {
        this.f$0 = installerTempDto;
        this.f$1 = activity;
    }

    public final void run() {
        this.f$0.installerFolder.Write("ib.exe", AndroidUtils.GetRawBytes(this.f$1, R.raw.ib));
    }
}
