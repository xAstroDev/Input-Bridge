package com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.buttons.common;

import android.view.KeyEvent;
import android.view.View;
import com.catfixture.inputbridge.core.input.utils.IInputWindowElement;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ButtonCommons$$ExternalSyntheticLambda2 implements View.OnKeyListener {
    public final /* synthetic */ IInputWindowElement f$0;

    public /* synthetic */ ButtonCommons$$ExternalSyntheticLambda2(IInputWindowElement iInputWindowElement) {
        this.f$0 = iInputWindowElement;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        return ButtonCommons.lambda$InitButtonDefs$3(this.f$0, view, i, keyEvent);
    }
}
