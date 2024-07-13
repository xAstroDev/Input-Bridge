package com.catfixture.inputbridge.core.input.core;

import com.catfixture.inputbridge.core.utils.math.Int2;

public class FloatToInt {
    private float errorX;
    private float errorY;
    private final Int2 result = new Int2(0, 0);

    public Int2 Process(float f, float f2) {
        float f3 = f + this.errorX;
        float f4 = f2 + this.errorY;
        int i = (int) f3;
        int i2 = (int) f4;
        this.errorX = f3 - ((float) i);
        this.errorY = f4 - ((float) i2);
        this.result.x = i;
        this.result.y = i2;
        return this.result;
    }
}
