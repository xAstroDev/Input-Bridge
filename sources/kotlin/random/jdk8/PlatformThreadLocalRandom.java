package kotlin.random.jdk8;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.AbstractPlatformRandom;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u000eH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u000eH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lkotlin/random/jdk8/PlatformThreadLocalRandom;", "Lkotlin/random/AbstractPlatformRandom;", "()V", "impl", "Ljava/util/Random;", "getImpl", "()Ljava/util/Random;", "nextDouble", "", "until", "nextInt", "", "from", "nextLong", "", "kotlin-stdlib-jdk8"}, k = 1, mv = {1, 5, 1})
/* compiled from: PlatformThreadLocalRandom.kt */
public final class PlatformThreadLocalRandom extends AbstractPlatformRandom {
    public Random getImpl() {
        ThreadLocalRandom current = ThreadLocalRandom.current();
        Intrinsics.checkNotNullExpressionValue(current, "ThreadLocalRandom.current()");
        return current;
    }

    public int nextInt(int i, int i2) {
        return ThreadLocalRandom.current().nextInt(i, i2);
    }

    public long nextLong(long j) {
        return ThreadLocalRandom.current().nextLong(j);
    }

    public long nextLong(long j, long j2) {
        return ThreadLocalRandom.current().nextLong(j, j2);
    }

    public double nextDouble(double d) {
        return ThreadLocalRandom.current().nextDouble(d);
    }
}
