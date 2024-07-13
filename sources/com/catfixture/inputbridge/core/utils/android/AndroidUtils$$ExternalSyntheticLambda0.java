package com.catfixture.inputbridge.core.utils.android;

import androidx.activity.result.ActivityResult;
import com.catfixture.inputbridge.core.utils.types.delegates.Action;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AndroidUtils$$ExternalSyntheticLambda0 implements Action {
    public final /* synthetic */ Runnable f$0;
    public final /* synthetic */ Runnable f$1;

    public /* synthetic */ AndroidUtils$$ExternalSyntheticLambda0(Runnable runnable, Runnable runnable2) {
        this.f$0 = runnable;
        this.f$1 = runnable2;
    }

    public final void Invoke(Object obj) {
        AndroidUtils.lambda$InstallUpdate$0(this.f$0, this.f$1, (ActivityResult) obj);
    }
}
