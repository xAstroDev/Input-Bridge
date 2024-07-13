package com.catfixture.inputbridge.ui.common.interactions;

import android.view.View;
import com.catfixture.inputbridge.core.utils.windows.MinimalWindow;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class OverlayDialog$$ExternalSyntheticLambda2 implements View.OnClickListener {
    public final /* synthetic */ Runnable f$0;
    public final /* synthetic */ MinimalWindow f$1;

    public /* synthetic */ OverlayDialog$$ExternalSyntheticLambda2(Runnable runnable, MinimalWindow minimalWindow) {
        this.f$0 = runnable;
        this.f$1 = minimalWindow;
    }

    public final void onClick(View view) {
        OverlayDialog.lambda$Show$0(this.f$0, this.f$1, view);
    }
}
