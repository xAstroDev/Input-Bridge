package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002 \u0000H\n"}, d2 = {"<anonymous>", "", "R"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: SelectUnbiased.kt */
final class UnbiasedSelectBuilderImpl$onTimeout$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function1<Continuation<? super R>, Object> $block;
    final /* synthetic */ long $timeMillis;
    final /* synthetic */ UnbiasedSelectBuilderImpl<R> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UnbiasedSelectBuilderImpl$onTimeout$1(UnbiasedSelectBuilderImpl<? super R> unbiasedSelectBuilderImpl, long j, Function1<? super Continuation<? super R>, ? extends Object> function1) {
        super(0);
        this.this$0 = unbiasedSelectBuilderImpl;
        this.$timeMillis = j;
        this.$block = function1;
    }

    public final void invoke() {
        this.this$0.getInstance().onTimeout(this.$timeMillis, this.$block);
    }
}
