package com.catfixture.inputbridge.ui.common.genAdapter;

public interface IMultiViewAdapterItem extends IAdapterItem {
    Object GetValue();

    int GetViewType();

    void NotifyChanged(Object obj);
}
