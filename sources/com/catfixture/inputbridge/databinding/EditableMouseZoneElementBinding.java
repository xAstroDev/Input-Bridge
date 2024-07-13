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

public final class EditableMouseZoneElementBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final SeekBar sensivitySlider;
    public final TextView sensivitySliderText;

    private EditableMouseZoneElementBinding(LinearLayout linearLayout, SeekBar seekBar, TextView textView) {
        this.rootView = linearLayout;
        this.sensivitySlider = seekBar;
        this.sensivitySliderText = textView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static EditableMouseZoneElementBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static EditableMouseZoneElementBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.editable_mouse_zone_element, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static EditableMouseZoneElementBinding bind(View view) {
        int i = R.id.sensivitySlider;
        SeekBar seekBar = (SeekBar) ViewBindings.findChildViewById(view, R.id.sensivitySlider);
        if (seekBar != null) {
            i = R.id.sensivitySliderText;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.sensivitySliderText);
            if (textView != null) {
                return new EditableMouseZoneElementBinding((LinearLayout) view, seekBar, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
