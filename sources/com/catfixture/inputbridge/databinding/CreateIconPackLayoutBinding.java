package com.catfixture.inputbridge.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.catfixture.inputbridge.R;

public final class CreateIconPackLayoutBinding implements ViewBinding {
    public final EditText author;
    public final Button createIconPack;
    public final EditText name;
    private final LinearLayout rootView;
    public final Button selectCustomIcon;

    private CreateIconPackLayoutBinding(LinearLayout linearLayout, EditText editText, Button button, EditText editText2, Button button2) {
        this.rootView = linearLayout;
        this.author = editText;
        this.createIconPack = button;
        this.name = editText2;
        this.selectCustomIcon = button2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static CreateIconPackLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static CreateIconPackLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.create_icon_pack_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static CreateIconPackLayoutBinding bind(View view) {
        int i = R.id.author;
        EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.author);
        if (editText != null) {
            i = R.id.createIconPack;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.createIconPack);
            if (button != null) {
                i = R.id.name;
                EditText editText2 = (EditText) ViewBindings.findChildViewById(view, R.id.name);
                if (editText2 != null) {
                    i = R.id.selectCustomIcon;
                    Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.selectCustomIcon);
                    if (button2 != null) {
                        return new CreateIconPackLayoutBinding((LinearLayout) view, editText, button, editText2, button2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
