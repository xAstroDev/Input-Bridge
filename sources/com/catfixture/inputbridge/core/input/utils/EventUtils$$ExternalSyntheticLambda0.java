package com.catfixture.inputbridge.core.input.utils;

import android.view.MotionEvent;
import android.view.View;
import com.catfixture.inputbridge.core.utils.math.Int2;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class EventUtils$$ExternalSyntheticLambda0 implements View.OnTouchListener {
    public final /* synthetic */ ITouchable f$0;
    public final /* synthetic */ Int2 f$1;

    public /* synthetic */ EventUtils$$ExternalSyntheticLambda0(ITouchable iTouchable, Int2 int2) {
        this.f$0 = iTouchable;
        this.f$1 = int2;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return EventUtils.lambda$InitializeITouchableEvents$0(this.f$0, this.f$1, view, motionEvent);
    }
}
