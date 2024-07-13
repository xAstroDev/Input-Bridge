package com.catfixture.inputbridge.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.catfixture.inputbridge.R;

public final class EditableSwipeElementBinding implements ViewBinding {
    public final Spinner codeDown;
    public final Spinner codeLeft;
    public final Spinner codeRight;
    public final Spinner codeUp;
    public final CheckBox eightDirMode;
    private final LinearLayout rootView;
    public final SeekBar swipeMinDistanceSlider;
    public final TextView swipeMinDistanceText;

    private EditableSwipeElementBinding(LinearLayout linearLayout, Spinner spinner, Spinner spinner2, Spinner spinner3, Spinner spinner4, CheckBox checkBox, SeekBar seekBar, TextView textView) {
        this.rootView = linearLayout;
        this.codeDown = spinner;
        this.codeLeft = spinner2;
        this.codeRight = spinner3;
        this.codeUp = spinner4;
        this.eightDirMode = checkBox;
        this.swipeMinDistanceSlider = seekBar;
        this.swipeMinDistanceText = textView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static EditableSwipeElementBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static EditableSwipeElementBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.editable_swipe_element, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static EditableSwipeElementBinding bind(View view) {
        int i = R.id.codeDown;
        Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.codeDown);
        if (spinner != null) {
            i = R.id.codeLeft;
            Spinner spinner2 = (Spinner) ViewBindings.findChildViewById(view, R.id.codeLeft);
            if (spinner2 != null) {
                i = R.id.codeRight;
                Spinner spinner3 = (Spinner) ViewBindings.findChildViewById(view, R.id.codeRight);
                if (spinner3 != null) {
                    i = R.id.codeUp;
                    Spinner spinner4 = (Spinner) ViewBindings.findChildViewById(view, R.id.codeUp);
                    if (spinner4 != null) {
                        i = R.id.eightDirMode;
                        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.eightDirMode);
                        if (checkBox != null) {
                            i = R.id.swipeMinDistanceSlider;
                            SeekBar seekBar = (SeekBar) ViewBindings.findChildViewById(view, R.id.swipeMinDistanceSlider);
                            if (seekBar != null) {
                                i = R.id.swipeMinDistanceText;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.swipeMinDistanceText);
                                if (textView != null) {
                                    return new EditableSwipeElementBinding((LinearLayout) view, spinner, spinner2, spinner3, spinner4, checkBox, seekBar, textView);
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
