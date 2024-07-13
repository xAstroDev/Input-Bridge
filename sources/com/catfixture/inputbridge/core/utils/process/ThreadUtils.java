package com.catfixture.inputbridge.core.utils.process;

import android.os.Handler;
import com.catfixture.inputbridge.core.utils.types.delegates.Action;

public class ThreadUtils {
    public static void Sleep(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException unused) {
        }
    }

    public static void LockThreadUntilUITask(Handler handler, Action<Thread> action) {
        Thread currentThread = Thread.currentThread();
        handler.post(new ThreadUtils$$ExternalSyntheticLambda0(action, currentThread));
        synchronized (currentThread) {
            try {
                currentThread.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
