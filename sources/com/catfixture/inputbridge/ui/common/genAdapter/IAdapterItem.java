package com.catfixture.inputbridge.ui.common.genAdapter;

public interface IAdapterItem {
    int GetSpacing();

    boolean IsVisible();

    void SetSpacing(int i);

    void ToggleVisibility(boolean z);
}
