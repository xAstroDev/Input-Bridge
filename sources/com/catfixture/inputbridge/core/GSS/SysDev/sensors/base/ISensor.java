package com.catfixture.inputbridge.core.GSS.SysDev.sensors.base;

public interface ISensor<T> {
    void Destroy();

    int GetType();

    T Read();
}
