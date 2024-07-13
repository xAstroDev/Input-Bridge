package com.catfixture.inputbridge.ui.activity.editors.phyDeviceEditor;

import com.catfixture.inputbridge.core.utils.math.Float2;

public class StickVisualElement extends VisualElement {
    public int code;
    public Float2 shearPos = new Float2();
    public int xAxis;
    public int yAxis;

    public StickVisualElement(int i, int i2, int i3, int i4, Float2 float2, String str) {
        this.drawable = i;
        this.position = float2;
        this.xAxis = i2;
        this.yAxis = i3;
        this.code = i4;
        this.name = str;
    }
}
