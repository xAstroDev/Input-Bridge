package com.catfixture.inputbridge.core.input.utils;

import com.catfixture.inputbridge.core.utils.math.Int2;

public interface ITransformable {
    Int2 GetPosition();

    Int2 GetSize();

    void SetPosition(int i, int i2);
}
