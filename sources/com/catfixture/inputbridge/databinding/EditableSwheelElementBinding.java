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

public final class EditableSwheelElementBinding implements ViewBinding {
    public final Spinner axisSelector;
    public final TextView axisSelectorLabel;
    public final Spinner axisType;
    public final LinearLayout bindingsView;
    public final EditableIconElementBinding customIcon;
    private final LinearLayout rootView;
    public final SeekBar sensivitySlider;
    public final TextView sensivitySliderText;

    private EditableSwheelElementBinding(LinearLayout linearLayout, Spinner spinner, TextView textView, Spinner spinner2, LinearLayout linearLayout2, EditableIconElementBinding editableIconElementBinding, SeekBar seekBar, TextView textView2) {
        this.rootView = linearLayout;
        this.axisSelector = spinner;
        this.axisSelectorLabel = textView;
        this.axisType = spinner2;
        this.bindingsView = linearLayout2;
        this.customIcon = editableIconElementBinding;
        this.sensivitySlider = seekBar;
        this.sensivitySliderText = textView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static EditableSwheelElementBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static EditableSwheelElementBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.editable_swheel_element, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static EditableSwheelElementBinding bind(View view) {
        int i = R.id.axisSelector;
        Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.axisSelector);
        if (spinner != null) {
            i = R.id.axisSelectorLabel;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.axisSelectorLabel);
            if (textView != null) {
                i = R.id.axisType;
                Spinner spinner2 = (Spinner) ViewBindings.findChildViewById(view, R.id.axisType);
                if (spinner2 != null) {
                    i = R.id.bindingsView;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.bindingsView);
                    if (linearLayout != null) {
                        i = R.id.customIcon;
                        View findChildViewById = ViewBindings.findChildViewById(view, R.id.customIcon);
                        if (findChildViewById != null) {
                            EditableIconElementBinding bind = EditableIconElementBinding.bind(findChildViewById);
                            i = R.id.sensivitySlider;
                            SeekBar seekBar = (SeekBar) ViewBindings.findChildViewById(view, R.id.sensivitySlider);
                            if (seekBar != null) {
                                i = R.id.sensivitySliderText;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.sensivitySliderText);
                                if (textView2 != null) {
                                    return new EditableSwheelElementBinding((LinearLayout) view, spinner, textView, spinner2, linearLayout, bind, seekBar, textView2);
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
