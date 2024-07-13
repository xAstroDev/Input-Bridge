package com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.swheel;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.catfixture.inputbridge.core.context.AppContext;
import com.catfixture.inputbridge.core.input.data.AxisBinding;
import com.catfixture.inputbridge.core.input.data.ComputedAxisBinding;
import com.catfixture.inputbridge.core.input.data.IconData;
import com.catfixture.inputbridge.core.input.data.InputTouchControlElementData;
import com.catfixture.inputbridge.core.input.devices.IInputDevice;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.DrawHelper;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.TouchableWindowElement;
import com.catfixture.inputbridge.core.utils.math.Float2;
import java.util.Observable;

public class SWheelElement extends TouchableWindowElement {
    private float currRot;
    private float currRotLerp;
    Paint p = new Paint();
    private Float2 startPos = new Float2(0.0f, 0.0f);
    private float startRot;

    public void CreateEditorEvents() {
    }

    public SWheelElement(Context context, InputTouchControlElementData inputTouchControlElementData) {
        super(context, inputTouchControlElementData);
        this.initialSize.Set(300.0f, 300.0f);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.isTouched) {
            this.p.setColorFilter(this.tintPduff);
        } else {
            this.p.setColorFilter((ColorFilter) null);
        }
        IconData iconData = this.data.customIcon;
        Bitmap GetBitmap = AppContext.cache.iconsCache.GetBitmap(iconData.iconName);
        if (GetBitmap == null || GetBitmap.isRecycled()) {
            GetBitmap = AppContext.cache.defaultBitmaps.wheelDefault;
        }
        CheckApplyMultPduff(this.p);
        canvas.rotate(this.currRot, ((float) this.lp.width) / 2.0f, ((float) this.lp.height) / 2.0f);
        Canvas canvas2 = canvas;
        DrawHelper.DrawCenterScaledBitmap(canvas2, GetBitmap, iconData.iconFineTuneData.position, this.lp.width, this.lp.height, iconData.iconFineTuneData.scale, this.p);
        if (!this.isTouched) {
            this.p.setColorFilter((ColorFilter) null);
        }
        canvas.rotate(0.0f);
        DrawHelper.DrawIsSelected(this.context, canvas, this.p, this.isSelected);
    }

    public void CreateEventActions(IInputDevice iInputDevice) {
        ComputedAxisBinding computedAxisBinding = new ComputedAxisBinding();
        if (this.data.swheelAxisBinding.axisType == 1) {
            this.onDown.addObserver(new SWheelElement$$ExternalSyntheticLambda0(this));
            this.onMove.addObserver(new SWheelElement$$ExternalSyntheticLambda4(this, iInputDevice));
            this.onUp.addObserver(new SWheelElement$$ExternalSyntheticLambda5(this, iInputDevice));
        } else if (this.data.swheelAxisBinding.axisType == 2) {
            this.onDown.addObserver(new SWheelElement$$ExternalSyntheticLambda1(this));
            this.onMove.addObserver(new SWheelElement$$ExternalSyntheticLambda2(this, computedAxisBinding, iInputDevice));
            this.onUp.addObserver(new SWheelElement$$ExternalSyntheticLambda3(this, computedAxisBinding, iInputDevice));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$CreateEventActions$0$com-catfixture-inputbridge-core-input-devices-touch-interaction-elements-swheel-SWheelElement  reason: not valid java name */
    public /* synthetic */ void m80lambda$CreateEventActions$0$comcatfixtureinputbridgecoreinputdevicestouchinteractionelementsswheelSWheelElement(Observable observable, Object obj) {
        MotionEvent motionEvent = (MotionEvent) obj;
        this.startPos = new Float2(motionEvent.getX(), motionEvent.getY());
        this.startRot = this.currRot;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$CreateEventActions$1$com-catfixture-inputbridge-core-input-devices-touch-interaction-elements-swheel-SWheelElement  reason: not valid java name */
    public /* synthetic */ void m81lambda$CreateEventActions$1$comcatfixtureinputbridgecoreinputdevicestouchinteractionelementsswheelSWheelElement(IInputDevice iInputDevice, Observable observable, Object obj) {
        MotionEvent motionEvent = (MotionEvent) obj;
        Float2 Sub = new Float2(motionEvent.getX(), motionEvent.getY()).Sub(this.startPos);
        invalidate();
        Float2 Mul = Sub.Mul(this.data.GetSensivity() * 0.15f);
        if (this.data.swheelAxisBinding.axisValue == 0) {
            float f = this.startRot + Mul.x;
            this.currRot = f;
            iInputDevice.SetConstantMouseShift(f, 0.0f);
            return;
        }
        float f2 = this.startRot + Mul.y;
        this.currRot = f2;
        iInputDevice.SetConstantMouseShift(0.0f, f2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$CreateEventActions$2$com-catfixture-inputbridge-core-input-devices-touch-interaction-elements-swheel-SWheelElement  reason: not valid java name */
    public /* synthetic */ void m82lambda$CreateEventActions$2$comcatfixtureinputbridgecoreinputdevicestouchinteractionelementsswheelSWheelElement(IInputDevice iInputDevice, Observable observable, Object obj) {
        this.currRot = 0.0f;
        iInputDevice.SetConstantMouseShift(0.0f, 0.0f);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$CreateEventActions$3$com-catfixture-inputbridge-core-input-devices-touch-interaction-elements-swheel-SWheelElement  reason: not valid java name */
    public /* synthetic */ void m83lambda$CreateEventActions$3$comcatfixtureinputbridgecoreinputdevicestouchinteractionelementsswheelSWheelElement(Observable observable, Object obj) {
        MotionEvent motionEvent = (MotionEvent) obj;
        this.startPos = new Float2(motionEvent.getX(), motionEvent.getY());
        this.startRot = this.currRot;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$CreateEventActions$4$com-catfixture-inputbridge-core-input-devices-touch-interaction-elements-swheel-SWheelElement  reason: not valid java name */
    public /* synthetic */ void m84lambda$CreateEventActions$4$comcatfixtureinputbridgecoreinputdevicestouchinteractionelementsswheelSWheelElement(ComputedAxisBinding computedAxisBinding, IInputDevice iInputDevice, Observable observable, Object obj) {
        MotionEvent motionEvent = (MotionEvent) obj;
        Float2 Sub = new Float2(motionEvent.getX(), motionEvent.getY()).Sub(this.startPos);
        invalidate();
        Float2 Mul = Sub.Mul(this.data.GetSensivity() * 0.15f);
        AxisBinding axisBinding = this.data.swheelAxisBinding;
        float f = this.startRot + Mul.x;
        this.currRot = f;
        ComputedAxisBinding.Check(computedAxisBinding, 1.0f, 360.0f, axisBinding, f);
        ComputedAxisBinding.ApplyInput(computedAxisBinding, iInputDevice, 1.0f);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$CreateEventActions$5$com-catfixture-inputbridge-core-input-devices-touch-interaction-elements-swheel-SWheelElement  reason: not valid java name */
    public /* synthetic */ void m85lambda$CreateEventActions$5$comcatfixtureinputbridgecoreinputdevicestouchinteractionelementsswheelSWheelElement(ComputedAxisBinding computedAxisBinding, IInputDevice iInputDevice, Observable observable, Object obj) {
        this.currRot = 0.0f;
        ComputedAxisBinding.ResetInput(computedAxisBinding, iInputDevice);
        invalidate();
    }

    public void Select(ViewGroup viewGroup) {
        super.Select(viewGroup);
        SWheelElementEditor sWheelElementEditor = new SWheelElementEditor(this.context, this);
        viewGroup.removeAllViews();
        viewGroup.addView(sWheelElementEditor.GetRoot());
    }
}
