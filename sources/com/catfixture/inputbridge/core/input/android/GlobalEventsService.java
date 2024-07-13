package com.catfixture.inputbridge.core.input.android;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityEvent;
import com.catfixture.inputbridge.core.debug.D;

public class GlobalEventsService extends AccessibilityService {
    public void onInterrupt() {
    }

    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        D.M("ACT : " + accessibilityEvent.getAction());
    }
}
