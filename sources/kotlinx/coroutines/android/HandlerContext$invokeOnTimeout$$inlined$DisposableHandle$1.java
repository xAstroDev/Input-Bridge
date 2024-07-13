package kotlinx.coroutines.android;

import kotlin.Metadata;
import kotlinx.coroutines.DisposableHandle;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/JobKt__JobKt$DisposableHandle$1", "Lkotlinx/coroutines/DisposableHandle;", "dispose", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: Job.kt */
public final class HandlerContext$invokeOnTimeout$$inlined$DisposableHandle$1 implements DisposableHandle {
    final /* synthetic */ Runnable $block$inlined;
    final /* synthetic */ HandlerContext this$0;

    public HandlerContext$invokeOnTimeout$$inlined$DisposableHandle$1(HandlerContext handlerContext, Runnable runnable) {
        this.this$0 = handlerContext;
        this.$block$inlined = runnable;
    }

    public void dispose() {
        this.this$0.handler.removeCallbacks(this.$block$inlined);
    }
}
