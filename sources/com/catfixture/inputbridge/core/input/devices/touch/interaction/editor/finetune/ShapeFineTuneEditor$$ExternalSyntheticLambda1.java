package com.catfixture.inputbridge.core.input.devices.touch.interaction.editor.finetune;

import android.widget.CompoundButton;
import com.catfixture.inputbridge.core.input.utils.IInputWindowElement;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ShapeFineTuneEditor$$ExternalSyntheticLambda1 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ ShapeFineTuneData f$0;
    public final /* synthetic */ IInputWindowElement f$1;

    public /* synthetic */ ShapeFineTuneEditor$$ExternalSyntheticLambda1(ShapeFineTuneData shapeFineTuneData, IInputWindowElement iInputWindowElement) {
        this.f$0 = shapeFineTuneData;
        this.f$1 = iInputWindowElement;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        ShapeFineTuneEditor.lambda$Init$0(this.f$0, this.f$1, compoundButton, z);
    }
}
