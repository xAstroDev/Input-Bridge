package com.catfixture.inputbridge.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.catfixture.inputbridge.R;

public final class CrosshairLayoutBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final View xAxis;
    public final View yAxis;

    private CrosshairLayoutBinding(RelativeLayout relativeLayout, View view, View view2) {
        this.rootView = relativeLayout;
        this.xAxis = view;
        this.yAxis = view2;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static CrosshairLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static CrosshairLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.crosshair_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static CrosshairLayoutBinding bind(View view) {
        int i = R.id.xAxis;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.xAxis);
        if (findChildViewById != null) {
            i = R.id.yAxis;
            View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.yAxis);
            if (findChildViewById2 != null) {
                return new CrosshairLayoutBinding((RelativeLayout) view, findChildViewById, findChildViewById2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
