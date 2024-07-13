package com.catfixture.inputbridge.core.utils.process;

import android.content.Context;
import com.catfixture.inputbridge.core.debug.D;
import com.catfixture.inputbridge.core.debug.logging.GlobalExceptions;
import com.catfixture.inputbridge.core.utils.types.delegates.Action;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcUtils {
    public static <T> int GetProcessIDByClassName(Class<T> cls) {
        return Integer.parseInt(cls.getName().substring(1));
    }

    public static void RunSystemCommand(String str, Action<Integer> action) {
        GlobalExceptions.Init((Context) null, new Thread(new ProcUtils$$ExternalSyntheticLambda0(str, action))).start();
    }

    static /* synthetic */ void lambda$RunSystemCommand$0(String str, Action action) {
        try {
            Process exec = Runtime.getRuntime().exec(str);
            exec.waitFor();
            int exitValue = exec.exitValue();
            if (action != null) {
                action.Invoke(Integer.valueOf(exitValue));
            }
        } catch (IOException | InterruptedException e) {
            D.E(e);
            if (action != null) {
                action.Invoke(-1);
            }
        }
    }

    public static void RunSystemCommandWithOutput(String str, Action<Integer> action) {
        GlobalExceptions.Init((Context) null, new Thread(new ProcUtils$$ExternalSyntheticLambda2(str, action))).start();
    }

    static /* synthetic */ void lambda$RunSystemCommandWithOutput$1(String str, Action action) {
        try {
            Process exec = Runtime.getRuntime().exec(str);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getErrorStream()));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
                sb.append(10);
            }
            D.M(sb.toString());
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            StringBuilder sb2 = new StringBuilder();
            while (true) {
                String readLine2 = bufferedReader2.readLine();
                if (readLine2 == null) {
                    break;
                }
                sb2.append(readLine2);
                sb2.append(10);
            }
            D.M(sb2.toString());
            exec.waitFor();
            int exitValue = exec.exitValue();
            if (action != null) {
                action.Invoke(Integer.valueOf(exitValue));
            }
        } catch (IOException | InterruptedException e) {
            D.E(e);
            if (action != null) {
                action.Invoke(-1);
            }
        }
    }

    public static void RunSystemCommandString(String str, Action<String> action) {
        GlobalExceptions.Init((Context) null, new Thread(new ProcUtils$$ExternalSyntheticLambda1(str, action))).start();
    }

    static /* synthetic */ void lambda$RunSystemCommandString$2(String str, Action action) {
        try {
            Process exec = Runtime.getRuntime().exec(str);
            String readLine = new BufferedReader(new InputStreamReader(exec.getInputStream())).readLine();
            D.M("RESULT WAS = " + readLine);
            action.Invoke(readLine);
            exec.destroy();
        } catch (IOException e) {
            D.E((Throwable) e);
        }
    }
}
