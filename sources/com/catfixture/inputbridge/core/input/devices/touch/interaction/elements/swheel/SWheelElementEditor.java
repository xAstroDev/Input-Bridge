package com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.swheel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.input.data.InputTouchControlElementData;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.CommonElementEditor;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.icon.IconElementCommons;
import com.catfixture.inputbridge.core.input.utils.IInputWindowElement;
import com.catfixture.inputbridge.ui.common.AxisBindingsHelper;

public class SWheelElementEditor extends CommonElementEditor {
    /* access modifiers changed from: private */
    public final TextView sensivityText;

    static /* synthetic */ void lambda$new$0() {
    }

    public SWheelElementEditor(final Context context, IInputWindowElement iInputWindowElement) {
        super(context, iInputWindowElement);
        final InputTouchControlElementData inputTouchControlElementData = (InputTouchControlElementData) iInputWindowElement.GetData();
        LinearLayout linearLayout = (LinearLayout) View.inflate(context, R.layout.editable_swheel_element, (ViewGroup) null);
        IconElementCommons.InitIcons(context, (LinearLayout) linearLayout.findViewById(R.id.customIcon), inputTouchControlElementData.customIcon, iInputWindowElement, "Custom icon");
        TextView textView = (TextView) linearLayout.findViewById(R.id.sensivitySliderText);
        this.sensivityText = textView;
        SeekBar seekBar = (SeekBar) linearLayout.findViewById(R.id.sensivitySlider);
        AxisBindingsHelper.LoadSelectedAxisSettings(context, linearLayout, R.layout.touch_controls_list_item, inputTouchControlElementData.swheelAxisBinding, SWheelElementEditor$$ExternalSyntheticLambda0.INSTANCE);
        textView.setVisibility(8);
        seekBar.setVisibility(8);
        textView.setVisibility(0);
        seekBar.setVisibility(0);
        textView.setText(context.getString(R.string.sensitivity_text, new Object[]{Integer.valueOf(inputTouchControlElementData.sensivity)}));
        seekBar.setProgress(inputTouchControlElementData.sensivity);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                inputTouchControlElementData.SetSensivity(i);
                SWheelElementEditor.this.sensivityText.setText(context.getString(R.string.sensitivity_text, new Object[]{Integer.valueOf(i)}));
            }
        });
        ((LinearLayout) this.root.findViewById(R.id.table)).addView(linearLayout);
    }
}
