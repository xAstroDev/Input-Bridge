package com.catfixture.inputbridge.core.overlay;

import android.view.ViewGroup;

public interface IOverlayFragment {
    void Destroy();

    ViewGroup GetContainer();

    int GetID();

    void OnFragmentHidden();

    void OnFragmentShown();
}
