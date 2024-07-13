package com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.scroll;

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

public class ScrollElementEditor extends CommonElementEditor {
    /* access modifiers changed from: private */
    public final TextView heightText;
    /* access modifiers changed from: private */
    public final TextView sensivityText;

    public ScrollElementEditor(final Context context, final IInputWindowElement iInputWindowElement) {
        super(context, iInputWindowElement);
        final InputTouchControlElementData inputTouchControlElementData = (InputTouchControlElementData) iInputWindowElement.GetData();
        LinearLayout linearLayout = (LinearLayout) View.inflate(context, R.layout.editable_scroll_element, (ViewGroup) null);
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
                ScrollElementEditor.this.sensivityText.setText(context.getString(R.string.sensitivity_text, new Object[]{Integer.valueOf(i)}));
            }
        });
        TextView textView2 = (TextView) linearLayout.findViewById(R.id.heightSliderText);
        this.heightText = textView2;
        SeekBar seekBar2 = (SeekBar) linearLayout.findViewById(R.id.heightSlider);
        textView2.setText(context.getString(R.string.height_text, new Object[]{Integer.valueOf(inputTouchControlElementData.height)}));
        seekBar2.setProgress(inputTouchControlElementData.height);
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                inputTouchControlElementData.SetHeight(i);
                ScrollElementEditor.this.heightText.setText(context.getString(R.string.height_text, new Object[]{Integer.valueOf(i)}));
                iInputWindowElement.SetInitialSize(75, inputTouchControlElementData.height);
                iInputWindowElement.SetScale(inputTouchControlElementData.scale);
            }
        });
        ((LinearLayout) this.root.findViewById(R.id.table)).addView(linearLayout);
    }
}
