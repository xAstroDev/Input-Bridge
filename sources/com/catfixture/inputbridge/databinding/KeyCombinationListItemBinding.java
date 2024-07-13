package com.catfixture.inputbridge.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.catfixture.inputbridge.R;

public final class KeyCombinationListItemBinding implements ViewBinding {
    public final Spinner keyCode;
    public final Button remove;
    private final LinearLayout rootView;

    private KeyCombinationListItemBinding(LinearLayout linearLayout, Spinner spinner, Button button) {
        this.rootView = linearLayout;
        this.keyCode = spinner;
        this.remove = button;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static KeyCombinationListItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static KeyCombinationListItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.key_combination_list_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static KeyCombinationListItemBinding bind(View view) {
        int i = R.id.keyCode;
        Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.keyCode);
        if (spinner != null) {
            i = R.id.remove;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.remove);
            if (button != null) {
                return new KeyCombinationListItemBinding((LinearLayout) view, spinner, button);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
