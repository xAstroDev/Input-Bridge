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
import com.catfixture.inputbridge.core.utils.math.Float2;

public class HUEPaletteView extends View {
    public Runnable OnValueChanged;
    private Bitmap bmp;
    Rect dst = new Rect();
    private float hue = 0.0f;
    Paint p = new Paint();
    Rect src = new Rect();
    private Float2 touch = new Float2();

    public HUEPaletteView(Context context) {
        super(context);
        CreatePalette();
    }

    public HUEPaletteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        CreatePalette();
    }

    public HUEPaletteView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        CreatePalette();
    }

    public HUEPaletteView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        CreatePalette();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.bmp.recycle();
    }

    private void CreatePalette() {
        post(new HUEPaletteView$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    public void CreatePaletteInternal() {
        int width = getWidth() / 4;
        int height = getHeight() / 4;
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        this.bmp = createBitmap;
        int[] iArr = new int[(width * height)];
        createBitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        float[] fArr = new float[3];
        for (int i = 0; i < height; i++) {
            for (int i2 = 0; i2 < width; i2++) {
                fArr[0] = (((float) i2) / ((float) width)) * 360.0f;
                fArr[1] = 1.0f;
                fArr[2] = 0.5f;
                iArr[(i * width) + i2] = ColorUtils.HSLToColor(fArr);
            }
        }
        this.bmp.setPixels(iArr, 0, width, 0, 0, width, height);
        invalidate();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.touch.x = motionEvent.getX();
        this.touch.y = motionEvent.getY();
        float width = this.touch.x / ((float) getWidth());
        this.hue = width;
        this.hue = Math.max(Math.min(width, 1.0f), 0.0f);
        Runnable runnable = this.OnValueChanged;
        if (runnable != null) {
            runnable.run();
        }
        invalidate();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        Bitmap bitmap = this.bmp;
        if (bitmap != null) {
            this.src.set(0, 0, bitmap.getWidth(), this.bmp.getHeight());
            this.dst.set(0, 0, width, height);
            canvas.drawBitmap(this.bmp, this.src, this.dst, this.p);
        }
        float max = Math.max(Math.min(this.touch.x, (float) width), 0.0f);
        this.p.setStrokeWidth(4.0f);
        this.p.setColor(-1);
        canvas.drawLine(max, 0.0f, max, (float) height, this.p);
    }

    public float GetHue() {
        return this.hue;
    }

    public void SetPositionByColor(int i) {
        post(new HUEPaletteView$$ExternalSyntheticLambda1(this, i));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$SetPositionByColor$0$com-catfixture-inputbridge-core-colorpicker-HUEPaletteView  reason: not valid java name */
    public /* synthetic */ void m44lambda$SetPositionByColor$0$comcatfixtureinputbridgecorecolorpickerHUEPaletteView(int i) {
        int width = getWidth();
        float[] fArr = new float[3];
        Colorut.RGBtoHSB(i, fArr);
        float f = (float) width;
        this.touch.x = fArr[0] * f;
        float f2 = this.touch.x / f;
        this.hue = f2;
        this.hue = Math.max(Math.min(f2, 1.0f), 0.0f);
        invalidate();
    }
}
