package com.catfixture.inputbridge.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.catfixture.inputbridge.R;

public final class EditorToolbarLayoutBinding implements ViewBinding {
    public final ImageView copyElementStyleTool;
    public final ImageView copyElementTool;
    public final ImageView pasteElementStyleTool;
    public final ImageView pasteElementTool;
    private final LinearLayout rootView;

    private EditorToolbarLayoutBinding(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4) {
        this.rootView = linearLayout;
        this.copyElementStyleTool = imageView;
        this.copyElementTool = imageView2;
        this.pasteElementStyleTool = imageView3;
        this.pasteElementTool = imageView4;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static EditorToolbarLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static EditorToolbarLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.editor_toolbar_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static EditorToolbarLayoutBinding bind(View view) {
        int i = R.id.copyElementStyleTool;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.copyElementStyleTool);
        if (imageView != null) {
            i = R.id.copyElementTool;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.copyElementTool);
            if (imageView2 != null) {
                i = R.id.pasteElementStyleTool;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.pasteElementStyleTool);
                if (imageView3 != null) {
                    i = R.id.pasteElementTool;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.pasteElementTool);
                    if (imageView4 != null) {
                        return new EditorToolbarLayoutBinding((LinearLayout) view, imageView, imageView2, imageView3, imageView4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
