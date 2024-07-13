package com.catfixture.inputbridge.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.catfixture.inputbridge.R;

public final class ActivityManualBinding implements ViewBinding {
    public final ImageView imageView;
    public final LinearLayout parentLayout;
    private final LinearLayout rootView;
    public final TextView textView10;
    public final TextView textView11;
    public final TextView textView13;
    public final TextView textView14;
    public final TextView textView15;
    public final TextView textView16;
    public final TextView textView17;
    public final TextView textView18;
    public final TextView textView19;
    public final TextView textView20;
    public final TextView textView21;
    public final TextView textView22;
    public final TextView textView25;
    public final TextView textView4;
    public final TextView textView5;

    private ActivityManualBinding(LinearLayout linearLayout, ImageView imageView2, LinearLayout linearLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView12, TextView textView23, TextView textView24, TextView textView26, TextView textView27, TextView textView28, TextView textView29, TextView textView30) {
        this.rootView = linearLayout;
        this.imageView = imageView2;
        this.parentLayout = linearLayout2;
        this.textView10 = textView;
        this.textView11 = textView2;
        this.textView13 = textView3;
        this.textView14 = textView6;
        this.textView15 = textView7;
        this.textView16 = textView8;
        this.textView17 = textView9;
        this.textView18 = textView12;
        this.textView19 = textView23;
        this.textView20 = textView24;
        this.textView21 = textView26;
        this.textView22 = textView27;
        this.textView25 = textView28;
        this.textView4 = textView29;
        this.textView5 = textView30;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityManualBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityManualBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_manual, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityManualBinding bind(View view) {
        View view2 = view;
        int i = R.id.imageView;
        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.imageView);
        if (imageView2 != null) {
            LinearLayout linearLayout = (LinearLayout) view2;
            i = R.id.textView10;
            TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.textView10);
            if (textView != null) {
                i = R.id.textView11;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, R.id.textView11);
                if (textView2 != null) {
                    i = R.id.textView13;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, R.id.textView13);
                    if (textView3 != null) {
                        i = R.id.textView14;
                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view2, R.id.textView14);
                        if (textView6 != null) {
                            i = R.id.textView15;
                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view2, R.id.textView15);
                            if (textView7 != null) {
                                i = R.id.textView16;
                                TextView textView8 = (TextView) ViewBindings.findChildViewById(view2, R.id.textView16);
                                if (textView8 != null) {
                                    i = R.id.textView17;
                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(view2, R.id.textView17);
                                    if (textView9 != null) {
                                        i = R.id.textView18;
                                        TextView textView12 = (TextView) ViewBindings.findChildViewById(view2, R.id.textView18);
                                        if (textView12 != null) {
                                            i = R.id.textView19;
                                            TextView textView23 = (TextView) ViewBindings.findChildViewById(view2, R.id.textView19);
                                            if (textView23 != null) {
                                                i = R.id.textView20;
                                                TextView textView24 = (TextView) ViewBindings.findChildViewById(view2, R.id.textView20);
                                                if (textView24 != null) {
                                                    i = R.id.textView21;
                                                    TextView textView26 = (TextView) ViewBindings.findChildViewById(view2, R.id.textView21);
                                                    if (textView26 != null) {
                                                        i = R.id.textView22;
                                                        TextView textView27 = (TextView) ViewBindings.findChildViewById(view2, R.id.textView22);
                                                        if (textView27 != null) {
                                                            i = R.id.textView25;
                                                            TextView textView28 = (TextView) ViewBindings.findChildViewById(view2, R.id.textView25);
                                                            if (textView28 != null) {
                                                                i = R.id.textView4;
                                                                TextView textView29 = (TextView) ViewBindings.findChildViewById(view2, R.id.textView4);
                                                                if (textView29 != null) {
                                                                    i = R.id.textView5;
                                                                    TextView textView30 = (TextView) ViewBindings.findChildViewById(view2, R.id.textView5);
                                                                    if (textView30 != null) {
                                                                        return new ActivityManualBinding(linearLayout, imageView2, linearLayout, textView, textView2, textView3, textView6, textView7, textView8, textView9, textView12, textView23, textView24, textView26, textView27, textView28, textView29, textView30);
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
