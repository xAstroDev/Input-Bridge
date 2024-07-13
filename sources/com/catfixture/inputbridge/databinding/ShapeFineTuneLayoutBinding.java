package com.catfixture.inputbridge.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.catfixture.inputbridge.R;

public final class ShapeFineTuneLayoutBinding implements ViewBinding {
    public final Button back;
    public final SeekBar cornerRadiusSlider;
    public final TextView cornerRadiusText;
    public final CheckBox enableFill;
    public final ColorPickerFieldLayoutBinding fillColor;
    private final LinearLayout rootView;
    public final ColorPickerFieldLayoutBinding strokeColor;
    public final TextView strokeWidthLabel;
    public final SeekBar strokeWidthSlider;

    private ShapeFineTuneLayoutBinding(LinearLayout linearLayout, Button button, SeekBar seekBar, TextView textView, CheckBox checkBox, ColorPickerFieldLayoutBinding colorPickerFieldLayoutBinding, ColorPickerFieldLayoutBinding colorPickerFieldLayoutBinding2, TextView textView2, SeekBar seekBar2) {
        this.rootView = linearLayout;
        this.back = button;
        this.cornerRadiusSlider = seekBar;
        this.cornerRadiusText = textView;
        this.enableFill = checkBox;
        this.fillColor = colorPickerFieldLayoutBinding;
        this.strokeColor = colorPickerFieldLayoutBinding2;
        this.strokeWidthLabel = textView2;
        this.strokeWidthSlider = seekBar2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ShapeFineTuneLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ShapeFineTuneLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.shape_fine_tune_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ShapeFineTuneLayoutBinding bind(View view) {
        int i = R.id.back;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.back);
        if (button != null) {
            i = R.id.cornerRadiusSlider;
            SeekBar seekBar = (SeekBar) ViewBindings.findChildViewById(view, R.id.cornerRadiusSlider);
            if (seekBar != null) {
                i = R.id.cornerRadiusText;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.cornerRadiusText);
                if (textView != null) {
                    i = R.id.enableFill;
                    CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.enableFill);
                    if (checkBox != null) {
                        i = R.id.fillColor;
                        View findChildViewById = ViewBindings.findChildViewById(view, R.id.fillColor);
                        if (findChildViewById != null) {
                            ColorPickerFieldLayoutBinding bind = ColorPickerFieldLayoutBinding.bind(findChildViewById);
                            i = R.id.strokeColor;
                            View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.strokeColor);
                            if (findChildViewById2 != null) {
                                ColorPickerFieldLayoutBinding bind2 = ColorPickerFieldLayoutBinding.bind(findChildViewById2);
                                i = R.id.strokeWidthLabel;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.strokeWidthLabel);
                                if (textView2 != null) {
                                    i = R.id.strokeWidthSlider;
                                    SeekBar seekBar2 = (SeekBar) ViewBindings.findChildViewById(view, R.id.strokeWidthSlider);
                                    if (seekBar2 != null) {
                                        return new ShapeFineTuneLayoutBinding((LinearLayout) view, button, seekBar, textView, checkBox, bind, bind2, textView2, seekBar2);
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
