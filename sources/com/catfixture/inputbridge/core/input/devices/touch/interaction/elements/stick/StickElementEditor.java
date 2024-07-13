package com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.stick;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
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
import com.catfixture.inputbridge.ui.utils.Utils;
import java.util.Objects;

public class StickElementEditor extends CommonElementEditor {
    /* access modifiers changed from: private */
    public final TextView sensivityText;

    public StickElementEditor(final Context context, IInputWindowElement iInputWindowElement) {
        super(context, iInputWindowElement);
        final InputTouchControlElementData inputTouchControlElementData = (InputTouchControlElementData) iInputWindowElement.GetData();
        LinearLayout linearLayout = (LinearLayout) View.inflate(context, R.layout.editable_stick_element, (ViewGroup) null);
        IconElementCommons.InitIcons(context, (LinearLayout) linearLayout.findViewById(R.id.outerCircle), inputTouchControlElementData.customIcon, iInputWindowElement, "Outer circle");
        IconElementCommons.InitIcons(context, (LinearLayout) linearLayout.findViewById(R.id.innerCircle), inputTouchControlElementData.innerCircleIcon, iInputWindowElement, "Inner circle");
        TextView textView = (TextView) linearLayout.findViewById(R.id.sensivitySliderText);
        this.sensivityText = textView;
        SeekBar seekBar = (SeekBar) linearLayout.findViewById(R.id.sensivitySlider);
        View findViewById = linearLayout.findViewById(R.id.walkCont);
        View findViewById2 = linearLayout.findViewById(R.id.xiCont);
        MovementType.Create(context);
        Spinner spinner = (Spinner) linearLayout.findViewById(R.id.movementType);
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) null);
        ArrayAdapter InitSpinner = Utils.InitSpinner(context, spinner, 0, R.layout.touch_controls_list_item);
        InitSpinner.addAll(MovementType.types);
        spinner.setAdapter(InitSpinner);
        spinner.setSelection(inputTouchControlElementData.movementType);
        Utils.AttachSpinnerAction(spinner, new StickElementEditor$$ExternalSyntheticLambda0(inputTouchControlElementData, iInputWindowElement));
        textView.setVisibility(8);
        seekBar.setVisibility(8);
        findViewById.setVisibility(8);
        findViewById2.setVisibility(8);
        int i = inputTouchControlElementData.movementType;
        if (i == 0) {
            findViewById.setVisibility(0);
            int i2 = inputTouchControlElementData.codeUp;
            Objects.requireNonNull(inputTouchControlElementData);
            CrossElementEditable.InitDir(linearLayout, R.id.codeUp, i2, new CrossElementEditable$$ExternalSyntheticLambda5(inputTouchControlElementData));
            int i3 = inputTouchControlElementData.codeDown;
            Objects.requireNonNull(inputTouchControlElementData);
            CrossElementEditable.InitDir(linearLayout, R.id.codeDown, i3, new CrossElementEditable$$ExternalSyntheticLambda2(inputTouchControlElementData));
            int i4 = inputTouchControlElementData.codeLeft;
            Objects.requireNonNull(inputTouchControlElementData);
            CrossElementEditable.InitDir(linearLayout, R.id.codeLeft, i4, new CrossElementEditable$$ExternalSyntheticLambda3(inputTouchControlElementData));
            int i5 = inputTouchControlElementData.codeRight;
            Objects.requireNonNull(inputTouchControlElementData);
            CrossElementEditable.InitDir(linearLayout, R.id.codeRight, i5, new CrossElementEditable$$ExternalSyntheticLambda4(inputTouchControlElementData));
        } else if (i == 1) {
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
                    StickElementEditor.this.sensivityText.setText(context.getString(R.string.sensitivity_text, new Object[]{Integer.valueOf(i)}));
                }
            });
        } else if (i == 2) {
            findViewById2.setVisibility(0);
            Spinner spinner2 = (Spinner) findViewById2.findViewById(R.id.sideSpinner);
            spinner2.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) null);
            ArrayAdapter InitSpinner2 = Utils.InitSpinner(context, spinner2, 0, R.layout.touch_controls_list_item);
            InitSpinner2.addAll(SSide.sides);
            spinner2.setAdapter(InitSpinner2);
            spinner2.setSelection(inputTouchControlElementData.stickSide);
            Utils.AttachSpinnerAction(spinner2, new StickElementEditor$$ExternalSyntheticLambda1(inputTouchControlElementData, iInputWindowElement));
        }
        ((LinearLayout) this.root.findViewById(R.id.table)).addView(linearLayout);
    }

    static /* synthetic */ void lambda$new$0(InputTouchControlElementData inputTouchControlElementData, IInputWindowElement iInputWindowElement, Integer num) {
        if (inputTouchControlElementData.movementType != num.intValue()) {
            inputTouchControlElementData.SetMovementType(num);
            iInputWindowElement.ResetEditor(false);
        }
    }

    static /* synthetic */ void lambda$new$1(InputTouchControlElementData inputTouchControlElementData, IInputWindowElement iInputWindowElement, Integer num) {
        if (inputTouchControlElementData.stickSide != num.intValue()) {
            inputTouchControlElementData.stickSide = num.intValue();
            iInputWindowElement.ResetEditor(false);
        }
    }
}
