package com.catfixture.inputbridge.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.catfixture.inputbridge.R;

public final class OverlayActionProgressFrameBinding implements ViewBinding {
    public final TextView currentTask;
    public final ProgressBar progressBar;
    public final ProgressBar progressBar2;
    private final LinearLayout rootView;
    public final Button stopOk;
    public final TextView title;

    private OverlayActionProgressFrameBinding(LinearLayout linearLayout, TextView textView, ProgressBar progressBar3, ProgressBar progressBar4, Button button, TextView textView2) {
        this.rootView = linearLayout;
        this.currentTask = textView;
        this.progressBar = progressBar3;
        this.progressBar2 = progressBar4;
        this.stopOk = button;
        this.title = textView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static OverlayActionProgressFrameBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static OverlayActionProgressFrameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.overlay_action_progress_frame, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static OverlayActionProgressFrameBinding bind(View view) {
        int i = R.id.currentTask;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.currentTask);
        if (textView != null) {
            i = R.id.progressBar;
            ProgressBar progressBar3 = (ProgressBar) ViewBindings.findChildViewById(view, R.id.progressBar);
            if (progressBar3 != null) {
                i = R.id.progressBar2;
                ProgressBar progressBar4 = (ProgressBar) ViewBindings.findChildViewById(view, R.id.progressBar2);
                if (progressBar4 != null) {
                    i = R.id.stopOk;
                    Button button = (Button) ViewBindings.findChildViewById(view, R.id.stopOk);
                    if (button != null) {
                        i = R.id.title;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.title);
                        if (textView2 != null) {
                            return new OverlayActionProgressFrameBinding((LinearLayout) view, textView, progressBar3, progressBar4, button, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
