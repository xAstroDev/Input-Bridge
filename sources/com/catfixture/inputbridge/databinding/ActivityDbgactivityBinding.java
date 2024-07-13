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

public final class ActivityDbgactivityBinding implements ViewBinding {
    public final Button clearAllLogs;
    public final Button clearLog;
    public final TextView logOut;
    private final LinearLayout rootView;
    public final Button saveLog;

    private ActivityDbgactivityBinding(LinearLayout linearLayout, Button button, Button button2, TextView textView, Button button3) {
        this.rootView = linearLayout;
        this.clearAllLogs = button;
        this.clearLog = button2;
        this.logOut = textView;
        this.saveLog = button3;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityDbgactivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityDbgactivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_dbgactivity, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityDbgactivityBinding bind(View view) {
        int i = R.id.clearAllLogs;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.clearAllLogs);
        if (button != null) {
            i = R.id.clearLog;
            Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.clearLog);
            if (button2 != null) {
                i = R.id.logOut;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.logOut);
                if (textView != null) {
                    i = R.id.saveLog;
                    Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.saveLog);
                    if (button3 != null) {
                        return new ActivityDbgactivityBinding((LinearLayout) view, button, button2, textView, button3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
