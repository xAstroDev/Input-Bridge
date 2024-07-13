package com.catfixture.inputbridge.core.service;

import android.os.Handler;
import java.util.Observable;
import java.util.Observer;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class InputService$$ExternalSyntheticLambda3 implements Observer {
    public final /* synthetic */ InputService f$0;
    public final /* synthetic */ Handler f$1;

    public /* synthetic */ InputService$$ExternalSyntheticLambda3(InputService inputService, Handler handler) {
        this.f$0 = inputService;
        this.f$1 = handler;
    }

    public final void update(Observable observable, Object obj) {
        this.f$0.m106lambda$RunService$2$comcatfixtureinputbridgecoreserviceInputService(this.f$1, observable, obj);
    }
}
