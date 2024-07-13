package com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.mouseZone;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.text.TextPaint;
import android.view.ViewGroup;
import com.catfixture.inputbridge.core.context.AppContext;
import com.catfixture.inputbridge.core.context.ConfigContext;
import com.catfixture.inputbridge.core.input.data.IconData;
import com.catfixture.inputbridge.core.input.data.InputTouchControlElementData;
import com.catfixture.inputbridge.core.input.devices.IInputDevice;
import com.catfixture.inputbridge.core.input.devices.touch.commons.MouseMovementEvents;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.DrawHelper;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.TouchableWindowElement;

public class MouseZoneElement extends TouchableWindowElement {
    Paint p = new Paint();
    TextPaint tp = new TextPaint();

    public void CreateEditorEvents() {
    }

    public MouseZoneElement(Context context, InputTouchControlElementData inputTouchControlElementData) {
        super(context, inputTouchControlElementData);
        this.initialSize.Set(400.0f, 400.0f);
        inputTouchControlElementData.buttonShape = inputTouchControlElementData.buttonShape != 0 ? inputTouchControlElementData.buttonShape : 1;
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

    public void CreateEventActions(IInputDevice iInputDevice) {
        MouseMovementEvents.Init(3, this, ConfigContext.data.GetCurrentProfile(), this.data, iInputDevice, true);
    }

    public void Select(ViewGroup viewGroup) {
        super.Select(viewGroup);
        MouseZoneElementEditable mouseZoneElementEditable = new MouseZoneElementEditable(this.context, this);
        viewGroup.removeAllViews();
        viewGroup.addView(mouseZoneElementEditable.GetRoot());
    }
}
