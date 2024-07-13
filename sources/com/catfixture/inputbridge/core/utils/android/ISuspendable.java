package com.catfixture.inputbridge.core.utils.android;

import com.catfixture.inputbridge.core.utils.types.AutoResetEvent;

public interface ISuspendable {
    AutoResetEvent OnSuspend();
}
