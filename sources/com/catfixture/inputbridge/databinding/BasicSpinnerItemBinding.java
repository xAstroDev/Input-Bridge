package com.catfixture.inputbridge.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.catfixture.inputbridge.R;
import java.util.Objects;

public final class BasicSpinnerItemBinding implements ViewBinding {
    private final TextView rootView;

    private BasicSpinnerItemBinding(TextView textView) {
        this.rootView = textView;
    }

    public TextView getRoot() {
        return this.rootView;
    }

    public static BasicSpinnerItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static BasicSpinnerItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.basic_spinner_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static BasicSpinnerItemBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        return new BasicSpinnerItemBinding((TextView) view);
    }
}
