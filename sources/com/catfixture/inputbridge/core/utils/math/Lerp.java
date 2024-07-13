package com.catfixture.inputbridge.core.utils.math;

public class Lerp {
    public static float Lerp(float f, float f2, float f3) {
        return (f * (1.0f - f3)) + (f2 * f3);
    }

    public static int Lerp(int i, int i2, float f) {
        return (int) ((((float) i) * (1.0f - f)) + (((float) i2) * f));
    }
}
