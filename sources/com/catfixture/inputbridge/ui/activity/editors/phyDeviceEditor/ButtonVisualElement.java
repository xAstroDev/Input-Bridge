package com.catfixture.inputbridge.ui.activity.editors.phyDeviceEditor;

import com.catfixture.inputbridge.core.utils.math.Float2;

public class ButtonVisualElement extends VisualElement {
    public int axis;
    public int code;
    public int customColor;
    public int dir;

    public ButtonVisualElement(int i, int i2, Float2 float2, String str) {
        this.drawable = i;
        this.code = i2;
        this.position = float2;
        this.name = str;
    }

    public ButtonVisualElement(int i, int i2, int i3, int i4, Float2 float2, String str) {
        this.drawable = i;
        this.code = i2;
        this.axis = i3;
        this.dir = i4;
        this.position = float2;
        this.name = str;
    }

    public ButtonVisualElement(int i, int i2, int i3, int i4, Float2 float2, String str, int i5) {
        this.drawable = i;
        this.code = i2;
        this.axis = i3;
        this.dir = i4;
        this.position = float2;
        this.name = str;
        this.customColor = i5;
    }
}
