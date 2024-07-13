package com.catfixture.inputbridge.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Spinner;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.catfixture.inputbridge.R;

public final class KeyboardBindingBinding implements ViewBinding {
    public final Spinner buttonCode;
    public final Spinner buttonType;
    public final Spinner mouseCode;
    private final LinearLayout rootView;

    private KeyboardBindingBinding(LinearLayout linearLayout, Spinner spinner, Spinner spinner2, Spinner spinner3) {
        this.rootView = linearLayout;
        this.buttonCode = spinner;
        this.buttonType = spinner2;
        this.mouseCode = spinner3;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static KeyboardBindingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static KeyboardBindingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.keyboard_binding, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static KeyboardBindingBinding bind(View view) {
        int i = R.id.buttonCode;
        Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.buttonCode);
        if (spinner != null) {
            i = R.id.buttonType;
            Spinner spinner2 = (Spinner) ViewBindings.findChildViewById(view, R.id.buttonType);
            if (spinner2 != null) {
                i = R.id.mouseCode;
                Spinner spinner3 = (Spinner) ViewBindings.findChildViewById(view, R.id.mouseCode);
                if (spinner3 != null) {
                    return new KeyboardBindingBinding((LinearLayout) view, spinner, spinner2, spinner3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
