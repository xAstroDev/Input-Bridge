package com.catfixture.inputbridge.core.debug;

import android.util.Log;
import com.catfixture.inputbridge.BuildConfig;
import com.catfixture.inputbridge.core.context.AppContext;
import com.catfixture.inputbridge.core.context.ConfigContext;
import java.io.PrintWriter;

public class D {
    public static void E(Throwable th) {
        if (ConfigContext.data != null && ConfigContext.data.debugEnabled) {
            PrintWriter GetErrorWriter = AppContext.app.debugContext.GetErrorWriter();
            if (GetErrorWriter != null) {
                th.printStackTrace(GetErrorWriter);
                GetErrorWriter.write(10);
                GetErrorWriter.flush();
            }
            th.printStackTrace();
        }
    }

    public static void E(Object obj) {
        E(obj.toString());
    }

    public static void E(String str) {
        PrintWriter GetErrorWriter = AppContext.app.debugContext.GetErrorWriter();
        if (GetErrorWriter != null) {
            GetErrorWriter.write(str);
            GetErrorWriter.write(10);
            GetErrorWriter.flush();
        }
        Log.e(BuildConfig.DBG_TAG, str);
    }

    public static void M(Object obj) {
        M(obj.toString());
    }

    public static void M(String str) {
        if (ConfigContext.data != null && ConfigContext.data.debugEnabled) {
            Log.d(BuildConfig.DBG_TAG, str);
        }
    }
}
