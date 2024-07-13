package com.catfixture.inputbridge.core.input.devices.touch;

import android.content.Context;
import com.catfixture.inputbridge.core.input.devices.IInputDevice;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.TouchDeviceOverlayFragment;
import com.catfixture.inputbridge.core.inputbridge.Marshall;
import com.catfixture.inputbridge.core.overlay.IOverlayFragment;
import com.catfixture.inputbridge.core.overlay.OverlayManager;
import com.catfixture.inputbridge.core.utils.math.Float2;
import com.catfixture.inputbridge.core.utils.types.delegates.Action;

public class TouchDevice implements IInputDevice {
    private final Marshall marshall;
    private Action<Float2> onMousePositionChanged;
    private final OverlayManager overlayManager;
    private final TouchDeviceOverlayFragment touchDeviceOverlayFragment;

    public TouchDevice(Context context, Marshall marshall2, OverlayManager overlayManager2) {
        this.marshall = marshall2;
        this.overlayManager = overlayManager2;
        TouchDeviceOverlayFragment touchDeviceOverlayFragment2 = new TouchDeviceOverlayFragment(context, this);
        this.touchDeviceOverlayFragment = touchDeviceOverlayFragment2;
        overlayManager2.AddOnBottom(touchDeviceOverlayFragment2);
        overlayManager2.Show((IOverlayFragment) touchDeviceOverlayFragment2);
    }

    public void Destroy() {
        this.overlayManager.Remove(this.touchDeviceOverlayFragment);
    }

    public void SendMouseDown(int i) {
        this.marshall.SendMouseButtonDownEvent((byte) i);
    }

    public void SendMouseUp(int i) {
        this.marshall.SendMouseButtonUpEvent((byte) i);
    }

    public void SendKeyDown(int i) {
        this.marshall.SendKeyDownEvent(i);
    }

    public void SendKeyUp(int i) {
        this.marshall.SendKeyUpEvent(i);
    }

    public void AddMouseShift(float f, float f2) {
        this.marshall.AddMouseShift(f, f2);
    }

    public void SetMousePos(float f, float f2, float f3) {
        this.marshall.SetMousePos(f, f2, f3);
        this.onMousePositionChanged.Invoke(new Float2(f, f2));
    }

    public void AddScroll(float f) {
        this.marshall.AddScroll(f);
    }

    public void SetScroll(float f) {
        this.marshall.SetScroll(f);
    }

    public void SetScrollDirty() {
        this.marshall.SetScrollDirty();
    }

    public void SetConstantMouseShift(float f, float f2) {
        this.marshall.SetConstantMouseShiftEvent(f, f2);
    }

    public void SendXIDown(int i) {
        if (i == 65) {
            this.marshall.SetXILeftTriggerDig(1.0f);
        } else if (i == 66) {
            this.marshall.SetXIRightTriggerDig(1.0f);
        } else {
            this.marshall.SendXIKeyDownEvent(i);
        }
    }

    public void SendXIUp(int i) {
        if (i == 65) {
            this.marshall.SetXILeftTriggerDig(0.0f);
        } else if (i == 66) {
            this.marshall.SetXIRightTriggerDig(0.0f);
        } else {
            this.marshall.SendXIKeyUpEvent(i);
        }
    }

    public void SetXIStick(int i, Float2 float2) {
        this.marshall.SetXIStick(i, float2);
    }

    public void SetXILeftTrigger(float f) {
        this.marshall.SetXILeftTrigger(f);
    }

    public void SetXIRightTrigger(float f) {
        this.marshall.SetXIRightTrigger(f);
    }

    public void ResetMousePos(float f, float f2) {
        this.marshall.ResetMousePos(f, f2);
    }

    public void SetOnMousePosChanged(Action<Float2> action) {
        this.onMousePositionChanged = action;
    }

    public void Reset() {
        this.marshall.ResetConnection();
    }
}
