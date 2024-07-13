package com.catfixture.inputbridge.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.catfixture.inputbridge.R;

public final class EditableStickElementBinding implements ViewBinding {
    public final EditableIconElementBinding innerCircle;
    public final Spinner movementType;
    public final EditableIconElementBinding outerCircle;
    private final LinearLayout rootView;
    public final SeekBar sensivitySlider;
    public final TextView sensivitySliderText;
    public final EditableMovementCommonBinding walkCont;
    public final EditableMovementXiBinding xiCont;

    private EditableStickElementBinding(LinearLayout linearLayout, EditableIconElementBinding editableIconElementBinding, Spinner spinner, EditableIconElementBinding editableIconElementBinding2, SeekBar seekBar, TextView textView, EditableMovementCommonBinding editableMovementCommonBinding, EditableMovementXiBinding editableMovementXiBinding) {
        this.rootView = linearLayout;
        this.innerCircle = editableIconElementBinding;
        this.movementType = spinner;
        this.outerCircle = editableIconElementBinding2;
        this.sensivitySlider = seekBar;
        this.sensivitySliderText = textView;
        this.walkCont = editableMovementCommonBinding;
        this.xiCont = editableMovementXiBinding;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static EditableStickElementBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static EditableStickElementBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.editable_stick_element, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static EditableStickElementBinding bind(View view) {
        int i = R.id.innerCircle;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.innerCircle);
        if (findChildViewById != null) {
            EditableIconElementBinding bind = EditableIconElementBinding.bind(findChildViewById);
            i = R.id.movementType;
            Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.movementType);
            if (spinner != null) {
                i = R.id.outerCircle;
                View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.outerCircle);
                if (findChildViewById2 != null) {
                    EditableIconElementBinding bind2 = EditableIconElementBinding.bind(findChildViewById2);
                    i = R.id.sensivitySlider;
                    SeekBar seekBar = (SeekBar) ViewBindings.findChildViewById(view, R.id.sensivitySlider);
                    if (seekBar != null) {
                        i = R.id.sensivitySliderText;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.sensivitySliderText);
                        if (textView != null) {
                            i = R.id.walkCont;
                            View findChildViewById3 = ViewBindings.findChildViewById(view, R.id.walkCont);
                            if (findChildViewById3 != null) {
                                EditableMovementCommonBinding bind3 = EditableMovementCommonBinding.bind(findChildViewById3);
                                i = R.id.xiCont;
                                View findChildViewById4 = ViewBindings.findChildViewById(view, R.id.xiCont);
                                if (findChildViewById4 != null) {
                                    return new EditableStickElementBinding((LinearLayout) view, bind, spinner, bind2, seekBar, textView, bind3, EditableMovementXiBinding.bind(findChildViewById4));
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
