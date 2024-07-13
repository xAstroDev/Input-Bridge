package com.catfixture.inputbridge.core.overlay;

import android.animation.ObjectAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.Const;
import com.catfixture.inputbridge.core.GSS.overlay.GSSOverlayFragment;
import com.catfixture.inputbridge.core.access.TouchEmulatorServic;
import com.catfixture.inputbridge.core.context.AppContext;
import com.catfixture.inputbridge.core.context.ConfigContext;
import com.catfixture.inputbridge.core.input.data.ComputedAxisBinding;
import com.catfixture.inputbridge.core.input.data.InputConfigProfile;
import com.catfixture.inputbridge.core.input.devices.sensors.PositionSensor;
import com.catfixture.inputbridge.core.input.devices.touch.TouchDevice;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.TouchDeviceOverlayFragment;
import com.catfixture.inputbridge.core.input.utils.HomeWatcher;
import com.catfixture.inputbridge.core.service.InputService;
import com.catfixture.inputbridge.core.utils.android.AndroidUtils;
import com.catfixture.inputbridge.core.utils.android.LayoutUtils;
import com.catfixture.inputbridge.core.utils.types.delegates.Action;
import com.catfixture.inputbridge.core.utils.windows.MinimalWindow;
import com.catfixture.inputbridge.core.weakmsg.WeakMsg;
import com.catfixture.inputbridge.ui.activity.editors.touchEditor.TouchEditorActivity;
import com.catfixture.inputbridge.ui.activity.main.ErrorH;
import com.catfixture.inputbridge.ui.activity.main.MainActivity;
import com.catfixture.inputbridge.ui.common.genAdapter.DisplayType;
import com.catfixture.inputbridge.ui.common.genAdapter.GenericSpinnerAdapter;
import java.util.Arrays;

public class MainControlsOverlayFragment implements IOverlayFragment {
    private static final float DISABLED_CONTROLS_ALPHA = 0.2f;
    public static final int ID_MAIN_CONTROLS_OVERLAY = 10000;
    private final int collapsedWidth;
    private ComputedAxisBinding comp = new ComputedAxisBinding();
    private final Context context;
    private final int currentInputDevice = 100;
    private ObjectAnimator endlessAlphaAnimation;
    private final int expandedWidth;
    private final InputService inputService;
    private boolean isExpanded;
    private boolean isShown;
    private HomeWatcher mHomeWatcher;
    private final ViewGroup mainCont;
    private final OverlayManager overlayManager;
    private PositionSensor pos;
    private final ViewGroup root;
    private MinimalWindow tempWin;
    /* access modifiers changed from: private */
    public TouchDevice touchDevice;
    private final BroadcastReceiver updateBRR;

    static /* synthetic */ void lambda$new$7(Integer num) {
    }

    public int GetID() {
        return ID_MAIN_CONTROLS_OVERLAY;
    }

    public MainControlsOverlayFragment(InputService inputService2, OverlayManager overlayManager2) {
        this.context = inputService2;
        this.overlayManager = overlayManager2;
        this.inputService = inputService2;
        ViewGroup viewGroup = (ViewGroup) View.inflate(inputService2, R.layout.overlay_settings_panel, (ViewGroup) null);
        this.root = viewGroup;
        LayoutUtils.SetMatchWrap(viewGroup);
        AndroidUtils.HideSystemUI(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(R.id.mainCont);
        this.mainCont = viewGroup2;
        viewGroup2.measure(0, 0);
        int measuredWidth = viewGroup2.getMeasuredWidth();
        this.collapsedWidth = measuredWidth;
        ((ViewGroup) viewGroup.findViewById(R.id.controlsContainer)).setVisibility(0);
        viewGroup2.measure(0, 0);
        this.expandedWidth = viewGroup2.getMeasuredWidth();
        viewGroup2.getLayoutParams().width = measuredWidth;
        viewGroup2.requestLayout();
        ImageView imageView = (ImageView) viewGroup.findViewById(R.id.settingsIco);
        imageView.setOnClickListener(new MainControlsOverlayFragment$$ExternalSyntheticLambda8(this, imageView, new MainControlsOverlayFragment$$ExternalSyntheticLambda4(this), inputService2));
        MainControlsOverlayFragment$$ExternalSyntheticLambda7 mainControlsOverlayFragment$$ExternalSyntheticLambda7 = new MainControlsOverlayFragment$$ExternalSyntheticLambda7(this, inputService2);
        if (ConfigContext.data.HasCurrentProfile()) {
            InputConfigProfile GetCurrentProfile = ConfigContext.data.GetCurrentProfile();
            ImageView imageView2 = (ImageView) viewGroup.findViewById(R.id.toggleMice);
            imageView2.setOnClickListener(new MainControlsOverlayFragment$$ExternalSyntheticLambda9(this, GetCurrentProfile, imageView2, inputService2));
            UpdateMiceButtonColor(imageView2, GetCurrentProfile.miceToggled);
        }
        ((ImageView) viewGroup.findViewById(R.id.toggleEditor)).setOnClickListener(new MainControlsOverlayFragment$$ExternalSyntheticLambda11(mainControlsOverlayFragment$$ExternalSyntheticLambda7, inputService2));
        ((ImageView) viewGroup.findViewById(R.id.toggleControllers)).setOnClickListener(new MainControlsOverlayFragment$$ExternalSyntheticLambda12(mainControlsOverlayFragment$$ExternalSyntheticLambda7, inputService2));
        Spinner spinner = (Spinner) viewGroup.findViewById(R.id.showProfiles);
        GenericSpinnerAdapter genericSpinnerAdapter = new GenericSpinnerAdapter((Context) inputService2, (int) R.layout.basic_spinner_item_spec_ov, ConfigContext.data.profiles, (Action<Integer>) MainControlsOverlayFragment$$ExternalSyntheticLambda15.INSTANCE);
        genericSpinnerAdapter.EnableCustomItemAction(MainControlsOverlayFragment$$ExternalSyntheticLambda14.INSTANCE);
        spinner.setAdapter(genericSpinnerAdapter);
        genericSpinnerAdapter.notifyDataSetChanged();
        spinner.setSelection(ConfigContext.data.currentProfile);
        spinner.setPopupBackgroundResource(R.color.white);
        spinner.post(new MainControlsOverlayFragment$$ExternalSyntheticLambda5(this, spinner, imageView));
        ((ImageView) viewGroup.findViewById(R.id.close)).setOnClickListener(new MainControlsOverlayFragment$$ExternalSyntheticLambda10(inputService2));
        ((ImageView) viewGroup.findViewById(R.id.hide)).setOnClickListener(new MainControlsOverlayFragment$$ExternalSyntheticLambda0(this));
        viewGroup2.setAlpha(0.2f);
        this.isShown = true;
        MinimizeWindow();
        this.updateBRR = WeakMsg.CreateListener(inputService2, new MainControlsOverlayFragment$$ExternalSyntheticLambda13(this));
        HomeWatcher homeWatcher = new HomeWatcher(inputService2);
        this.mHomeWatcher = homeWatcher;
        homeWatcher.setOnHomePressedListener(new HomeWatcher.OnHomePressedListener() {
            public void onHomePressed() {
                if (MainControlsOverlayFragment.this.touchDevice != null) {
                    MainControlsOverlayFragment.this.touchDevice.Reset();
                }
                MainControlsOverlayFragment.this.HideAll();
            }

            public void onHomeLongPressed() {
                if (MainControlsOverlayFragment.this.touchDevice != null) {
                    MainControlsOverlayFragment.this.touchDevice.Reset();
                }
                MainControlsOverlayFragment.this.HideAll();
            }
        });
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$com-catfixture-inputbridge-core-overlay-MainControlsOverlayFragment  reason: not valid java name */
    public /* synthetic */ void m98lambda$new$0$comcatfixtureinputbridgecoreoverlayMainControlsOverlayFragment() {
        if (!this.isExpanded) {
            ActivateTouchControls();
            if (!this.isShown) {
                RestoreWindow();
                return;
            }
            RestoreWindow();
        }
        boolean z = !this.isExpanded;
        this.isExpanded = z;
        SetExpanded(z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$new$2$com-catfixture-inputbridge-core-overlay-MainControlsOverlayFragment  reason: not valid java name */
    public /* synthetic */ void m101lambda$new$2$comcatfixtureinputbridgecoreoverlayMainControlsOverlayFragment(ImageView imageView, Runnable runnable, InputService inputService2, View view) {
        if (!this.isShown) {
            try {
                if (TouchEmulatorServic.HasInstance()) {
                    TouchEmulatorServic.GetInstance().TryMinimize(new MainControlsOverlayFragment$$ExternalSyntheticLambda16(imageView, runnable));
                } else {
                    imageView.post(runnable);
                }
            } catch (Exception e) {
                ErrorH.RaiseCrash(inputService2, e.getMessage(), Arrays.toString(e.getStackTrace()));
            }
        } else {
            runnable.run();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$new$3$com-catfixture-inputbridge-core-overlay-MainControlsOverlayFragment  reason: not valid java name */
    public /* synthetic */ void m102lambda$new$3$comcatfixtureinputbridgecoreoverlayMainControlsOverlayFragment(InputService inputService2) {
        HideAll();
        WeakMsg.Send((Context) inputService2, (int) Const.BCAST_ACTION_STOP_CONNECTION);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$new$4$com-catfixture-inputbridge-core-overlay-MainControlsOverlayFragment  reason: not valid java name */
    public /* synthetic */ void m103lambda$new$4$comcatfixtureinputbridgecoreoverlayMainControlsOverlayFragment(InputConfigProfile inputConfigProfile, ImageView imageView, InputService inputService2, View view) {
        inputConfigProfile.miceToggled = !inputConfigProfile.miceToggled;
        inputConfigProfile.Save();
        UpdateMiceButtonColor(imageView, inputConfigProfile.miceToggled);
        Intent PrepareMessage = WeakMsg.PrepareMessage(Const.BCAST_ACTION_SET_MICE_STATE);
        PrepareMessage.putExtra("state", inputConfigProfile.miceToggled);
        WeakMsg.Send((Context) inputService2, PrepareMessage);
        SetExpanded(false);
    }

    static /* synthetic */ void lambda$new$5(Runnable runnable, InputService inputService2, View view) {
        runnable.run();
        Intent intent = new Intent(inputService2, TouchEditorActivity.class);
        intent.addFlags(268468224);
        inputService2.startActivity(intent);
    }

    static /* synthetic */ void lambda$new$6(Runnable runnable, InputService inputService2, View view) {
        runnable.run();
        Intent intent = new Intent(inputService2, MainActivity.class);
        intent.putExtra("SetTab", 2);
        intent.addFlags(268468224);
        inputService2.startActivity(intent);
    }

    static /* synthetic */ void lambda$new$8(View view, Integer num, DisplayType displayType) {
        if (displayType == DisplayType.Normal) {
            view.setVisibility(8);
        } else {
            view.setVisibility(0);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$new$9$com-catfixture-inputbridge-core-overlay-MainControlsOverlayFragment  reason: not valid java name */
    public /* synthetic */ void m104lambda$new$9$comcatfixtureinputbridgecoreoverlayMainControlsOverlayFragment(Spinner spinner, final ImageView imageView) {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                MainControlsOverlayFragment.this.StopPositionSensor();
                ConfigContext.data.SetCurrentProfile(i);
                imageView.callOnClick();
                MainControlsOverlayFragment.this.ReinflateControls();
                MainControlsOverlayFragment.this.ActivateTouchControls();
            }
        });
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$new$11$com-catfixture-inputbridge-core-overlay-MainControlsOverlayFragment  reason: not valid java name */
    public /* synthetic */ void m99lambda$new$11$comcatfixtureinputbridgecoreoverlayMainControlsOverlayFragment(View view) {
        AndroidUtils.HideSystemUI(this.root);
        HideAll();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$new$12$com-catfixture-inputbridge-core-overlay-MainControlsOverlayFragment  reason: not valid java name */
    public /* synthetic */ void m100lambda$new$12$comcatfixtureinputbridgecoreoverlayMainControlsOverlayFragment(Integer num, Intent intent) {
        if (num.intValue() != 4508) {
            return;
        }
        if (TouchEmulatorServic.HasInstance()) {
            TouchEmulatorServic.GetInstance().TryMinimize(new MainControlsOverlayFragment$$ExternalSyntheticLambda1(this));
        } else {
            ActivateTouchControls();
        }
    }

    /* access modifiers changed from: private */
    public void StopPositionSensor() {
        PositionSensor positionSensor = this.pos;
        if (positionSensor != null) {
            positionSensor.OnChanged = null;
        }
    }

    private void UpdateMiceButtonColor(ImageView imageView, boolean z) {
        imageView.setImageResource(z ? R.drawable.fx_ov_mice_active : R.drawable.fx_ov_micekeyboard);
    }

    private boolean IsControlsHidden() {
        return this.overlayManager.IsShown((int) TouchDeviceOverlayFragment.ID_TOUCH_CONTROLS_OVERLAY);
    }

    private void RestoreWindow() {
        if (!this.isShown) {
            StopAnimation(this.endlessAlphaAnimation);
            this.endlessAlphaAnimation = null;
            this.overlayManager.SetExpanded();
            this.isShown = true;
        }
    }

    private void MinimizeWindow() {
        if (this.isShown) {
            if (this.endlessAlphaAnimation == null) {
                this.endlessAlphaAnimation = StartAlphaEndlessAnimation(this.mainCont);
            }
            OverlayManager overlayManager2 = this.overlayManager;
            int i = this.collapsedWidth;
            overlayManager2.SetCollapsed(i, i);
            this.isShown = false;
        }
    }

    private ObjectAnimator StartAlphaEndlessAnimation(View view) {
        view.clearAnimation();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", new float[]{0.05f, 0.8f});
        ofFloat.setDuration(500);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        return ofFloat;
    }

    private void StopAnimation(ObjectAnimator objectAnimator) {
        if (objectAnimator != null) {
            objectAnimator.removeAllUpdateListeners();
            objectAnimator.removeAllListeners();
            objectAnimator.end();
            objectAnimator.cancel();
        }
    }

    public void ActivateTouchControls() {
        if (!this.mHomeWatcher.isWatching()) {
            this.mHomeWatcher.startWatch();
        }
        this.mainCont.postDelayed(new MainControlsOverlayFragment$$ExternalSyntheticLambda2(this), 2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$ActivateTouchControls$14$com-catfixture-inputbridge-core-overlay-MainControlsOverlayFragment  reason: not valid java name */
    public /* synthetic */ void m96lambda$ActivateTouchControls$14$comcatfixtureinputbridgecoreoverlayMainControlsOverlayFragment() {
        RestoreWindow();
        this.overlayManager.Show((int) GSSOverlayFragment.ID_GSS_OVERLAY_FRAGMENT);
        if (this.touchDevice == null) {
            this.touchDevice = new TouchDevice(this.context, this.inputService.GetMarshall(), this.overlayManager);
        }
        InputConfigProfile GetCurrentProfile = ConfigContext.data.GetCurrentProfile();
        this.pos = AppContext.app.GetPositionSensor();
        if (GetCurrentProfile.posSensorData.enable) {
            this.pos.SetData(GetCurrentProfile.posSensorData);
            this.pos.OnChanged = new MainControlsOverlayFragment$$ExternalSyntheticLambda6(this, GetCurrentProfile);
        }
        this.inputService.EnableProtocol();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$ActivateTouchControls$13$com-catfixture-inputbridge-core-overlay-MainControlsOverlayFragment  reason: not valid java name */
    public /* synthetic */ void m95lambda$ActivateTouchControls$13$comcatfixtureinputbridgecoreoverlayMainControlsOverlayFragment(InputConfigProfile inputConfigProfile) {
        this.comp.mouseX = 0.0f;
        this.comp.mouseY = 0.0f;
        this.comp.leftXiStickX = 0.0f;
        this.comp.leftXiStickY = 0.0f;
        this.comp.rightXiStickX = 0.0f;
        this.comp.rightXiStickY = 0.0f;
        float f = ((float) inputConfigProfile.posSensorData.sensitivity) / 100.0f;
        float floatValue = inputConfigProfile.posSensorData.clamps.get(1).floatValue();
        ComputedAxisBinding.Check(this.comp, f, floatValue, inputConfigProfile.posSensorData.axisX, this.pos.GetXRot());
        ComputedAxisBinding.Check(this.comp, f, floatValue, inputConfigProfile.posSensorData.axisY, this.pos.GetYRot());
        ComputedAxisBinding.Check(this.comp, f, floatValue, inputConfigProfile.posSensorData.axisZ, this.pos.GetZRot());
        ComputedAxisBinding.ApplyInput(this.comp, this.touchDevice, f);
    }

    public void DeactivateTouchControls() {
        StopPositionSensor();
        this.overlayManager.Hide((int) GSSOverlayFragment.ID_GSS_OVERLAY_FRAGMENT);
        this.inputService.DisableProtocol();
        TouchDevice touchDevice2 = this.touchDevice;
        if (touchDevice2 != null) {
            touchDevice2.Destroy();
            this.touchDevice = null;
        }
    }

    /* access modifiers changed from: private */
    public void ReinflateControls() {
        TouchDevice touchDevice2 = this.touchDevice;
        if (touchDevice2 != null) {
            touchDevice2.Destroy();
            this.touchDevice = null;
            this.touchDevice = new TouchDevice(this.context, this.inputService.GetMarshall(), this.overlayManager);
        }
    }

    public void HideAll() {
        SetExpanded(false);
        this.mainCont.postDelayed(new MainControlsOverlayFragment$$ExternalSyntheticLambda3(this), 2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$HideAll$15$com-catfixture-inputbridge-core-overlay-MainControlsOverlayFragment  reason: not valid java name */
    public /* synthetic */ void m97lambda$HideAll$15$comcatfixtureinputbridgecoreoverlayMainControlsOverlayFragment() {
        MinimizeWindow();
        DeactivateTouchControls();
    }

    public ViewGroup GetContainer() {
        return this.root;
    }

    public void OnFragmentShown() {
        if (this.mainCont != null) {
            InputConfigProfile GetCurrentProfile = ConfigContext.data.GetCurrentProfile();
            HideAll();
            if (GetCurrentProfile != null && GetCurrentProfile.showControlsWhenConnected && TouchEmulatorServic.HasInstance()) {
                TouchEmulatorServic.GetInstance().TryMinimize(new MainControlsOverlayFragment$$ExternalSyntheticLambda1(this));
            }
        }
    }

    public void OnFragmentHidden() {
        InputConfigProfile GetCurrentProfile = ConfigContext.data.GetCurrentProfile();
        if (GetCurrentProfile != null && GetCurrentProfile.showControlsWhenConnected) {
            HideAll();
        }
    }

    public void Destroy() {
        HomeWatcher homeWatcher = this.mHomeWatcher;
        if (homeWatcher != null) {
            homeWatcher.stopWatch();
        }
        DeactivateTouchControls();
        MinimalWindow minimalWindow = this.tempWin;
        if (minimalWindow != null) {
            minimalWindow.Destroy();
        }
        WeakMsg.DestroyListener(this.context, this.updateBRR);
    }

    private void SetExpanded(boolean z) {
        this.isExpanded = z;
        LayoutUtils.SetSizeRelative(this.mainCont, z ? this.expandedWidth : this.collapsedWidth, this.collapsedWidth);
        this.mainCont.setAlpha(z ? 1.0f : 0.2f);
        this.mainCont.requestLayout();
    }
}
