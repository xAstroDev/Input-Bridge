package com.catfixture.inputbridge.core.input.devices.touch.interaction.elements;

import android.view.ViewTreeObserver;
import android.widget.ScrollView;
import com.catfixture.inputbridge.core.context.ConfigContext;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CommonElementEditor$$ExternalSyntheticLambda2 implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ ScrollView f$0;

    public /* synthetic */ CommonElementEditor$$ExternalSyntheticLambda2(ScrollView scrollView) {
        this.f$0 = scrollView;
    }

    public final void onGlobalLayout() {
        this.f$0.setScrollY(ConfigContext.data.GetCurrentProfile().tceScrollPos);
    }
}
