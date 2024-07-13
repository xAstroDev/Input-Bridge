package com.catfixture.inputbridge.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.catfixture.inputbridge.R;

public final class OverlaySettingsPanelMinBinding implements ViewBinding {
    public final LinearLayout mainCont;
    private final RelativeLayout rootView;
    public final ImageView settingsIco;

    private OverlaySettingsPanelMinBinding(RelativeLayout relativeLayout, LinearLayout linearLayout, ImageView imageView) {
        this.rootView = relativeLayout;
        this.mainCont = linearLayout;
        this.settingsIco = imageView;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static OverlaySettingsPanelMinBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static OverlaySettingsPanelMinBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.overlay_settings_panel_min, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static OverlaySettingsPanelMinBinding bind(View view) {
        int i = R.id.mainCont;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.mainCont);
        if (linearLayout != null) {
            i = R.id.settingsIco;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.settingsIco);
            if (imageView != null) {
                return new OverlaySettingsPanelMinBinding((RelativeLayout) view, linearLayout, imageView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
