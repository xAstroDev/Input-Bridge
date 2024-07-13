package com.catfixture.inputbridge.core.input.devices.touch.interaction.editor.finetune;

import android.widget.CompoundButton;
import android.widget.SeekBar;
import com.catfixture.inputbridge.core.input.utils.IInputWindowElement;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FineTuneEditorCommon$$ExternalSyntheticLambda0 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ ShadowData f$0;
    public final /* synthetic */ IInputWindowElement f$1;
    public final /* synthetic */ SeekBar f$2;

    public /* synthetic */ FineTuneEditorCommon$$ExternalSyntheticLambda0(ShadowData shadowData, IInputWindowElement iInputWindowElement, SeekBar seekBar) {
        this.f$0 = shadowData;
        this.f$1 = iInputWindowElement;
        this.f$2 = seekBar;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        FineTuneEditorCommon.lambda$InitShadowEditor$0(this.f$0, this.f$1, this.f$2, compoundButton, z);
    }
}
