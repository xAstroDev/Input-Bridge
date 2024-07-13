package com.catfixture.inputbridge.core.input.devices.touch.interaction.elements;

import android.content.Context;
import android.view.View;
import com.catfixture.inputbridge.core.input.data.InputTouchControlElementData;
import com.catfixture.inputbridge.core.input.utils.IInputWindowElement;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CommonElementEditor$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ InputTouchControlElementData f$0;
    public final /* synthetic */ IInputWindowElement f$1;
    public final /* synthetic */ Context f$2;

    public /* synthetic */ CommonElementEditor$$ExternalSyntheticLambda0(InputTouchControlElementData inputTouchControlElementData, IInputWindowElement iInputWindowElement, Context context) {
        this.f$0 = inputTouchControlElementData;
        this.f$1 = iInputWindowElement;
        this.f$2 = context;
    }

    public final void onClick(View view) {
        CommonElementEditor.lambda$new$3(this.f$0, this.f$1, this.f$2, view);
    }
}
