package com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.swheel;

import com.catfixture.inputbridge.core.input.devices.IInputDevice;
import java.util.Observable;
import java.util.Observer;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SWheelElement$$ExternalSyntheticLambda4 implements Observer {
    public final /* synthetic */ SWheelElement f$0;
    public final /* synthetic */ IInputDevice f$1;

    public /* synthetic */ SWheelElement$$ExternalSyntheticLambda4(SWheelElement sWheelElement, IInputDevice iInputDevice) {
        this.f$0 = sWheelElement;
        this.f$1 = iInputDevice;
    }

    public final void update(Observable observable, Object obj) {
        this.f$0.m81lambda$CreateEventActions$1$comcatfixtureinputbridgecoreinputdevicestouchinteractionelementsswheelSWheelElement(this.f$1, observable, obj);
    }
}
