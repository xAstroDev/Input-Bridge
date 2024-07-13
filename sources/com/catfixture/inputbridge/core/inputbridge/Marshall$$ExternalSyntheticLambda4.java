package com.catfixture.inputbridge.core.inputbridge;

import android.content.Context;
import android.os.Handler;
import java.util.Observable;
import java.util.Observer;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Marshall$$ExternalSyntheticLambda4 implements Observer {
    public final /* synthetic */ Marshall f$0;
    public final /* synthetic */ Context f$1;
    public final /* synthetic */ Handler f$2;
    public final /* synthetic */ int f$3;

    public /* synthetic */ Marshall$$ExternalSyntheticLambda4(Marshall marshall, Context context, Handler handler, int i) {
        this.f$0 = marshall;
        this.f$1 = context;
        this.f$2 = handler;
        this.f$3 = i;
    }

    public final void update(Observable observable, Object obj) {
        this.f$0.m93lambda$new$1$comcatfixtureinputbridgecoreinputbridgeMarshall(this.f$1, this.f$2, this.f$3, observable, obj);
    }
}
