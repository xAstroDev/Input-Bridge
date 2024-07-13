package com.catfixture.inputbridge.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.catfixture.inputbridge.R;

public final class TextFineTuneLayoutBinding implements ViewBinding {
    public final Button back;
    public final ColorPickerFieldLayoutBinding fontColor;
    public final Spinner fontWeight;
    public final TextView positionText;
    public final SeekBar positionX;
    public final SeekBar positionY;
    private final LinearLayout rootView;
    public final TextView scaleLabel;
    public final SeekBar scaleSlider;

    private TextFineTuneLayoutBinding(LinearLayout linearLayout, Button button, ColorPickerFieldLayoutBinding colorPickerFieldLayoutBinding, Spinner spinner, TextView textView, SeekBar seekBar, SeekBar seekBar2, TextView textView2, SeekBar seekBar3) {
        this.rootView = linearLayout;
        this.back = button;
        this.fontColor = colorPickerFieldLayoutBinding;
        this.fontWeight = spinner;
        this.positionText = textView;
        this.positionX = seekBar;
        this.positionY = seekBar2;
        this.scaleLabel = textView2;
        this.scaleSlider = seekBar3;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TextFineTuneLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static TextFineTuneLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.text_fine_tune_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TextFineTuneLayoutBinding bind(View view) {
        int i = R.id.back;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.back);
        if (button != null) {
            i = R.id.fontColor;
            View findChildViewById = ViewBindings.findChildViewById(view, R.id.fontColor);
            if (findChildViewById != null) {
                ColorPickerFieldLayoutBinding bind = ColorPickerFieldLayoutBinding.bind(findChildViewById);
                i = R.id.fontWeight;
                Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.fontWeight);
                if (spinner != null) {
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
                                        return new TextFineTuneLayoutBinding((LinearLayout) view, button, bind, spinner, textView, seekBar, seekBar2, textView2, seekBar3);
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
