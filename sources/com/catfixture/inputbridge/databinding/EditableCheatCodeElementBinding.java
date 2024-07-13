package com.catfixture.inputbridge.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.catfixture.inputbridge.R;

public final class EditableCheatCodeElementBinding implements ViewBinding {
    public final Spinner actionsSpinner;
    public final Button addAction;
    public final LinearLayout cheatCodeActionsContainer;
    private final LinearLayout rootView;

    private EditableCheatCodeElementBinding(LinearLayout linearLayout, Spinner spinner, Button button, LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.actionsSpinner = spinner;
        this.addAction = button;
        this.cheatCodeActionsContainer = linearLayout2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static EditableCheatCodeElementBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static EditableCheatCodeElementBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.editable_cheat_code_element, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static EditableCheatCodeElementBinding bind(View view) {
        int i = R.id.actionsSpinner;
        Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.actionsSpinner);
        if (spinner != null) {
            i = R.id.addAction;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.addAction);
            if (button != null) {
                i = R.id.cheatCodeActionsContainer;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.cheatCodeActionsContainer);
                if (linearLayout != null) {
                    return new EditableCheatCodeElementBinding((LinearLayout) view, spinner, button, linearLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
