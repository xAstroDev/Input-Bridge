package com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.mouseZone;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.input.data.InputTouchControlElementData;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.CommonElementEditor;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.buttons.common.ButtonCommons;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.icon.IconElementCommons;
import com.catfixture.inputbridge.core.input.utils.IInputWindowElement;

public class MouseZoneElementEditable extends CommonElementEditor {
    /* access modifiers changed from: private */
    public final TextView sensivityText;

    public MouseZoneElementEditable(final Context context, IInputWindowElement iInputWindowElement) {
        super(context, iInputWindowElement);
        final InputTouchControlElementData inputTouchControlElementData = (InputTouchControlElementData) iInputWindowElement.GetData();
        LinearLayout linearLayout = (LinearLayout) View.inflate(context, R.layout.editable_mouse_zone_element, (ViewGroup) null);
        ButtonCommons.InitButtonDefs(context, linearLayout, inputTouchControlElementData, iInputWindowElement);
        IconElementCommons.InitIcons(context, linearLayout, inputTouchControlElementData.customIcon, iInputWindowElement, (String) null);
        TextView textView = (TextView) linearLayout.findViewById(R.id.sensivitySliderText);
        this.sensivityText = textView;
        SeekBar seekBar = (SeekBar) linearLayout.findViewById(R.id.sensivitySlider);
        textView.setText(context.getString(R.string.sensitivity_text, new Object[]{Integer.valueOf(inputTouchControlElementData.sensivity)}));
        seekBar.setProgress(inputTouchControlElementData.sensivity);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                inputTouchControlElementData.SetSensivity(i);
                MouseZoneElementEditable.this.sensivityText.setText(context.getString(R.string.sensitivity_text, new Object[]{Integer.valueOf(i)}));
            }
        });
        ((LinearLayout) this.root.findViewById(R.id.table)).addView(linearLayout);
    }
}
