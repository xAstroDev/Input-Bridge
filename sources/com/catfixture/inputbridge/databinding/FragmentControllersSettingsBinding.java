package com.catfixture.inputbridge.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.ui.custom.WarningComponent;

public final class FragmentControllersSettingsBinding implements ViewBinding {
    public final RecyclerView controllersList;
    public final WarningComponent noControllersFound;
    private final LinearLayout rootView;

    private FragmentControllersSettingsBinding(LinearLayout linearLayout, RecyclerView recyclerView, WarningComponent warningComponent) {
        this.rootView = linearLayout;
        this.controllersList = recyclerView;
        this.noControllersFound = warningComponent;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentControllersSettingsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentControllersSettingsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_controllers_settings, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentControllersSettingsBinding bind(View view) {
        int i = R.id.controllersList;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.controllersList);
        if (recyclerView != null) {
            i = R.id.noControllersFound;
            WarningComponent warningComponent = (WarningComponent) ViewBindings.findChildViewById(view, R.id.noControllersFound);
            if (warningComponent != null) {
                return new FragmentControllersSettingsBinding((LinearLayout) view, recyclerView, warningComponent);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
