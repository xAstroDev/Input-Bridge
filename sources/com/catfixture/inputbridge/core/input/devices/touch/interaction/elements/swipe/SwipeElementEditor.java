package com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.swipe;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.input.data.InputTouchControlElementData;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.CommonElementEditor;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.cross.CrossElementEditable;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.cross.CrossElementEditable$$ExternalSyntheticLambda2;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.cross.CrossElementEditable$$ExternalSyntheticLambda3;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.cross.CrossElementEditable$$ExternalSyntheticLambda4;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.cross.CrossElementEditable$$ExternalSyntheticLambda5;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.icon.IconElementCommons;
import com.catfixture.inputbridge.core.input.utils.IInputWindowElement;
import java.util.Objects;

public class SwipeElementEditor extends CommonElementEditor {
    /* access modifiers changed from: private */
    public final TextView swipeMinDistanceText;

    public SwipeElementEditor(final Context context, IInputWindowElement iInputWindowElement) {
        super(context, iInputWindowElement);
        final InputTouchControlElementData inputTouchControlElementData = (InputTouchControlElementData) iInputWindowElement.GetData();
        LinearLayout linearLayout = (LinearLayout) View.inflate(context, R.layout.editable_swipe_element, (ViewGroup) null);
        IconElementCommons.InitIcons(context, linearLayout, inputTouchControlElementData.customIcon, iInputWindowElement, (String) null);
        TextView textView = (TextView) linearLayout.findViewById(R.id.swipeMinDistanceText);
        this.swipeMinDistanceText = textView;
        SeekBar seekBar = (SeekBar) linearLayout.findViewById(R.id.swipeMinDistanceSlider);
        textView.setVisibility(0);
        seekBar.setVisibility(0);
        int i = inputTouchControlElementData.codeUp;
        Objects.requireNonNull(inputTouchControlElementData);
        CrossElementEditable.InitDir(linearLayout, R.id.codeUp, i, new CrossElementEditable$$ExternalSyntheticLambda5(inputTouchControlElementData));
        int i2 = inputTouchControlElementData.codeDown;
        Objects.requireNonNull(inputTouchControlElementData);
        CrossElementEditable.InitDir(linearLayout, R.id.codeDown, i2, new CrossElementEditable$$ExternalSyntheticLambda2(inputTouchControlElementData));
        int i3 = inputTouchControlElementData.codeLeft;
        Objects.requireNonNull(inputTouchControlElementData);
        CrossElementEditable.InitDir(linearLayout, R.id.codeLeft, i3, new CrossElementEditable$$ExternalSyntheticLambda3(inputTouchControlElementData));
        int i4 = inputTouchControlElementData.codeRight;
        Objects.requireNonNull(inputTouchControlElementData);
        CrossElementEditable.InitDir(linearLayout, R.id.codeRight, i4, new CrossElementEditable$$ExternalSyntheticLambda4(inputTouchControlElementData));
        textView.setVisibility(0);
        seekBar.setVisibility(0);
        textView.setText(context.getString(R.string.min_distance_to_swipe, new Object[]{Integer.valueOf(inputTouchControlElementData.sensivity)}));
        seekBar.setProgress(inputTouchControlElementData.sensivity);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                inputTouchControlElementData.SetSensivity(i);
                SwipeElementEditor.this.swipeMinDistanceText.setText(context.getString(R.string.min_distance_to_swipe, new Object[]{Integer.valueOf(i)}));
            }
        });
        CheckBox checkBox = (CheckBox) linearLayout.findViewById(R.id.eightDirMode);
        checkBox.setChecked(inputTouchControlElementData.eightDirMode);
        checkBox.setOnCheckedChangeListener(new SwipeElementEditor$$ExternalSyntheticLambda0(inputTouchControlElementData));
        ((LinearLayout) this.root.findViewById(R.id.table)).addView(linearLayout);
    }
}
