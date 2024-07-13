package com.catfixture.inputbridge.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.catfixture.inputbridge.R;
import com.google.android.material.slider.RangeSlider;

public final class FragmentSensorsSettingsBinding implements ViewBinding {
    public final Spinner axisSelector;
    public final TextView axisSelectorLabel;
    public final Spinner axisType;
    public final LinearLayout bindingsView;
    public final Button calibratePosSensor;
    public final RangeSlider clampSlider;
    public final CheckBox enablePositionSensor;
    public final LinearLayout enabledCont;
    public final SeekBar gain;
    public final TextView gainSliderText;
    public final CheckBox invertAxis;
    public final Spinner latencyChooser;
    public final LinearLayout linearLayout;
    public final LinearLayout previewCont;
    public final ConstraintLayout previewSetupCont;
    private final LinearLayout rootView;
    public final Button selectXAxis;
    public final Button selectYAxis;
    public final Button selectZAxis;
    public final SeekBar sensitivity;
    public final TextView sensitivitySliderText;
    public final SeekBar smooth;
    public final TextView smoothSliderText;
    public final TextView xRotAxis;
    public final TextView yRotAxis;
    public final TextView zRotAxis;

    private FragmentSensorsSettingsBinding(LinearLayout linearLayout2, Spinner spinner, TextView textView, Spinner spinner2, LinearLayout linearLayout3, Button button, RangeSlider rangeSlider, CheckBox checkBox, LinearLayout linearLayout4, SeekBar seekBar, TextView textView2, CheckBox checkBox2, Spinner spinner3, LinearLayout linearLayout5, LinearLayout linearLayout6, ConstraintLayout constraintLayout, Button button2, Button button3, Button button4, SeekBar seekBar2, TextView textView3, SeekBar seekBar3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        this.rootView = linearLayout2;
        this.axisSelector = spinner;
        this.axisSelectorLabel = textView;
        this.axisType = spinner2;
        this.bindingsView = linearLayout3;
        this.calibratePosSensor = button;
        this.clampSlider = rangeSlider;
        this.enablePositionSensor = checkBox;
        this.enabledCont = linearLayout4;
        this.gain = seekBar;
        this.gainSliderText = textView2;
        this.invertAxis = checkBox2;
        this.latencyChooser = spinner3;
        this.linearLayout = linearLayout5;
        this.previewCont = linearLayout6;
        this.previewSetupCont = constraintLayout;
        this.selectXAxis = button2;
        this.selectYAxis = button3;
        this.selectZAxis = button4;
        this.sensitivity = seekBar2;
        this.sensitivitySliderText = textView3;
        this.smooth = seekBar3;
        this.smoothSliderText = textView4;
        this.xRotAxis = textView5;
        this.yRotAxis = textView6;
        this.zRotAxis = textView7;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentSensorsSettingsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentSensorsSettingsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_sensors_settings, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentSensorsSettingsBinding bind(View view) {
        View view2 = view;
        int i = R.id.axisSelector;
        Spinner spinner = (Spinner) ViewBindings.findChildViewById(view2, R.id.axisSelector);
        if (spinner != null) {
            i = R.id.axisSelectorLabel;
            TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.axisSelectorLabel);
            if (textView != null) {
                i = R.id.axisType;
                Spinner spinner2 = (Spinner) ViewBindings.findChildViewById(view2, R.id.axisType);
                if (spinner2 != null) {
                    i = R.id.bindingsView;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.bindingsView);
                    if (linearLayout2 != null) {
                        i = R.id.calibratePosSensor;
                        Button button = (Button) ViewBindings.findChildViewById(view2, R.id.calibratePosSensor);
                        if (button != null) {
                            i = R.id.clampSlider;
                            RangeSlider rangeSlider = (RangeSlider) ViewBindings.findChildViewById(view2, R.id.clampSlider);
                            if (rangeSlider != null) {
                                i = R.id.enablePositionSensor;
                                CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view2, R.id.enablePositionSensor);
                                if (checkBox != null) {
                                    i = R.id.enabledCont;
                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.enabledCont);
                                    if (linearLayout3 != null) {
                                        i = R.id.gain;
                                        SeekBar seekBar = (SeekBar) ViewBindings.findChildViewById(view2, R.id.gain);
                                        if (seekBar != null) {
                                            i = R.id.gainSliderText;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, R.id.gainSliderText);
                                            if (textView2 != null) {
                                                i = R.id.invertAxis;
                                                CheckBox checkBox2 = (CheckBox) ViewBindings.findChildViewById(view2, R.id.invertAxis);
                                                if (checkBox2 != null) {
                                                    i = R.id.latencyChooser;
                                                    Spinner spinner3 = (Spinner) ViewBindings.findChildViewById(view2, R.id.latencyChooser);
                                                    if (spinner3 != null) {
                                                        i = R.id.linearLayout;
                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.linearLayout);
                                                        if (linearLayout4 != null) {
                                                            i = R.id.previewCont;
                                                            LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.previewCont);
                                                            if (linearLayout5 != null) {
                                                                i = R.id.previewSetupCont;
                                                                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view2, R.id.previewSetupCont);
                                                                if (constraintLayout != null) {
                                                                    i = R.id.selectXAxis;
                                                                    Button button2 = (Button) ViewBindings.findChildViewById(view2, R.id.selectXAxis);
                                                                    if (button2 != null) {
                                                                        i = R.id.selectYAxis;
                                                                        Button button3 = (Button) ViewBindings.findChildViewById(view2, R.id.selectYAxis);
                                                                        if (button3 != null) {
                                                                            i = R.id.selectZAxis;
                                                                            Button button4 = (Button) ViewBindings.findChildViewById(view2, R.id.selectZAxis);
                                                                            if (button4 != null) {
                                                                                i = R.id.sensitivity;
                                                                                SeekBar seekBar2 = (SeekBar) ViewBindings.findChildViewById(view2, R.id.sensitivity);
                                                                                if (seekBar2 != null) {
                                                                                    i = R.id.sensitivitySliderText;
                                                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, R.id.sensitivitySliderText);
                                                                                    if (textView3 != null) {
                                                                                        i = R.id.smooth;
                                                                                        SeekBar seekBar3 = (SeekBar) ViewBindings.findChildViewById(view2, R.id.smooth);
                                                                                        if (seekBar3 != null) {
                                                                                            i = R.id.smoothSliderText;
                                                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, R.id.smoothSliderText);
                                                                                            if (textView4 != null) {
                                                                                                i = R.id.xRotAxis;
                                                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, R.id.xRotAxis);
                                                                                                if (textView5 != null) {
                                                                                                    i = R.id.yRotAxis;
                                                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view2, R.id.yRotAxis);
                                                                                                    if (textView6 != null) {
                                                                                                        i = R.id.zRotAxis;
                                                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view2, R.id.zRotAxis);
                                                                                                        if (textView7 != null) {
                                                                                                            return new FragmentSensorsSettingsBinding((LinearLayout) view2, spinner, textView, spinner2, linearLayout2, button, rangeSlider, checkBox, linearLayout3, seekBar, textView2, checkBox2, spinner3, linearLayout4, linearLayout5, constraintLayout, button2, button3, button4, seekBar2, textView3, seekBar3, textView4, textView5, textView6, textView7);
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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
