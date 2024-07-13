package com.catfixture.inputbridge.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.catfixture.inputbridge.R;
import java.util.Objects;

public final class BasicSpinnerItemSpecOvBinding implements ViewBinding {
    private final TextView rootView;
    public final TextView text;

    private BasicSpinnerItemSpecOvBinding(TextView textView, TextView textView2) {
        this.rootView = textView;
        this.text = textView2;
    }

    public TextView getRoot() {
        return this.rootView;
    }

    public static BasicSpinnerItemSpecOvBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static BasicSpinnerItemSpecOvBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.basic_spinner_item_spec_ov, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static BasicSpinnerItemSpecOvBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        TextView textView = (TextView) view;
        return new BasicSpinnerItemSpecOvBinding(textView, textView);
    }
}
