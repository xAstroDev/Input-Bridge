package com.catfixture.inputbridge.core.colorpicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.utils.types.delegates.Action;

public class ColorPickerDialog {
    private final Context context;
    private final Action<Integer> listener;

    public ColorPickerDialog(Context context2, Action<Integer> action) {
        this.context = context2;
        this.listener = action;
    }

    public void Show(View view, int i, int i2, int i3) {
        View inflate = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(R.layout.color_picker_diag_layout, (ViewGroup) null);
        HUEPaletteView hUEPaletteView = (HUEPaletteView) inflate.findViewById(R.id.HUEPaletteView);
        SBPaletteView sBPaletteView = (SBPaletteView) inflate.findViewById(R.id.SBPaletteView);
        AlphaPaletteView alphaPaletteView = (AlphaPaletteView) inflate.findViewById(R.id.AlphaPalette);
        sBPaletteView.SetHUEControl(hUEPaletteView);
        sBPaletteView.SetAlphaControl(alphaPaletteView);
        hUEPaletteView.SetPositionByColor(i3);
        sBPaletteView.SetPositionByColor(i3);
        alphaPaletteView.SetPositionByAlpha((i3 >> 24) & 255);
        sBPaletteView.SetOnColorChanged(this.listener);
        new PopupWindow(inflate, -2, -2, true).showAtLocation(view, 0, i, i2);
        inflate.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
    }
}
