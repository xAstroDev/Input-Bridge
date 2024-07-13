package com.catfixture.inputbridge.core.input.devices.touch.commons;

import com.catfixture.inputbridge.core.input.devices.IInputDevice;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.TouchableWindowElement;
import com.catfixture.inputbridge.core.utils.math.Int2;
import java.util.Observable;
import java.util.Observer;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class WindowsEightDirMoveEvents$$ExternalSyntheticLambda1 implements Observer {
    public final /* synthetic */ WindowsEightDirMoveEvents f$0;
    public final /* synthetic */ Int2 f$1;
    public final /* synthetic */ TouchableWindowElement f$2;
    public final /* synthetic */ Int2 f$3;
    public final /* synthetic */ IInputDevice f$4;

    public /* synthetic */ WindowsEightDirMoveEvents$$ExternalSyntheticLambda1(WindowsEightDirMoveEvents windowsEightDirMoveEvents, Int2 int2, TouchableWindowElement touchableWindowElement, Int2 int22, IInputDevice iInputDevice) {
        this.f$0 = windowsEightDirMoveEvents;
        this.f$1 = int2;
        this.f$2 = touchableWindowElement;
        this.f$3 = int22;
        this.f$4 = iInputDevice;
    }

    public final void update(Observable observable, Object obj) {
        this.f$0.m49lambda$new$1$comcatfixtureinputbridgecoreinputdevicestouchcommonsWindowsEightDirMoveEvents(this.f$1, this.f$2, this.f$3, this.f$4, observable, obj);
    }
}
