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

public final class FragmentPerformanceSettingsBinding implements ViewBinding {
    public final Button addSensor;
    public final TextView buttonEngineRateText;
    public final CheckBox filterActions;
    public final CheckBox forceEvents;
    public final SeekBar gssFontSize;
    public final SeekBar ibDriverRate;
    public final TextView ibDriverRateText;
    public final SeekBar pipeRate;
    private final LinearLayout rootView;
    public final CheckBox showRAM;

    private FragmentPerformanceSettingsBinding(LinearLayout linearLayout, Button button, TextView textView, CheckBox checkBox, CheckBox checkBox2, SeekBar seekBar, SeekBar seekBar2, TextView textView2, SeekBar seekBar3, CheckBox checkBox3) {
        this.rootView = linearLayout;
        this.addSensor = button;
        this.buttonEngineRateText = textView;
        this.filterActions = checkBox;
        this.forceEvents = checkBox2;
        this.gssFontSize = seekBar;
        this.ibDriverRate = seekBar2;
        this.ibDriverRateText = textView2;
        this.pipeRate = seekBar3;
        this.showRAM = checkBox3;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentPerformanceSettingsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentPerformanceSettingsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_performance_settings, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentPerformanceSettingsBinding bind(View view) {
        int i = R.id.addSensor;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.addSensor);
        if (button != null) {
            i = R.id.buttonEngineRateText;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.buttonEngineRateText);
            if (textView != null) {
                i = R.id.filterActions;
                CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.filterActions);
                if (checkBox != null) {
                    i = R.id.forceEvents;
                    CheckBox checkBox2 = (CheckBox) ViewBindings.findChildViewById(view, R.id.forceEvents);
                    if (checkBox2 != null) {
                        i = R.id.gssFontSize;
                        SeekBar seekBar = (SeekBar) ViewBindings.findChildViewById(view, R.id.gssFontSize);
                        if (seekBar != null) {
                            i = R.id.ibDriverRate;
                            SeekBar seekBar2 = (SeekBar) ViewBindings.findChildViewById(view, R.id.ibDriverRate);
                            if (seekBar2 != null) {
                                i = R.id.ibDriverRateText;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.ibDriverRateText);
                                if (textView2 != null) {
                                    i = R.id.pipeRate;
                                    SeekBar seekBar3 = (SeekBar) ViewBindings.findChildViewById(view, R.id.pipeRate);
                                    if (seekBar3 != null) {
                                        i = R.id.showRAM;
                                        CheckBox checkBox3 = (CheckBox) ViewBindings.findChildViewById(view, R.id.showRAM);
                                        if (checkBox3 != null) {
                                            return new FragmentPerformanceSettingsBinding((LinearLayout) view, button, textView, checkBox, checkBox2, seekBar, seekBar2, textView2, seekBar3, checkBox3);
                                        }
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
