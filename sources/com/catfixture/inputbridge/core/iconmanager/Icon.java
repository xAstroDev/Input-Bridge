package com.catfixture.inputbridge.core.iconmanager;

import android.graphics.Bitmap;
import com.catfixture.inputbridge.ui.common.genAdapter.IAdapterItem;
import java.io.Serializable;

public class Icon implements IAdapterItem, Serializable {
    static final long serialVersionUID = 24362;
    public BitmapData bmpData = new BitmapData();
    public transient Bitmap cachedBmp;
    public String name;
    public String path;
    public int scaleType;

    public int GetSpacing() {
        return 0;
    }

    public boolean IsVisible() {
        return true;
    }

    public void SetSpacing(int i) {
    }

    public void ToggleVisibility(boolean z) {
    }

    public String toString() {
        return this.name;
    }
}
