package com.catfixture.inputbridge.core.utils.types.delegates;

public class Functions {

    public interface Function0<T> {
        T Invoke();
    }

    public interface Function1<T, X1> {
        T Invoke(X1 x1);
    }

    public interface Function2<T, X1, X2> {
        T Invoke(X1 x1, X2 x2);
    }
}
