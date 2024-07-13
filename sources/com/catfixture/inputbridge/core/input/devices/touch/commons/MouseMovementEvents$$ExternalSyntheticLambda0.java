package com.catfixture.inputbridge.core.input.devices.touch.commons;

import com.catfixture.inputbridge.core.input.devices.IInputDevice;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class MouseMovementEvents$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ IInputDevice f$0;

    public /* synthetic */ MouseMovementEvents$$ExternalSyntheticLambda0(IInputDevice iInputDevice) {
        this.f$0 = iInputDevice;
    }

    public final void run() {
        this.f$0.SendMouseUp(0);
    }
}
