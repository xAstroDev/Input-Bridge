package com.catfixture.inputbridge.core.inputbridge;

import com.catfixture.inputbridge.core.utils.types.Event;

public interface IPipe {
    Event OnAlive();

    Event OnDataReceived();

    void SetTargetRate(int i);

    void Start();

    void Stop();

    IPipe Write(byte b);

    IPipe Write(float f);

    IPipe Write(int i);

    IPipe Write(XIState xIState);
}
