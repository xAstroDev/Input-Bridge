package com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.buttons.common;

import com.catfixture.inputbridge.core.input.data.InputTouchControlElementData;
import com.catfixture.inputbridge.core.input.utils.IInputWindowElement;
import com.catfixture.inputbridge.core.utils.types.delegates.Action;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ButtonCommons$$ExternalSyntheticLambda3 implements Action {
    public final /* synthetic */ InputTouchControlElementData f$0;
    public final /* synthetic */ IInputWindowElement f$1;

    public /* synthetic */ ButtonCommons$$ExternalSyntheticLambda3(InputTouchControlElementData inputTouchControlElementData, IInputWindowElement iInputWindowElement) {
        this.f$0 = inputTouchControlElementData;
        this.f$1 = iInputWindowElement;
    }

    public final void Invoke(Object obj) {
        ButtonCommons.lambda$InitButtonDefs$0(this.f$0, this.f$1, (Integer) obj);
    }
}
