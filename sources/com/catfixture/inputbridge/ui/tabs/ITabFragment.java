package com.catfixture.inputbridge.ui.tabs;

import android.app.Activity;
import android.content.Context;
import android.view.View;

public interface ITabFragment {
    Activity GetActivity();

    Context GetContext();

    View GetRoot();

    void Hide();

    View OnCreate();

    void OnDestroy();

    void Show();

    void onResume();

    void onSuspend();
}
