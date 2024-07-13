package com.catfixture.inputbridge.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Spinner;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.catfixture.inputbridge.R;

public final class EditableButtonCommonTypeBinding implements ViewBinding {
    public final Spinner buttonCode;
    public final Spinner buttonType;
    public final LinearLayout kbcodeRow;
    public final Spinner mouseCode;
    public final LinearLayout mscodeRow;
    private final LinearLayout rootView;
    public final Spinner xinputcode;
    public final LinearLayout xinputcodeRow;

    private EditableButtonCommonTypeBinding(LinearLayout linearLayout, Spinner spinner, Spinner spinner2, LinearLayout linearLayout2, Spinner spinner3, LinearLayout linearLayout3, Spinner spinner4, LinearLayout linearLayout4) {
        this.rootView = linearLayout;
        this.buttonCode = spinner;
        this.buttonType = spinner2;
        this.kbcodeRow = linearLayout2;
        this.mouseCode = spinner3;
        this.mscodeRow = linearLayout3;
        this.xinputcode = spinner4;
        this.xinputcodeRow = linearLayout4;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static EditableButtonCommonTypeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static EditableButtonCommonTypeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.editable_button_common_type, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static EditableButtonCommonTypeBinding bind(View view) {
        int i = R.id.buttonCode;
        Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.buttonCode);
        if (spinner != null) {
            i = R.id.buttonType;
            Spinner spinner2 = (Spinner) ViewBindings.findChildViewById(view, R.id.buttonType);
            if (spinner2 != null) {
                i = R.id.kbcodeRow;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.kbcodeRow);
                if (linearLayout != null) {
                    i = R.id.mouseCode;
                    Spinner spinner3 = (Spinner) ViewBindings.findChildViewById(view, R.id.mouseCode);
                    if (spinner3 != null) {
                        i = R.id.mscodeRow;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.mscodeRow);
                        if (linearLayout2 != null) {
                            i = R.id.xinputcode;
                            Spinner spinner4 = (Spinner) ViewBindings.findChildViewById(view, R.id.xinputcode);
                            if (spinner4 != null) {
                                i = R.id.xinputcodeRow;
                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.xinputcodeRow);
                                if (linearLayout3 != null) {
                                    return new EditableButtonCommonTypeBinding((LinearLayout) view, spinner, spinner2, linearLayout, spinner3, linearLayout2, spinner4, linearLayout3);
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
