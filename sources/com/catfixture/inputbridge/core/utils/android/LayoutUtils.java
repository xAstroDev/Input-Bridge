package com.catfixture.inputbridge.core.utils.android;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class LayoutUtils {
    public static void SetMatchMatch(View view) {
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    }

    public static void SetMatchWrap(View view) {
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    }

    public static void SetWrapWrap(View view) {
        view.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    }

    public static void SetWrapWrapRelative(View view) {
        view.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
    }

    public static void SetMatchWrapRelative(View view) {
        view.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
    }

    public static void SetMatchMatchRelative(View view) {
        view.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    }

    public static void SetSizeRelative(View view, int i, int i2) {
        view.setLayoutParams(new RelativeLayout.LayoutParams(i, i2));
    }

    public static void SetSize(View view, int i, int i2) {
        view.setLayoutParams(new LinearLayout.LayoutParams(i, i2));
    }

    public static void SetRelativeLayoutPos(ViewGroup viewGroup, int i, int i2) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewGroup.getLayoutParams();
        layoutParams.leftMargin = i;
        layoutParams.topMargin = i2;
        viewGroup.requestLayout();
    }

    public static int GetDP(Context context, int i) {
        return Math.round(TypedValue.applyDimension(1, (float) i, context.getResources().getDisplayMetrics()));
    }

    public static void RunJustBeforeBeingDrawn(final View view, final Runnable runnable) {
        view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            public boolean onPreDraw() {
                view.getViewTreeObserver().removeOnPreDrawListener(this);
                runnable.run();
                return true;
            }
        });
    }
}
