package com.catfixture.inputbridge.core.overlay;

import android.widget.ImageView;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class MainControlsOverlayFragment$$ExternalSyntheticLambda16 implements Runnable {
    public final /* synthetic */ ImageView f$0;
    public final /* synthetic */ Runnable f$1;

    public /* synthetic */ MainControlsOverlayFragment$$ExternalSyntheticLambda16(ImageView imageView, Runnable runnable) {
        this.f$0 = imageView;
        this.f$1 = runnable;
    }

    public final void run() {
        this.f$0.post(this.f$1);
    }
}
