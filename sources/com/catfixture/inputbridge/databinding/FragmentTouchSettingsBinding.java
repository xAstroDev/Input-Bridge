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
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.ui.custom.WarningComponent;

public final class FragmentTouchSettingsBinding implements ViewBinding {
    public final WarningComponent acsNotLaunchedWarn;
    public final Button editControls;
    public final CheckBox enableTouchRumble;
    public final CheckBox enableXInput;
    public final CheckBox enableXInputRumble;
    public final CheckBox hideTouchControls;
    public final CheckBox icHidePanels;
    public final CheckBox icMaximize;
    public final LinearLayout icmp;
    public final CheckBox integrateControls;
    public final Spinner integrateControlsType;
    public final Button openAccessSettings;
    public final Button repairOldProfile;
    private final LinearLayout rootView;
    public final SeekBar rumbleImputusTime;
    public final TextView rumbleImputusTimeLabel;
    public final CheckBox showControlsWhenConnected;
    public final CheckBox showXIFPS;
    public final LinearLayout touchRumbleCont;
    public final LinearLayout xInputCont;

    private FragmentTouchSettingsBinding(LinearLayout linearLayout, WarningComponent warningComponent, Button button, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, CheckBox checkBox5, CheckBox checkBox6, LinearLayout linearLayout2, CheckBox checkBox7, Spinner spinner, Button button2, Button button3, SeekBar seekBar, TextView textView, CheckBox checkBox8, CheckBox checkBox9, LinearLayout linearLayout3, LinearLayout linearLayout4) {
        this.rootView = linearLayout;
        this.acsNotLaunchedWarn = warningComponent;
        this.editControls = button;
        this.enableTouchRumble = checkBox;
        this.enableXInput = checkBox2;
        this.enableXInputRumble = checkBox3;
        this.hideTouchControls = checkBox4;
        this.icHidePanels = checkBox5;
        this.icMaximize = checkBox6;
        this.icmp = linearLayout2;
        this.integrateControls = checkBox7;
        this.integrateControlsType = spinner;
        this.openAccessSettings = button2;
        this.repairOldProfile = button3;
        this.rumbleImputusTime = seekBar;
        this.rumbleImputusTimeLabel = textView;
        this.showControlsWhenConnected = checkBox8;
        this.showXIFPS = checkBox9;
        this.touchRumbleCont = linearLayout3;
        this.xInputCont = linearLayout4;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentTouchSettingsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentTouchSettingsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_touch_settings, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentTouchSettingsBinding bind(View view) {
        View view2 = view;
        int i = R.id.acsNotLaunchedWarn;
        WarningComponent warningComponent = (WarningComponent) ViewBindings.findChildViewById(view2, R.id.acsNotLaunchedWarn);
        if (warningComponent != null) {
            i = R.id.editControls;
            Button button = (Button) ViewBindings.findChildViewById(view2, R.id.editControls);
            if (button != null) {
                i = R.id.enableTouchRumble;
                CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view2, R.id.enableTouchRumble);
                if (checkBox != null) {
                    i = R.id.enableXInput;
                    CheckBox checkBox2 = (CheckBox) ViewBindings.findChildViewById(view2, R.id.enableXInput);
                    if (checkBox2 != null) {
                        i = R.id.enableXInputRumble;
                        CheckBox checkBox3 = (CheckBox) ViewBindings.findChildViewById(view2, R.id.enableXInputRumble);
                        if (checkBox3 != null) {
                            i = R.id.hideTouchControls;
                            CheckBox checkBox4 = (CheckBox) ViewBindings.findChildViewById(view2, R.id.hideTouchControls);
                            if (checkBox4 != null) {
                                i = R.id.icHidePanels;
                                CheckBox checkBox5 = (CheckBox) ViewBindings.findChildViewById(view2, R.id.icHidePanels);
                                if (checkBox5 != null) {
                                    i = R.id.icMaximize;
                                    CheckBox checkBox6 = (CheckBox) ViewBindings.findChildViewById(view2, R.id.icMaximize);
                                    if (checkBox6 != null) {
                                        i = R.id.icmp;
                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.icmp);
                                        if (linearLayout != null) {
                                            i = R.id.integrateControls;
                                            CheckBox checkBox7 = (CheckBox) ViewBindings.findChildViewById(view2, R.id.integrateControls);
                                            if (checkBox7 != null) {
                                                i = R.id.integrateControlsType;
                                                Spinner spinner = (Spinner) ViewBindings.findChildViewById(view2, R.id.integrateControlsType);
                                                if (spinner != null) {
                                                    i = R.id.openAccessSettings;
                                                    Button button2 = (Button) ViewBindings.findChildViewById(view2, R.id.openAccessSettings);
                                                    if (button2 != null) {
                                                        i = R.id.repairOldProfile;
                                                        Button button3 = (Button) ViewBindings.findChildViewById(view2, R.id.repairOldProfile);
                                                        if (button3 != null) {
                                                            i = R.id.rumbleImputusTime;
                                                            SeekBar seekBar = (SeekBar) ViewBindings.findChildViewById(view2, R.id.rumbleImputusTime);
                                                            if (seekBar != null) {
                                                                i = R.id.rumbleImputusTimeLabel;
                                                                TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.rumbleImputusTimeLabel);
                                                                if (textView != null) {
                                                                    i = R.id.showControlsWhenConnected;
                                                                    CheckBox checkBox8 = (CheckBox) ViewBindings.findChildViewById(view2, R.id.showControlsWhenConnected);
                                                                    if (checkBox8 != null) {
                                                                        i = R.id.showXIFPS;
                                                                        CheckBox checkBox9 = (CheckBox) ViewBindings.findChildViewById(view2, R.id.showXIFPS);
                                                                        if (checkBox9 != null) {
                                                                            i = R.id.touchRumbleCont;
                                                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.touchRumbleCont);
                                                                            if (linearLayout2 != null) {
                                                                                i = R.id.xInputCont;
                                                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.xInputCont);
                                                                                if (linearLayout3 != null) {
                                                                                    return new FragmentTouchSettingsBinding((LinearLayout) view2, warningComponent, button, checkBox, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, linearLayout, checkBox7, spinner, button2, button3, seekBar, textView, checkBox8, checkBox9, linearLayout2, linearLayout3);
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
