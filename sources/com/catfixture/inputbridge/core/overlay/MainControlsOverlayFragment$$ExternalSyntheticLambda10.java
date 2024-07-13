package com.catfixture.inputbridge.core.overlay;

import android.content.Context;
import android.view.View;
import com.catfixture.inputbridge.core.Const;
import com.catfixture.inputbridge.core.service.InputService;
import com.catfixture.inputbridge.core.weakmsg.WeakMsg;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class MainControlsOverlayFragment$$ExternalSyntheticLambda10 implements View.OnClickListener {
    public final /* synthetic */ InputService f$0;

    public /* synthetic */ MainControlsOverlayFragment$$ExternalSyntheticLambda10(InputService inputService) {
        this.f$0 = inputService;
    }

    public final void onClick(View view) {
        WeakMsg.Send((Context) this.f$0, (int) Const.BCAST_ACTION_STOP_SERVER);
    }
}
