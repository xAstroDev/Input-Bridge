package com.catfixture.inputbridge.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.catfixture.inputbridge.R;

public final class SpoilerLayoutBinding implements ViewBinding {
    public final LinearLayout content;
    public final RelativeLayout head;
    private final LinearLayout rootView;
    public final ImageView spoilerStatus;
    public final TextView titleText;

    private SpoilerLayoutBinding(LinearLayout linearLayout, LinearLayout linearLayout2, RelativeLayout relativeLayout, ImageView imageView, TextView textView) {
        this.rootView = linearLayout;
        this.content = linearLayout2;
        this.head = relativeLayout;
        this.spoilerStatus = imageView;
        this.titleText = textView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SpoilerLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static SpoilerLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.spoiler_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static SpoilerLayoutBinding bind(View view) {
        int i = R.id.content;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.content);
        if (linearLayout != null) {
            i = R.id.head;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.head);
            if (relativeLayout != null) {
                i = R.id.spoilerStatus;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.spoilerStatus);
                if (imageView != null) {
                    i = R.id.titleText;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.titleText);
                    if (textView != null) {
                        return new SpoilerLayoutBinding((LinearLayout) view, linearLayout, relativeLayout, imageView, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
