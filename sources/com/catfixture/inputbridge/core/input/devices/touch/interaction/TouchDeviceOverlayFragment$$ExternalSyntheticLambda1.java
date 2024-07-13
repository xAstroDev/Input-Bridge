package com.catfixture.inputbridge.core.input.devices.touch.interaction;

import android.content.Context;
import android.widget.RelativeLayout;
import com.catfixture.inputbridge.core.input.devices.IInputDevice;
import com.catfixture.inputbridge.core.utils.types.delegates.Action;
import java.util.List;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class TouchDeviceOverlayFragment$$ExternalSyntheticLambda1 implements Action {
    public final /* synthetic */ Context f$0;
    public final /* synthetic */ IInputDevice f$1;
    public final /* synthetic */ RelativeLayout f$2;
    public final /* synthetic */ List f$3;
    public final /* synthetic */ boolean f$4;
    public final /* synthetic */ Action f$5;

    public /* synthetic */ TouchDeviceOverlayFragment$$ExternalSyntheticLambda1(Context context, IInputDevice iInputDevice, RelativeLayout relativeLayout, List list, boolean z, Action action) {
        this.f$0 = context;
        this.f$1 = iInputDevice;
        this.f$2 = relativeLayout;
        this.f$3 = list;
        this.f$4 = z;
        this.f$5 = action;
    }

    public final void Invoke(Object obj) {
        TouchDeviceOverlayFragment.lambda$InflateControls$0(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, (Boolean) obj);
    }
}
