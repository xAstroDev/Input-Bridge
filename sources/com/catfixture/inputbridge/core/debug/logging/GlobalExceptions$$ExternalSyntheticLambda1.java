package com.catfixture.inputbridge.core.debug.logging;

import android.content.Context;
import java.lang.Thread;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class GlobalExceptions$$ExternalSyntheticLambda1 implements Thread.UncaughtExceptionHandler {
    public final /* synthetic */ Context f$0;

    public /* synthetic */ GlobalExceptions$$ExternalSyntheticLambda1(Context context) {
        this.f$0 = context;
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        GlobalExceptions.lambda$Init$2(this.f$0, thread, th);
    }
}