package com.catfixture.inputbridge.core.utils.process;

import com.catfixture.inputbridge.core.utils.types.delegates.Action;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ProcUtils$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ String f$0;
    public final /* synthetic */ Action f$1;

    public /* synthetic */ ProcUtils$$ExternalSyntheticLambda0(String str, Action action) {
        this.f$0 = str;
        this.f$1 = action;
    }

    public final void run() {
        ProcUtils.lambda$RunSystemCommand$0(this.f$0, this.f$1);
    }
}
