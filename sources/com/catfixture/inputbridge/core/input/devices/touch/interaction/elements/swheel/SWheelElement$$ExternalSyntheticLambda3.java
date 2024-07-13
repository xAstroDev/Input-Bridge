package com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.swheel;

import com.catfixture.inputbridge.core.input.data.ComputedAxisBinding;
import com.catfixture.inputbridge.core.input.devices.IInputDevice;
import java.util.Observable;
import java.util.Observer;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SWheelElement$$ExternalSyntheticLambda3 implements Observer {
    public final /* synthetic */ SWheelElement f$0;
    public final /* synthetic */ ComputedAxisBinding f$1;
    public final /* synthetic */ IInputDevice f$2;

    public /* synthetic */ SWheelElement$$ExternalSyntheticLambda3(SWheelElement sWheelElement, ComputedAxisBinding computedAxisBinding, IInputDevice iInputDevice) {
        this.f$0 = sWheelElement;
        this.f$1 = computedAxisBinding;
        this.f$2 = iInputDevice;
    }

    public final void update(Observable observable, Object obj) {
        this.f$0.m85lambda$CreateEventActions$5$comcatfixtureinputbridgecoreinputdevicestouchinteractionelementsswheelSWheelElement(this.f$1, this.f$2, observable, obj);
    }
}
