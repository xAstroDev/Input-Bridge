package com.catfixture.inputbridge.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.catfixture.inputbridge.R;
import java.util.Objects;

public final class ActivityKeyboardEditorBinding implements ViewBinding {
    private final ConstraintLayout rootView;

    private ActivityKeyboardEditorBinding(ConstraintLayout constraintLayout) {
        this.rootView = constraintLayout;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityKeyboardEditorBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityKeyboardEditorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_keyboard_editor, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityKeyboardEditorBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        return new ActivityKeyboardEditorBinding((ConstraintLayout) view);
    }
}
