package com.catfixture.inputbridge.core.input.devices.touch.commons;

import com.catfixture.inputbridge.core.input.devices.IInputDevice;
import com.catfixture.inputbridge.core.utils.math.Int2;
import java.util.Observable;
import java.util.Observer;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class XInputEightDirMoveEvents$$ExternalSyntheticLambda2 implements Observer {
    public final /* synthetic */ Int2 f$0;
    public final /* synthetic */ IInputDevice f$1;

    public /* synthetic */ XInputEightDirMoveEvents$$ExternalSyntheticLambda2(Int2 int2, IInputDevice iInputDevice) {
        this.f$0 = int2;
        this.f$1 = iInputDevice;
    }

    public final void update(Observable observable, Object obj) {
        XInputEightDirMoveEvents.lambda$new$2(this.f$0, this.f$1, observable, obj);
    }
}
