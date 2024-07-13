package com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.buttons.button;

import android.widget.CompoundButton;
import com.catfixture.inputbridge.core.input.data.InputTouchControlElementData;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ButtonElementEditable$$ExternalSyntheticLambda0 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ InputTouchControlElementData f$0;

    public /* synthetic */ ButtonElementEditable$$ExternalSyntheticLambda0(InputTouchControlElementData inputTouchControlElementData) {
        this.f$0 = inputTouchControlElementData;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.f$0.useMouseMode = z;
    }
}
