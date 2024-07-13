package com.catfixture.inputbridge.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.catfixture.inputbridge.R;

public final class EditableButtonCombinationElementBinding implements ViewBinding {
    public final Button addKey;
    public final RecyclerView combinationView;
    private final LinearLayout rootView;

    private EditableButtonCombinationElementBinding(LinearLayout linearLayout, Button button, RecyclerView recyclerView) {
        this.rootView = linearLayout;
        this.addKey = button;
        this.combinationView = recyclerView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static EditableButtonCombinationElementBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static EditableButtonCombinationElementBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.editable_button_combination_element, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static EditableButtonCombinationElementBinding bind(View view) {
        int i = R.id.addKey;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.addKey);
        if (button != null) {
            i = R.id.combinationView;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.combinationView);
            if (recyclerView != null) {
                return new EditableButtonCombinationElementBinding((LinearLayout) view, button, recyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
