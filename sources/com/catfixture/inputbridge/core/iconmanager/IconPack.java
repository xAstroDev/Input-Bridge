package com.catfixture.inputbridge.core.iconmanager;

import com.catfixture.inputbridge.ui.common.genAdapter.IAdapterItem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class IconPack implements IAdapterItem, Serializable {
    static final long serialVersionUID = 23442;
    public String author;
    public Icon customIcon;
    public List<Icon> icons = new ArrayList();
    public boolean isEnabled = true;
    public String name;
    public long packSize;

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

    public boolean Contains(Icon icon) {
        for (Icon icon2 : this.icons) {
            if (icon2.name.equals(icon.name)) {
                return true;
            }
        }
        return false;
    }
}
