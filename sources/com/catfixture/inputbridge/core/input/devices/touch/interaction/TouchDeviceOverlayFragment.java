package com.catfixture.inputbridge.core.input.devices.touch.interaction;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Size;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.context.ConfigContext;
import com.catfixture.inputbridge.core.input.core.MegaHoverHandler;
import com.catfixture.inputbridge.core.input.data.InputConfigData;
import com.catfixture.inputbridge.core.input.data.InputConfigProfile;
import com.catfixture.inputbridge.core.input.data.InputTouchControlElementData;
import com.catfixture.inputbridge.core.input.devices.IInputDevice;
import com.catfixture.inputbridge.core.input.devices.controller.GenericControllerInputBridge;
import com.catfixture.inputbridge.core.input.devices.touch.commons.MouseMovementEvents;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.TouchableWindowElement;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.buttons.button.ButtonElement;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.buttons.buttonCombination.ButtonCombinationElement;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.cheatCode.CheatCodeElement;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.cross.CrossElement;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.fullscreen.FullscreenElement;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.mouseZone.MouseZoneElement;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.scroll.ScrollElement;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.stick.StickElement;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.swheel.SWheelElement;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.swipe.SwipeElement;
import com.catfixture.inputbridge.core.input.utils.DragAndDropHandle;
import com.catfixture.inputbridge.core.input.utils.IInputWindowElement;
import com.catfixture.inputbridge.core.overlay.IOverlayFragment;
import com.catfixture.inputbridge.core.utils.android.AndroidUtils;
import com.catfixture.inputbridge.core.utils.android.LayoutUtils;
import com.catfixture.inputbridge.core.utils.math.Float2;
import com.catfixture.inputbridge.core.utils.math.Int2;
import com.catfixture.inputbridge.core.utils.types.delegates.Action;
import com.catfixture.inputbridge.core.weakmsg.WeakMsg;
import com.catfixture.inputbridge.ui.activity.editors.touchEditor.EditorFloatShared;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class TouchDeviceOverlayFragment implements IOverlayFragment {
    public static final int ID_TOUCH_CONTROLS_OVERLAY = 10001;
    private final Context context;
    private final IInputDevice inputDevice;
    private BroadcastReceiver miceStateListener;
    private final RelativeLayout root;
    private final List<IInputWindowElement> windowElements = new ArrayList();

    public void Destroy() {
    }

    public int GetID() {
        return ID_TOUCH_CONTROLS_OVERLAY;
    }

    public TouchDeviceOverlayFragment(Context context2, IInputDevice iInputDevice) {
        this.context = context2;
        this.inputDevice = iInputDevice;
        this.root = new RelativeLayout(context2);
    }

    public void TryGetWindowElementById(int i, Action<IInputWindowElement> action) {
        for (IInputWindowElement next : this.windowElements) {
            if (next.GetId() == i) {
                action.Invoke(next);
                return;
            }
        }
    }

    public IInputWindowElement TryGetWindowElementById(int i) {
        for (IInputWindowElement next : this.windowElements) {
            if (next.GetId() == i) {
                return next;
            }
        }
        return null;
    }

    public static void InflateControls(Context context2, IInputDevice iInputDevice, RelativeLayout relativeLayout, List<IInputWindowElement> list, boolean z, Action<Integer> action) {
        TouchableWindowElement touchableWindowElement;
        Context context3 = context2;
        IInputDevice iInputDevice2 = iInputDevice;
        RelativeLayout relativeLayout2 = relativeLayout;
        relativeLayout.removeAllViews();
        list.clear();
        InputConfigData inputConfigData = ConfigContext.data;
        if (inputConfigData.HasCurrentProfile()) {
            InputConfigProfile GetCurrentProfile = inputConfigData.GetCurrentProfile();
            if (z || !GetCurrentProfile.touchControlsHidden) {
                int GetDP = LayoutUtils.GetDP(context3, GetCurrentProfile.snappingSize);
                Size GetRealDisplaySize = AndroidUtils.GetRealDisplaySize((WindowManager) context3.getSystemService(WindowManager.class));
                double width = ((double) GetRealDisplaySize.getWidth()) / ((double) GetCurrentProfile.refResolution.x);
                double height = ((double) GetRealDisplaySize.getHeight()) / ((double) GetCurrentProfile.refResolution.y);
                if (GetCurrentProfile.refResolution.x == -1 || GetCurrentProfile.refResolution.y == -1) {
                    width = 1.0d;
                    height = 1.0d;
                }
                GetCurrentProfile.SetRefResolution(new Int2(GetRealDisplaySize.getWidth(), GetRealDisplaySize.getHeight()));
                double d = width + ((double) EditorFloatShared.profileScale.x);
                double d2 = height + ((double) EditorFloatShared.profileScale.y);
                MegaHoverHandler megaHoverHandler = null;
                if (!z) {
                    GenericControllerInputBridge genericControllerInputBridge = new GenericControllerInputBridge(context3);
                    genericControllerInputBridge.Create(iInputDevice2);
                    genericControllerInputBridge.setClickable(true);
                    LayoutUtils.SetMatchMatch(genericControllerInputBridge);
                    relativeLayout2.addView(genericControllerInputBridge);
                    if (GetCurrentProfile.screenAsMouse) {
                        InputTouchControlElementData inputTouchControlElementData = new InputTouchControlElementData();
                        FullscreenElement fullscreenElement = new FullscreenElement(context3);
                        MouseMovementEvents.Init(1, fullscreenElement, GetCurrentProfile, inputTouchControlElementData, iInputDevice, true);
                        relativeLayout2.addView(fullscreenElement);
                    }
                    megaHoverHandler = new MegaHoverHandler(context3);
                }
                MegaHoverHandler megaHoverHandler2 = megaHoverHandler;
                for (InputTouchControlElementData next : GetCurrentProfile.touchControlElements) {
                    switch (next.type) {
                        case 1:
                            touchableWindowElement = new ButtonElement(context3, next);
                            if (!z) {
                                megaHoverHandler2.RegisterView(touchableWindowElement);
                                break;
                            }
                            break;
                        case 2:
                            touchableWindowElement = new ButtonCombinationElement(context3, next);
                            break;
                        case 3:
                            touchableWindowElement = new CrossElement(context3, next);
                            break;
                        case 4:
                            touchableWindowElement = new StickElement(context3, next);
                            break;
                        case 5:
                            touchableWindowElement = new MouseZoneElement(context3, next);
                            break;
                        case 6:
                            touchableWindowElement = new ScrollElement(context3, next);
                            break;
                        case 7:
                            touchableWindowElement = new CheatCodeElement(context3, next);
                            break;
                        case 8:
                            touchableWindowElement = new SwipeElement(context3, next);
                            break;
                        case 9:
                            touchableWindowElement = new SWheelElement(context3, next);
                            break;
                        default:
                            List<IInputWindowElement> list2 = list;
                            Action<Integer> action2 = action;
                            context3 = context2;
                            continue;
                    }
                    TouchableWindowElement touchableWindowElement2 = touchableWindowElement;
                    touchableWindowElement2.SetReinflate(new TouchDeviceOverlayFragment$$ExternalSyntheticLambda3(touchableWindowElement2));
                    TouchDeviceOverlayFragment$$ExternalSyntheticLambda1 touchDeviceOverlayFragment$$ExternalSyntheticLambda1 = r0;
                    TouchableWindowElement touchableWindowElement3 = touchableWindowElement2;
                    InputTouchControlElementData inputTouchControlElementData2 = next;
                    MegaHoverHandler megaHoverHandler3 = megaHoverHandler2;
                    TouchDeviceOverlayFragment$$ExternalSyntheticLambda1 touchDeviceOverlayFragment$$ExternalSyntheticLambda12 = new TouchDeviceOverlayFragment$$ExternalSyntheticLambda1(context2, iInputDevice, relativeLayout, list, z, action);
                    touchableWindowElement3.SetEditorReset(touchDeviceOverlayFragment$$ExternalSyntheticLambda1);
                    touchableWindowElement3.SetScale(inputTouchControlElementData2.scale).SetAlpha(inputTouchControlElementData2.alpha);
                    if (!(d == 1.0d && d2 == 1.0d)) {
                        inputTouchControlElementData2.SetPosition(new Int2((int) (((double) inputTouchControlElementData2.position.x) * d), (int) (((double) inputTouchControlElementData2.position.y) * d2)));
                    }
                    touchableWindowElement3.SetPosition(inputTouchControlElementData2.position.x, inputTouchControlElementData2.position.y);
                    if (z) {
                        DragAndDropHandle dragAndDropHandle = new DragAndDropHandle(touchableWindowElement3);
                        dragAndDropHandle.onPositionChanged.addObserver(new TouchDeviceOverlayFragment$$ExternalSyntheticLambda4(inputTouchControlElementData2));
                        dragAndDropHandle.SetLimits(GetRealDisplaySize.getWidth(), GetRealDisplaySize.getHeight());
                        dragAndDropHandle.EnableSnap(GetDP);
                        touchableWindowElement3.CreateEditorEvents();
                        touchableWindowElement3.onDown.addObserver(new TouchDeviceOverlayFragment$$ExternalSyntheticLambda5(action, touchableWindowElement3));
                        touchableWindowElement3.InitEditorAppearance(GetCurrentProfile.showBackground);
                    } else {
                        Action<Integer> action3 = action;
                        touchableWindowElement3.CreateActionDecorations(GetCurrentProfile);
                        touchableWindowElement3.CreateEventActions(iInputDevice2);
                    }
                    relativeLayout2.addView(touchableWindowElement3);
                    list.add(touchableWindowElement3);
                    context3 = context2;
                    megaHoverHandler2 = megaHoverHandler3;
                }
            }
        }
    }

    static /* synthetic */ void lambda$InflateControls$0(Context context2, IInputDevice iInputDevice, RelativeLayout relativeLayout, List list, boolean z, Action action, Boolean bool) {
        InflateControls(context2, iInputDevice, relativeLayout, list, z, action);
        action.Invoke(Integer.valueOf(bool.booleanValue() ? -2 : -1));
    }

    static /* synthetic */ void lambda$InflateControls$2(Action action, TouchableWindowElement touchableWindowElement, Observable observable, Object obj) {
        if (action != null) {
            action.Invoke(Integer.valueOf(touchableWindowElement.GetId()));
        }
    }

    public ViewGroup GetContainer() {
        return this.root;
    }

    public void OnFragmentShown() {
        InflateControls(this.context, this.inputDevice, this.root, this.windowElements, false, (Action<Integer>) null);
        if (ConfigContext.data.HasCurrentProfile()) {
            ImageView imageView = new ImageView(this.context);
            imageView.setVisibility(ConfigContext.data.GetCurrentProfile().miceToggled ? 0 : 8);
            imageView.setImageResource(R.drawable.cursor_default);
            imageView.setLayoutParams(new LinearLayout.LayoutParams(LayoutUtils.GetDP(this.context, 10), LayoutUtils.GetDP(this.context, 25)));
            this.root.addView(imageView);
            this.inputDevice.SetOnMousePosChanged(new TouchDeviceOverlayFragment$$ExternalSyntheticLambda2(imageView));
            this.miceStateListener = WeakMsg.CreateListener(this.context, new TouchDeviceOverlayFragment$$ExternalSyntheticLambda0(imageView));
        }
    }

    static /* synthetic */ void lambda$OnFragmentShown$3(ImageView imageView, Float2 float2) {
        imageView.setX(float2.x + 5.0f);
        imageView.setY(float2.y - 15.0f);
    }

    static /* synthetic */ void lambda$OnFragmentShown$4(ImageView imageView, Integer num, Intent intent) {
        if (num.intValue() == 4511) {
            int i = 0;
            if (!intent.getBooleanExtra("state", false)) {
                i = 8;
            }
            imageView.setVisibility(i);
        }
    }

    public void OnFragmentHidden() {
        WeakMsg.DestroyListener(this.context, this.miceStateListener);
        this.miceStateListener = null;
    }

    public void DeselectAll() {
        for (IInputWindowElement Deselect : this.windowElements) {
            Deselect.Deselect();
        }
    }
}
