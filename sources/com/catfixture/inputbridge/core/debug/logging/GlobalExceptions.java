package com.catfixture.inputbridge.core.debug.logging;

import android.content.Context;
import com.catfixture.inputbridge.core.debug.D;
import com.catfixture.inputbridge.ui.activity.main.ErrorH;
import java.lang.Thread;
import java.util.Arrays;

public class GlobalExceptions {
    private static final Thread.UncaughtExceptionHandler handler = GlobalExceptions$$ExternalSyntheticLambda3.INSTANCE;

    static /* synthetic */ void lambda$static$0(Thread thread, Throwable th) {
        Throwable cause = th.getCause();
        D.E(th.getMessage());
        if (cause != null) {
            D.E("Uncaught exception");
            D.E(cause);
        }
    }

    public static void Init(Context context) {
        Thread.setDefaultUncaughtExceptionHandler(new GlobalExceptions$$ExternalSyntheticLambda0(context));
        Thread.currentThread().setUncaughtExceptionHandler(new GlobalExceptions$$ExternalSyntheticLambda1(context));
    }

    static /* synthetic */ void lambda$Init$1(Context context, Thread thread, Throwable th) {
        ErrorH.RaiseCrash(context, th.getMessage(), Arrays.toString(th.getStackTrace()));
        handler.uncaughtException(thread, th);
    }

    static /* synthetic */ void lambda$Init$2(Context context, Thread thread, Throwable th) {
        ErrorH.RaiseCrash(context, th.getMessage(), Arrays.toString(th.getStackTrace()));
        handler.uncaughtException(thread, th);
    }

    public static Thread Init(Context context, Thread thread) {
        Thread.setDefaultUncaughtExceptionHandler(new GlobalExceptions$$ExternalSyntheticLambda2(context));
        return thread;
    }

    static /* synthetic */ void lambda$Init$3(Context context, Thread thread, Throwable th) {
        ErrorH.RaiseCrash(context, th.getMessage(), Arrays.toString(th.getStackTrace()));
        handler.uncaughtException(thread, th);
    }
}
