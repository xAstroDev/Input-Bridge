package com.catfixture.inputbridge.core.utils.android;

import java.util.Observable;
import java.util.Observer;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ActivityActions$$ExternalSyntheticLambda0 implements Observer {
    public final /* synthetic */ Runnable f$0;

    public /* synthetic */ ActivityActions$$ExternalSyntheticLambda0(Runnable runnable) {
        this.f$0 = runnable;
    }

    public final void update(Observable observable, Object obj) {
        this.f$0.run();
    }
}
