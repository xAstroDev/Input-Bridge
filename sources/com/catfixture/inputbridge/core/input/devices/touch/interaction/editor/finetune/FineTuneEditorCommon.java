package com.catfixture.inputbridge.core.input.devices.touch.interaction.editor.finetune;

import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.input.utils.IInputWindowElement;

public class FineTuneEditorCommon {
    public static void InitShadowEditor(LinearLayout linearLayout, final ShadowData shadowData, final IInputWindowElement iInputWindowElement) {
        SeekBar seekBar = (SeekBar) linearLayout.findViewById(R.id.shadowRadius);
        CheckBox checkBox = (CheckBox) linearLayout.findViewById(R.id.drawShadow);
        checkBox.setChecked(shadowData.draw);
        checkBox.setOnCheckedChangeListener(new FineTuneEditorCommon$$ExternalSyntheticLambda0(shadowData, iInputWindowElement, seekBar));
        seekBar.setVisibility(shadowData.draw ? 0 : 8);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                ShadowData.this.radius = (float) i;
                iInputWindowElement.Reinflate();
            }
        });
    }

    static /* synthetic */ void lambda$InitShadowEditor$0(ShadowData shadowData, IInputWindowElement iInputWindowElement, SeekBar seekBar, CompoundButton compoundButton, boolean z) {
        shadowData.draw = z;
        iInputWindowElement.Reinflate();
        seekBar.setVisibility(z ? 0 : 8);
    }
}
