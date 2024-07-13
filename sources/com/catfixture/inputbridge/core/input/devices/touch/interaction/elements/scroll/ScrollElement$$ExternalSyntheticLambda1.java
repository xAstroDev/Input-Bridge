package com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.scroll;

import android.view.MotionEvent;
import com.catfixture.inputbridge.core.input.devices.IInputDevice;
import java.util.Observable;
import java.util.Observer;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ScrollElement$$ExternalSyntheticLambda1 implements Observer {
    public final /* synthetic */ IInputDevice f$0;

    public /* synthetic */ ScrollElement$$ExternalSyntheticLambda1(IInputDevice iInputDevice) {
        this.f$0 = iInputDevice;
    }

    public final void update(Observable observable, Object obj) {
        this.f$0.SetScroll(((MotionEvent) obj).getY());
    }
}
