package com.catfixture.inputbridge.core.context;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.debug.D;

public class CachedDefaultBitmaps {
    public Bitmap crossDefault;
    public Bitmap stickInnerDefault;
    public Bitmap stickOuterDefault;
    public Bitmap wheelDefault;

    public CachedDefaultBitmaps(Context context) {
        this.crossDefault = BitmapFactory.decodeResource(context.getResources(), R.drawable.fx_tc_cross_btn_image);
        this.stickInnerDefault = BitmapFactory.decodeResource(context.getResources(), R.drawable.fx_tc_stick_inner);
        this.stickOuterDefault = BitmapFactory.decodeResource(context.getResources(), R.drawable.fx_tc_stick_outer);
        this.wheelDefault = BitmapFactory.decodeResource(context.getResources(), R.drawable.fx_swheel);
    }

    public void Destroy() {
        try {
            Bitmap bitmap = this.crossDefault;
            if (bitmap != null) {
                bitmap.recycle();
                this.crossDefault = null;
            }
            Bitmap bitmap2 = this.stickInnerDefault;
            if (bitmap2 != null) {
                bitmap2.recycle();
                this.stickInnerDefault = null;
            }
            Bitmap bitmap3 = this.stickOuterDefault;
            if (bitmap3 != null) {
                bitmap3.recycle();
                this.stickOuterDefault = null;
            }
            Bitmap bitmap4 = this.wheelDefault;
            if (bitmap4 != null) {
                bitmap4.recycle();
                this.wheelDefault = null;
            }
        } catch (Exception unused) {
            D.E("Something goes wrong!");
        }
    }
}
