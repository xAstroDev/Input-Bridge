package com.catfixture.inputbridge.ui.activity.editors.phyDeviceEditor;

import android.graphics.Bitmap;
import com.catfixture.inputbridge.core.utils.math.Float2;

public class VisualElement {
    public Bitmap bmp;
    public Float2 calculatedPos = new Float2();
    public Float2 calculatedSize = new Float2();
    public int drawable;
    public boolean isActive = false;
    public boolean isSelected = false;
    public String name;
    public Float2 position;

    public VisualElement() {
    }

    public VisualElement(String str) {
        this.name = str;
    }
}
