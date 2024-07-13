package com.catfixture.inputbridge.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.viewbinding.ViewBinding;
import com.catfixture.inputbridge.R;
import java.util.Objects;

public final class CheatCodeDelayFieldBinding implements ViewBinding {
    private final EditText rootView;

    private CheatCodeDelayFieldBinding(EditText editText) {
        this.rootView = editText;
    }

    public EditText getRoot() {
        return this.rootView;
    }

    public static CheatCodeDelayFieldBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static CheatCodeDelayFieldBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.cheat_code_delay_field, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static CheatCodeDelayFieldBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        return new CheatCodeDelayFieldBinding((EditText) view);
    }
}
