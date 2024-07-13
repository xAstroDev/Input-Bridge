package com.catfixture.inputbridge.core.updates;

import android.app.Activity;
import android.os.Handler;
import com.catfixture.inputbridge.ui.common.interactions.OverlayActionProgressAsync;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Updater$$ExternalSyntheticLambda4 implements Runnable {
    public final /* synthetic */ Updater f$0;
    public final /* synthetic */ Handler f$1;
    public final /* synthetic */ OverlayActionProgressAsync f$2;
    public final /* synthetic */ Activity f$3;

    public /* synthetic */ Updater$$ExternalSyntheticLambda4(Updater updater, Handler handler, OverlayActionProgressAsync overlayActionProgressAsync, Activity activity) {
        this.f$0 = updater;
        this.f$1 = handler;
        this.f$2 = overlayActionProgressAsync;
        this.f$3 = activity;
    }

    public final void run() {
        this.f$0.m114lambda$Update$4$comcatfixtureinputbridgecoreupdatesUpdater(this.f$1, this.f$2, this.f$3);
    }
}
