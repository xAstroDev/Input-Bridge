package com.catfixture.inputbridge.core.input.utils;

import android.view.ViewGroup;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.TouchableWindowElement;
import com.catfixture.inputbridge.core.utils.math.Int2;

public interface IInputWindowElement {
    void Deselect();

    Object GetData();

    TouchableWindowElement GetHandle();

    int GetId();

    Int2 GetPosition();

    Int2 GetSize();

    void Reinflate();

    void ResetEditor(boolean z);

    void Select(ViewGroup viewGroup);

    IInputWindowElement SetAlpha(float f);

    void SetHandle(TouchableWindowElement touchableWindowElement);

    IInputWindowElement SetInitialSize(int i, int i2);

    IInputWindowElement SetScale(int i);

    IInputWindowElement SetSize(int i, int i2);
}
