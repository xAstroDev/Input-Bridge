package com.catfixture.inputbridge.core.utils;

import android.view.View;

public class ModeHolder {
    public Runnable onOff;
    public View root;
    public Runnable runnable;

    public ModeHolder(View view, Runnable runnable2) {
        this.runnable = runnable2;
        this.root = view;
    }

    public ModeHolder(View view, Runnable runnable2, Runnable runnable3) {
        this.runnable = runnable2;
        this.root = view;
        this.onOff = runnable3;
    }
}
