package com.catfixture.inputbridge.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.catfixture.inputbridge.R;

public final class FineTuneEditorShadowLayoutBinding implements ViewBinding {
    public final CheckBox drawShadow;
    private final LinearLayout rootView;
    public final SeekBar shadowRadius;

    private FineTuneEditorShadowLayoutBinding(LinearLayout linearLayout, CheckBox checkBox, SeekBar seekBar) {
        this.rootView = linearLayout;
        this.drawShadow = checkBox;
        this.shadowRadius = seekBar;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FineTuneEditorShadowLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FineTuneEditorShadowLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fine_tune_editor_shadow_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FineTuneEditorShadowLayoutBinding bind(View view) {
        int i = R.id.drawShadow;
        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.drawShadow);
        if (checkBox != null) {
            i = R.id.shadowRadius;
            SeekBar seekBar = (SeekBar) ViewBindings.findChildViewById(view, R.id.shadowRadius);
            if (seekBar != null) {
                return new FineTuneEditorShadowLayoutBinding((LinearLayout) view, checkBox, seekBar);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
