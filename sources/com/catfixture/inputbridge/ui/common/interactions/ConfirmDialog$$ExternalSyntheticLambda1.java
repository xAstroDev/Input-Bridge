package com.catfixture.inputbridge.ui.common.interactions;

import android.content.DialogInterface;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ConfirmDialog$$ExternalSyntheticLambda1 implements DialogInterface.OnClickListener {
    public final /* synthetic */ Runnable f$0;

    public /* synthetic */ ConfirmDialog$$ExternalSyntheticLambda1(Runnable runnable) {
        this.f$0 = runnable;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f$0.run();
    }
}
