package com.catfixture.inputbridge.core.input.data;

import com.catfixture.inputbridge.core.context.ConfigContext;
import com.catfixture.inputbridge.ui.common.genAdapter.IAdapterItem;

public class KeyCombination implements IAdapterItem {
    public int code;
    public String name;

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

    public void SetCode(Integer num) {
        this.code = num.intValue();
        ConfigContext.Save();
    }
}
