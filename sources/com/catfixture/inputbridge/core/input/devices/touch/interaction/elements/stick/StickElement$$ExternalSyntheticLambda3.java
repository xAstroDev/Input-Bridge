package com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.stick;

import com.catfixture.inputbridge.core.input.devices.IInputDevice;
import java.util.Observable;
import java.util.Observer;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class StickElement$$ExternalSyntheticLambda3 implements Observer {
    public final /* synthetic */ StickElement f$0;
    public final /* synthetic */ IInputDevice f$1;

    public /* synthetic */ StickElement$$ExternalSyntheticLambda3(StickElement stickElement, IInputDevice iInputDevice) {
        this.f$0 = stickElement;
        this.f$1 = iInputDevice;
    }

    public final void update(Observable observable, Object obj) {
        this.f$0.m72lambda$CreateEventActions$1$comcatfixtureinputbridgecoreinputdevicestouchinteractionelementsstickStickElement(this.f$1, observable, obj);
    }
}
