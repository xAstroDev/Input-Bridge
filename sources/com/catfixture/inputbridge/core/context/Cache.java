package com.catfixture.inputbridge.core.context;

import android.content.Context;
import com.catfixture.inputbridge.core.debug.D;
import com.catfixture.inputbridge.core.iconmanager.IconPacksManager;

public class Cache {
    public CachedDefaultBitmaps defaultBitmaps;
    public IconPacksManager iconManager = new IconPacksManager();
    public IconsCache iconsCache = new IconsCache();

    public Cache(Context context) {
        this.defaultBitmaps = new CachedDefaultBitmaps(context);
    }

    public void Destroy() {
        try {
            this.iconManager.Destroy();
        } catch (Exception unused) {
            D.E("Error can't destroy icm");
        }
        try {
            this.iconsCache.Destroy();
        } catch (Exception unused2) {
            D.E("Error can't destroy icc");
        }
        try {
            this.defaultBitmaps.Destroy();
        } catch (Exception unused3) {
            D.E("Error can't destroy idm");
        }
    }
}
