package com.catfixture.inputbridge.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.catfixture.inputbridge.R;

public final class OverlayDialogFrameBinding implements ViewBinding {
    public final Button no;
    public final Button ok;
    private final LinearLayout rootView;
    public final TextView text;
    public final TextView title;

    private OverlayDialogFrameBinding(LinearLayout linearLayout, Button button, Button button2, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.no = button;
        this.ok = button2;
        this.text = textView;
        this.title = textView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static OverlayDialogFrameBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static OverlayDialogFrameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.overlay_dialog_frame, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static OverlayDialogFrameBinding bind(View view) {
        int i = R.id.no;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.no);
        if (button != null) {
            i = R.id.ok;
            Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.ok);
            if (button2 != null) {
                i = R.id.text;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.text);
                if (textView != null) {
                    i = R.id.title;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.title);
                    if (textView2 != null) {
                        return new OverlayDialogFrameBinding((LinearLayout) view, button, button2, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
