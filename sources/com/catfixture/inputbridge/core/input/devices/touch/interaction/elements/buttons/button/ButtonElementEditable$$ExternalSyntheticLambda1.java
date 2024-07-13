package com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.buttons.button;

import android.widget.CompoundButton;
import android.widget.LinearLayout;
import com.catfixture.inputbridge.core.input.data.InputTouchControlElementData;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ButtonElementEditable$$ExternalSyntheticLambda1 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ InputTouchControlElementData f$0;
    public final /* synthetic */ LinearLayout f$1;

    public /* synthetic */ ButtonElementEditable$$ExternalSyntheticLambda1(InputTouchControlElementData inputTouchControlElementData, LinearLayout linearLayout) {
        this.f$0 = inputTouchControlElementData;
        this.f$1 = linearLayout;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        ButtonElementEditable.lambda$new$1(this.f$0, this.f$1, compoundButton, z);
    }
}
