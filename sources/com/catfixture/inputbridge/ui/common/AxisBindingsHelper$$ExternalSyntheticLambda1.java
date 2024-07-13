package com.catfixture.inputbridge.ui.common;

import com.catfixture.inputbridge.core.input.data.AxisBinding;
import com.catfixture.inputbridge.core.utils.types.delegates.Action;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AxisBindingsHelper$$ExternalSyntheticLambda1 implements Action {
    public final /* synthetic */ AxisBinding f$0;
    public final /* synthetic */ Runnable f$1;

    public /* synthetic */ AxisBindingsHelper$$ExternalSyntheticLambda1(AxisBinding axisBinding, Runnable runnable) {
        this.f$0 = axisBinding;
        this.f$1 = runnable;
    }

    public final void Invoke(Object obj) {
        AxisBindingsHelper.lambda$ReloadAxisSubtype$1(this.f$0, this.f$1, (Integer) obj);
    }
}
