package com.catfixture.inputbridge.core.input.utils;

import java.util.Observable;
import java.util.Observer;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DragAndDropHandle$$ExternalSyntheticLambda2 implements Observer {
    public final /* synthetic */ DragAndDropHandle f$0;
    public final /* synthetic */ ITouchable f$1;

    public /* synthetic */ DragAndDropHandle$$ExternalSyntheticLambda2(DragAndDropHandle dragAndDropHandle, ITouchable iTouchable) {
        this.f$0 = dragAndDropHandle;
        this.f$1 = iTouchable;
    }

    public final void update(Observable observable, Object obj) {
        this.f$0.m91lambda$new$2$comcatfixtureinputbridgecoreinpututilsDragAndDropHandle(this.f$1, observable, obj);
    }
}
