package com.catfixture.inputbridge.core.utils.objProvider;

import com.catfixture.inputbridge.core.utils.types.delegates.Functions;

public class SimpleObjectProvider implements IObjectProvider {
    private final Functions.Function0<Object> o;

    public SimpleObjectProvider(Functions.Function0<Object> function0) {
        this.o = function0;
    }

    public Object get() {
        return this.o.Invoke();
    }
}
