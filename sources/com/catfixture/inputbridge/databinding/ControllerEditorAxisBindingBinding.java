package com.catfixture.inputbridge.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.catfixture.inputbridge.R;

public final class ControllerEditorAxisBindingBinding implements ViewBinding {
    public final Spinner axisSelector;
    public final TextView axisSelectorLabel;
    public final Spinner axisType;
    private final LinearLayout rootView;

    private ControllerEditorAxisBindingBinding(LinearLayout linearLayout, Spinner spinner, TextView textView, Spinner spinner2) {
        this.rootView = linearLayout;
        this.axisSelector = spinner;
        this.axisSelectorLabel = textView;
        this.axisType = spinner2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ControllerEditorAxisBindingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ControllerEditorAxisBindingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.controller_editor_axis_binding, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ControllerEditorAxisBindingBinding bind(View view) {
        int i = R.id.axisSelector;
        Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.axisSelector);
        if (spinner != null) {
            i = R.id.axisSelectorLabel;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.axisSelectorLabel);
            if (textView != null) {
                i = R.id.axisType;
                Spinner spinner2 = (Spinner) ViewBindings.findChildViewById(view, R.id.axisType);
                if (spinner2 != null) {
                    return new ControllerEditorAxisBindingBinding((LinearLayout) view, spinner, textView, spinner2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
