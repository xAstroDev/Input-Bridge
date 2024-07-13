package com.catfixture.inputbridge.core.debug.logging;

import java.lang.Thread;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class GlobalExceptions$$ExternalSyntheticLambda3 implements Thread.UncaughtExceptionHandler {
    public static final /* synthetic */ GlobalExceptions$$ExternalSyntheticLambda3 INSTANCE = new GlobalExceptions$$ExternalSyntheticLambda3();

    private /* synthetic */ GlobalExceptions$$ExternalSyntheticLambda3() {
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        GlobalExceptions.lambda$static$0(thread, th);
    }
}
