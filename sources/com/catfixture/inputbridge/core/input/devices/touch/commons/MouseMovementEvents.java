package com.catfixture.inputbridge.core.input.devices.touch.commons;

import android.os.Handler;
import android.view.MotionEvent;
import com.catfixture.inputbridge.core.context.AppContext;
import com.catfixture.inputbridge.core.input.data.InputConfigProfile;
import com.catfixture.inputbridge.core.input.data.InputTouchControlElementData;
import com.catfixture.inputbridge.core.input.devices.IInputDevice;
import com.catfixture.inputbridge.core.input.utils.ITouchable;
import java.util.Observable;

public class MouseMovementEvents {
    private static boolean alaDrag = false;
    private static long lastClickTime = 0;
    private static float lastX = 0.0f;
    private static float lastY = 0.0f;
    private static int usedBy = -1;
    private static boolean wasDc;

    public static void Init(int i, ITouchable iTouchable, InputConfigProfile inputConfigProfile, InputTouchControlElementData inputTouchControlElementData, IInputDevice iInputDevice, boolean z) {
        Handler handler = new Handler();
        iTouchable.OnDown().addObserver(new MouseMovementEvents$$ExternalSyntheticLambda1(i, inputTouchControlElementData, inputConfigProfile, iInputDevice, z));
        iTouchable.OnMove().addObserver(new MouseMovementEvents$$ExternalSyntheticLambda2(i, inputTouchControlElementData, iInputDevice, inputConfigProfile));
        if (z) {
            iTouchable.OnClick().addObserver(new MouseMovementEvents$$ExternalSyntheticLambda4(iInputDevice, handler));
        }
        iTouchable.OnUp().addObserver(new MouseMovementEvents$$ExternalSyntheticLambda3(i, inputTouchControlElementData, z, iInputDevice));
    }

    static /* synthetic */ void lambda$Init$0(int i, InputTouchControlElementData inputTouchControlElementData, InputConfigProfile inputConfigProfile, IInputDevice iInputDevice, boolean z, Observable observable, Object obj) {
        if (usedBy == -1) {
            usedBy = i;
        }
        if (usedBy == i) {
            MotionEvent motionEvent = (MotionEvent) obj;
            if (!inputTouchControlElementData.isDragging) {
                inputTouchControlElementData.firstMoveIndex = motionEvent.getPointerId(motionEvent.getActionIndex());
                inputTouchControlElementData.isDragging = true;
                if (!inputConfigProfile.miceToggled) {
                    iInputDevice.ResetMousePos(motionEvent.getX(), motionEvent.getY());
                }
                wasDc = false;
                alaDrag = false;
                iInputDevice.SetMousePos(motionEvent.getX(), motionEvent.getY(), inputTouchControlElementData.GetSensivity());
                if (inputConfigProfile.miceToggled && z) {
                    if (System.currentTimeMillis() - lastClickTime < 200) {
                        iInputDevice.SendMouseDown(0);
                        wasDc = true;
                        return;
                    }
                    lastClickTime = System.currentTimeMillis();
                    lastX = motionEvent.getX();
                    lastY = motionEvent.getY();
                }
            }
        }
    }

    static /* synthetic */ void lambda$Init$1(int i, InputTouchControlElementData inputTouchControlElementData, IInputDevice iInputDevice, InputConfigProfile inputConfigProfile, Observable observable, Object obj) {
        if (usedBy == i) {
            MotionEvent motionEvent = (MotionEvent) obj;
            if (inputTouchControlElementData.isDragging) {
                iInputDevice.SetMousePos(motionEvent.getX(), motionEvent.getY(), inputTouchControlElementData.GetSensivity());
                if (inputConfigProfile.miceToggled && System.currentTimeMillis() - lastClickTime > 500 && !alaDrag && lastX - motionEvent.getX() < 10.0f && lastY - motionEvent.getY() < 10.0f) {
                    iInputDevice.SendMouseDown(0);
                    AppContext.app.vibrator.vibrate(15);
                    alaDrag = true;
                }
            }
        }
    }

    static /* synthetic */ void lambda$Init$3(IInputDevice iInputDevice, Handler handler, Observable observable, Object obj) {
        if (!wasDc) {
            iInputDevice.SendMouseDown(0);
            handler.postDelayed(new MouseMovementEvents$$ExternalSyntheticLambda0(iInputDevice), 5);
        }
    }

    static /* synthetic */ void lambda$Init$4(int i, InputTouchControlElementData inputTouchControlElementData, boolean z, IInputDevice iInputDevice, Observable observable, Object obj) {
        if (usedBy == i) {
            usedBy = -1;
            inputTouchControlElementData.isDragging = false;
            if (z) {
                iInputDevice.SendMouseUp(0);
            }
        }
    }
}
