package com.catfixture.inputbridge.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.catfixture.inputbridge.R;

public final class IconPackItemBinding implements ViewBinding {
    public final TextView author;
    public final ToggleButton enableIconPack;
    public final TextView imagesCount;
    public final TextView name;
    public final TextView packSize;
    public final ImageView preview;
    public final ImageView removeButton;
    private final LinearLayout rootView;

    private IconPackItemBinding(LinearLayout linearLayout, TextView textView, ToggleButton toggleButton, TextView textView2, TextView textView3, TextView textView4, ImageView imageView, ImageView imageView2) {
        this.rootView = linearLayout;
        this.author = textView;
        this.enableIconPack = toggleButton;
        this.imagesCount = textView2;
        this.name = textView3;
        this.packSize = textView4;
        this.preview = imageView;
        this.removeButton = imageView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static IconPackItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IconPackItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.icon_pack_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static IconPackItemBinding bind(View view) {
        int i = R.id.author;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.author);
        if (textView != null) {
            i = R.id.enableIconPack;
            ToggleButton toggleButton = (ToggleButton) ViewBindings.findChildViewById(view, R.id.enableIconPack);
            if (toggleButton != null) {
                i = R.id.imagesCount;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.imagesCount);
                if (textView2 != null) {
                    i = R.id.name;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.name);
                    if (textView3 != null) {
                        i = R.id.packSize;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.packSize);
                        if (textView4 != null) {
                            i = R.id.preview;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.preview);
                            if (imageView != null) {
                                i = R.id.removeButton;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.removeButton);
                                if (imageView2 != null) {
                                    return new IconPackItemBinding((LinearLayout) view, textView, toggleButton, textView2, textView3, textView4, imageView, imageView2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
