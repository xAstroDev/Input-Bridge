package com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.buttons.buttonCombination;

import com.catfixture.inputbridge.core.input.devices.IInputDevice;
import java.util.Observable;
import java.util.Observer;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ButtonCombinationElement$$ExternalSyntheticLambda0 implements Observer {
    public final /* synthetic */ ButtonCombinationElement f$0;
    public final /* synthetic */ IInputDevice f$1;

    public /* synthetic */ ButtonCombinationElement$$ExternalSyntheticLambda0(ButtonCombinationElement buttonCombinationElement, IInputDevice iInputDevice) {
        this.f$0 = buttonCombinationElement;
        this.f$1 = iInputDevice;
    }

    public final void update(Observable observable, Object obj) {
        this.f$0.m64lambda$CreateEventActions$0$comcatfixtureinputbridgecoreinputdevicestouchinteractionelementsbuttonsbuttonCombinationButtonCombinationElement(this.f$1, observable, obj);
    }
}
