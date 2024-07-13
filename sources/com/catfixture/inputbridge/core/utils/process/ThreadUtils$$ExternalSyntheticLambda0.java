package com.catfixture.inputbridge.core.utils.process;

import com.catfixture.inputbridge.core.utils.types.delegates.Action;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ThreadUtils$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ Action f$0;
    public final /* synthetic */ Thread f$1;

    public /* synthetic */ ThreadUtils$$ExternalSyntheticLambda0(Action action, Thread thread) {
        this.f$0 = action;
        this.f$1 = thread;
    }

    public final void run() {
        this.f$0.Invoke(this.f$1);
    }
}
