package com.catfixture.inputbridge.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Spinner;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.catfixture.inputbridge.R;

public final class EditableMovementXiBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final Spinner sideSpinner;

    private EditableMovementXiBinding(LinearLayout linearLayout, Spinner spinner) {
        this.rootView = linearLayout;
        this.sideSpinner = spinner;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static EditableMovementXiBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static EditableMovementXiBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.editable_movement_xi, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static EditableMovementXiBinding bind(View view) {
        Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.sideSpinner);
        if (spinner != null) {
            return new EditableMovementXiBinding((LinearLayout) view, spinner);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.sideSpinner)));
    }
}
