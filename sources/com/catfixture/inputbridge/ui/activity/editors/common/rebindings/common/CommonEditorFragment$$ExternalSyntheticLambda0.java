package com.catfixture.inputbridge.ui.activity.editors.common.rebindings.common;

import com.catfixture.inputbridge.core.input.data.KeyboardRebinding;
import com.catfixture.inputbridge.core.utils.types.delegates.Action;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CommonEditorFragment$$ExternalSyntheticLambda0 implements Action {
    public final /* synthetic */ KeyboardRebinding f$0;
    public final /* synthetic */ Runnable f$1;

    public /* synthetic */ CommonEditorFragment$$ExternalSyntheticLambda0(KeyboardRebinding keyboardRebinding, Runnable runnable) {
        this.f$0 = keyboardRebinding;
        this.f$1 = runnable;
    }

    public final void Invoke(Object obj) {
        CommonEditorFragment.lambda$SetupButtonType$1(this.f$0, this.f$1, (Integer) obj);
    }
}
