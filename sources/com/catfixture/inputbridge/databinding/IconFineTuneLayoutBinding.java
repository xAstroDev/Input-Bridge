package com.catfixture.inputbridge.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.catfixture.inputbridge.R;

public final class IconFineTuneLayoutBinding implements ViewBinding {
    public final Button back;
    public final TextView positionText;
    public final SeekBar positionX;
    public final SeekBar positionY;
    private final LinearLayout rootView;
    public final TextView scaleLabel;
    public final SeekBar scaleSlider;
    public final ColorPickerFieldLayoutBinding tintColor;

    private IconFineTuneLayoutBinding(LinearLayout linearLayout, Button button, TextView textView, SeekBar seekBar, SeekBar seekBar2, TextView textView2, SeekBar seekBar3, ColorPickerFieldLayoutBinding colorPickerFieldLayoutBinding) {
        this.rootView = linearLayout;
        this.back = button;
        this.positionText = textView;
        this.positionX = seekBar;
        this.positionY = seekBar2;
        this.scaleLabel = textView2;
        this.scaleSlider = seekBar3;
        this.tintColor = colorPickerFieldLayoutBinding;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static IconFineTuneLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IconFineTuneLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.icon_fine_tune_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static IconFineTuneLayoutBinding bind(View view) {
        int i = R.id.back;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.back);
        if (button != null) {
            i = R.id.positionText;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.positionText);
            if (textView != null) {
                i = R.id.positionX;
                SeekBar seekBar = (SeekBar) ViewBindings.findChildViewById(view, R.id.positionX);
                if (seekBar != null) {
                    i = R.id.positionY;
                    SeekBar seekBar2 = (SeekBar) ViewBindings.findChildViewById(view, R.id.positionY);
                    if (seekBar2 != null) {
                        i = R.id.scaleLabel;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.scaleLabel);
                        if (textView2 != null) {
                            i = R.id.scaleSlider;
                            SeekBar seekBar3 = (SeekBar) ViewBindings.findChildViewById(view, R.id.scaleSlider);
                            if (seekBar3 != null) {
                                i = R.id.tintColor;
                                View findChildViewById = ViewBindings.findChildViewById(view, R.id.tintColor);
                                if (findChildViewById != null) {
                                    return new IconFineTuneLayoutBinding((LinearLayout) view, button, textView, seekBar, seekBar2, textView2, seekBar3, ColorPickerFieldLayoutBinding.bind(findChildViewById));
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
