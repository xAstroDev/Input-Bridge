package com.catfixture.inputbridge.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.catfixture.inputbridge.R;

public final class ColorPickerDarkFieldLayoutBinding implements ViewBinding {
    public final View color;
    private final LinearLayout rootView;
    public final TextView text;

    private ColorPickerDarkFieldLayoutBinding(LinearLayout linearLayout, View view, TextView textView) {
        this.rootView = linearLayout;
        this.color = view;
        this.text = textView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ColorPickerDarkFieldLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ColorPickerDarkFieldLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.color_picker_dark_field_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ColorPickerDarkFieldLayoutBinding bind(View view) {
        int i = R.id.color;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.color);
        if (findChildViewById != null) {
            i = R.id.text;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.text);
            if (textView != null) {
                return new ColorPickerDarkFieldLayoutBinding((LinearLayout) view, findChildViewById, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
