package com.catfixture.inputbridge.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.catfixture.inputbridge.R;

public final class EditableIconElementBinding implements ViewBinding {
    public final Spinner icon;
    public final ImageView openIconSettings;
    private final LinearLayout rootView;
    public final TextView text;

    private EditableIconElementBinding(LinearLayout linearLayout, Spinner spinner, ImageView imageView, TextView textView) {
        this.rootView = linearLayout;
        this.icon = spinner;
        this.openIconSettings = imageView;
        this.text = textView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static EditableIconElementBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static EditableIconElementBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.editable_icon_element, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static EditableIconElementBinding bind(View view) {
        int i = R.id.icon;
        Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.icon);
        if (spinner != null) {
            i = R.id.openIconSettings;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.openIconSettings);
            if (imageView != null) {
                i = R.id.text;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.text);
                if (textView != null) {
                    return new EditableIconElementBinding((LinearLayout) view, spinner, imageView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
