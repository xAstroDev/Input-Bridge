package com.catfixture.inputbridge.core.input.devices.touch.interaction;

import com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.TouchableWindowElement;
import com.catfixture.inputbridge.core.utils.types.delegates.Action;
import java.util.Observable;
import java.util.Observer;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class TouchDeviceOverlayFragment$$ExternalSyntheticLambda5 implements Observer {
    public final /* synthetic */ Action f$0;
    public final /* synthetic */ TouchableWindowElement f$1;

    public /* synthetic */ TouchDeviceOverlayFragment$$ExternalSyntheticLambda5(Action action, TouchableWindowElement touchableWindowElement) {
        this.f$0 = action;
        this.f$1 = touchableWindowElement;
    }

    public final void update(Observable observable, Object obj) {
        TouchDeviceOverlayFragment.lambda$InflateControls$2(this.f$0, this.f$1, observable, obj);
    }
}
