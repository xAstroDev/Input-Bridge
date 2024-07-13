package com.catfixture.inputbridge.ui.common.interactions;

import android.content.DialogInterface;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ConfirmDialog$$ExternalSyntheticLambda0 implements DialogInterface.OnCancelListener {
    public final /* synthetic */ Runnable f$0;

    public /* synthetic */ ConfirmDialog$$ExternalSyntheticLambda0(Runnable runnable) {
        this.f$0 = runnable;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ConfirmDialog.lambda$Show$2(this.f$0, dialogInterface);
    }
}
