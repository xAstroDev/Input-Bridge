package com.catfixture.inputbridge.core.input.devices.touch.commons;

import android.os.Handler;
import com.catfixture.inputbridge.core.input.devices.IInputDevice;
import java.util.Observable;
import java.util.Observer;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class MouseMovementEvents$$ExternalSyntheticLambda4 implements Observer {
    public final /* synthetic */ IInputDevice f$0;
    public final /* synthetic */ Handler f$1;

    public /* synthetic */ MouseMovementEvents$$ExternalSyntheticLambda4(IInputDevice iInputDevice, Handler handler) {
        this.f$0 = iInputDevice;
        this.f$1 = handler;
    }

    public final void update(Observable observable, Object obj) {
        MouseMovementEvents.lambda$Init$3(this.f$0, this.f$1, observable, obj);
    }
}
