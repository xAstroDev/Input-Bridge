package com.catfixture.inputbridge.core.input.devices.touch.interaction.elements;

import android.os.Vibrator;
import com.catfixture.inputbridge.core.input.data.InputConfigProfile;
import java.util.Observable;
import java.util.Observer;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class TouchableWindowElement$$ExternalSyntheticLambda1 implements Observer {
    public final /* synthetic */ TouchableWindowElement f$0;
    public final /* synthetic */ InputConfigProfile f$1;
    public final /* synthetic */ Vibrator f$2;

    public /* synthetic */ TouchableWindowElement$$ExternalSyntheticLambda1(TouchableWindowElement touchableWindowElement, InputConfigProfile inputConfigProfile, Vibrator vibrator) {
        this.f$0 = touchableWindowElement;
        this.f$1 = inputConfigProfile;
        this.f$2 = vibrator;
    }

    public final void update(Observable observable, Object obj) {
        this.f$0.m52lambda$CreateActionDecorations$0$comcatfixtureinputbridgecoreinputdevicestouchinteractionelementsTouchableWindowElement(this.f$1, this.f$2, observable, obj);
    }
}
