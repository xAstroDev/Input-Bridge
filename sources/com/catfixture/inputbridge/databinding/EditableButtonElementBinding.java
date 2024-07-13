package com.catfixture.inputbridge.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.catfixture.inputbridge.R;

public final class EditableButtonElementBinding implements ViewBinding {
    public final CheckBox buttonMouseMode;
    public final CheckBox buttonTriggerMode;
    private final LinearLayout rootView;
    public final ColorPickerFieldLayoutBinding triggerModeColor;

    private EditableButtonElementBinding(LinearLayout linearLayout, CheckBox checkBox, CheckBox checkBox2, ColorPickerFieldLayoutBinding colorPickerFieldLayoutBinding) {
        this.rootView = linearLayout;
        this.buttonMouseMode = checkBox;
        this.buttonTriggerMode = checkBox2;
        this.triggerModeColor = colorPickerFieldLayoutBinding;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static EditableButtonElementBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static EditableButtonElementBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.editable_button_element, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static EditableButtonElementBinding bind(View view) {
        int i = R.id.buttonMouseMode;
        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.buttonMouseMode);
        if (checkBox != null) {
            i = R.id.buttonTriggerMode;
            CheckBox checkBox2 = (CheckBox) ViewBindings.findChildViewById(view, R.id.buttonTriggerMode);
            if (checkBox2 != null) {
                i = R.id.triggerModeColor;
                View findChildViewById = ViewBindings.findChildViewById(view, R.id.triggerModeColor);
                if (findChildViewById != null) {
                    return new EditableButtonElementBinding((LinearLayout) view, checkBox, checkBox2, ColorPickerFieldLayoutBinding.bind(findChildViewById));
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
