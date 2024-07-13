package com.catfixture.inputbridge.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.catfixture.inputbridge.R;
import java.util.Objects;

public final class TouchControlsListItemBinding implements ViewBinding {
    private final TextView rootView;

    private TouchControlsListItemBinding(TextView textView) {
        this.rootView = textView;
    }

    public TextView getRoot() {
        return this.rootView;
    }

    public static TouchControlsListItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static TouchControlsListItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.touch_controls_list_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TouchControlsListItemBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        return new TouchControlsListItemBinding((TextView) view);
    }
}
