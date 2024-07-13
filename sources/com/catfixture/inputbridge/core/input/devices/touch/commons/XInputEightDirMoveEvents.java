package com.catfixture.inputbridge.core.input.devices.touch.commons;

import android.view.MotionEvent;
import com.catfixture.inputbridge.core.input.data.InputTouchControlElementData;
import com.catfixture.inputbridge.core.input.devices.IInputDevice;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.TouchableWindowElement;
import com.catfixture.inputbridge.core.utils.math.Int2;
import java.util.Observable;

public class XInputEightDirMoveEvents {
    private void SetAxis(TouchableWindowElement touchableWindowElement, Int2 int2, Int2 int22) {
        Int2 GetSize = touchableWindowElement.GetSize();
        InputTouchControlElementData inputTouchControlElementData = (InputTouchControlElementData) touchableWindowElement.GetData();
        float f = ((float) GetSize.x) * 0.25f;
        float f2 = ((float) GetSize.y) * 0.25f;
        if ((((float) int22.x) < (-f) || ((float) int22.x) > f) && (((float) int22.y) < (-f2) || ((float) int22.y) > f2)) {
            int2.Set((float) (int22.y > 0 ? inputTouchControlElementData.codeDown : inputTouchControlElementData.codeUp), (float) (int22.x > 0 ? inputTouchControlElementData.codeRight : inputTouchControlElementData.codeLeft));
            return;
        }
        if (Math.abs(int22.x) > Math.abs(int22.y)) {
            int2.Set(-1.0f, (float) (int22.x > 0 ? inputTouchControlElementData.codeRight : inputTouchControlElementData.codeLeft));
        } else {
            int2.Set((float) (int22.y > 0 ? inputTouchControlElementData.codeDown : inputTouchControlElementData.codeUp), -1.0f);
        }
    }

    public XInputEightDirMoveEvents(TouchableWindowElement touchableWindowElement, IInputDevice iInputDevice) {
        Int2 GetSize = touchableWindowElement.GetSize();
        Int2 int2 = new Int2(-1, -1);
        Int2 int22 = GetSize;
        TouchableWindowElement touchableWindowElement2 = touchableWindowElement;
        Int2 int23 = int2;
        IInputDevice iInputDevice2 = iInputDevice;
        touchableWindowElement.onDown.addObserver(new XInputEightDirMoveEvents$$ExternalSyntheticLambda0(this, int22, touchableWindowElement2, int23, iInputDevice2));
        touchableWindowElement.onMove.addObserver(new XInputEightDirMoveEvents$$ExternalSyntheticLambda1(this, int22, touchableWindowElement2, int23, iInputDevice2));
        touchableWindowElement.onUp.addObserver(new XInputEightDirMoveEvents$$ExternalSyntheticLambda2(int2, iInputDevice));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$com-catfixture-inputbridge-core-input-devices-touch-commons-XInputEightDirMoveEvents  reason: not valid java name */
    public /* synthetic */ void m50lambda$new$0$comcatfixtureinputbridgecoreinputdevicestouchcommonsXInputEightDirMoveEvents(Int2 int2, TouchableWindowElement touchableWindowElement, Int2 int22, IInputDevice iInputDevice, Observable observable, Object obj) {
        MotionEvent motionEvent = (MotionEvent) obj;
        Int2 int23 = new Int2(((int) motionEvent.getX()) - (int2.x / 2), ((int) motionEvent.getY()) - (int2.y / 2));
        Int2 int24 = new Int2(-1, -1);
        SetAxis(touchableWindowElement, int24, int23);
        if (int22.x != -1) {
            iInputDevice.SendXIUp(int22.x);
        }
        if (int24.x != -1) {
            iInputDevice.SendXIDown(int24.x);
            int22.x = int24.x;
        }
        if (int22.y != -1) {
            iInputDevice.SendXIUp(int22.y);
        }
        if (int24.y != -1) {
            iInputDevice.SendXIDown(int24.y);
            int22.y = int24.y;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$new$1$com-catfixture-inputbridge-core-input-devices-touch-commons-XInputEightDirMoveEvents  reason: not valid java name */
    public /* synthetic */ void m51lambda$new$1$comcatfixtureinputbridgecoreinputdevicestouchcommonsXInputEightDirMoveEvents(Int2 int2, TouchableWindowElement touchableWindowElement, Int2 int22, IInputDevice iInputDevice, Observable observable, Object obj) {
        MotionEvent motionEvent = (MotionEvent) obj;
        Int2 int23 = new Int2(((int) motionEvent.getX()) - (int2.x / 2), ((int) motionEvent.getY()) - (int2.y / 2));
        Int2 int24 = new Int2(-1, -1);
        SetAxis(touchableWindowElement, int24, int23);
        if (int24.x != -1 && int22.x == -1) {
            iInputDevice.SendXIDown(int24.x);
            int22.x = int24.x;
        } else if (int24.x != -1 && int22.x != int24.x) {
            iInputDevice.SendXIUp(int22.x);
            iInputDevice.SendXIDown(int24.x);
            int22.x = int24.x;
        } else if (int24.x == -1 && int22.x != -1) {
            iInputDevice.SendXIUp(int22.x);
            int22.x = -1;
        }
        if (int24.y != -1 && int22.y == -1) {
            iInputDevice.SendXIDown(int24.y);
            int22.y = int24.y;
        } else if (int24.y != -1 && int22.y != int24.y) {
            iInputDevice.SendXIUp(int22.y);
            iInputDevice.SendXIDown(int24.y);
            int22.y = int24.y;
        } else if (int24.y == -1 && int22.y != -1) {
            iInputDevice.SendXIUp(int22.y);
            int22.y = -1;
        }
    }

    static /* synthetic */ void lambda$new$2(Int2 int2, IInputDevice iInputDevice, Observable observable, Object obj) {
        if (int2.x != -1) {
            iInputDevice.SendXIUp(int2.x);
        }
        if (int2.y != -1) {
            iInputDevice.SendXIUp(int2.y);
        }
    }
}
