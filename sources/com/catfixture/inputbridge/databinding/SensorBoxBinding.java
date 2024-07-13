package com.catfixture.inputbridge.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.catfixture.inputbridge.R;

public final class SensorBoxBinding implements ViewBinding {
    public final Spinner displayName;
    public final Spinner displayPostfix;
    public final CheckBox enableSensor;
    public final TextView path;
    public final ColorPickerDarkFieldLayoutBinding pcolorSelector;
    private final LinearLayout rootView;
    public final ColorPickerDarkFieldLayoutBinding scolorSelector;
    public final TextView type;
    public final TextView valuePreview;

    private SensorBoxBinding(LinearLayout linearLayout, Spinner spinner, Spinner spinner2, CheckBox checkBox, TextView textView, ColorPickerDarkFieldLayoutBinding colorPickerDarkFieldLayoutBinding, ColorPickerDarkFieldLayoutBinding colorPickerDarkFieldLayoutBinding2, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.displayName = spinner;
        this.displayPostfix = spinner2;
        this.enableSensor = checkBox;
        this.path = textView;
        this.pcolorSelector = colorPickerDarkFieldLayoutBinding;
        this.scolorSelector = colorPickerDarkFieldLayoutBinding2;
        this.type = textView2;
        this.valuePreview = textView3;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SensorBoxBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static SensorBoxBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.sensor_box, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static SensorBoxBinding bind(View view) {
        int i = R.id.displayName;
        Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.displayName);
        if (spinner != null) {
            i = R.id.displayPostfix;
            Spinner spinner2 = (Spinner) ViewBindings.findChildViewById(view, R.id.displayPostfix);
            if (spinner2 != null) {
                i = R.id.enableSensor;
                CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.enableSensor);
                if (checkBox != null) {
                    i = R.id.path;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.path);
                    if (textView != null) {
                        i = R.id.pcolorSelector;
                        View findChildViewById = ViewBindings.findChildViewById(view, R.id.pcolorSelector);
                        if (findChildViewById != null) {
                            ColorPickerDarkFieldLayoutBinding bind = ColorPickerDarkFieldLayoutBinding.bind(findChildViewById);
                            i = R.id.scolorSelector;
                            View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.scolorSelector);
                            if (findChildViewById2 != null) {
                                ColorPickerDarkFieldLayoutBinding bind2 = ColorPickerDarkFieldLayoutBinding.bind(findChildViewById2);
                                i = R.id.type;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.type);
                                if (textView2 != null) {
                                    i = R.id.valuePreview;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.valuePreview);
                                    if (textView3 != null) {
                                        return new SensorBoxBinding((LinearLayout) view, spinner, spinner2, checkBox, textView, bind, bind2, textView2, textView3);
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
