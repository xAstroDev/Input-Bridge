package com.catfixture.inputbridge.core.utils.android;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import com.catfixture.inputbridge.core.utils.types.delegates.Action;

public interface IActivityLaunchable {
    void Launch(Intent intent, Action<ActivityResult> action);
}
