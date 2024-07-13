package com.catfixture.inputbridge.core.utils.android;

import com.catfixture.inputbridge.core.utils.types.AutoResetEvent;

public interface IPermissionGrantable {
    public static final AutoResetEvent onGranted = new AutoResetEvent();
}
