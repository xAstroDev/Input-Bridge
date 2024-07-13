package com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.cheatCode;

import android.view.View;
import com.catfixture.inputbridge.core.input.data.CheatCodeAction;
import com.catfixture.inputbridge.core.input.data.InputTouchControlElementData;
import com.catfixture.inputbridge.core.input.utils.IInputWindowElement;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CheatCodeEditable$$ExternalSyntheticLambda1 implements View.OnLongClickListener {
    public final /* synthetic */ InputTouchControlElementData f$0;
    public final /* synthetic */ CheatCodeAction f$1;
    public final /* synthetic */ IInputWindowElement f$2;

    public /* synthetic */ CheatCodeEditable$$ExternalSyntheticLambda1(InputTouchControlElementData inputTouchControlElementData, CheatCodeAction cheatCodeAction, IInputWindowElement iInputWindowElement) {
        this.f$0 = inputTouchControlElementData;
        this.f$1 = cheatCodeAction;
        this.f$2 = iInputWindowElement;
    }

    public final boolean onLongClick(View view) {
        return CheatCodeEditable.lambda$new$1(this.f$0, this.f$1, this.f$2, view);
    }
}
