package com.catfixture.inputbridge.core.utils.objProvider;

import com.catfixture.inputbridge.core.utils.types.delegates.Functions;

public class SimpleTypedProvider<T> implements ITypedProvider<T> {
    private final Functions.Function0<T> o;

    public SimpleTypedProvider(Functions.Function0<T> function0) {
        this.o = function0;
    }

    public T get() {
        return this.o.Invoke();
    }
}
