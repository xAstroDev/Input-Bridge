package com.catfixture.inputbridge.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.catfixture.inputbridge.R;

public final class OverlaySettingsPanelBinding implements ViewBinding {
    public final ImageView close;
    public final LinearLayout controlsContainer;
    public final ImageView hide;
    public final LinearLayout mainCont;
    private final RelativeLayout rootView;
    public final ImageView settingsIco;
    public final Spinner showProfiles;
    public final ImageView toggleControllers;
    public final ImageView toggleEditor;
    public final ImageView toggleMice;

    private OverlaySettingsPanelBinding(RelativeLayout relativeLayout, ImageView imageView, LinearLayout linearLayout, ImageView imageView2, LinearLayout linearLayout2, ImageView imageView3, Spinner spinner, ImageView imageView4, ImageView imageView5, ImageView imageView6) {
        this.rootView = relativeLayout;
        this.close = imageView;
        this.controlsContainer = linearLayout;
        this.hide = imageView2;
        this.mainCont = linearLayout2;
        this.settingsIco = imageView3;
        this.showProfiles = spinner;
        this.toggleControllers = imageView4;
        this.toggleEditor = imageView5;
        this.toggleMice = imageView6;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static OverlaySettingsPanelBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static OverlaySettingsPanelBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.overlay_settings_panel, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static OverlaySettingsPanelBinding bind(View view) {
        int i = R.id.close;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.close);
        if (imageView != null) {
            i = R.id.controlsContainer;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.controlsContainer);
            if (linearLayout != null) {
                i = R.id.hide;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.hide);
                if (imageView2 != null) {
                    i = R.id.mainCont;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.mainCont);
                    if (linearLayout2 != null) {
                        i = R.id.settingsIco;
                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.settingsIco);
                        if (imageView3 != null) {
                            i = R.id.showProfiles;
                            Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.showProfiles);
                            if (spinner != null) {
                                i = R.id.toggleControllers;
                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.toggleControllers);
                                if (imageView4 != null) {
                                    i = R.id.toggleEditor;
                                    ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, R.id.toggleEditor);
                                    if (imageView5 != null) {
                                        i = R.id.toggleMice;
                                        ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, R.id.toggleMice);
                                        if (imageView6 != null) {
                                            return new OverlaySettingsPanelBinding((RelativeLayout) view, imageView, linearLayout, imageView2, linearLayout2, imageView3, spinner, imageView4, imageView5, imageView6);
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
