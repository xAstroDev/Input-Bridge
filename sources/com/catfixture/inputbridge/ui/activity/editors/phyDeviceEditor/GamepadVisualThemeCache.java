package com.catfixture.inputbridge.ui.activity.editors.phyDeviceEditor;

import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.List;

public class GamepadVisualThemeCache {
    private List<Bitmap> images = new ArrayList();

    public void RegisterBitmap(Bitmap bitmap) {
        this.images.add(bitmap);
    }

    public void FreeCache() {
        for (Bitmap next : this.images) {
            if (!next.isRecycled()) {
                next.recycle();
            }
        }
        this.images.clear();
    }
}
