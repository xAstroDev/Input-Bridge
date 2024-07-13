package com.catfixture.inputbridge.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Spinner;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.catfixture.inputbridge.R;

public final class ControllerEditorStickBindingBinding implements ViewBinding {
    public final Spinner movementType;
    private final LinearLayout rootView;
    public final EditableMovementCommonBinding walkCont;
    public final EditableMovementXiBinding xiCont;

    private ControllerEditorStickBindingBinding(LinearLayout linearLayout, Spinner spinner, EditableMovementCommonBinding editableMovementCommonBinding, EditableMovementXiBinding editableMovementXiBinding) {
        this.rootView = linearLayout;
        this.movementType = spinner;
        this.walkCont = editableMovementCommonBinding;
        this.xiCont = editableMovementXiBinding;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ControllerEditorStickBindingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ControllerEditorStickBindingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.controller_editor_stick_binding, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ControllerEditorStickBindingBinding bind(View view) {
        int i = R.id.movementType;
        Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.movementType);
        if (spinner != null) {
            i = R.id.walkCont;
            View findChildViewById = ViewBindings.findChildViewById(view, R.id.walkCont);
            if (findChildViewById != null) {
                EditableMovementCommonBinding bind = EditableMovementCommonBinding.bind(findChildViewById);
                View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.xiCont);
                if (findChildViewById2 != null) {
                    return new ControllerEditorStickBindingBinding((LinearLayout) view, spinner, bind, EditableMovementXiBinding.bind(findChildViewById2));
                }
                i = R.id.xiCont;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
