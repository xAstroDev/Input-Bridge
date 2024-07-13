package com.catfixture.inputbridge.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.catfixture.inputbridge.R;

public final class EditableScrollElementBinding implements ViewBinding {
    public final SeekBar heightSlider;
    public final TextView heightSliderText;
    private final LinearLayout rootView;
    public final SeekBar sensivitySlider;
    public final TextView sensivitySliderText;

    private EditableScrollElementBinding(LinearLayout linearLayout, SeekBar seekBar, TextView textView, SeekBar seekBar2, TextView textView2) {
        this.rootView = linearLayout;
        this.heightSlider = seekBar;
        this.heightSliderText = textView;
        this.sensivitySlider = seekBar2;
        this.sensivitySliderText = textView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static EditableScrollElementBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static EditableScrollElementBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.editable_scroll_element, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static EditableScrollElementBinding bind(View view) {
        int i = R.id.heightSlider;
        SeekBar seekBar = (SeekBar) ViewBindings.findChildViewById(view, R.id.heightSlider);
        if (seekBar != null) {
            i = R.id.heightSliderText;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.heightSliderText);
            if (textView != null) {
                i = R.id.sensivitySlider;
                SeekBar seekBar2 = (SeekBar) ViewBindings.findChildViewById(view, R.id.sensivitySlider);
                if (seekBar2 != null) {
                    i = R.id.sensivitySliderText;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.sensivitySliderText);
                    if (textView2 != null) {
                        return new EditableScrollElementBinding((LinearLayout) view, seekBar, textView, seekBar2, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
