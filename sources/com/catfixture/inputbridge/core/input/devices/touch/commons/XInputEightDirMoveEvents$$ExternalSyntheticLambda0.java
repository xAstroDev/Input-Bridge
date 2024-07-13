package com.catfixture.inputbridge.core.input.devices.touch.commons;

import com.catfixture.inputbridge.core.input.devices.IInputDevice;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.TouchableWindowElement;
import com.catfixture.inputbridge.core.utils.math.Int2;
import java.util.Observable;
import java.util.Observer;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class XInputEightDirMoveEvents$$ExternalSyntheticLambda0 implements Observer {
    public final /* synthetic */ XInputEightDirMoveEvents f$0;
    public final /* synthetic */ Int2 f$1;
    public final /* synthetic */ TouchableWindowElement f$2;
    public final /* synthetic */ Int2 f$3;
    public final /* synthetic */ IInputDevice f$4;

    public /* synthetic */ XInputEightDirMoveEvents$$ExternalSyntheticLambda0(XInputEightDirMoveEvents xInputEightDirMoveEvents, Int2 int2, TouchableWindowElement touchableWindowElement, Int2 int22, IInputDevice iInputDevice) {
        this.f$0 = xInputEightDirMoveEvents;
        this.f$1 = int2;
        this.f$2 = touchableWindowElement;
        this.f$3 = int22;
        this.f$4 = iInputDevice;
    }

    public final void update(Observable observable, Object obj) {
        this.f$0.m50lambda$new$0$comcatfixtureinputbridgecoreinputdevicestouchcommonsXInputEightDirMoveEvents(this.f$1, this.f$2, this.f$3, this.f$4, observable, obj);
    }
}
