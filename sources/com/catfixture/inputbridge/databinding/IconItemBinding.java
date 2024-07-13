package com.catfixture.inputbridge.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.catfixture.inputbridge.R;

public final class IconItemBinding implements ViewBinding {
    public final TextView name;
    public final ImageView preview;
    public final ImageView removeButton;
    private final LinearLayout rootView;
    public final TextView size;

    private IconItemBinding(LinearLayout linearLayout, TextView textView, ImageView imageView, ImageView imageView2, TextView textView2) {
        this.rootView = linearLayout;
        this.name = textView;
        this.preview = imageView;
        this.removeButton = imageView2;
        this.size = textView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static IconItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IconItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.icon_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static IconItemBinding bind(View view) {
        int i = R.id.name;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.name);
        if (textView != null) {
            i = R.id.preview;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.preview);
            if (imageView != null) {
                i = R.id.removeButton;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.removeButton);
                if (imageView2 != null) {
                    i = R.id.size;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.size);
                    if (textView2 != null) {
                        return new IconItemBinding((LinearLayout) view, textView, imageView, imageView2, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
