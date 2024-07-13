package com.catfixture.inputbridge.core.input.devices.touch.interaction.elements;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.catfixture.inputbridge.core.input.data.InputTouchControlElementData;
import com.catfixture.inputbridge.core.utils.types.delegates.Action;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DrawHelper$$ExternalSyntheticLambda0 implements Action {
    public final /* synthetic */ InputTouchControlElementData f$0;
    public final /* synthetic */ Canvas f$1;
    public final /* synthetic */ float f$2;
    public final /* synthetic */ float f$3;
    public final /* synthetic */ float f$4;
    public final /* synthetic */ Paint f$5;
    public final /* synthetic */ float f$6;
    public final /* synthetic */ int f$7;
    public final /* synthetic */ int f$8;

    public /* synthetic */ DrawHelper$$ExternalSyntheticLambda0(InputTouchControlElementData inputTouchControlElementData, Canvas canvas, float f, float f2, float f3, Paint paint, float f4, int i, int i2) {
        this.f$0 = inputTouchControlElementData;
        this.f$1 = canvas;
        this.f$2 = f;
        this.f$3 = f2;
        this.f$4 = f3;
        this.f$5 = paint;
        this.f$6 = f4;
        this.f$7 = i;
        this.f$8 = i2;
    }

    public final void Invoke(Object obj) {
        DrawHelper.lambda$DrawShape$0(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, (Boolean) obj);
    }
}
