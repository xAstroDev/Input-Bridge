package com.catfixture.inputbridge.core.access;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;
import android.content.Intent;
import android.graphics.Path;
import android.os.Build;
import android.os.Handler;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import com.catfixture.inputbridge.core.context.ConfigContext;
import com.catfixture.inputbridge.core.debug.D;
import com.catfixture.inputbridge.core.input.data.InputConfigProfile;
import com.catfixture.inputbridge.core.utils.types.delegates.Action;
import com.catfixture.inputbridge.ui.activity.main.ErrorH;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;

public class TouchEmulatorServic extends AccessibilityService {
    public static WeakReference<TouchEmulatorServic> weakInstance;
    private boolean isMaximized;
    private boolean isRunning;

    public void onInterrupt() {
    }

    private static GestureDescription createClick3(float f, float f2) {
        if (Build.VERSION.SDK_INT < 24) {
            return null;
        }
        Path path = new Path();
        path.moveTo(f, f2);
        GestureDescription.Builder builder = new GestureDescription.Builder();
        builder.addStroke(new GestureDescription.StrokeDescription(path, 1, 10));
        Path path2 = new Path();
        path2.moveTo(100.0f + f, f2);
        builder.addStroke(new GestureDescription.StrokeDescription(path2, 2, 10));
        Path path3 = new Path();
        path3.moveTo(f + 200.0f, f2);
        builder.addStroke(new GestureDescription.StrokeDescription(path3, 3, 10));
        return builder.build();
    }

    public static TouchEmulatorServic GetInstance() {
        return (TouchEmulatorServic) weakInstance.get();
    }

    public static boolean HasInstance() {
        WeakReference<TouchEmulatorServic> weakReference = weakInstance;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    public void onCreate() {
        super.onCreate();
        weakInstance = new WeakReference<>(this);
    }

    private AccessibilityNodeInfo GetNode(AccessibilityEvent accessibilityEvent, String str) {
        AccessibilityNodeInfo source = accessibilityEvent.getSource();
        if (source == null) {
            return null;
        }
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByViewId = source.findAccessibilityNodeInfosByViewId(accessibilityEvent.getPackageName() + ":id/" + str);
        if (findAccessibilityNodeInfosByViewId.size() > 0) {
            return findAccessibilityNodeInfosByViewId.get(0);
        }
        return null;
    }

    public void onRebind(Intent intent) {
        super.onRebind(intent);
        weakInstance = new WeakReference<>(this);
    }

    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
    }

    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        String viewIdResourceName;
        if (accessibilityEvent.getEventType() == 1 && accessibilityEvent.getSource() != null && (viewIdResourceName = accessibilityEvent.getSource().getViewIdResourceName()) != null && viewIdResourceName.toString().contains("button_fullscreen")) {
            this.isMaximized = !this.isMaximized;
        }
    }

    public void TripleClick(int i, int i2, final Action<Boolean> action) {
        if (Build.VERSION.SDK_INT >= 24) {
            boolean dispatchGesture = dispatchGesture(createClick3((float) i, (float) i2), new AccessibilityService.GestureResultCallback() {
                public void onCompleted(GestureDescription gestureDescription) {
                    super.onCompleted(gestureDescription);
                    D.M("gesture completed");
                    action.Invoke(true);
                }

                public void onCancelled(GestureDescription gestureDescription) {
                    super.onCancelled(gestureDescription);
                    D.M("gesture cancelled");
                    action.Invoke(false);
                }
            }, (Handler) null);
            D.M("Gesture dispatched? " + dispatchGesture);
        }
    }

    public void Stop() {
        stopSelf();
        weakInstance = null;
    }

    private AccessibilityNodeInfo FindNode(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        for (int i = 0; i < accessibilityNodeInfo.getChildCount(); i++) {
            AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i);
            if (child != null) {
                child.refresh();
                if (child.getViewIdResourceName() != null && child.getViewIdResourceName().contains(str)) {
                    return child;
                }
                AccessibilityNodeInfo FindNode = FindNode(child, str);
                if (FindNode != null) {
                    return FindNode;
                }
            }
        }
        return null;
    }

    public void TryMinimize(Runnable runnable) {
        try {
            D.E("1. Minimize request received!");
            for (AccessibilityWindowInfo accessibilityWindowInfo : getWindows()) {
                AccessibilityNodeInfo root = accessibilityWindowInfo.getRoot();
                if (root != null) {
                    if (root.getPackageName() != null) {
                        AccessibilityNodeInfo root2 = accessibilityWindowInfo.getRoot();
                        AccessibilityNodeInfo FindNode = FindNode(root2, "button_fullscreen");
                        AccessibilityNodeInfo FindNode2 = FindNode(root2, "default_ui_overlay_toolbar");
                        if (FindNode2 != null) {
                            if (FindNode != null) {
                                if (!this.isRunning) {
                                    InputConfigProfile GetCurrentProfile = ConfigContext.data.GetCurrentProfile();
                                    if (!GetCurrentProfile.integrateControls) {
                                        runnable.run();
                                    } else if (FindNode2.isVisibleToUser()) {
                                        this.isRunning = true;
                                        if (GetCurrentProfile.icMaximize && !this.isMaximized) {
                                            FindNode.performAction(16);
                                        }
                                        if (GetCurrentProfile.icHidePanels) {
                                            new Handler().postDelayed(new TouchEmulatorServic$$ExternalSyntheticLambda1(this, runnable), 500);
                                        } else {
                                            runnable.run();
                                        }
                                    } else {
                                        runnable.run();
                                    }
                                }
                            }
                        }
                        D.E("Error main items not found!");
                        runnable.run();
                        return;
                    }
                }
            }
        } catch (Exception e) {
            ErrorH.RaiseCrash(this, e.getMessage(), Arrays.toString(e.getStackTrace()));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$TryMinimize$1$com-catfixture-inputbridge-core-access-TouchEmulatorServic  reason: not valid java name */
    public /* synthetic */ void m42lambda$TryMinimize$1$comcatfixtureinputbridgecoreaccessTouchEmulatorServic(Runnable runnable) {
        TripleClick(500, 500, new TouchEmulatorServic$$ExternalSyntheticLambda0(this, runnable));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$TryMinimize$0$com-catfixture-inputbridge-core-access-TouchEmulatorServic  reason: not valid java name */
    public /* synthetic */ void m41lambda$TryMinimize$0$comcatfixtureinputbridgecoreaccessTouchEmulatorServic(Runnable runnable, Boolean bool) {
        runnable.run();
        this.isRunning = false;
        D.E("TRY MAX DONE!");
    }

    public void Reset() {
        this.isMaximized = false;
    }
}
