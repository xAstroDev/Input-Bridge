package com.catfixture.inputbridge.ui.activity.editors.phyDeviceEditor;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.InputDevice;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.catfixture.inputbridge.core.utils.math.Float2;
import com.catfixture.inputbridge.core.utils.types.delegates.Action;
import com.catfixture.inputbridge.core.utils.types.delegates.Action2;
import java.util.Iterator;

public class GamepadVisual extends View {
    private ColorFilter activeColor;
    private ColorFilter colorFilter;
    private final Rect dst = new Rect();
    private boolean isReady;
    private Action<VisualElement> onSelectionChanged;
    private Action2<Float, Float> onTriggersChanged;
    private final Paint p = new Paint();
    private int productID;
    private Bitmap rootBMP;
    private final Rect src = new Rect();
    GamepadVisualTheme theme;
    private int vendorID;

    public void SetupTheme(int i, int i2, GamepadVisualTheme gamepadVisualTheme) {
        this.productID = i2;
        this.vendorID = i;
        this.colorFilter = new LightingColorFilter(gamepadVisualTheme.selectedColor, -7829368);
        this.activeColor = new LightingColorFilter(gamepadVisualTheme.pressedColor, ViewCompat.MEASURED_STATE_MASK);
        this.theme = gamepadVisualTheme;
        for (ButtonVisualElement next : gamepadVisualTheme.buttons) {
            if (next.bmp == null) {
                next.bmp = BitmapFactory.decodeResource(getResources(), next.drawable);
            }
        }
        for (StickVisualElement next2 : gamepadVisualTheme.sticks) {
            if (next2.bmp == null) {
                next2.bmp = BitmapFactory.decodeResource(getResources(), next2.drawable);
            }
        }
        this.rootBMP = BitmapFactory.decodeResource(getResources(), gamepadVisualTheme.bgFront);
        this.isReady = true;
    }

    public void Create() {
        post(new GamepadVisual$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$Create$0$com-catfixture-inputbridge-ui-activity-editors-phyDeviceEditor-GamepadVisual  reason: not valid java name */
    public /* synthetic */ void m125lambda$Create$0$comcatfixtureinputbridgeuiactivityeditorsphyDeviceEditorGamepadVisual() {
        setFocusableInTouchMode(true);
        setFocusable(true);
        requestFocus();
    }

    private void Destroy() {
        if (!this.rootBMP.isRecycled()) {
            this.rootBMP.recycle();
        }
    }

    public GamepadVisual(Context context) {
        super(context);
        Create();
    }

    public GamepadVisual(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Create();
    }

    public GamepadVisual(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Create();
    }

    public GamepadVisual(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Create();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Destroy();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Canvas canvas2 = canvas;
        super.onDraw(canvas);
        if (this.isReady) {
            this.p.setColorFilter((ColorFilter) null);
            int width = this.rootBMP.getWidth();
            int height = this.rootBMP.getHeight();
            float width2 = (float) getWidth();
            float height2 = (float) getHeight();
            float f = (float) height;
            float f2 = ((float) width) / f;
            int i = (int) width2;
            int i2 = (int) (width2 / f2);
            float f3 = f2 * height2;
            if (f3 <= width2) {
                i = (int) f3;
                i2 = (int) height2;
            }
            float f4 = (float) i;
            int i3 = (int) (width2 - f4);
            this.src.set(0, 0, width, height);
            this.dst.set(i3, 0, i + i3, i2);
            canvas2.drawBitmap(this.rootBMP, this.src, this.dst, this.p);
            float f5 = (float) i2;
            float f6 = f5 / f;
            float f7 = width2 / height2;
            Iterator<ButtonVisualElement> it = this.theme.buttons.iterator();
            while (it.hasNext()) {
                ButtonVisualElement next = it.next();
                int width3 = next.bmp.getWidth();
                int height3 = next.bmp.getHeight();
                int i4 = (int) (((float) width3) * f6);
                int i5 = (int) (((float) height3) * f6);
                float f8 = (float) i4;
                int i6 = (int) ((width2 - f8) - ((next.position.x * f4) / 100.0f));
                int i7 = (int) ((next.position.y * f5) / 100.0f);
                Iterator<ButtonVisualElement> it2 = it;
                float f9 = f5;
                this.src.set(0, 0, width3, height3);
                this.dst.set(i6, i7, i4 + i6, i5 + i7);
                if (!next.isSelected) {
                    this.p.setColorFilter((ColorFilter) null);
                } else if (next.customColor != 0) {
                    this.p.setColorFilter(new LightingColorFilter(next.customColor, ViewCompat.MEASURED_STATE_MASK));
                } else {
                    this.p.setColorFilter(this.colorFilter);
                }
                if (next.isActive) {
                    this.p.setColorFilter(this.activeColor);
                }
                next.calculatedPos.Set((float) i6, (float) i7);
                next.calculatedSize.Set(f8, (float) i5);
                canvas2.drawBitmap(next.bmp, this.src, this.dst, this.p);
                it = it2;
                f5 = f9;
            }
            float f10 = f5;
            this.p.setColorFilter((ColorFilter) null);
            Iterator<StickVisualElement> it3 = this.theme.sticks.iterator();
            while (it3.hasNext()) {
                StickVisualElement next2 = it3.next();
                int width4 = next2.bmp.getWidth();
                int height4 = next2.bmp.getHeight();
                int i8 = (int) (((float) width4) * f6);
                int i9 = (int) (((float) height4) * f6);
                float f11 = (float) i8;
                int i10 = (int) ((width2 - f11) - (((next2.position.x + ((next2.shearPos.x / f7) * 5.0f)) * f4) / 100.0f));
                int i11 = (int) ((f10 * (next2.position.y + (next2.shearPos.y * 5.0f))) / 100.0f);
                Iterator<StickVisualElement> it4 = it3;
                this.src.set(0, 0, width4, height4);
                this.dst.set(i10, i11, i8 + i10, i9 + i11);
                if (next2.isSelected) {
                    this.p.setColorFilter(this.colorFilter);
                } else {
                    this.p.setColorFilter((ColorFilter) null);
                }
                if (next2.isActive) {
                    this.p.setColorFilter(this.activeColor);
                }
                next2.calculatedPos.Set((float) i10, (float) i11);
                next2.calculatedSize.Set(f11, (float) i9);
                canvas2.drawBitmap(next2.bmp, this.src, this.dst, this.p);
                it3 = it4;
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            DeselectAll();
            Iterator<ButtonVisualElement> it = this.theme.buttons.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ButtonVisualElement next = it.next();
                if (CheckPos(motionEvent.getX(), motionEvent.getY(), next.calculatedPos, next.calculatedSize)) {
                    SelectVisual(next);
                    break;
                }
            }
            Iterator<StickVisualElement> it2 = this.theme.sticks.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                StickVisualElement next2 = it2.next();
                if (CheckPos(motionEvent.getX(), motionEvent.getY(), next2.calculatedPos, next2.calculatedSize)) {
                    SelectVisual(next2);
                    break;
                }
            }
            invalidate();
        }
        return true;
    }

    private void TriggerOnSelectedEvent(VisualElement visualElement) {
        this.onSelectionChanged.Invoke(visualElement);
    }

    private void DeselectAll() {
        for (StickVisualElement stickVisualElement : this.theme.sticks) {
            stickVisualElement.isSelected = false;
        }
        for (ButtonVisualElement buttonVisualElement : this.theme.buttons) {
            buttonVisualElement.isSelected = false;
        }
        TriggerOnSelectedEvent((VisualElement) null);
    }

    private boolean CheckPos(float f, float f2, Float2 float2, Float2 float22) {
        return f > float2.x && f < float2.x + float22.x && f2 > float2.y && f2 < float2.y + float22.y;
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if (!CheckVIDPID(motionEvent.getDevice())) {
            return false;
        }
        if (motionEvent.getAction() == 2) {
            float axisValue = motionEvent.getAxisValue(this.theme.fakeRtElement.code);
            float axisValue2 = motionEvent.getAxisValue(this.theme.fakeLtElement.code);
            if (axisValue > 0.5f) {
                this.onSelectionChanged.Invoke(this.theme.fakeRtElement);
            }
            if (axisValue2 > 0.5f) {
                this.onSelectionChanged.Invoke(this.theme.fakeLtElement);
            }
            Action2<Float, Float> action2 = this.onTriggersChanged;
            if (action2 != null) {
                action2.Invoke(Float.valueOf(axisValue), Float.valueOf(axisValue2));
            }
            for (ButtonVisualElement next : this.theme.buttons) {
                if (next.code == -1) {
                    if (motionEvent.getAxisValue(next.axis) == ((float) next.dir)) {
                        DeselectAll();
                        SelectVisual(next);
                        next.isActive = true;
                    } else {
                        next.isActive = false;
                    }
                }
            }
            for (StickVisualElement next2 : this.theme.sticks) {
                Float2 float2 = new Float2(-motionEvent.getAxisValue(next2.xAxis), motionEvent.getAxisValue(next2.yAxis));
                if (float2.x != 0.0f || float2.y != 0.0f) {
                    if (float2.AbsMore(0.2f)) {
                        DeselectAll();
                        SelectVisual(next2);
                    }
                    next2.shearPos.Set(float2);
                }
            }
            invalidate();
        }
        return true;
    }

    private boolean CheckVIDPID(InputDevice inputDevice) {
        return inputDevice.getVendorId() == this.vendorID && inputDevice.getProductId() == this.productID;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!CheckVIDPID(keyEvent.getDevice())) {
            return false;
        }
        for (StickVisualElement next : this.theme.sticks) {
            if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == next.code) {
                DeselectAll();
                next.isSelected = true;
                SelectVisual(next.code == 106 ? this.theme.fakeThumblElement : this.theme.fakeThumbrElement);
                next.isActive = true;
            }
            if (keyEvent.getAction() == 1 && keyEvent.getKeyCode() == next.code) {
                next.isActive = false;
            }
        }
        for (ButtonVisualElement next2 : this.theme.buttons) {
            if (keyEvent.getKeyCode() == next2.code && keyEvent.getAction() == 0) {
                DeselectAll();
                SelectVisual(next2);
                next2.isActive = true;
            } else if (keyEvent.getKeyCode() == next2.code && keyEvent.getAction() == 1) {
                next2.isActive = false;
            }
        }
        invalidate();
        return true;
    }

    private void SelectVisual(VisualElement visualElement) {
        visualElement.isSelected = true;
        TriggerOnSelectedEvent(visualElement);
    }

    public void SetOnSelectionChanged(Action<VisualElement> action) {
        this.onSelectionChanged = action;
    }

    public void SetOnTriggersChanged(Action2<Float, Float> action2) {
        this.onTriggersChanged = action2;
    }
}
