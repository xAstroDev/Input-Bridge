package com.catfixture.inputbridge.core.colorpicker;

import android.content.Context;
import android.view.View;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.editor.finetune.ColorData;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ColorPickerUtils$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ View f$0;
    public final /* synthetic */ Context f$1;
    public final /* synthetic */ ColorData f$2;
    public final /* synthetic */ Runnable f$3;
    public final /* synthetic */ View f$4;

    public /* synthetic */ ColorPickerUtils$$ExternalSyntheticLambda0(View view, Context context, ColorData colorData, Runnable runnable, View view2) {
        this.f$0 = view;
        this.f$1 = context;
        this.f$2 = colorData;
        this.f$3 = runnable;
        this.f$4 = view2;
    }

    public final void onClick(View view) {
        ColorPickerUtils.lambda$InitColorPicker$1(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, view);
    }
}
