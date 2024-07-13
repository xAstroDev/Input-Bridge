package com.catfixture.inputbridge.core.utils.math;

import android.view.MotionEvent;

public class Float2 {
    public static final Float2 Zero = new Float2(0.0f, 0.0f);
    public float x;
    public float y;

    public Float2(float f, float f2) {
        this.x = f;
        this.y = f2;
    }

    public Float2(MotionEvent.PointerCoords pointerCoords) {
        this.x = pointerCoords.x;
        this.y = pointerCoords.y;
    }

    public Float2() {
    }

    public Float2 Add(Float2 float2) {
        return new Float2(this.x + float2.x, this.y + float2.y);
    }

    public Float2 Mul(float f) {
        return new Float2(this.x * f, this.y * f);
    }

    public Float2 AddSelf(Float2 float2) {
        this.x += float2.x;
        this.y += float2.y;
        return this;
    }

    public Float2 Sub(Float2 float2) {
        return new Float2(this.x - float2.x, this.y - float2.y);
    }

    public Float2 SubSelf(Float2 float2) {
        this.x -= float2.x;
        this.y -= float2.y;
        return this;
    }

    public Float2 Div(Float2 float2) {
        return new Float2(this.x / float2.x, this.y / float2.y);
    }

    public Float2 Div(float f) {
        return new Float2(this.x / f, this.y / f);
    }

    public String toString() {
        return "Float2{x=" + this.x + ", y=" + this.y + '}';
    }

    public float Magnitude() {
        float f = this.x;
        float f2 = this.y;
        return (float) Math.sqrt((double) ((f * f) + (f2 * f2)));
    }

    public float Distance(Float2 float2) {
        float f = float2.x - this.x;
        float f2 = float2.y - this.y;
        return (float) Math.sqrt((double) ((f * f) + (f2 * f2)));
    }

    public float Distance(float f, float f2) {
        float f3 = f - this.x;
        float f4 = f2 - this.y;
        return (float) Math.sqrt((double) ((f3 * f3) + (f4 * f4)));
    }

    public void Set(float f, float f2) {
        this.x = f;
        this.y = f2;
    }

    public void Set(Float2 float2) {
        this.x = float2.x;
        this.y = float2.y;
    }

    public Float2 Normalized() {
        float Magnitude = Magnitude();
        if (Magnitude == 0.0f) {
            Magnitude = 1.0f;
        }
        return Div(Magnitude);
    }

    public boolean AbsMore(float f) {
        return Math.abs(this.x) > f || Math.abs(this.y) > f;
    }

    public Float2 Clamp(int i, int i2) {
        float f = this.x;
        float f2 = (float) i;
        if (f < f2) {
            f = f2;
        } else {
            float f3 = (float) i2;
            if (f > f3) {
                f = f3;
            }
        }
        this.x = f;
        float f4 = this.y;
        if (f4 >= f2) {
            f2 = (float) i2;
            if (f4 <= f2) {
                f2 = f4;
            }
        }
        this.y = f2;
        return this;
    }

    public Float2 Clamp(float f, float f2) {
        float f3 = this.x;
        if (f3 < f) {
            f3 = f;
        } else if (f3 > f2) {
            f3 = f2;
        }
        this.x = f3;
        float f4 = this.y;
        if (f4 >= f) {
            f = f4 > f2 ? f2 : f4;
        }
        this.y = f;
        return this;
    }
}
