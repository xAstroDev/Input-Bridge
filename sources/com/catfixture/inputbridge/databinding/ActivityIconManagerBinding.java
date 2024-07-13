package com.catfixture.inputbridge.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.catfixture.inputbridge.R;

public final class ActivityIconManagerBinding implements ViewBinding {
    public final Button createNewIconPack;
    public final RecyclerView iconPacksView;
    public final Button installIconPack;
    public final TextView packsFoundCount;
    private final LinearLayout rootView;
    public final TextView textView6;

    private ActivityIconManagerBinding(LinearLayout linearLayout, Button button, RecyclerView recyclerView, Button button2, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.createNewIconPack = button;
        this.iconPacksView = recyclerView;
        this.installIconPack = button2;
        this.packsFoundCount = textView;
        this.textView6 = textView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityIconManagerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityIconManagerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_icon_manager, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityIconManagerBinding bind(View view) {
        int i = R.id.createNewIconPack;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.createNewIconPack);
        if (button != null) {
            i = R.id.iconPacksView;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.iconPacksView);
            if (recyclerView != null) {
                i = R.id.installIconPack;
                Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.installIconPack);
                if (button2 != null) {
                    i = R.id.packsFoundCount;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.packsFoundCount);
                    if (textView != null) {
                        i = R.id.textView6;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.textView6);
                        if (textView2 != null) {
                            return new ActivityIconManagerBinding((LinearLayout) view, button, recyclerView, button2, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
