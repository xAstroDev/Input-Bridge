package com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.buttons.button;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.text.TextPaint;
import android.view.ViewGroup;
import com.catfixture.inputbridge.core.context.AppContext;
import com.catfixture.inputbridge.core.context.ConfigContext;
import com.catfixture.inputbridge.core.input.data.IconData;
import com.catfixture.inputbridge.core.input.data.InputTouchControlElementData;
import com.catfixture.inputbridge.core.input.devices.IInputDevice;
import com.catfixture.inputbridge.core.input.devices.touch.commons.MouseMovementEvents;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.CommonElementView;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.DrawHelper;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.TouchableWindowElement;
import java.util.Observable;

public class ButtonElement extends TouchableWindowElement {
    private ColorFilter cachedTriggerPduff;
    private boolean isTriggeredNow;
    private Paint p = new Paint();
    private TextPaint tp = new TextPaint();

    public void CreateEditorEvents() {
    }

    public ButtonElement(Context context, InputTouchControlElementData inputTouchControlElementData) {
        super(context, inputTouchControlElementData);
        CommonElementView.InitCommon(context, this);
        this.cachedTriggerPduff = new PorterDuffColorFilter(inputTouchControlElementData.triggerModeColor.color, PorterDuff.Mode.MULTIPLY);
    }

    public void CreateEventActions(IInputDevice iInputDevice) {
        if (this.data.useTriggerMode) {
            CreateTriggeredEvents(iInputDevice);
        } else {
            CreateNormalEvents(iInputDevice);
        }
        if (this.data.useMouseMode) {
            MouseMovementEvents.Init(2, this, ConfigContext.data.GetCurrentProfile(), this.data, iInputDevice, false);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.isTouched) {
            this.p.setColorFilter(this.tintPduff);
            this.tp.setColorFilter(this.tintPduff);
        } else {
            this.p.setColorFilter((ColorFilter) null);
            this.tp.setColorFilter((ColorFilter) null);
        }
        if (this.isTriggeredNow) {
            this.p.setColorFilter(this.cachedTriggerPduff);
            this.tp.setColorFilter(this.cachedTriggerPduff);
        }
        DrawHelper.DrawShape(canvas, this.data, this.lp.width, this.lp.height, this.p);
        DrawHelper.DrawIsSelected(this.context, canvas, this.p, this.isSelected);
        IconData iconData = this.data.customIcon;
        Bitmap GetBitmap = AppContext.cache.iconsCache.GetBitmap(iconData.iconName);
        if (GetBitmap == null || GetBitmap.isRecycled()) {
            DrawHelper.DrawCenterScaledText(canvas, this.lp.width, this.lp.height, this.data, this.tp);
            return;
        }
        CheckApplyMultPduff(this.p);
        DrawHelper.DrawCenterScaledBitmap(canvas, GetBitmap, iconData.iconFineTuneData.position, this.lp.width, this.lp.height, iconData.iconFineTuneData.scale, this.p);
        if (!this.isTouched) {
            this.p.setColorFilter((ColorFilter) null);
        }
    }

    private void CreateTriggeredEvents(IInputDevice iInputDevice) {
        this.onClick.addObserver(new ButtonElement$$ExternalSyntheticLambda6(this, iInputDevice));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0034, code lost:
        if (r3 != 2) goto L_0x004d;
     */
    /* renamed from: lambda$CreateTriggeredEvents$0$com-catfixture-inputbridge-core-input-devices-touch-interaction-elements-buttons-button-ButtonElement  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void m60lambda$CreateTriggeredEvents$0$comcatfixtureinputbridgecoreinputdevicestouchinteractionelementsbuttonsbuttonButtonElement(com.catfixture.inputbridge.core.input.devices.IInputDevice r2, java.util.Observable r3, java.lang.Object r4) {
        /*
            r1 = this;
            boolean r3 = r1.isTriggeredNow
            r4 = 1
            r3 = r3 ^ r4
            r1.isTriggeredNow = r3
            r0 = 2
            if (r3 == 0) goto L_0x002c
            com.catfixture.inputbridge.core.input.data.InputTouchControlElementData r3 = r1.data
            int r3 = r3.buttonType
            if (r3 == 0) goto L_0x0024
            if (r3 == r4) goto L_0x001c
            if (r3 == r0) goto L_0x0014
            goto L_0x004d
        L_0x0014:
            com.catfixture.inputbridge.core.input.data.InputTouchControlElementData r3 = r1.data
            int r3 = r3.xinputCode
            r2.SendXIDown(r3)
            goto L_0x004d
        L_0x001c:
            com.catfixture.inputbridge.core.input.data.InputTouchControlElementData r3 = r1.data
            int r3 = r3.mouseCode
            r2.SendMouseDown(r3)
            goto L_0x004d
        L_0x0024:
            com.catfixture.inputbridge.core.input.data.InputTouchControlElementData r3 = r1.data
            int r3 = r3.windowsKeyCode
            r2.SendKeyDown(r3)
            goto L_0x004d
        L_0x002c:
            com.catfixture.inputbridge.core.input.data.InputTouchControlElementData r3 = r1.data
            int r3 = r3.buttonType
            if (r3 == 0) goto L_0x003f
            if (r3 == r4) goto L_0x0037
            if (r3 == r0) goto L_0x0046
            goto L_0x004d
        L_0x0037:
            com.catfixture.inputbridge.core.input.data.InputTouchControlElementData r3 = r1.data
            int r3 = r3.mouseCode
            r2.SendMouseUp(r3)
            goto L_0x004d
        L_0x003f:
            com.catfixture.inputbridge.core.input.data.InputTouchControlElementData r3 = r1.data
            int r3 = r3.windowsKeyCode
            r2.SendKeyUp(r3)
        L_0x0046:
            com.catfixture.inputbridge.core.input.data.InputTouchControlElementData r3 = r1.data
            int r3 = r3.xinputCode
            r2.SendXIUp(r3)
        L_0x004d:
            r1.invalidate()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.buttons.button.ButtonElement.m60lambda$CreateTriggeredEvents$0$comcatfixtureinputbridgecoreinputdevicestouchinteractionelementsbuttonsbuttonButtonElement(com.catfixture.inputbridge.core.input.devices.IInputDevice, java.util.Observable, java.lang.Object):void");
    }

    private void CreateNormalEvents(IInputDevice iInputDevice) {
        if (this.data.buttonType == 0) {
            this.onDown.addObserver(new ButtonElement$$ExternalSyntheticLambda0(this, iInputDevice));
            this.onUp.addObserver(new ButtonElement$$ExternalSyntheticLambda1(this, iInputDevice));
        } else if (this.data.buttonType == 1) {
            this.onDown.addObserver(new ButtonElement$$ExternalSyntheticLambda2(this, iInputDevice));
            this.onUp.addObserver(new ButtonElement$$ExternalSyntheticLambda3(this, iInputDevice));
        } else if (this.data.buttonType == 2) {
            this.onDown.addObserver(new ButtonElement$$ExternalSyntheticLambda4(this, iInputDevice));
            this.onUp.addObserver(new ButtonElement$$ExternalSyntheticLambda5(this, iInputDevice));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$CreateNormalEvents$1$com-catfixture-inputbridge-core-input-devices-touch-interaction-elements-buttons-button-ButtonElement  reason: not valid java name */
    public /* synthetic */ void m54lambda$CreateNormalEvents$1$comcatfixtureinputbridgecoreinputdevicestouchinteractionelementsbuttonsbuttonButtonElement(IInputDevice iInputDevice, Observable observable, Object obj) {
        iInputDevice.SendKeyDown(this.data.windowsKeyCode);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$CreateNormalEvents$2$com-catfixture-inputbridge-core-input-devices-touch-interaction-elements-buttons-button-ButtonElement  reason: not valid java name */
    public /* synthetic */ void m55lambda$CreateNormalEvents$2$comcatfixtureinputbridgecoreinputdevicestouchinteractionelementsbuttonsbuttonButtonElement(IInputDevice iInputDevice, Observable observable, Object obj) {
        iInputDevice.SendKeyUp(this.data.windowsKeyCode);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$CreateNormalEvents$3$com-catfixture-inputbridge-core-input-devices-touch-interaction-elements-buttons-button-ButtonElement  reason: not valid java name */
    public /* synthetic */ void m56lambda$CreateNormalEvents$3$comcatfixtureinputbridgecoreinputdevicestouchinteractionelementsbuttonsbuttonButtonElement(IInputDevice iInputDevice, Observable observable, Object obj) {
        iInputDevice.SendMouseDown(this.data.mouseCode);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$CreateNormalEvents$4$com-catfixture-inputbridge-core-input-devices-touch-interaction-elements-buttons-button-ButtonElement  reason: not valid java name */
    public /* synthetic */ void m57lambda$CreateNormalEvents$4$comcatfixtureinputbridgecoreinputdevicestouchinteractionelementsbuttonsbuttonButtonElement(IInputDevice iInputDevice, Observable observable, Object obj) {
        iInputDevice.SendMouseUp(this.data.mouseCode);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$CreateNormalEvents$5$com-catfixture-inputbridge-core-input-devices-touch-interaction-elements-buttons-button-ButtonElement  reason: not valid java name */
    public /* synthetic */ void m58lambda$CreateNormalEvents$5$comcatfixtureinputbridgecoreinputdevicestouchinteractionelementsbuttonsbuttonButtonElement(IInputDevice iInputDevice, Observable observable, Object obj) {
        iInputDevice.SendXIDown(this.data.xinputCode);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$CreateNormalEvents$6$com-catfixture-inputbridge-core-input-devices-touch-interaction-elements-buttons-button-ButtonElement  reason: not valid java name */
    public /* synthetic */ void m59lambda$CreateNormalEvents$6$comcatfixtureinputbridgecoreinputdevicestouchinteractionelementsbuttonsbuttonButtonElement(IInputDevice iInputDevice, Observable observable, Object obj) {
        iInputDevice.SendXIUp(this.data.xinputCode);
    }

    public void Select(ViewGroup viewGroup) {
        super.Select(viewGroup);
        ButtonElementEditable buttonElementEditable = new ButtonElementEditable(this.context, this);
        viewGroup.removeAllViews();
        viewGroup.addView(buttonElementEditable.GetRoot());
    }
}
