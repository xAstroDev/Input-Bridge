package com.catfixture.inputbridge.core.utils.math;

import android.view.MotionEvent;

public class Int2 {
    public static final Int2 Zero = new Int2(0, 0);
    public int x;
    public int y;

    public Int2(int i, int i2) {
        this.x = i;
        this.y = i2;
    }

    public Int2(MotionEvent.PointerCoords pointerCoords) {
        this.x = (int) pointerCoords.x;
        this.y = (int) pointerCoords.y;
    }

    public Int2 Add(Int2 int2) {
        return new Int2(this.x + int2.x, this.y + int2.y);
    }

    public Int2 Add(Float2 float2) {
        return new Int2((int) (((float) this.x) + float2.x), (int) (((float) this.y) + float2.y));
    }

    public Int2 Div(Int2 int2) {
        return new Int2(this.x / int2.x, this.y / int2.y);
    }

    public Int2 Div(float f) {
        return new Int2((int) (((float) this.x) / f), (int) (((float) this.y) / f));
    }

    public Int2 AddSelf(Int2 int2) {
        this.x += int2.x;
        this.y += int2.y;
        return this;
    }

    public Int2 Sub(Int2 int2) {
        return new Int2(this.x - int2.x, this.y - int2.y);
    }

    public Int2 SubSelf(Int2 int2) {
        this.x -= int2.x;
        this.y -= int2.y;
        return this;
    }

    public void Set(float f, float f2) {
        this.x = (int) f;
        this.y = (int) f2;
    }

    public int Distance(Int2 int2) {
        int i = int2.x - this.x;
        int i2 = int2.y - this.y;
        return (int) Math.sqrt((double) ((i * i) + (i2 * i2)));
    }

    public int Distance(int i, int i2) {
        int i3 = i - this.x;
        int i4 = i2 - this.y;
        return (int) Math.sqrt((double) ((i3 * i3) + (i4 * i4)));
    }

    public int Distance(float f, float f2) {
        return Distance((int) f, (int) f2);
    }

    public float Dot(Int2 int2) {
        Int2 Sub = Sub(int2);
        float Distance = (float) Distance(Sub);
        if (Distance <= 0.0f) {
            return 0.0f;
        }
        Int2 Div = Sub.Div(Distance);
        return (float) ((this.x * Div.x) + (this.y * Div.y));
    }

    public String toString() {
        return "Int2{x=" + this.x + ", y=" + this.y + '}';
    }
}
