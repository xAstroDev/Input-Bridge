package com.catfixture.inputbridge.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.catfixture.inputbridge.R;

public final class ColorPickerFieldLayoutBinding implements ViewBinding {
    public final View color;
    private final LinearLayout rootView;
    public final TextView text;

    private ColorPickerFieldLayoutBinding(LinearLayout linearLayout, View view, TextView textView) {
        this.rootView = linearLayout;
        this.color = view;
        this.text = textView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ColorPickerFieldLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ColorPickerFieldLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.color_picker_field_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ColorPickerFieldLayoutBinding bind(View view) {
        int i = R.id.color;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.color);
        if (findChildViewById != null) {
            i = R.id.text;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.text);
            if (textView != null) {
                return new ColorPickerFieldLayoutBinding((LinearLayout) view, findChildViewById, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
