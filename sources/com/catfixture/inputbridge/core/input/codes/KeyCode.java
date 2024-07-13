package com.catfixture.inputbridge.core.input.codes;

import com.catfixture.inputbridge.ui.common.genAdapter.IAdapterItem;

public class KeyCode implements IAdapterItem {
    public final int androidKeyCode;
    public final String name;
    public final int windowsKeyCode;

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

    public KeyCode(String str, int i, int i2) {
        this.name = str;
        this.windowsKeyCode = i;
        this.androidKeyCode = i2;
    }

    public String toString() {
        return this.name;
    }
}
