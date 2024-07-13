package com.catfixture.inputbridge.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.ui.custom.Chapter;

public final class FragmentHelpBinding implements ViewBinding {
    public final LinearLayout authorChapter;
    public final Button dbg;
    public final ImageView discordHook;
    public final Button manualButton;
    private final LinearLayout rootView;
    public final TextView textView3;
    public final Chapter thankChapter;
    public final TextView thanksNames;

    private FragmentHelpBinding(LinearLayout linearLayout, LinearLayout linearLayout2, Button button, ImageView imageView, Button button2, TextView textView, Chapter chapter, TextView textView2) {
        this.rootView = linearLayout;
        this.authorChapter = linearLayout2;
        this.dbg = button;
        this.discordHook = imageView;
        this.manualButton = button2;
        this.textView3 = textView;
        this.thankChapter = chapter;
        this.thanksNames = textView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentHelpBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentHelpBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_help, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentHelpBinding bind(View view) {
        int i = R.id.authorChapter;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.authorChapter);
        if (linearLayout != null) {
            i = R.id.dbg;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.dbg);
            if (button != null) {
                i = R.id.discordHook;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.discordHook);
                if (imageView != null) {
                    i = R.id.manualButton;
                    Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.manualButton);
                    if (button2 != null) {
                        i = R.id.textView3;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.textView3);
                        if (textView != null) {
                            i = R.id.thankChapter;
                            Chapter chapter = (Chapter) ViewBindings.findChildViewById(view, R.id.thankChapter);
                            if (chapter != null) {
                                i = R.id.thanksNames;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.thanksNames);
                                if (textView2 != null) {
                                    return new FragmentHelpBinding((LinearLayout) view, linearLayout, button, imageView, button2, textView, chapter, textView2);
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
