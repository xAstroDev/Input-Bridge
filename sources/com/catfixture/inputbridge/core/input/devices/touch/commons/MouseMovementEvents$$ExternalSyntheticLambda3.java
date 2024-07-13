package com.catfixture.inputbridge.core.input.devices.touch.commons;

import com.catfixture.inputbridge.core.input.data.InputTouchControlElementData;
import com.catfixture.inputbridge.core.input.devices.IInputDevice;
import java.util.Observable;
import java.util.Observer;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class MouseMovementEvents$$ExternalSyntheticLambda3 implements Observer {
    public final /* synthetic */ int f$0;
    public final /* synthetic */ InputTouchControlElementData f$1;
    public final /* synthetic */ boolean f$2;
    public final /* synthetic */ IInputDevice f$3;

    public /* synthetic */ MouseMovementEvents$$ExternalSyntheticLambda3(int i, InputTouchControlElementData inputTouchControlElementData, boolean z, IInputDevice iInputDevice) {
        this.f$0 = i;
        this.f$1 = inputTouchControlElementData;
        this.f$2 = z;
        this.f$3 = iInputDevice;
    }

    public final void update(Observable observable, Object obj) {
        MouseMovementEvents.lambda$Init$4(this.f$0, this.f$1, this.f$2, this.f$3, observable, obj);
    }
}
