package com.catfixture.inputbridge.core.updates;

import android.app.Activity;
import android.os.Handler;
import com.catfixture.inputbridge.core.utils.types.delegates.Action;
import com.catfixture.inputbridge.ui.common.interactions.OverlayActionProgressAsync;
import okhttp3.Response;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Updater$$ExternalSyntheticLambda1 implements Action {
    public final /* synthetic */ Updater f$0;
    public final /* synthetic */ Handler f$1;
    public final /* synthetic */ OverlayActionProgressAsync f$2;
    public final /* synthetic */ String f$3;
    public final /* synthetic */ Activity f$4;
    public final /* synthetic */ Runnable f$5;

    public /* synthetic */ Updater$$ExternalSyntheticLambda1(Updater updater, Handler handler, OverlayActionProgressAsync overlayActionProgressAsync, String str, Activity activity, Runnable runnable) {
        this.f$0 = updater;
        this.f$1 = handler;
        this.f$2 = overlayActionProgressAsync;
        this.f$3 = str;
        this.f$4 = activity;
        this.f$5 = runnable;
    }

    public final void Invoke(Object obj) {
        this.f$0.m112lambda$Update$2$comcatfixtureinputbridgecoreupdatesUpdater(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, (Response) obj);
    }
}
