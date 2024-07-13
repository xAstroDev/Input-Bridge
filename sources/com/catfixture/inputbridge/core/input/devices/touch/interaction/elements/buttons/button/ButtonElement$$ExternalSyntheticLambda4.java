package com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.buttons.button;

import com.catfixture.inputbridge.core.input.devices.IInputDevice;
import java.util.Observable;
import java.util.Observer;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ButtonElement$$ExternalSyntheticLambda4 implements Observer {
    public final /* synthetic */ ButtonElement f$0;
    public final /* synthetic */ IInputDevice f$1;

    public /* synthetic */ ButtonElement$$ExternalSyntheticLambda4(ButtonElement buttonElement, IInputDevice iInputDevice) {
        this.f$0 = buttonElement;
        this.f$1 = iInputDevice;
    }

    public final void update(Observable observable, Object obj) {
        this.f$0.m58lambda$CreateNormalEvents$5$comcatfixtureinputbridgecoreinputdevicestouchinteractionelementsbuttonsbuttonButtonElement(this.f$1, observable, obj);
    }
}
