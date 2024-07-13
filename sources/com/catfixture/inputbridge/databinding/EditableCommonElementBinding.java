package com.catfixture.inputbridge.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.catfixture.inputbridge.R;

public final class EditableCommonElementBinding implements ViewBinding {
    public final Spinner controlType;
    public final SeekBar opacitySlider;
    public final TextView opacitySliderText;
    public final Button removeControl;
    private final LinearLayout rootView;
    public final SeekBar sizeSlider;
    public final TextView sizeSliderText;
    public final LinearLayout table;
    public final ScrollView touchElementSettingsScroll;

    private EditableCommonElementBinding(LinearLayout linearLayout, Spinner spinner, SeekBar seekBar, TextView textView, Button button, SeekBar seekBar2, TextView textView2, LinearLayout linearLayout2, ScrollView scrollView) {
        this.rootView = linearLayout;
        this.controlType = spinner;
        this.opacitySlider = seekBar;
        this.opacitySliderText = textView;
        this.removeControl = button;
        this.sizeSlider = seekBar2;
        this.sizeSliderText = textView2;
        this.table = linearLayout2;
        this.touchElementSettingsScroll = scrollView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static EditableCommonElementBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static EditableCommonElementBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.editable_common_element, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static EditableCommonElementBinding bind(View view) {
        int i = R.id.controlType;
        Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.controlType);
        if (spinner != null) {
            i = R.id.opacitySlider;
            SeekBar seekBar = (SeekBar) ViewBindings.findChildViewById(view, R.id.opacitySlider);
            if (seekBar != null) {
                i = R.id.opacitySliderText;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.opacitySliderText);
                if (textView != null) {
                    i = R.id.removeControl;
                    Button button = (Button) ViewBindings.findChildViewById(view, R.id.removeControl);
                    if (button != null) {
                        i = R.id.sizeSlider;
                        SeekBar seekBar2 = (SeekBar) ViewBindings.findChildViewById(view, R.id.sizeSlider);
                        if (seekBar2 != null) {
                            i = R.id.sizeSliderText;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.sizeSliderText);
                            if (textView2 != null) {
                                i = R.id.table;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.table);
                                if (linearLayout != null) {
                                    i = R.id.touch_element_settings_scroll;
                                    ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, R.id.touch_element_settings_scroll);
                                    if (scrollView != null) {
                                        return new EditableCommonElementBinding((LinearLayout) view, spinner, seekBar, textView, button, seekBar2, textView2, linearLayout, scrollView);
                                    }
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
