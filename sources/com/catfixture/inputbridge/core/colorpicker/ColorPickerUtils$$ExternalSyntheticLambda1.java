package com.catfixture.inputbridge.core.colorpicker;

import android.view.View;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.editor.finetune.ColorData;
import com.catfixture.inputbridge.core.utils.types.delegates.Action;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ColorPickerUtils$$ExternalSyntheticLambda1 implements Action {
    public final /* synthetic */ View f$0;
    public final /* synthetic */ ColorData f$1;
    public final /* synthetic */ Runnable f$2;

    public /* synthetic */ ColorPickerUtils$$ExternalSyntheticLambda1(View view, ColorData colorData, Runnable runnable) {
        this.f$0 = view;
        this.f$1 = colorData;
        this.f$2 = runnable;
    }

    public final void Invoke(Object obj) {
        ColorPickerUtils.lambda$InitColorPicker$0(this.f$0, this.f$1, this.f$2, (Integer) obj);
    }
}
