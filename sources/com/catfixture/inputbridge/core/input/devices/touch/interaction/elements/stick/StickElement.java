package com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.stick;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.ViewGroup;
import androidx.core.math.MathUtils;
import com.catfixture.inputbridge.core.context.AppContext;
import com.catfixture.inputbridge.core.input.data.IconData;
import com.catfixture.inputbridge.core.input.data.InputTouchControlElementData;
import com.catfixture.inputbridge.core.input.devices.IInputDevice;
import com.catfixture.inputbridge.core.input.devices.touch.commons.WindowsEightDirMoveEvents;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.DrawHelper;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.TouchableWindowElement;
import com.catfixture.inputbridge.core.utils.math.Float2;
import com.catfixture.inputbridge.core.utils.math.Int2;
import java.util.Observable;

public class StickElement extends TouchableWindowElement {
    private WindowsEightDirMoveEvents eightDirMoveEvents;
    private Float2 innerCirclePosition = new Float2();
    Paint p = new Paint();
    private final Int2 pressedButtons = new Int2(-1, -1);
    private Float2 startPos = new Float2(0.0f, 0.0f);

    public void CreateEditorEvents() {
    }

    public StickElement(Context context, InputTouchControlElementData inputTouchControlElementData) {
        super(context, inputTouchControlElementData);
        this.initialSize.Set(300.0f, 300.0f);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0017  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x001b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void SetAxis(com.catfixture.inputbridge.core.input.data.InputTouchControlElementData r3, com.catfixture.inputbridge.core.utils.math.Int2 r4, float r5, float r6, float r7) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.stick.StickElement.SetAxis(com.catfixture.inputbridge.core.input.data.InputTouchControlElementData, com.catfixture.inputbridge.core.utils.math.Int2, float, float, float):void");
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
            GetBitmap = AppContext.cache.defaultBitmaps.stickOuterDefault;
        }
        CheckApplyMultPduff(this.p);
        Canvas canvas2 = canvas;
        DrawHelper.DrawCenterScaledBitmap(canvas2, GetBitmap, iconData.iconFineTuneData.position, this.lp.width, this.lp.height, iconData.iconFineTuneData.scale, this.p);
        if (!this.isTouched) {
            this.p.setColorFilter((ColorFilter) null);
        }
        IconData iconData2 = this.data.innerCircleIcon;
        Bitmap GetBitmap2 = AppContext.cache.iconsCache.GetBitmap(iconData2.iconName);
        if (GetBitmap2 == null || GetBitmap2.isRecycled()) {
            GetBitmap2 = AppContext.cache.defaultBitmaps.stickInnerDefault;
        }
        Bitmap bitmap = GetBitmap2;
        float Magnitude = this.innerCirclePosition.Magnitude();
        float f = iconData.iconFineTuneData.scale * ((float) this.lp.width) * 0.25f;
        if (Magnitude > f) {
            Float2 Div = this.innerCirclePosition.Div(Magnitude);
            this.innerCirclePosition.x = Div.x * f;
            this.innerCirclePosition.y = Div.y * f * this.data.innerCircleRadius;
        }
        CheckApplyMultPduff(this.p);
        DrawHelper.DrawCenterScaledBitmap(canvas, bitmap, iconData2.iconFineTuneData.position.Add(this.innerCirclePosition), this.lp.width, this.lp.height, iconData.iconFineTuneData.scale * 0.7f * iconData2.iconFineTuneData.scale, this.p);
        if (!this.isTouched) {
            this.p.setColorFilter((ColorFilter) null);
        }
        DrawHelper.DrawIsSelected(this.context, canvas, this.p, this.isSelected);
    }

    public void CreateEventActions(IInputDevice iInputDevice) {
        if (this.data.movementType == 0) {
            this.onDown.addObserver(new StickElement$$ExternalSyntheticLambda0(this));
            this.onMove.addObserver(new StickElement$$ExternalSyntheticLambda3(this, iInputDevice));
            this.onUp.addObserver(new StickElement$$ExternalSyntheticLambda4(this, iInputDevice));
        } else if (this.data.movementType == 1) {
            this.onDown.addObserver(new StickElement$$ExternalSyntheticLambda1(this));
            this.onMove.addObserver(new StickElement$$ExternalSyntheticLambda5(this, iInputDevice));
            this.onUp.addObserver(new StickElement$$ExternalSyntheticLambda6(this, iInputDevice));
        } else if (this.data.movementType == 2) {
            this.onDown.addObserver(new StickElement$$ExternalSyntheticLambda2(this));
            this.onMove.addObserver(new StickElement$$ExternalSyntheticLambda7(this, iInputDevice));
            this.onUp.addObserver(new StickElement$$ExternalSyntheticLambda8(this, iInputDevice));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$CreateEventActions$0$com-catfixture-inputbridge-core-input-devices-touch-interaction-elements-stick-StickElement  reason: not valid java name */
    public /* synthetic */ void m71lambda$CreateEventActions$0$comcatfixtureinputbridgecoreinputdevicestouchinteractionelementsstickStickElement(Observable observable, Object obj) {
        MotionEvent motionEvent = (MotionEvent) obj;
        this.startPos = new Float2(motionEvent.getX(), motionEvent.getY());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$CreateEventActions$1$com-catfixture-inputbridge-core-input-devices-touch-interaction-elements-stick-StickElement  reason: not valid java name */
    public /* synthetic */ void m72lambda$CreateEventActions$1$comcatfixtureinputbridgecoreinputdevicestouchinteractionelementsstickStickElement(IInputDevice iInputDevice, Observable observable, Object obj) {
        MotionEvent motionEvent = (MotionEvent) obj;
        Float2 Sub = new Float2(motionEvent.getX(), motionEvent.getY()).Sub(this.startPos);
        this.innerCirclePosition = Sub;
        invalidate();
        Int2 int2 = new Int2(-1, -1);
        SetAxis(this.data, int2, Sub.x, Sub.y, 100.0f);
        if (int2.x != -1 && this.pressedButtons.x == -1) {
            iInputDevice.SendKeyDown(int2.x);
            this.pressedButtons.x = int2.x;
        } else if (int2.x != -1 && this.pressedButtons.x != int2.x) {
            iInputDevice.SendKeyUp(this.pressedButtons.x);
            iInputDevice.SendKeyDown(int2.x);
            this.pressedButtons.x = int2.x;
        } else if (int2.x == -1 && this.pressedButtons.x != -1) {
            iInputDevice.SendKeyUp(this.pressedButtons.x);
            this.pressedButtons.x = -1;
        }
        if (int2.y != -1 && this.pressedButtons.y == -1) {
            iInputDevice.SendKeyDown(int2.y);
            this.pressedButtons.y = int2.y;
        } else if (int2.y != -1 && this.pressedButtons.y != int2.y) {
            iInputDevice.SendKeyUp(this.pressedButtons.y);
            iInputDevice.SendKeyDown(int2.y);
            this.pressedButtons.y = int2.y;
        } else if (int2.y == -1 && this.pressedButtons.y != -1) {
            iInputDevice.SendKeyUp(this.pressedButtons.y);
            this.pressedButtons.y = -1;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$CreateEventActions$2$com-catfixture-inputbridge-core-input-devices-touch-interaction-elements-stick-StickElement  reason: not valid java name */
    public /* synthetic */ void m73lambda$CreateEventActions$2$comcatfixtureinputbridgecoreinputdevicestouchinteractionelementsstickStickElement(IInputDevice iInputDevice, Observable observable, Object obj) {
        this.innerCirclePosition.Set(0.0f, 0.0f);
        if (this.pressedButtons.x != -1) {
            iInputDevice.SendKeyUp(this.pressedButtons.x);
        }
        if (this.pressedButtons.y != -1) {
            iInputDevice.SendKeyUp(this.pressedButtons.y);
        }
        this.pressedButtons.x = -1;
        this.pressedButtons.y = -1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$CreateEventActions$3$com-catfixture-inputbridge-core-input-devices-touch-interaction-elements-stick-StickElement  reason: not valid java name */
    public /* synthetic */ void m74lambda$CreateEventActions$3$comcatfixtureinputbridgecoreinputdevicestouchinteractionelementsstickStickElement(Observable observable, Object obj) {
        MotionEvent motionEvent = (MotionEvent) obj;
        this.startPos = new Float2(motionEvent.getX(), motionEvent.getY());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$CreateEventActions$4$com-catfixture-inputbridge-core-input-devices-touch-interaction-elements-stick-StickElement  reason: not valid java name */
    public /* synthetic */ void m75lambda$CreateEventActions$4$comcatfixtureinputbridgecoreinputdevicestouchinteractionelementsstickStickElement(IInputDevice iInputDevice, Observable observable, Object obj) {
        MotionEvent motionEvent = (MotionEvent) obj;
        Float2 Sub = new Float2(motionEvent.getX(), motionEvent.getY()).Sub(this.startPos);
        this.innerCirclePosition = Sub;
        invalidate();
        Float2 Mul = Sub.Mul(this.data.GetSensivity() * 0.15f);
        iInputDevice.SetConstantMouseShift(Mul.x, Mul.y);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$CreateEventActions$5$com-catfixture-inputbridge-core-input-devices-touch-interaction-elements-stick-StickElement  reason: not valid java name */
    public /* synthetic */ void m76lambda$CreateEventActions$5$comcatfixtureinputbridgecoreinputdevicestouchinteractionelementsstickStickElement(IInputDevice iInputDevice, Observable observable, Object obj) {
        this.innerCirclePosition.Set(0.0f, 0.0f);
        iInputDevice.SetConstantMouseShift(0.0f, 0.0f);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$CreateEventActions$6$com-catfixture-inputbridge-core-input-devices-touch-interaction-elements-stick-StickElement  reason: not valid java name */
    public /* synthetic */ void m77lambda$CreateEventActions$6$comcatfixtureinputbridgecoreinputdevicestouchinteractionelementsstickStickElement(Observable observable, Object obj) {
        MotionEvent motionEvent = (MotionEvent) obj;
        this.startPos = new Float2(motionEvent.getX(), motionEvent.getY());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$CreateEventActions$7$com-catfixture-inputbridge-core-input-devices-touch-interaction-elements-stick-StickElement  reason: not valid java name */
    public /* synthetic */ void m78lambda$CreateEventActions$7$comcatfixtureinputbridgecoreinputdevicestouchinteractionelementsstickStickElement(IInputDevice iInputDevice, Observable observable, Object obj) {
        MotionEvent motionEvent = (MotionEvent) obj;
        Float2 Sub = new Float2(motionEvent.getX(), motionEvent.getY()).Sub(this.startPos);
        this.innerCirclePosition = Sub;
        invalidate();
        float f = this.data.innerCircleIcon.iconFineTuneData.scale * ((float) this.lp.width) * 0.25f;
        iInputDevice.SetXIStick(this.data.stickSide, Sub.Normalized().Mul(MathUtils.clamp(Sub.Magnitude(), -f, f) / f));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$CreateEventActions$8$com-catfixture-inputbridge-core-input-devices-touch-interaction-elements-stick-StickElement  reason: not valid java name */
    public /* synthetic */ void m79lambda$CreateEventActions$8$comcatfixtureinputbridgecoreinputdevicestouchinteractionelementsstickStickElement(IInputDevice iInputDevice, Observable observable, Object obj) {
        this.innerCirclePosition.Set(0.0f, 0.0f);
        iInputDevice.SetXIStick(this.data.stickSide, Float2.Zero);
        invalidate();
    }

    public void Select(ViewGroup viewGroup) {
        super.Select(viewGroup);
        StickElementEditor stickElementEditor = new StickElementEditor(this.context, this);
        viewGroup.removeAllViews();
        viewGroup.addView(stickElementEditor.GetRoot());
    }
}
