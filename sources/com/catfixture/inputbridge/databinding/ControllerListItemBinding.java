package com.catfixture.inputbridge.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.catfixture.inputbridge.R;

public final class ControllerListItemBinding implements ViewBinding {
    public final TextView contMac;
    public final TextView contName;
    public final TextView contType;
    public final ImageView icon;
    public final LinearLayout linearLayout3;
    public final Button removeCont;
    private final LinearLayout rootView;

    private ControllerListItemBinding(LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, ImageView imageView, LinearLayout linearLayout2, Button button) {
        this.rootView = linearLayout;
        this.contMac = textView;
        this.contName = textView2;
        this.contType = textView3;
        this.icon = imageView;
        this.linearLayout3 = linearLayout2;
        this.removeCont = button;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ControllerListItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ControllerListItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.controller_list_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ControllerListItemBinding bind(View view) {
        int i = R.id.contMac;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.contMac);
        if (textView != null) {
            i = R.id.contName;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.contName);
            if (textView2 != null) {
                i = R.id.contType;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.contType);
                if (textView3 != null) {
                    i = R.id.icon;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.icon);
                    if (imageView != null) {
                        i = R.id.linearLayout3;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.linearLayout3);
                        if (linearLayout != null) {
                            i = R.id.removeCont;
                            Button button = (Button) ViewBindings.findChildViewById(view, R.id.removeCont);
                            if (button != null) {
                                return new ControllerListItemBinding((LinearLayout) view, textView, textView2, textView3, imageView, linearLayout, button);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
