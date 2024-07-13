package com.catfixture.inputbridge.core.utils.android;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Handler;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.debug.D;
import com.catfixture.inputbridge.core.utils.files.FileUtils;
import com.catfixture.inputbridge.core.utils.process.ProcUtils;
import com.catfixture.inputbridge.ui.common.interactions.ConfirmDialog;
import java.io.File;

public class Installer {
    public static void InstallInputBridge(Activity activity, Handler handler, Runnable runnable) {
        ProgressDialog progressDialog = new ProgressDialog(activity);
        progressDialog.setProgressStyle(0);
        progressDialog.setMessage("Installing... please wait!\n");
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.show();
        String absolutePath = activity.getFilesDir().getAbsolutePath();
        File CopyRawToTemp = FileUtils.CopyRawToTemp(activity, R.raw.vgo_bridge_service_android_root_installer, "/installerScript.sh");
        File CopyRawToTemp2 = FileUtils.CopyRawToTemp(activity, R.raw.ib, "/ib.exe");
        File CopyRawToTemp3 = FileUtils.CopyRawToTemp(activity, R.raw.ib_launcher, "/ib");
        ProcUtils.RunSystemCommandWithOutput("su -c sh " + absolutePath + "/installerScript.sh 0 " + absolutePath, new Installer$$ExternalSyntheticLambda0(handler, progressDialog, activity, runnable, CopyRawToTemp2, CopyRawToTemp, CopyRawToTemp3));
    }

    static /* synthetic */ void lambda$InstallInputBridge$1(Handler handler, ProgressDialog progressDialog, Activity activity, Runnable runnable, File file, File file2, File file3, Integer num) {
        D.M("Installer returned : " + num);
        handler.post(new Installer$$ExternalSyntheticLambda1(progressDialog, num, activity, runnable));
        file.delete();
        file2.delete();
        file3.delete();
    }

    static /* synthetic */ void lambda$InstallInputBridge$0(ProgressDialog progressDialog, Integer num, Activity activity, Runnable runnable) {
        progressDialog.setMessage("Done!");
        if (num.intValue() == 0) {
            String string = activity.getString(R.string.installed_text);
            ConfirmDialog.Show(activity, string, activity.getString(R.string.install_ok_root) + "installed!");
        } else {
            ConfirmDialog.Show(activity, activity.getString(R.string.not_installed_text), activity.getString(R.string.install_fail_root));
        }
        if (runnable != null) {
            runnable.run();
        }
        progressDialog.dismiss();
    }
}
