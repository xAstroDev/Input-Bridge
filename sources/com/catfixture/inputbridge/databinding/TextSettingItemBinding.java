package com.catfixture.inputbridge.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.catfixture.inputbridge.R;

public final class TextSettingItemBinding implements ViewBinding {
    public final TextView description;
    public final EditText handle;
    public final TextView name;
    private final LinearLayout rootView;

    private TextSettingItemBinding(LinearLayout linearLayout, TextView textView, EditText editText, TextView textView2) {
        this.rootView = linearLayout;
        this.description = textView;
        this.handle = editText;
        this.name = textView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TextSettingItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static TextSettingItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.text_setting_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TextSettingItemBinding bind(View view) {
        int i = R.id.description;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.description);
        if (textView != null) {
            i = R.id.handle;
            EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.handle);
            if (editText != null) {
                i = R.id.name;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.name);
                if (textView2 != null) {
                    return new TextSettingItemBinding((LinearLayout) view, textView, editText, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
