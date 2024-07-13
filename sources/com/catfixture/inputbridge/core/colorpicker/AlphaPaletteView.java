package com.catfixture.inputbridge.core.colorpicker;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.utils.math.Float2;

public class AlphaPaletteView extends View {
    public Runnable OnValueChanged;
    private int alpha;
    private Bitmap checkerbCache;
    private LinearGradient gradient;
    Paint p = new Paint();
    Rect r = new Rect();
    private Float2 touch = new Float2();

    public AlphaPaletteView(Context context) {
        super(context);
    }

    public AlphaPaletteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Create();
    }

    private void Create() {
        this.checkerbCache = BitmapFactory.decodeResource(getResources(), R.drawable.chekerb);
    }

    public AlphaPaletteView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public AlphaPaletteView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Destroy();
    }

    private void Destroy() {
        this.checkerbCache.recycle();
        this.checkerbCache = null;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.touch.x = motionEvent.getX();
        this.touch.y = motionEvent.getY();
        int height = getHeight();
        Float2 float2 = this.touch;
        float f = (float) height;
        float2.y = (float) ((int) Math.min(Math.max(float2.y, 0.0f), f));
        this.alpha = (int) ((1.0f - (this.touch.y / f)) * 255.0f);
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
        Bitmap bitmap = this.checkerbCache;
        if (bitmap != null && !bitmap.isRecycled()) {
            int width2 = this.checkerbCache.getWidth();
            int height2 = this.checkerbCache.getHeight();
            for (int i = 0; i < width; i += width2) {
                for (int i2 = 0; i2 < height; i2 += height2) {
                    canvas.drawBitmap(this.checkerbCache, (float) i, (float) i2, this.p);
                }
            }
        }
        if (this.gradient == null) {
            this.gradient = new LinearGradient(0.0f, 50.0f, 0.0f, (float) height, ViewCompat.MEASURED_STATE_MASK, 0, Shader.TileMode.CLAMP);
        }
        this.p.setStyle(Paint.Style.FILL);
        this.r.set(0, 0, width, height);
        this.p.setShader(this.gradient);
        canvas.drawRect(this.r, this.p);
        this.p.setShader((Shader) null);
        float f = this.touch.y;
        this.p.setColor(-1);
        this.p.setStyle(Paint.Style.STROKE);
        this.p.setStrokeWidth(4.0f);
        canvas.drawLine(0.0f, f, (float) width, f, this.p);
    }

    public int GetAlpha() {
        return this.alpha;
    }

    public void SetPositionByAlpha(int i) {
        this.alpha = i;
        post(new AlphaPaletteView$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$SetPositionByAlpha$0$com-catfixture-inputbridge-core-colorpicker-AlphaPaletteView  reason: not valid java name */
    public /* synthetic */ void m43lambda$SetPositionByAlpha$0$comcatfixtureinputbridgecorecolorpickerAlphaPaletteView() {
        int height = getHeight();
        this.touch.y = (1.0f - (((float) this.alpha) / 255.0f)) * ((float) height);
        invalidate();
    }
}
