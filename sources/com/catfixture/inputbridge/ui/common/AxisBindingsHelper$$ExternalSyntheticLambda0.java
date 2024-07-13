package com.catfixture.inputbridge.ui.common;

import android.content.Context;
import android.view.View;
import com.catfixture.inputbridge.core.input.data.AxisBinding;
import com.catfixture.inputbridge.core.utils.types.delegates.Action;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AxisBindingsHelper$$ExternalSyntheticLambda0 implements Action {
    public final /* synthetic */ AxisBinding f$0;
    public final /* synthetic */ Context f$1;
    public final /* synthetic */ View f$2;
    public final /* synthetic */ int f$3;
    public final /* synthetic */ Runnable f$4;

    public /* synthetic */ AxisBindingsHelper$$ExternalSyntheticLambda0(AxisBinding axisBinding, Context context, View view, int i, Runnable runnable) {
        this.f$0 = axisBinding;
        this.f$1 = context;
        this.f$2 = view;
        this.f$3 = i;
        this.f$4 = runnable;
    }

    public final void Invoke(Object obj) {
        AxisBindingsHelper.lambda$LoadSelectedAxisSettings$0(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, (Integer) obj);
    }
}
