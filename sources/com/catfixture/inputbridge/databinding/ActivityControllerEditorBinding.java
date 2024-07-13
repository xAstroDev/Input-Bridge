package com.catfixture.inputbridge.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.catfixture.inputbridge.R;

public final class ActivityControllerEditorBinding implements ViewBinding {
    public final TextView deviceName;
    public final TextView deviceProps;
    public final View divider;
    public final View divider2;
    public final LinearLayout linearLayout2;
    public final ProgressBar ltForce;
    public final LinearLayout mappingView;
    public final TextView noSelection;
    public final ConstraintLayout relativeLayout;
    private final ConstraintLayout rootView;
    public final ProgressBar rtForce;
    public final Button saveExitButton;
    public final TextView selectedName;
    public final LinearLayout view;

    private ActivityControllerEditorBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, View view2, View view3, LinearLayout linearLayout, ProgressBar progressBar, LinearLayout linearLayout3, TextView textView3, ConstraintLayout constraintLayout2, ProgressBar progressBar2, Button button, TextView textView4, LinearLayout linearLayout4) {
        this.rootView = constraintLayout;
        this.deviceName = textView;
        this.deviceProps = textView2;
        this.divider = view2;
        this.divider2 = view3;
        this.linearLayout2 = linearLayout;
        this.ltForce = progressBar;
        this.mappingView = linearLayout3;
        this.noSelection = textView3;
        this.relativeLayout = constraintLayout2;
        this.rtForce = progressBar2;
        this.saveExitButton = button;
        this.selectedName = textView4;
        this.view = linearLayout4;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityControllerEditorBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityControllerEditorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_controller_editor, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityControllerEditorBinding bind(View view2) {
        View view3 = view2;
        int i = R.id.deviceName;
        TextView textView = (TextView) ViewBindings.findChildViewById(view3, R.id.deviceName);
        if (textView != null) {
            i = R.id.deviceProps;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view3, R.id.deviceProps);
            if (textView2 != null) {
                i = R.id.divider;
                View findChildViewById = ViewBindings.findChildViewById(view3, R.id.divider);
                if (findChildViewById != null) {
                    i = R.id.divider2;
                    View findChildViewById2 = ViewBindings.findChildViewById(view3, R.id.divider2);
                    if (findChildViewById2 != null) {
                        i = R.id.linearLayout2;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view3, R.id.linearLayout2);
                        if (linearLayout != null) {
                            i = R.id.ltForce;
                            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view3, R.id.ltForce);
                            if (progressBar != null) {
                                i = R.id.mappingView;
                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view3, R.id.mappingView);
                                if (linearLayout3 != null) {
                                    i = R.id.noSelection;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view3, R.id.noSelection);
                                    if (textView3 != null) {
                                        ConstraintLayout constraintLayout = (ConstraintLayout) view3;
                                        i = R.id.rtForce;
                                        ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(view3, R.id.rtForce);
                                        if (progressBar2 != null) {
                                            i = R.id.saveExitButton;
                                            Button button = (Button) ViewBindings.findChildViewById(view3, R.id.saveExitButton);
                                            if (button != null) {
                                                i = R.id.selectedName;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view3, R.id.selectedName);
                                                if (textView4 != null) {
                                                    i = R.id.view;
                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view3, R.id.view);
                                                    if (linearLayout4 != null) {
                                                        return new ActivityControllerEditorBinding(constraintLayout, textView, textView2, findChildViewById, findChildViewById2, linearLayout, progressBar, linearLayout3, textView3, constraintLayout, progressBar2, button, textView4, linearLayout4);
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
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
    }
}
