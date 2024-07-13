package com.catfixture.inputbridge.core.input.devices.controller;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.context.ConfigContext;
import com.catfixture.inputbridge.core.debug.D;
import com.catfixture.inputbridge.core.input.codes.KeyCode;
import com.catfixture.inputbridge.core.input.codes.KeyCodes;
import com.catfixture.inputbridge.core.input.data.AxisBinding;
import com.catfixture.inputbridge.core.input.data.ComputedAxisBinding;
import com.catfixture.inputbridge.core.input.data.ControllerConfigData;
import com.catfixture.inputbridge.core.input.data.ControllerRebindRecord;
import com.catfixture.inputbridge.core.input.data.InputConfigProfile;
import com.catfixture.inputbridge.core.input.devices.IInputDevice;
import com.catfixture.inputbridge.core.utils.android.LayoutUtils;
import com.catfixture.inputbridge.core.utils.math.Float2;
import com.catfixture.inputbridge.core.utils.math.Int2;
import java.util.HashMap;

public class GenericControllerInputBridge extends RelativeLayout {
    private InputConfigProfile cfgProfile;
    private ComputedAxisBinding comp = new ComputedAxisBinding();
    private IInputDevice inputDevice;
    private final HashMap<Integer, Integer> pressedKeys = new HashMap<>();
    Int2 startButtons = new Int2(-1, -1);

    private boolean OutOfDeadZone(float f, float f2) {
        return f < (-f2) || f > f2;
    }

    public GenericControllerInputBridge(Context context) {
        super(context);
        UpdateViewConfig();
    }

    public GenericControllerInputBridge(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        UpdateViewConfig();
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        UpdateViewConfig();
    }

    private void UpdateViewConfig() {
        this.cfgProfile = ConfigContext.data.GetCurrentProfile();
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        TryCapturePointer(ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION);
        TryCapturePointer(500);
        setBackgroundResource(R.drawable.no_focus);
    }

    private void TryCapturePointer(int i) {
        if (Build.VERSION.SDK_INT < 26) {
            D.E("Not supported!");
        } else if (!hasPointerCapture()) {
            postDelayed(new GenericControllerInputBridge$$ExternalSyntheticLambda0(this), (long) i);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$TryCapturePointer$0$com-catfixture-inputbridge-core-input-devices-controller-GenericControllerInputBridge  reason: not valid java name */
    public /* synthetic */ void m47lambda$TryCapturePointer$0$comcatfixtureinputbridgecoreinputdevicescontrollerGenericControllerInputBridge() {
        requestFocus();
        requestPointerCapture();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        ControllerConfigData GetControllerConfig;
        if (keyEvent.getRepeatCount() != 0 || (GetControllerConfig = this.cfgProfile.GetControllerConfig(keyEvent.getDevice())) == null) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        int action = keyEvent.getAction();
        String str = keyCode + " " + keyEvent.getUnicodeChar() + " " + KeyEvent.keyCodeToString(keyCode);
        if (GetControllerConfig.type == 12) {
            KeyCode GetKeyCodeByAndroidKeyCode = KeyCodes.GetKeyCodeByAndroidKeyCode(keyCode);
            if (GetKeyCodeByAndroidKeyCode != null) {
                int i = GetKeyCodeByAndroidKeyCode.windowsKeyCode;
                return true;
            }
            D.E("KEY NOT SUPPORTED " + str);
            return true;
        } else if (GetControllerConfig.type != 10) {
            return true;
        } else {
            ProcessKeyMapping(GetControllerConfig, action, keyCode);
            return true;
        }
    }

    private void ProcessKeyMapping(ControllerConfigData controllerConfigData, int i, int i2) {
        ControllerRebindRecord FindBindingByLinkedCode = controllerConfigData.FindBindingByLinkedCode(i2);
        if (FindBindingByLinkedCode == null) {
            return;
        }
        if (FindBindingByLinkedCode.buttonType == 0) {
            if (i == 0) {
                this.inputDevice.SendKeyDown(FindBindingByLinkedCode.windowsKeyCode);
            } else if (i == 1) {
                this.inputDevice.SendKeyUp(FindBindingByLinkedCode.windowsKeyCode);
            }
        } else if (FindBindingByLinkedCode.buttonType == 1) {
            if (i == 0) {
                this.inputDevice.SendMouseDown(FindBindingByLinkedCode.mouseCode);
            } else if (i == 1) {
                this.inputDevice.SendMouseUp(FindBindingByLinkedCode.mouseCode);
            }
        } else if (FindBindingByLinkedCode.buttonType != 2) {
        } else {
            if (i == 0) {
                this.inputDevice.SendXIDown(FindBindingByLinkedCode.xinputCode);
            } else if (i == 1) {
                this.inputDevice.SendXIUp(FindBindingByLinkedCode.xinputCode);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0017  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x001b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void SetAxis(com.catfixture.inputbridge.core.input.data.ControllerRebindRecord r3, com.catfixture.inputbridge.core.utils.math.Int2 r4, float r5, float r6, float r7) {
        /*
            r2 = this;
            int r0 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            r1 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r0 <= 0) goto L_0x000a
            int r6 = r3.codeDown
        L_0x0008:
            float r6 = (float) r6
            goto L_0x0013
        L_0x000a:
            float r0 = -r7
            int r6 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r6 >= 0) goto L_0x0012
            int r6 = r3.codeUp
            goto L_0x0008
        L_0x0012:
            r6 = r1
        L_0x0013:
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 <= 0) goto L_0x001b
            int r3 = r3.codeRight
        L_0x0019:
            float r1 = (float) r3
            goto L_0x0023
        L_0x001b:
            float r7 = -r7
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 >= 0) goto L_0x0023
            int r3 = r3.codeLeft
            goto L_0x0019
        L_0x0023:
            r4.Set(r6, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.catfixture.inputbridge.core.input.devices.controller.GenericControllerInputBridge.SetAxis(com.catfixture.inputbridge.core.input.data.ControllerRebindRecord, com.catfixture.inputbridge.core.utils.math.Int2, float, float, float):void");
    }

    public boolean dispatchCapturedPointerEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        ControllerConfigData GetControllerConfig = this.cfgProfile.GetControllerConfig(motionEvent.getDevice());
        if (GetControllerConfig == null || GetControllerConfig.type != 11) {
            return true;
        }
        if (action == 2 || action == 7) {
            this.inputDevice.AddMouseShift(motionEvent.getRawX(), motionEvent.getRawY());
            return true;
        } else if (action == 11) {
            int DetermineMouseButton = DetermineMouseButton(motionEvent.getActionButton());
            if (DetermineMouseButton == -1) {
                return true;
            }
            this.inputDevice.SendMouseDown(DetermineMouseButton);
            return true;
        } else if (action == 12) {
            int DetermineMouseButton2 = DetermineMouseButton(motionEvent.getActionButton());
            if (DetermineMouseButton2 == -1) {
                return true;
            }
            this.inputDevice.SendMouseUp(DetermineMouseButton2);
            return true;
        } else if (action != 8) {
            return true;
        } else {
            this.inputDevice.AddScroll(motionEvent.getAxisValue(9));
            return true;
        }
    }

    private int DetermineMouseButton(int i) {
        if (i == 1) {
            return 0;
        }
        if (i != 2) {
            if (i == 4) {
                return 2;
            }
            if (i != 8) {
                if (i != 16) {
                    if (i == 32) {
                        return 0;
                    }
                    if (i != 64) {
                        D.E("Not supported mouse button !" + i);
                    }
                }
                return -1;
            }
        }
        return 1;
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        ControllerConfigData GetControllerConfig = this.cfgProfile.GetControllerConfig(motionEvent.getDevice());
        if (GetControllerConfig.type == 10) {
            for (ControllerRebindRecord next : GetControllerConfig.rebinds) {
                if (next != null) {
                    if (next.movementType == 1) {
                        float axisValue = motionEvent.getAxisValue(next.xAxis);
                        float axisValue2 = motionEvent.getAxisValue(next.yAxis);
                        if (OutOfDeadZone(axisValue, 0.1f) || OutOfDeadZone(axisValue2, 0.1f)) {
                            this.inputDevice.SetConstantMouseShift(axisValue * 10.0f, axisValue2 * 10.0f);
                        } else {
                            this.inputDevice.SetConstantMouseShift(0.0f, 0.0f);
                        }
                    } else if (next.movementType == 0) {
                        float axisValue3 = motionEvent.getAxisValue(next.xAxis);
                        float axisValue4 = motionEvent.getAxisValue(next.yAxis);
                        Int2 int2 = new Int2(-1, -1);
                        SetAxis(next, int2, axisValue3, axisValue4, 0.5f);
                        if (int2.y != -1 && this.startButtons.y != -1 && int2.y != this.startButtons.y) {
                            this.inputDevice.SendKeyUp(this.startButtons.y);
                            this.inputDevice.SendKeyDown(int2.y);
                            this.startButtons.y = int2.y;
                        } else if (int2.y == -1 && this.startButtons.y != -1) {
                            this.inputDevice.SendKeyUp(this.startButtons.y);
                            this.startButtons.y = -1;
                        } else if (this.startButtons.y == -1 && int2.y != -1) {
                            this.inputDevice.SendKeyDown(int2.y);
                            this.startButtons.y = int2.y;
                        }
                        if (int2.x != -1 && this.startButtons.x != -1 && int2.x != this.startButtons.x) {
                            this.inputDevice.SendKeyUp(this.startButtons.x);
                            this.inputDevice.SendKeyDown(int2.x);
                            this.startButtons.x = int2.x;
                        } else if (int2.x == -1 && this.startButtons.x != -1) {
                            this.inputDevice.SendKeyUp(this.startButtons.x);
                            this.startButtons.x = -1;
                        } else if (this.startButtons.x == -1 && int2.x != -1) {
                            this.inputDevice.SendKeyDown(int2.x);
                            this.startButtons.x = int2.x;
                        }
                    } else if (next.movementType == 2) {
                        this.inputDevice.SetXIStick(next.stickSide, new Float2(motionEvent.getAxisValue(next.xAxis), motionEvent.getAxisValue(next.yAxis)));
                    }
                    float axisValue5 = motionEvent.getAxisValue(15);
                    float axisValue6 = motionEvent.getAxisValue(16);
                    if (axisValue5 > 0.0f) {
                        ProcessKeyMapping(GetControllerConfig, 0, 15);
                    } else {
                        ProcessKeyMapping(GetControllerConfig, 1, 15);
                    }
                    if (axisValue5 < 0.0f) {
                        ProcessKeyMapping(GetControllerConfig, 0, 13);
                    } else {
                        ProcessKeyMapping(GetControllerConfig, 1, 13);
                    }
                    if (axisValue6 > 0.0f) {
                        ProcessKeyMapping(GetControllerConfig, 0, 16);
                    } else {
                        ProcessKeyMapping(GetControllerConfig, 1, 16);
                    }
                    if (axisValue6 < 0.0f) {
                        ProcessKeyMapping(GetControllerConfig, 0, 14);
                    } else {
                        ProcessKeyMapping(GetControllerConfig, 1, 14);
                    }
                }
            }
            for (AxisBinding next2 : GetControllerConfig.axesBindings) {
                ComputedAxisBinding.Check(this.comp, 1.0f, 1.0f, next2, motionEvent.getAxisValue(next2.owner));
            }
            ComputedAxisBinding.ApplyInput(this.comp, this.inputDevice, 1.0f);
        }
        return true;
    }

    public void Create(IInputDevice iInputDevice) {
        LayoutUtils.SetMatchMatch(this);
        this.inputDevice = iInputDevice;
    }
}
