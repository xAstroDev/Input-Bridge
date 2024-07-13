package com.catfixture.inputbridge.ui.tabs;

import android.app.Activity;
import android.content.Context;
import android.view.View;

public abstract class DefaultTabFragment implements ITabFragment {
    private final Activity activity;
    private final Context context;
    private final View root = OnCreate();

    /* access modifiers changed from: protected */
    public void Init() {
    }

    public void onSuspend() {
    }

    public DefaultTabFragment(Activity activity2) {
        this.activity = activity2;
        this.context = activity2;
        Init();
    }

    public Activity GetActivity() {
        return this.activity;
    }

    public Context GetContext() {
        return this.context;
    }

    public void Show() {
        this.root.setVisibility(0);
        onResume();
    }

    public void Hide() {
        this.root.setVisibility(8);
        onSuspend();
    }

    public View GetRoot() {
        return this.root;
    }
}
