package com.catfixture.inputbridge.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.colorpicker.AlphaPaletteView;
import com.catfixture.inputbridge.core.colorpicker.HUEPaletteView;
import com.catfixture.inputbridge.core.colorpicker.SBPaletteView;

public final class ColorPickerDiagLayoutBinding implements ViewBinding {
    public final AlphaPaletteView AlphaPalette;
    public final HUEPaletteView HUEPaletteView;
    public final SBPaletteView SBPaletteView;
    private final LinearLayout rootView;

    private ColorPickerDiagLayoutBinding(LinearLayout linearLayout, AlphaPaletteView alphaPaletteView, HUEPaletteView hUEPaletteView, SBPaletteView sBPaletteView) {
        this.rootView = linearLayout;
        this.AlphaPalette = alphaPaletteView;
        this.HUEPaletteView = hUEPaletteView;
        this.SBPaletteView = sBPaletteView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ColorPickerDiagLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ColorPickerDiagLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.color_picker_diag_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ColorPickerDiagLayoutBinding bind(View view) {
        int i = R.id.AlphaPalette;
        AlphaPaletteView alphaPaletteView = (AlphaPaletteView) ViewBindings.findChildViewById(view, R.id.AlphaPalette);
        if (alphaPaletteView != null) {
            i = R.id.HUEPaletteView;
            HUEPaletteView hUEPaletteView = (HUEPaletteView) ViewBindings.findChildViewById(view, R.id.HUEPaletteView);
            if (hUEPaletteView != null) {
                i = R.id.SBPaletteView;
                SBPaletteView sBPaletteView = (SBPaletteView) ViewBindings.findChildViewById(view, R.id.SBPaletteView);
                if (sBPaletteView != null) {
                    return new ColorPickerDiagLayoutBinding((LinearLayout) view, alphaPaletteView, hUEPaletteView, sBPaletteView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
