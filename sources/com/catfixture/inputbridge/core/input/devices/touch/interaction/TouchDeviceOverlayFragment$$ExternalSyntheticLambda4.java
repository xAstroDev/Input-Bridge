package com.catfixture.inputbridge.core.input.devices.touch.interaction;

import com.catfixture.inputbridge.core.input.data.InputTouchControlElementData;
import com.catfixture.inputbridge.core.utils.math.Int2;
import java.util.Observable;
import java.util.Observer;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class TouchDeviceOverlayFragment$$ExternalSyntheticLambda4 implements Observer {
    public final /* synthetic */ InputTouchControlElementData f$0;

    public /* synthetic */ TouchDeviceOverlayFragment$$ExternalSyntheticLambda4(InputTouchControlElementData inputTouchControlElementData) {
        this.f$0 = inputTouchControlElementData;
    }

    public final void update(Observable observable, Object obj) {
        this.f$0.SetPosition((Int2) obj);
    }
}
