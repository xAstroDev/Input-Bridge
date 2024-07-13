package com.catfixture.inputbridge.core.colorpicker;

import androidx.core.view.ViewCompat;

public class Colorut {
    public static int MultARGB(int i, int i2) {
        return ((int) ((((float) (i & 255)) / 255.0f) * (((float) (i2 & 255)) / 255.0f) * 255.0f)) | (((int) (((((float) ((i >> 24) & 255)) / 255.0f) * (((float) ((i2 >> 24) & 255)) / 255.0f)) * 255.0f)) << 24) | (((int) (((((float) ((i >> 16) & 255)) / 255.0f) * (((float) ((i2 >> 16) & 255)) / 255.0f)) * 255.0f)) << 16) | (((int) (((((float) ((i >> 8) & 255)) / 255.0f) * (((float) ((i2 >> 8) & 255)) / 255.0f)) * 255.0f)) << 8);
    }

    public static int HSBtoRGB(float f, float f2, float f3) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        if (f2 == 0.0f) {
            i3 = (int) ((f3 * 255.0f) + 0.5f);
        } else {
            float floor = (f - ((float) Math.floor((double) f))) * 6.0f;
            float floor2 = floor - ((float) Math.floor((double) floor));
            float f4 = (1.0f - f2) * f3;
            float f5 = (1.0f - (f2 * floor2)) * f3;
            float f6 = (1.0f - (f2 * (1.0f - floor2))) * f3;
            int i7 = (int) floor;
            if (i7 == 0) {
                i4 = (int) ((f3 * 255.0f) + 0.5f);
                i5 = (int) ((f6 * 255.0f) + 0.5f);
            } else if (i7 != 1) {
                if (i7 != 2) {
                    if (i7 == 3) {
                        i6 = (int) ((f4 * 255.0f) + 0.5f);
                        i2 = (int) ((f5 * 255.0f) + 0.5f);
                    } else if (i7 == 4) {
                        i6 = (int) ((f6 * 255.0f) + 0.5f);
                        i2 = (int) ((f4 * 255.0f) + 0.5f);
                    } else if (i7 != 5) {
                        i3 = 0;
                    } else {
                        i3 = (int) ((f3 * 255.0f) + 0.5f);
                        i2 = (int) ((f4 * 255.0f) + 0.5f);
                        i = (int) ((f5 * 255.0f) + 0.5f);
                    }
                    i = (int) ((f3 * 255.0f) + 0.5f);
                } else {
                    i3 = (int) ((f4 * 255.0f) + 0.5f);
                    i2 = (int) ((f3 * 255.0f) + 0.5f);
                    i = (int) ((f6 * 255.0f) + 0.5f);
                }
                return (i3 << 16) | ViewCompat.MEASURED_STATE_MASK | (i2 << 8) | (i << 0);
            } else {
                i4 = (int) ((f5 * 255.0f) + 0.5f);
                i5 = (int) ((f3 * 255.0f) + 0.5f);
            }
            i = (int) ((f4 * 255.0f) + 0.5f);
            return (i3 << 16) | ViewCompat.MEASURED_STATE_MASK | (i2 << 8) | (i << 0);
        }
        i2 = i3;
        i = i2;
        return (i3 << 16) | ViewCompat.MEASURED_STATE_MASK | (i2 << 8) | (i << 0);
    }

    public static void RGBtoHSB(int i, float[] fArr) {
        int i2 = (i >> 16) & 255;
        int i3 = (i >> 8) & 255;
        int i4 = i & 255;
        int i5 = i2 > i3 ? i2 : i3;
        if (i4 > i5) {
            i5 = i4;
        }
        int i6 = i2 < i3 ? i2 : i3;
        if (i4 < i6) {
            i6 = i4;
        }
        float f = (float) i5;
        float f2 = f / 255.0f;
        float f3 = 0.0f;
        float f4 = i5 != 0 ? ((float) (i5 - i6)) / f : 0.0f;
        if (f4 != 0.0f) {
            float f5 = (float) (i5 - i6);
            float f6 = ((float) (i5 - i2)) / f5;
            float f7 = ((float) (i5 - i3)) / f5;
            float f8 = ((float) (i5 - i4)) / f5;
            float f9 = (i2 == i5 ? f8 - f7 : i3 == i5 ? (f6 + 2.0f) - f8 : (f7 + 4.0f) - f6) / 6.0f;
            f3 = f9 < 0.0f ? f9 + 1.0f : f9;
        }
        fArr[0] = f3;
        fArr[1] = f4;
        fArr[2] = f2;
    }
}
