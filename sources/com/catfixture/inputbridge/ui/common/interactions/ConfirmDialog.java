package com.catfixture.inputbridge.ui.common.interactions;

import android.content.Context;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import com.catfixture.inputbridge.R;

public class ConfirmDialog {
    static /* synthetic */ void lambda$Show$4(DialogInterface dialogInterface, int i) {
    }

    public static void Show(Context context, String str, String str2, String str3, Runnable runnable, String str4, Runnable runnable2) {
        AlertDialog.Builder negativeButton = new AlertDialog.Builder(context).setTitle((CharSequence) str).setMessage((CharSequence) str2).setIcon(17301543).setPositiveButton((CharSequence) str3, (DialogInterface.OnClickListener) new ConfirmDialog$$ExternalSyntheticLambda1(runnable)).setNegativeButton((CharSequence) str4, (DialogInterface.OnClickListener) new ConfirmDialog$$ExternalSyntheticLambda2(runnable2));
        negativeButton.setOnCancelListener(new ConfirmDialog$$ExternalSyntheticLambda0(runnable2));
        negativeButton.show();
    }

    static /* synthetic */ void lambda$Show$1(Runnable runnable, DialogInterface dialogInterface, int i) {
        if (runnable != null) {
            runnable.run();
        }
    }

    static /* synthetic */ void lambda$Show$2(Runnable runnable, DialogInterface dialogInterface) {
        if (runnable != null) {
            runnable.run();
        }
    }

    public static void Show(Context context, String str, String str2, String str3, Runnable runnable) {
        new AlertDialog.Builder(context).setTitle((CharSequence) str).setMessage((CharSequence) str2).setIcon(17301543).setPositiveButton((CharSequence) str3, (DialogInterface.OnClickListener) new ConfirmDialog$$ExternalSyntheticLambda3(runnable)).show();
    }

    static /* synthetic */ void lambda$Show$3(Runnable runnable, DialogInterface dialogInterface, int i) {
        if (runnable != null) {
            runnable.run();
        }
    }

    public static void Show(Context context, String str, String str2) {
        new AlertDialog.Builder(context).setTitle((CharSequence) str).setMessage((CharSequence) str2).setIcon(17301543).setPositiveButton((CharSequence) context.getString(R.string.ok), (DialogInterface.OnClickListener) ConfirmDialog$$ExternalSyntheticLambda4.INSTANCE).show();
    }
}
