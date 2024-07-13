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

public final class ControllerRebindingBinding implements ViewBinding {
    public final LinearLayout borderView;
    public final KeyboardBindingBinding buttonRebindingCont;
    public final SeekBar deadZoneSlider;
    public final TextView deadZoneSliderText;
    public final LinearLayout motionRebindingCont;
    public final Spinner motionType;
    public final LinearLayout multibindCont;
    public final KeyboardBindingBinding negBindCont;
    public final KeyboardBindingBinding posBindCont;
    public final TextView rebLab;
    public final Button remove;
    private final LinearLayout rootView;
    public final SeekBar sensivitySlider;
    public final TextView sensivitySliderText;

    private ControllerRebindingBinding(LinearLayout linearLayout, LinearLayout linearLayout2, KeyboardBindingBinding keyboardBindingBinding, SeekBar seekBar, TextView textView, LinearLayout linearLayout3, Spinner spinner, LinearLayout linearLayout4, KeyboardBindingBinding keyboardBindingBinding2, KeyboardBindingBinding keyboardBindingBinding3, TextView textView2, Button button, SeekBar seekBar2, TextView textView3) {
        this.rootView = linearLayout;
        this.borderView = linearLayout2;
        this.buttonRebindingCont = keyboardBindingBinding;
        this.deadZoneSlider = seekBar;
        this.deadZoneSliderText = textView;
        this.motionRebindingCont = linearLayout3;
        this.motionType = spinner;
        this.multibindCont = linearLayout4;
        this.negBindCont = keyboardBindingBinding2;
        this.posBindCont = keyboardBindingBinding3;
        this.rebLab = textView2;
        this.remove = button;
        this.sensivitySlider = seekBar2;
        this.sensivitySliderText = textView3;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ControllerRebindingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ControllerRebindingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.controller_rebinding, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ControllerRebindingBinding bind(View view) {
        View view2 = view;
        int i = R.id.borderView;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.borderView);
        if (linearLayout != null) {
            i = R.id.buttonRebindingCont;
            View findChildViewById = ViewBindings.findChildViewById(view2, R.id.buttonRebindingCont);
            if (findChildViewById != null) {
                KeyboardBindingBinding bind = KeyboardBindingBinding.bind(findChildViewById);
                i = R.id.deadZoneSlider;
                SeekBar seekBar = (SeekBar) ViewBindings.findChildViewById(view2, R.id.deadZoneSlider);
                if (seekBar != null) {
                    i = R.id.deadZoneSliderText;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.deadZoneSliderText);
                    if (textView != null) {
                        i = R.id.motionRebindingCont;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.motionRebindingCont);
                        if (linearLayout2 != null) {
                            i = R.id.motionType;
                            Spinner spinner = (Spinner) ViewBindings.findChildViewById(view2, R.id.motionType);
                            if (spinner != null) {
                                i = R.id.multibindCont;
                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.multibindCont);
                                if (linearLayout3 != null) {
                                    i = R.id.negBindCont;
                                    View findChildViewById2 = ViewBindings.findChildViewById(view2, R.id.negBindCont);
                                    if (findChildViewById2 != null) {
                                        KeyboardBindingBinding bind2 = KeyboardBindingBinding.bind(findChildViewById2);
                                        i = R.id.posBindCont;
                                        View findChildViewById3 = ViewBindings.findChildViewById(view2, R.id.posBindCont);
                                        if (findChildViewById3 != null) {
                                            KeyboardBindingBinding bind3 = KeyboardBindingBinding.bind(findChildViewById3);
                                            i = R.id.rebLab;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, R.id.rebLab);
                                            if (textView2 != null) {
                                                i = R.id.remove;
                                                Button button = (Button) ViewBindings.findChildViewById(view2, R.id.remove);
                                                if (button != null) {
                                                    i = R.id.sensivitySlider;
                                                    SeekBar seekBar2 = (SeekBar) ViewBindings.findChildViewById(view2, R.id.sensivitySlider);
                                                    if (seekBar2 != null) {
                                                        i = R.id.sensivitySliderText;
                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, R.id.sensivitySliderText);
                                                        if (textView3 != null) {
                                                            return new ControllerRebindingBinding((LinearLayout) view2, linearLayout, bind, seekBar, textView, linearLayout2, spinner, linearLayout3, bind2, bind3, textView2, button, seekBar2, textView3);
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
