package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.DelayKt", f = "Delay.kt", i = {}, l = {155}, m = "awaitCancellation", n = {}, s = {})
/* compiled from: Delay.kt */
final class DelayKt$awaitCancellation$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    DelayKt$awaitCancellation$1(Continuation<? super DelayKt$awaitCancellation$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return DelayKt.awaitCancellation(this);
    }
}
