package com.catfixture.inputbridge.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import androidx.viewbinding.ViewBinding;
import com.catfixture.inputbridge.R;
import java.util.Objects;

public final class CheatCodeKeyFieldBinding implements ViewBinding {
    private final Spinner rootView;

    private CheatCodeKeyFieldBinding(Spinner spinner) {
        this.rootView = spinner;
    }

    public Spinner getRoot() {
        return this.rootView;
    }

    public static CheatCodeKeyFieldBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static CheatCodeKeyFieldBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.cheat_code_key_field, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static CheatCodeKeyFieldBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        return new CheatCodeKeyFieldBinding((Spinner) view);
    }
}
