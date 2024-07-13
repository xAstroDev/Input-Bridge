package com.catfixture.inputbridge.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Spinner;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.catfixture.inputbridge.R;

public final class EditableMovementCommonBinding implements ViewBinding {
    public final Spinner codeDown;
    public final Spinner codeLeft;
    public final Spinner codeRight;
    public final Spinner codeUp;
    private final LinearLayout rootView;

    private EditableMovementCommonBinding(LinearLayout linearLayout, Spinner spinner, Spinner spinner2, Spinner spinner3, Spinner spinner4) {
        this.rootView = linearLayout;
        this.codeDown = spinner;
        this.codeLeft = spinner2;
        this.codeRight = spinner3;
        this.codeUp = spinner4;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static EditableMovementCommonBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static EditableMovementCommonBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.editable_movement_common, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static EditableMovementCommonBinding bind(View view) {
        int i = R.id.codeDown;
        Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.codeDown);
        if (spinner != null) {
            i = R.id.codeLeft;
            Spinner spinner2 = (Spinner) ViewBindings.findChildViewById(view, R.id.codeLeft);
            if (spinner2 != null) {
                i = R.id.codeRight;
                Spinner spinner3 = (Spinner) ViewBindings.findChildViewById(view, R.id.codeRight);
                if (spinner3 != null) {
                    i = R.id.codeUp;
                    Spinner spinner4 = (Spinner) ViewBindings.findChildViewById(view, R.id.codeUp);
                    if (spinner4 != null) {
                        return new EditableMovementCommonBinding((LinearLayout) view, spinner, spinner2, spinner3, spinner4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
