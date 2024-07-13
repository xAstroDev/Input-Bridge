package com.catfixture.inputbridge.core.input.devices.touch.interaction.elements;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import androidx.core.view.ViewCompat;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.input.codes.KeyCode;
import com.catfixture.inputbridge.core.input.codes.KeyCodes;
import com.catfixture.inputbridge.core.input.codes.MouseCodes;
import com.catfixture.inputbridge.core.input.codes.XInputCodes;
import com.catfixture.inputbridge.core.input.data.InputTouchControlElementData;
import com.catfixture.inputbridge.core.utils.math.Int2;

public class DrawHelper {
    private static Rect bounds = new Rect();
    static Rect dst = new Rect();
    static Rect src = new Rect();

    public static void DrawIsSelected(Context context, Canvas canvas, Paint paint, boolean z) {
        if (z) {
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(context.getColor(R.color.red));
            canvas.drawRect(0.0f, 0.0f, 10.0f, 10.0f, paint);
        }
    }

    public static void DrawCenterScaledBitmap(Canvas canvas, Bitmap bitmap, Int2 int2, int i, int i2, float f, Paint paint) {
        if (bitmap != null) {
            float f2 = (float) i;
            float f3 = (float) i2;
            src.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            float f4 = 1.0f - f;
            dst.set(((int) (f2 * f4)) + int2.x, ((int) (f3 * f4)) + int2.y, ((int) (f2 * f)) + int2.x, ((int) (f3 * f)) + int2.y);
            canvas.drawBitmap(bitmap, src, dst, paint);
            paint.setColorFilter((ColorFilter) null);
        }
    }

    public static void DrawShape(Canvas canvas, InputTouchControlElementData inputTouchControlElementData, int i, int i2, Paint paint) {
        float f = inputTouchControlElementData.shapeFineTuneData.strokeWidth;
        paint.setStrokeWidth(f);
        float f2 = f / 2.0f;
        if (inputTouchControlElementData.shapeFineTuneData.shadowData.draw) {
            f2 += inputTouchControlElementData.shapeFineTuneData.shadowData.radius;
        }
        float f3 = f2;
        float f4 = (((float) i) / 2.0f) - f3;
        DrawHelper$$ExternalSyntheticLambda0 drawHelper$$ExternalSyntheticLambda0 = new DrawHelper$$ExternalSyntheticLambda0(inputTouchControlElementData, canvas, f4 + f3, f4, f3, paint, f, i, i2);
        if (inputTouchControlElementData.shapeFineTuneData.enableFill) {
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(inputTouchControlElementData.shapeFineTuneData.fillColor.color);
            drawHelper$$ExternalSyntheticLambda0.Invoke(true);
        }
        if (inputTouchControlElementData.shapeFineTuneData.shadowData.draw) {
            paint.setShadowLayer(inputTouchControlElementData.shapeFineTuneData.shadowData.radius, 0.0f, 0.0f, ViewCompat.MEASURED_STATE_MASK);
        }
        paint.setColor(inputTouchControlElementData.shapeFineTuneData.strokeColor.color);
        paint.setStyle(Paint.Style.STROKE);
        drawHelper$$ExternalSyntheticLambda0.Invoke(false);
        if (inputTouchControlElementData.shapeFineTuneData.shadowData.draw) {
            paint.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        }
    }

    static /* synthetic */ void lambda$DrawShape$0(InputTouchControlElementData inputTouchControlElementData, Canvas canvas, float f, float f2, float f3, Paint paint, float f4, int i, int i2, Boolean bool) {
        InputTouchControlElementData inputTouchControlElementData2 = inputTouchControlElementData;
        float f5 = f3;
        int i3 = i;
        int i4 = i2;
        int i5 = inputTouchControlElementData2.buttonShape;
        if (i5 == 0) {
            float f6 = bool.booleanValue() ? -f5 : 0.0f;
            Canvas canvas2 = canvas;
            float f7 = f;
            Paint paint2 = paint;
            canvas.drawCircle(f, f, f6 + f2, paint);
        } else if (i5 == 1) {
            paint.setStrokeWidth(f4);
            canvas.drawRoundRect(f3, f3, ((float) i3) - f5, ((float) i4) - f5, inputTouchControlElementData2.shapeFineTuneData.cornerRadius, inputTouchControlElementData2.shapeFineTuneData.cornerRadius, paint);
        } else if (i5 == 2) {
            paint.setStrokeWidth(f4);
            canvas.drawRect(f3, f3, ((float) i3) - f5, ((float) i4) - f5, paint);
        }
    }

    public static void DrawCenterScaledText(Canvas canvas, int i, int i2, InputTouchControlElementData inputTouchControlElementData, TextPaint textPaint) {
        Typeface typeface;
        String GetCodeName;
        String str = null;
        if (inputTouchControlElementData.customText != null) {
            str = inputTouchControlElementData.customText;
        } else if (inputTouchControlElementData.buttonType == 1) {
            str = MouseCodes.GetCodeSmallName(inputTouchControlElementData.mouseCode);
        } else if (inputTouchControlElementData.buttonType == 0) {
            KeyCode GetKeyCodeByWindowsKeyCode = KeyCodes.GetKeyCodeByWindowsKeyCode(inputTouchControlElementData.windowsKeyCode);
            if (GetKeyCodeByWindowsKeyCode != null) {
                str = GetKeyCodeByWindowsKeyCode.name;
            }
        } else if (inputTouchControlElementData.buttonType == 2 && (GetCodeName = XInputCodes.GetCodeName(inputTouchControlElementData.xinputCode)) != null) {
            str = GetCodeName;
        }
        if (str != null) {
            int i3 = inputTouchControlElementData.textFineTuneData.size;
            if (inputTouchControlElementData.textFineTuneData.weight == 0) {
                typeface = Typeface.DEFAULT;
            } else if (inputTouchControlElementData.textFineTuneData.weight == 1) {
                typeface = Typeface.DEFAULT_BOLD;
            } else if (inputTouchControlElementData.textFineTuneData.weight == 2) {
                typeface = Typeface.defaultFromStyle(2);
            } else if (inputTouchControlElementData.textFineTuneData.weight == 3) {
                typeface = Typeface.defaultFromStyle(3);
            } else {
                typeface = inputTouchControlElementData.textFineTuneData.weight == 4 ? Typeface.SERIF : Typeface.DEFAULT;
            }
            textPaint.setTypeface(typeface);
            textPaint.setColor(inputTouchControlElementData.textFineTuneData.color.color);
            textPaint.setStyle(Paint.Style.FILL);
            textPaint.setTextSize((float) i3);
            textPaint.getTextBounds(str, 0, str.length(), bounds);
            if (inputTouchControlElementData.textFineTuneData.shadowData.draw) {
                textPaint.setShadowLayer(inputTouchControlElementData.textFineTuneData.shadowData.radius, 0.0f, 0.0f, ViewCompat.MEASURED_STATE_MASK);
            }
            canvas.drawText(str, ((((float) i) / 2.0f) - (((float) bounds.width()) / 2.0f)) + ((float) inputTouchControlElementData.textFineTuneData.position.x), (((((float) i2) / 2.0f) + (((float) bounds.height()) / 2.0f)) - 1.0f) + ((float) inputTouchControlElementData.textFineTuneData.position.y), textPaint);
            if (inputTouchControlElementData.textFineTuneData.shadowData.draw) {
                textPaint.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            }
        }
    }
}
