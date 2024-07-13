package com.catfixture.inputbridge.core.utils.windows;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.debug.D;
import com.catfixture.inputbridge.core.utils.android.AndroidUtils;
import java.lang.reflect.Field;

public class MinimalWindow {
    private int EVENTS_FLAGS;
    private int FLAG_HEIGHT;
    private int FLAG_WIDTH;
    private int GRAVITY_FLAGS;
    private int LAYOUT_FLAGS;
    private int PIXEL_FORMAT;
    /* access modifiers changed from: private */
    public final RelativeLayout container;
    private WindowManager.LayoutParams genLayoutParams;
    private boolean isCreated;
    /* access modifiers changed from: private */
    public boolean needHideSystemUI;
    private final WindowManager winMan;

    public MinimalWindow(Context context) {
        this.winMan = (WindowManager) context.getSystemService("window");
        AnonymousClass1 r0 = new RelativeLayout(context) {
            public void onWindowSystemUiVisibilityChanged(int i) {
                super.onWindowSystemUiVisibilityChanged(i);
                if (MinimalWindow.this.needHideSystemUI) {
                    AndroidUtils.HideSystemUI(MinimalWindow.this.container);
                }
            }

            /* access modifiers changed from: protected */
            public void onFocusChanged(boolean z, int i, Rect rect) {
                super.onFocusChanged(z, i, rect);
                getContext().setTheme(R.style.Theme_InputBridge);
            }
        };
        this.container = r0;
        r0.postDelayed(new MinimalWindow$$ExternalSyntheticLambda0(this), 50);
        context.setTheme(R.style.Theme_InputBridge);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$com-catfixture-inputbridge-core-utils-windows-MinimalWindow  reason: not valid java name */
    public /* synthetic */ void m117lambda$new$0$comcatfixtureinputbridgecoreutilswindowsMinimalWindow() {
        if (this.needHideSystemUI) {
            AndroidUtils.HideSystemUI(this.container);
        }
    }

    public MinimalWindow SetTranslucent() {
        this.PIXEL_FORMAT = -3;
        return this;
    }

    public MinimalWindow SetOpaque() {
        this.PIXEL_FORMAT = -1;
        return this;
    }

    public MinimalWindow EnableEvents() {
        this.EVENTS_FLAGS = 8781824;
        return this;
    }

    public MinimalWindow EnableEventsTouchOnly() {
        this.EVENTS_FLAGS = 8388616;
        return this;
    }

    public MinimalWindow DisableEvents() {
        this.EVENTS_FLAGS = 24;
        return this;
    }

    public MinimalWindow SetOverlay() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.LAYOUT_FLAGS = 2038;
        } else if (Build.VERSION.SDK_INT >= 24) {
            this.LAYOUT_FLAGS = 2003;
        } else {
            this.LAYOUT_FLAGS = 2002;
        }
        return this;
    }

    public MinimalWindow SetFullscreen() {
        this.FLAG_WIDTH = -1;
        this.FLAG_HEIGHT = -1;
        return this;
    }

    public MinimalWindow SetWrapContent() {
        this.FLAG_WIDTH = -2;
        this.FLAG_HEIGHT = -2;
        return this;
    }

    private MinimalWindow UpdateLayoutParams() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(this.FLAG_WIDTH, this.FLAG_HEIGHT, this.LAYOUT_FLAGS, 16777216 | this.EVENTS_FLAGS, this.PIXEL_FORMAT);
        this.genLayoutParams = layoutParams;
        layoutParams.gravity = this.GRAVITY_FLAGS;
        try {
            Class<?> cls = Class.forName("android.view.WindowManager$LayoutParams");
            Field field = cls.getField("privateFlags");
            Field field2 = cls.getField("PRIVATE_FLAG_NO_MOVE_ANIMATION");
            field.setInt(this.genLayoutParams, field2.getInt(this.genLayoutParams) | field.getInt(this.genLayoutParams));
        } catch (Exception e) {
            D.E((Throwable) e);
        }
        return this;
    }

    public MinimalWindow Update() {
        UpdateLayoutParams();
        if (this.container.isAttachedToWindow()) {
            this.winMan.updateViewLayout(this.container, this.genLayoutParams);
        }
        return this;
    }

    public void Create() {
        if (!this.isCreated) {
            this.isCreated = true;
            UpdateLayoutParams();
            this.winMan.addView(this.container, this.genLayoutParams);
        }
    }

    public void Destroy() {
        this.isCreated = false;
        try {
            this.winMan.removeView(this.container);
        } catch (Exception unused) {
        }
    }

    public ViewGroup GetContainer() {
        return this.container;
    }

    public MinimalWindow SetGravity(int i) {
        this.GRAVITY_FLAGS = i;
        return this;
    }

    public MinimalWindow SetSize(int i, int i2) {
        this.FLAG_WIDTH = i;
        this.FLAG_HEIGHT = i2;
        return this;
    }

    public MinimalWindow EnableSystemUIHide() {
        this.needHideSystemUI = true;
        return this;
    }

    public MinimalWindow SetNoSize() {
        this.FLAG_WIDTH = 0;
        this.FLAG_HEIGHT = 0;
        return this;
    }
}
