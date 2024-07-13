package com.catfixture.inputbridge.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.catfixture.inputbridge.R;

public final class GamepadDefaultSetupPromptBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final Button useEmpty;
    public final Button useWasd;
    public final Button useXI;

    private GamepadDefaultSetupPromptBinding(LinearLayout linearLayout, Button button, Button button2, Button button3) {
        this.rootView = linearLayout;
        this.useEmpty = button;
        this.useWasd = button2;
        this.useXI = button3;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static GamepadDefaultSetupPromptBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static GamepadDefaultSetupPromptBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.gamepad_default_setup_prompt, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static GamepadDefaultSetupPromptBinding bind(View view) {
        int i = R.id.useEmpty;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.useEmpty);
        if (button != null) {
            i = R.id.useWasd;
            Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.useWasd);
            if (button2 != null) {
                i = R.id.useXI;
                Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.useXI);
                if (button3 != null) {
                    return new GamepadDefaultSetupPromptBinding((LinearLayout) view, button, button2, button3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
