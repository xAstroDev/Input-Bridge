package com.catfixture.inputbridge.core.context;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.catfixture.inputbridge.core.debug.D;
import com.catfixture.inputbridge.core.iconmanager.Icon;
import com.catfixture.inputbridge.core.iconmanager.IconPack;
import java.util.ArrayList;
import java.util.List;

public class IconsCache {
    public List<Icon> icons = new ArrayList();

    public void InitCache() {
        ClearCache();
        Icon icon = new Icon();
        icon.name = "None";
        this.icons.add(icon);
        for (IconPack next : AppContext.cache.iconManager.iconPacks) {
            if (next.isEnabled) {
                this.icons.addAll(next.icons);
            }
        }
    }

    public void ClearCache() {
        for (Icon next : this.icons) {
            if (next.cachedBmp != null && !next.cachedBmp.isRecycled()) {
                next.cachedBmp.recycle();
                next.cachedBmp = null;
            }
        }
        this.icons.clear();
    }

    public int IndexOf(String str) {
        int i = 0;
        for (Icon icon : this.icons) {
            if (icon.name.equals(str)) {
                return i;
            }
            i++;
        }
        return 0;
    }

    public Bitmap GetBitmap(String str) {
        if (this.icons.size() == 0) {
            InitCache();
        }
        for (Icon next : this.icons) {
            if (next.name.equals(str)) {
                return GetBitmap(next);
            }
        }
        return null;
    }

    public Bitmap GetBitmap(Icon icon) {
        if (icon == null) {
            return null;
        }
        if (icon.cachedBmp != null) {
            return icon.cachedBmp;
        }
        try {
            if (icon.bmpData.binData == null) {
                return null;
            }
            D.M("Decoding");
            icon.cachedBmp = BitmapFactory.decodeByteArray(icon.bmpData.binData, 0, icon.bmpData.binData.length);
            return icon.cachedBmp;
        } catch (Exception unused) {
            D.E("Can't decode bitmap! Icon pack contains broken images");
            return null;
        }
    }

    public void Destroy() {
        ClearCache();
    }
}
