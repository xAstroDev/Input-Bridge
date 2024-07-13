package com.catfixture.inputbridge.core.colorpicker;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;
import com.catfixture.inputbridge.core.utils.math.Float2;
import com.catfixture.inputbridge.core.utils.types.delegates.Action;

public class SBPaletteView extends View {
    private AlphaPaletteView apv;
    private Bitmap bmp;
    Rect dst = new Rect();
    private HUEPaletteView hpv;
    private Action<Integer> listener;
    Paint p = new Paint();
    Rect src = new Rect();
    private Float2 touch = new Float2(0.0f, 0.0f);

    public SBPaletteView(Context context) {
        super(context);
    }

    public SBPaletteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SBPaletteView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public SBPaletteView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.bmp.recycle();
    }

    private void CreatePaletteInternal() {
        int width = getWidth() / 4;
        int height = getHeight() / 4;
        float GetHue = this.hpv.GetHue();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        this.bmp = createBitmap;
        int[] iArr = new int[(width * height)];
        createBitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        for (int i = 0; i < height; i++) {
            for (int i2 = 0; i2 < width; i2++) {
                iArr[(i * width) + i2] = Colorut.HSBtoRGB(GetHue, ((float) i2) / ((float) width), 1.0f - (((float) i) / ((float) height)));
            }
        }
        this.bmp.setPixels(iArr, 0, width, 0, 0, width, height);
        invalidate();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int width = getWidth();
        int height = getHeight();
        this.touch.x = Math.min(Math.max(motionEvent.getX(), 0.0f), (float) width);
        this.touch.y = Math.min(Math.max(motionEvent.getY(), 0.0f), (float) height);
        InvokeChangeEvent();
        invalidate();
        return true;
    }

    /* access modifiers changed from: private */
    public void InvokeChangeEvent() {
        int width = getWidth();
        int height = getHeight();
        if (this.listener != null) {
            float GetHue = this.hpv.GetHue();
            this.listener.Invoke(Integer.valueOf(ColorUtils.setAlphaComponent(Colorut.HSBtoRGB(GetHue, this.touch.x / ((float) width), 1.0f - (this.touch.y / ((float) height))), this.apv.GetAlpha())));
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.bmp != null) {
            int width = getWidth();
            int height = getHeight();
            this.src.set(0, 0, this.bmp.getWidth(), this.bmp.getHeight());
            this.dst.set(0, 0, width, height);
            canvas.drawBitmap(this.bmp, this.src, this.dst, this.p);
        }
        this.p.setStrokeWidth(2.0f);
        this.p.setStyle(Paint.Style.STROKE);
        this.p.setColor(-1);
        canvas.drawCircle(this.touch.x, this.touch.y, (float) 30, this.p);
        this.p.setStyle(Paint.Style.STROKE);
        this.p.setColor(ViewCompat.MEASURED_STATE_MASK);
        canvas.drawCircle(this.touch.x, this.touch.y, (float) 28, this.p);
    }

    public void SetHUEControl(HUEPaletteView hUEPaletteView) {
        this.hpv = hUEPaletteView;
        hUEPaletteView.OnValueChanged = new SBPaletteView$$ExternalSyntheticLambda0(this);
    }

    public void SetAlphaControl(AlphaPaletteView alphaPaletteView) {
        this.apv = alphaPaletteView;
        alphaPaletteView.OnValueChanged = new SBPaletteView$$ExternalSyntheticLambda1(this);
    }

    /* access modifiers changed from: private */
    public void RecreateBmp() {
        Bitmap bitmap = this.bmp;
        if (bitmap != null) {
            bitmap.recycle();
        }
        CreatePaletteInternal();
        InvokeChangeEvent();
    }

    public void SetOnColorChanged(Action<Integer> action) {
        this.listener = action;
    }

    public void SetPositionByColor(int i) {
        post(new SBPaletteView$$ExternalSyntheticLambda2(this, i));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$SetPositionByColor$0$com-catfixture-inputbridge-core-colorpicker-SBPaletteView  reason: not valid java name */
    public /* synthetic */ void m46lambda$SetPositionByColor$0$comcatfixtureinputbridgecorecolorpickerSBPaletteView(int i) {
        int width = getWidth();
        int height = getHeight();
        float[] fArr = new float[3];
        Colorut.RGBtoHSB(i, fArr);
        this.touch.x = fArr[1] * ((float) width);
        this.touch.y = (1.0f - fArr[2]) * ((float) height);
        RecreateBmp();
        invalidate();
    }
}
