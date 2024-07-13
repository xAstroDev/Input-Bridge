package com.catfixture.inputbridge.core.input.data;

import androidx.core.math.MathUtils;
import com.catfixture.inputbridge.core.input.devices.IInputDevice;
import com.catfixture.inputbridge.core.utils.math.Float2;
import com.catfixture.inputbridge.ui.utils.Utils;

public class ComputedAxisBinding {
    public float leftXiStickX = 0.0f;
    public float leftXiStickY = 0.0f;
    public float lt = 0.0f;
    public float mouseX = 0.0f;
    public float mouseY = 0.0f;
    public float rightXiStickX = 0.0f;
    public float rightXiStickY = 0.0f;
    public float rt = 0.0f;

    public static void Check(ComputedAxisBinding computedAxisBinding, float f, float f2, AxisBinding axisBinding, float f3) {
        if (axisBinding.axisType == 1) {
            if (axisBinding.axisValue == 0) {
                computedAxisBinding.mouseX = f3;
            } else {
                computedAxisBinding.mouseY = f3;
            }
        } else if (axisBinding.axisType != 2) {
        } else {
            if (axisBinding.axisValue == 0) {
                computedAxisBinding.leftXiStickX = MathUtils.clamp(Utils.Map(f3 * f, -f2, f2, -1.0f, 1.0f), -1.0f, 1.0f);
            } else if (axisBinding.axisValue == 1) {
                computedAxisBinding.leftXiStickY = MathUtils.clamp(Utils.Map(f3 * f, -f2, f2, -1.0f, 1.0f), -1.0f, 1.0f);
            } else if (axisBinding.axisValue == 2) {
                computedAxisBinding.rightXiStickX = MathUtils.clamp(Utils.Map(f3 * f, -f2, f2, -1.0f, 1.0f), -1.0f, 1.0f);
            } else if (axisBinding.axisValue == 3) {
                computedAxisBinding.rightXiStickY = MathUtils.clamp(Utils.Map(f3 * f, -f2, f2, -1.0f, 1.0f), -1.0f, 1.0f);
            } else if (axisBinding.axisValue == 4) {
                computedAxisBinding.lt = MathUtils.clamp(Utils.Map(f3 * f, 0.0f, f2, 0.0f, 1.0f), 0.0f, 1.0f);
            } else if (axisBinding.axisValue == 5) {
                computedAxisBinding.rt = MathUtils.clamp(Utils.Map(f3 * f, 0.0f, f2, 0.0f, 1.0f), 0.0f, 1.0f);
            }
        }
    }

    public static void ApplyInput(ComputedAxisBinding computedAxisBinding, IInputDevice iInputDevice, float f) {
        float f2 = computedAxisBinding.mouseX;
        if (!(f2 == 0.0f && computedAxisBinding.mouseY == 0.0f)) {
            iInputDevice.SetConstantMouseShift(f2 * f, computedAxisBinding.mouseY * f);
        }
        if (!(computedAxisBinding.leftXiStickX == 0.0f && computedAxisBinding.leftXiStickY == 0.0f)) {
            iInputDevice.SetXIStick(XInputSide.LEFT, new Float2(computedAxisBinding.leftXiStickX, computedAxisBinding.leftXiStickY));
        }
        if (!(computedAxisBinding.rightXiStickX == 0.0f && computedAxisBinding.rightXiStickY == 0.0f)) {
            iInputDevice.SetXIStick(XInputSide.RIGHT, new Float2(computedAxisBinding.rightXiStickX, computedAxisBinding.rightXiStickY));
        }
        iInputDevice.SetXILeftTrigger(computedAxisBinding.lt);
        iInputDevice.SetXIRightTrigger(computedAxisBinding.rt);
    }

    public static void ResetInput(ComputedAxisBinding computedAxisBinding, IInputDevice iInputDevice) {
        if (!(computedAxisBinding.mouseX == 0.0f && computedAxisBinding.mouseY == 0.0f)) {
            iInputDevice.SetConstantMouseShift(0.0f, 0.0f);
        }
        if (!(computedAxisBinding.leftXiStickX == 0.0f && computedAxisBinding.leftXiStickY == 0.0f)) {
            iInputDevice.SetXIStick(XInputSide.LEFT, new Float2(0.0f, 0.0f));
        }
        if (!(computedAxisBinding.rightXiStickX == 0.0f && computedAxisBinding.rightXiStickY == 0.0f)) {
            iInputDevice.SetXIStick(XInputSide.RIGHT, new Float2(0.0f, 0.0f));
        }
        iInputDevice.SetXILeftTrigger(0.0f);
        iInputDevice.SetXIRightTrigger(0.0f);
    }
}
