package com.catfixture.inputbridge.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.viewbinding.ViewBinding;
import com.catfixture.inputbridge.R;
import java.util.Objects;

public final class CheatCodeTextFieldBinding implements ViewBinding {
    private final EditText rootView;

    private CheatCodeTextFieldBinding(EditText editText) {
        this.rootView = editText;
    }

    public EditText getRoot() {
        return this.rootView;
    }

    public static CheatCodeTextFieldBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static CheatCodeTextFieldBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.cheat_code_text_field, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static CheatCodeTextFieldBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        return new CheatCodeTextFieldBinding((EditText) view);
    }
}
