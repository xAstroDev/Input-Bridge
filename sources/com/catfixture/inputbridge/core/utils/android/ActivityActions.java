package com.catfixture.inputbridge.core.utils.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class ActivityActions {
    public static void initializeCloseOnSuspend(Activity activity, Runnable runnable) {
        if (activity instanceof ISuspendable) {
            ((ISuspendable) activity).OnSuspend().addObserver(new ActivityActions$$ExternalSyntheticLambda0(runnable));
        }
    }

    public static void startActivity(Context context, Class<?> cls) {
        context.startActivity(new Intent(context, cls));
    }
}
