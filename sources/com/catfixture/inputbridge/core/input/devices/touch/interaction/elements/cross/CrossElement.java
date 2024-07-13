package com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.cross;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.view.ViewGroup;
import com.catfixture.inputbridge.core.context.AppContext;
import com.catfixture.inputbridge.core.input.data.IconData;
import com.catfixture.inputbridge.core.input.data.InputTouchControlElementData;
import com.catfixture.inputbridge.core.input.devices.IInputDevice;
import com.catfixture.inputbridge.core.input.devices.touch.commons.WindowsEightDirMoveEvents;
import com.catfixture.inputbridge.core.input.devices.touch.commons.XInputEightDirMoveEvents;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.DrawHelper;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.TouchableWindowElement;

public class CrossElement extends TouchableWindowElement {
    Paint p = new Paint();

    public void CreateEditorEvents() {
    }

    public CrossElement(Context context, InputTouchControlElementData inputTouchControlElementData) {
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
            GetBitmap = AppContext.cache.defaultBitmaps.crossDefault;
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
        if (this.data.enableXI) {
            this.data.codeDown = 2;
            this.data.codeUp = 1;
            this.data.codeLeft = 4;
            this.data.codeRight = 8;
            new XInputEightDirMoveEvents(this, iInputDevice);
            return;
        }
        new WindowsEightDirMoveEvents(this, iInputDevice);
    }

    public void Select(ViewGroup viewGroup) {
        super.Select(viewGroup);
        CrossElementEditable crossElementEditable = new CrossElementEditable(this.context, this);
        viewGroup.removeAllViews();
        viewGroup.addView(crossElementEditable.GetRoot());
    }
}
