package com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.swipe;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.catfixture.inputbridge.core.context.AppContext;
import com.catfixture.inputbridge.core.input.data.IconData;
import com.catfixture.inputbridge.core.input.data.InputTouchControlElementData;
import com.catfixture.inputbridge.core.input.devices.IInputDevice;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.DrawHelper;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.TouchableWindowElement;
import com.catfixture.inputbridge.core.utils.math.Float2;
import java.util.Observable;

public class SwipeElement extends TouchableWindowElement {
    private Float2 lastPressedPos = new Float2(0.0f, 0.0f);
    Paint p = new Paint();
    private Float2 startPos = new Float2(0.0f, 0.0f);

    public void CreateEditorEvents() {
    }

    public SwipeElement(Context context, InputTouchControlElementData inputTouchControlElementData) {
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
            GetBitmap = AppContext.cache.defaultBitmaps.stickOuterDefault;
        }
        CheckApplyMultPduff(this.p);
        Canvas canvas2 = canvas;
        DrawHelper.DrawCenterScaledBitmap(canvas2, GetBitmap, iconData.iconFineTuneData.position, this.lp.width, this.lp.height, iconData.iconFineTuneData.scale, this.p);
        if (!this.isTouched) {
            this.p.setColorFilter((ColorFilter) null);
        }
        DrawHelper.DrawIsSelected(this.context, canvas, this.p, this.isSelected);
    }

    public void CreateEventActions(IInputDevice iInputDevice) {
        this.onDown.addObserver(new SwipeElement$$ExternalSyntheticLambda0(this));
        this.onMove.addObserver(new SwipeElement$$ExternalSyntheticLambda1(this));
        this.onUp.addObserver(new SwipeElement$$ExternalSyntheticLambda2(this, iInputDevice));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$CreateEventActions$0$com-catfixture-inputbridge-core-input-devices-touch-interaction-elements-swipe-SwipeElement  reason: not valid java name */
    public /* synthetic */ void m86lambda$CreateEventActions$0$comcatfixtureinputbridgecoreinputdevicestouchinteractionelementsswipeSwipeElement(Observable observable, Object obj) {
        MotionEvent motionEvent = (MotionEvent) obj;
        this.startPos = new Float2(motionEvent.getX(), motionEvent.getY());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$CreateEventActions$1$com-catfixture-inputbridge-core-input-devices-touch-interaction-elements-swipe-SwipeElement  reason: not valid java name */
    public /* synthetic */ void m87lambda$CreateEventActions$1$comcatfixtureinputbridgecoreinputdevicestouchinteractionelementsswipeSwipeElement(Observable observable, Object obj) {
        MotionEvent motionEvent = (MotionEvent) obj;
        this.lastPressedPos = new Float2(motionEvent.getX(), motionEvent.getY());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$CreateEventActions$2$com-catfixture-inputbridge-core-input-devices-touch-interaction-elements-swipe-SwipeElement  reason: not valid java name */
    public /* synthetic */ void m88lambda$CreateEventActions$2$comcatfixtureinputbridgecoreinputdevicestouchinteractionelementsswipeSwipeElement(IInputDevice iInputDevice, Observable observable, Object obj) {
        Float2 Sub = this.lastPressedPos.Sub(this.startPos);
        if (Math.abs(Sub.x) > ((float) this.data.sensivity) || Math.abs(Sub.y) > ((float) this.data.sensivity)) {
            int i = Sub.y > ((float) this.data.sensivity) ? this.data.codeDown : Sub.y < ((float) (-this.data.sensivity)) ? this.data.codeUp : -1;
            int i2 = Sub.x > ((float) this.data.sensivity) ? this.data.codeRight : Sub.x < ((float) (-this.data.sensivity)) ? this.data.codeLeft : -1;
            if (this.data.eightDirMode) {
                if (i != -1) {
                    iInputDevice.SendKeyDown(i);
                    iInputDevice.SendKeyUp(i);
                }
                if (i2 != -1) {
                    iInputDevice.SendKeyDown(i2);
                    iInputDevice.SendKeyUp(i2);
                }
            } else {
                if (i != -1 && Math.abs(Sub.y) > Math.abs(Sub.x)) {
                    iInputDevice.SendKeyDown(i);
                    iInputDevice.SendKeyUp(i);
                }
                if (i2 != -1 && Math.abs(Sub.x) > Math.abs(Sub.y)) {
                    iInputDevice.SendKeyDown(i2);
                    iInputDevice.SendKeyUp(i2);
                }
            }
        }
        this.lastPressedPos.Set(0.0f, 0.0f);
    }

    public void Select(ViewGroup viewGroup) {
        super.Select(viewGroup);
        SwipeElementEditor swipeElementEditor = new SwipeElementEditor(this.context, this);
        viewGroup.removeAllViews();
        viewGroup.addView(swipeElementEditor.GetRoot());
    }
}
