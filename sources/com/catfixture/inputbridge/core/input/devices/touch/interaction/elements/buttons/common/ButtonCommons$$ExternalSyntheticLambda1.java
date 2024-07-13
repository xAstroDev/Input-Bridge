package com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.buttons.common;

import android.content.Context;
import android.view.View;
import com.catfixture.inputbridge.core.input.data.InputTouchControlElementData;
import com.catfixture.inputbridge.core.input.utils.IInputWindowElement;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ButtonCommons$$ExternalSyntheticLambda1 implements View.OnClickListener {
    public final /* synthetic */ Context f$0;
    public final /* synthetic */ IInputWindowElement f$1;
    public final /* synthetic */ InputTouchControlElementData f$2;

    public /* synthetic */ ButtonCommons$$ExternalSyntheticLambda1(Context context, IInputWindowElement iInputWindowElement, InputTouchControlElementData inputTouchControlElementData) {
        this.f$0 = context;
        this.f$1 = iInputWindowElement;
        this.f$2 = inputTouchControlElementData;
    }

    public final void onClick(View view) {
        ButtonCommons.lambda$InitButtonDefs$2(this.f$0, this.f$1, this.f$2, view);
    }
}
