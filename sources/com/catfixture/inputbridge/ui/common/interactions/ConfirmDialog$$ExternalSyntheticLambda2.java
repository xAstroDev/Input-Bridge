package com.catfixture.inputbridge.ui.common.interactions;

import android.content.DialogInterface;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ConfirmDialog$$ExternalSyntheticLambda2 implements DialogInterface.OnClickListener {
    public final /* synthetic */ Runnable f$0;

    public /* synthetic */ ConfirmDialog$$ExternalSyntheticLambda2(Runnable runnable) {
        this.f$0 = runnable;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ConfirmDialog.lambda$Show$1(this.f$0, dialogInterface, i);
    }
}
