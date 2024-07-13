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

public final class ActivityIconsViewBinding implements ViewBinding {
    public final Button addAllFromFolder;
    public final Button addNewIcon;
    public final Button exportIconPack;
    public final RecyclerView iconsView;
    public final TextView packsContainsImagesCount;
    private final LinearLayout rootView;
    public final TextView textView6;

    private ActivityIconsViewBinding(LinearLayout linearLayout, Button button, Button button2, Button button3, RecyclerView recyclerView, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.addAllFromFolder = button;
        this.addNewIcon = button2;
        this.exportIconPack = button3;
        this.iconsView = recyclerView;
        this.packsContainsImagesCount = textView;
        this.textView6 = textView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityIconsViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityIconsViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_icons_view, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityIconsViewBinding bind(View view) {
        int i = R.id.addAllFromFolder;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.addAllFromFolder);
        if (button != null) {
            i = R.id.addNewIcon;
            Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.addNewIcon);
            if (button2 != null) {
                i = R.id.exportIconPack;
                Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.exportIconPack);
                if (button3 != null) {
                    i = R.id.iconsView;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.iconsView);
                    if (recyclerView != null) {
                        i = R.id.packsContainsImagesCount;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.packsContainsImagesCount);
                        if (textView != null) {
                            i = R.id.textView6;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.textView6);
                            if (textView2 != null) {
                                return new ActivityIconsViewBinding((LinearLayout) view, button, button2, button3, recyclerView, textView, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
