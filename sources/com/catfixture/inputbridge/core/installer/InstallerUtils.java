package com.catfixture.inputbridge.core.installer;

import android.app.Activity;
import android.net.Uri;
import android.os.Environment;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.context.ConfigContext;
import com.catfixture.inputbridge.core.utils.files.FileUtils;
import com.catfixture.inputbridge.core.utils.files.IFileAccessAbstraction;
import com.catfixture.inputbridge.ui.common.interactions.ConfirmDialog;
import com.catfixture.inputbridge.ui.common.interactions.OverlayActionProgressSync;

public class InstallerUtils {
    public static void CopyInstallerToDownload(Activity activity, Runnable runnable) {
        Uri parse = Uri.parse(Environment.getExternalStorageDirectory() + "/" + ConfigContext.data.appFolder);
        StringBuilder sb = new StringBuilder();
        sb.append(activity.getString(R.string.installing_what_text));
        sb.append(" ");
        String sb2 = sb.toString();
        FileUtils.RequestFolderAccess(activity, parse, new InstallerUtils$$ExternalSyntheticLambda0(activity, runnable, activity.getString(R.string.creating_what_text) + " ", "InputBridge", "Installer", sb2), new InstallerUtils$$ExternalSyntheticLambda6(activity, runnable));
    }

    static /* synthetic */ void lambda$CopyInstallerToDownload$10(Activity activity, Runnable runnable, String str, String str2, String str3, String str4, IFileAccessAbstraction iFileAccessAbstraction) {
        if (!ConfigContext.data.appFolder.equals(iFileAccessAbstraction.GetEndSegment())) {
            ConfirmDialog.Show(activity, activity.getString(R.string.error_text), activity.getString(R.string.error_use_only_downloads, new Object[]{ConfigContext.data.appFolder}), activity.getString(R.string.close_text), new InstallerUtils$$ExternalSyntheticLambda2(runnable));
            FileUtils.ClearPersistedPerm(activity, iFileAccessAbstraction.GetUri());
            return;
        }
        try {
            InstallerTempDto installerTempDto = new InstallerTempDto();
            OverlayActionProgressSync overlayActionProgressSync = new OverlayActionProgressSync(activity, activity.getString(R.string.installing_text));
            overlayActionProgressSync.Init(activity.getString(R.string.initializing_text));
            OverlayActionProgressSync Enqueue = overlayActionProgressSync.Enqueue(str + str2 + " dir", 10, new InstallerUtils$$ExternalSyntheticLambda13(installerTempDto, iFileAccessAbstraction, str2));
            OverlayActionProgressSync Enqueue2 = Enqueue.Enqueue(str + str2 + " dir", 20, new InstallerUtils$$ExternalSyntheticLambda1(installerTempDto, str3));
            StringBuilder sb = new StringBuilder();
            sb.append(str4);
            sb.append("install.bat");
            OverlayActionProgressSync Enqueue3 = Enqueue2.Enqueue(sb.toString(), 40, new InstallerUtils$$ExternalSyntheticLambda9(installerTempDto, activity));
            OverlayActionProgressSync Enqueue4 = Enqueue3.Enqueue(str4 + "ib", 10, new InstallerUtils$$ExternalSyntheticLambda10(installerTempDto, activity));
            OverlayActionProgressSync Enqueue5 = Enqueue4.Enqueue(str4 + "ib.exe", 60, new InstallerUtils$$ExternalSyntheticLambda11(installerTempDto, activity));
            Enqueue5.Enqueue(str4 + "di.dll", 80, new InstallerUtils$$ExternalSyntheticLambda12(installerTempDto, activity)).OnDone(new InstallerUtils$$ExternalSyntheticLambda7(activity, runnable)).OnFail(new InstallerUtils$$ExternalSyntheticLambda5(activity, iFileAccessAbstraction, runnable)).OnAbort(new InstallerUtils$$ExternalSyntheticLambda8(activity, runnable)).Execute();
        } catch (Exception unused) {
            ShowFall(activity, runnable);
        }
    }

    static /* synthetic */ void lambda$CopyInstallerToDownload$0(Runnable runnable) {
        if (runnable != null) {
            runnable.run();
        }
    }

    static /* synthetic */ void lambda$CopyInstallerToDownload$8(Activity activity, IFileAccessAbstraction iFileAccessAbstraction, Runnable runnable) {
        FileUtils.ClearPersistedPerm(activity, iFileAccessAbstraction.GetUri());
        ShowFall(activity, runnable);
    }

    /* access modifiers changed from: private */
    public static void ShowSuccess(Activity activity, Runnable runnable) {
        String string = activity.getString(R.string.done_text);
        ConfirmDialog.Show(activity, string, activity.getString(R.string.installer_saved_text, new Object[]{ConfigContext.data.appFolder}) + activity.getString(R.string.afterinstall_tip_text), activity.getString(R.string.close_text), new InstallerUtils$$ExternalSyntheticLambda4(runnable));
    }

    static /* synthetic */ void lambda$ShowSuccess$12(Runnable runnable) {
        if (runnable != null) {
            runnable.run();
        }
    }

    /* access modifiers changed from: private */
    public static void ShowFall(Activity activity, Runnable runnable) {
        ConfirmDialog.Show(activity, activity.getString(R.string.error_text), activity.getString(R.string.installer_not_saved_text), activity.getString(R.string.close_text), new InstallerUtils$$ExternalSyntheticLambda3(runnable));
    }

    static /* synthetic */ void lambda$ShowFall$13(Runnable runnable) {
        if (runnable != null) {
            runnable.run();
        }
    }
}
