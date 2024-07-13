package com.catfixture.inputbridge.ui.activity.editors.phyDeviceEditor;

import com.catfixture.inputbridge.core.utils.math.Float2;
import java.util.ArrayList;
import java.util.List;

public class GamepadVisualTheme {
    public int bgFront;
    public List<ButtonVisualElement> buttons = new ArrayList();
    public AxisFakeElement fakeLtElement;
    public AxisFakeElement fakeRtElement;
    public ButtonVisualElement fakeThumblElement;
    public ButtonVisualElement fakeThumbrElement;
    public int pressedColor;
    public int selectedColor;
    public List<StickVisualElement> sticks = new ArrayList();

    public GamepadVisualTheme AddBase(int i, int i2) {
        return this;
    }

    public GamepadVisualTheme(String str, int i, String str2, int i2, String str3, String str4, int i3, int i4, int i5) {
        this.fakeLtElement = new AxisFakeElement(i, str);
        this.fakeRtElement = new AxisFakeElement(i2, str2);
        this.fakeThumblElement = new ButtonVisualElement(0, 106, new Float2(0.0f, 0.0f), str3);
        this.fakeThumbrElement = new ButtonVisualElement(0, 107, new Float2(0.0f, 0.0f), str4);
        this.bgFront = i3;
        this.selectedColor = i4;
        this.pressedColor = i5;
    }

    public GamepadVisualTheme AddButton(String str, int i, int i2, Float2 float2) {
        this.buttons.add(new ButtonVisualElement(i, i2, float2, str));
        return this;
    }

    public GamepadVisualTheme AddButton(String str, int i, int i2, Float2 float2, int i3) {
        this.buttons.add(new ButtonVisualElement(i, i2, 0, 0, float2, str, i3));
        return this;
    }

    public GamepadVisualTheme AddAxisButton(String str, int i, int i2, int i3, Float2 float2) {
        this.buttons.add(new ButtonVisualElement(i, -1, i2, i3, float2, str));
        return this;
    }

    public GamepadVisualTheme AddAxisButton(String str, int i, int i2, int i3, Float2 float2, int i4) {
        this.buttons.add(new ButtonVisualElement(i, -1, i2, i3, float2, str, i4));
        return this;
    }

    public GamepadVisualTheme AddStick(String str, int i, int i2, int i3, int i4, Float2 float2) {
        this.sticks.add(new StickVisualElement(i, i2, i3, i4, float2, str));
        return this;
    }

    public List<StickVisualElement> GetSticks() {
        return this.sticks;
    }
}
