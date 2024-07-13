package com.catfixture.inputbridge.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.catfixture.inputbridge.R;

public final class EditableCrossElementBinding implements ViewBinding {
    public final EditableIconElementBinding defConf1;
    public final EditableMovementCommonBinding defConf2;
    public final CheckBox enableXInput;
    private final LinearLayout rootView;

    private EditableCrossElementBinding(LinearLayout linearLayout, EditableIconElementBinding editableIconElementBinding, EditableMovementCommonBinding editableMovementCommonBinding, CheckBox checkBox) {
        this.rootView = linearLayout;
        this.defConf1 = editableIconElementBinding;
        this.defConf2 = editableMovementCommonBinding;
        this.enableXInput = checkBox;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static EditableCrossElementBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static EditableCrossElementBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.editable_cross_element, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static EditableCrossElementBinding bind(View view) {
        int i = R.id.defConf1;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.defConf1);
        if (findChildViewById != null) {
            EditableIconElementBinding bind = EditableIconElementBinding.bind(findChildViewById);
            View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.defConf2);
            if (findChildViewById2 != null) {
                EditableMovementCommonBinding bind2 = EditableMovementCommonBinding.bind(findChildViewById2);
                CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.enableXInput);
                if (checkBox != null) {
                    return new EditableCrossElementBinding((LinearLayout) view, bind, bind2, checkBox);
                }
                i = R.id.enableXInput;
            } else {
                i = R.id.defConf2;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
