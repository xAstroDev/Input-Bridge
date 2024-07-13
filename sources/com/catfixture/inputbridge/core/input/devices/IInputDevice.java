package com.catfixture.inputbridge.core.input.devices;

import com.catfixture.inputbridge.core.utils.math.Float2;
import com.catfixture.inputbridge.core.utils.types.delegates.Action;

public interface IInputDevice {
    void AddMouseShift(float f, float f2);

    void AddScroll(float f);

    void Destroy();

    void ResetMousePos(float f, float f2);

    void SendKeyDown(int i);

    void SendKeyUp(int i);

    void SendMouseDown(int i);

    void SendMouseUp(int i);

    void SendXIDown(int i);

    void SendXIUp(int i);

    void SetConstantMouseShift(float f, float f2);

    void SetMousePos(float f, float f2, float f3);

    void SetOnMousePosChanged(Action<Float2> action);

    void SetScroll(float f);

    void SetScrollDirty();

    void SetXILeftTrigger(float f);

    void SetXIRightTrigger(float f);

    void SetXIStick(int i, Float2 float2);
}
