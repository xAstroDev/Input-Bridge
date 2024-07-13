package com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.swipe;

import com.catfixture.inputbridge.core.input.devices.IInputDevice;
import java.util.Observable;
import java.util.Observer;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SwipeElement$$ExternalSyntheticLambda2 implements Observer {
    public final /* synthetic */ SwipeElement f$0;
    public final /* synthetic */ IInputDevice f$1;

    public /* synthetic */ SwipeElement$$ExternalSyntheticLambda2(SwipeElement swipeElement, IInputDevice iInputDevice) {
        this.f$0 = swipeElement;
        this.f$1 = iInputDevice;
    }

    public final void update(Observable observable, Object obj) {
        this.f$0.m88lambda$CreateEventActions$2$comcatfixtureinputbridgecoreinputdevicestouchinteractionelementsswipeSwipeElement(this.f$1, observable, obj);
    }
}
