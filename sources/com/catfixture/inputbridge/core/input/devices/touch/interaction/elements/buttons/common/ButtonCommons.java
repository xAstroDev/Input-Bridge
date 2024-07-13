package com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.buttons.common;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.debug.D;
import com.catfixture.inputbridge.core.input.data.InputTouchControlElementData;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.icon.IconElementCommons;
import com.catfixture.inputbridge.core.input.utils.IInputWindowElement;
import com.catfixture.inputbridge.ui.activity.editors.touchEditor.TouchEditorActivity;
import com.catfixture.inputbridge.ui.utils.Utils;

public class ButtonCommons {
    public static void InitButtonDefs(Context context, LinearLayout linearLayout, final InputTouchControlElementData inputTouchControlElementData, IInputWindowElement iInputWindowElement) {
        IconElementCommons.InitIcons(context, linearLayout, inputTouchControlElementData.customIcon, iInputWindowElement, (String) null);
        Shapes.Create(context);
        Spinner spinner = (Spinner) linearLayout.findViewById(R.id.buttonShape);
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) null);
        ArrayAdapter InitSpinner = Utils.InitSpinner(context, spinner, 0, R.layout.touch_controls_list_item);
        InitSpinner.addAll(Shapes.shapes);
        spinner.setAdapter(InitSpinner);
        spinner.setSelection(inputTouchControlElementData.buttonShape);
        Utils.AttachSpinnerAction(spinner, new ButtonCommons$$ExternalSyntheticLambda3(inputTouchControlElementData, iInputWindowElement));
        ((ImageView) linearLayout.findViewById(R.id.openShapeSettings)).setOnClickListener(new ButtonCommons$$ExternalSyntheticLambda0(context, iInputWindowElement, inputTouchControlElementData));
        ((ImageView) linearLayout.findViewById(R.id.openTextSettings)).setOnClickListener(new ButtonCommons$$ExternalSyntheticLambda1(context, iInputWindowElement, inputTouchControlElementData));
        EditText editText = (EditText) linearLayout.findViewById(R.id.customText);
        if (inputTouchControlElementData.customIcon.iconName == null || "None".equals(inputTouchControlElementData.customIcon.iconName)) {
            editText.setText(inputTouchControlElementData.customText);
            editText.addTextChangedListener(new TextWatcher() {
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void afterTextChanged(Editable editable) {
                    InputTouchControlElementData.this.SetCustomText(editable.toString());
                }
            });
            editText.setOnKeyListener(new ButtonCommons$$ExternalSyntheticLambda2(iInputWindowElement));
            return;
        }
        linearLayout.findViewById(R.id.openTextSettings).setVisibility(8);
        linearLayout.findViewById(R.id.customTextLabel).setVisibility(8);
        editText.setVisibility(8);
    }

    static /* synthetic */ void lambda$InitButtonDefs$0(InputTouchControlElementData inputTouchControlElementData, IInputWindowElement iInputWindowElement, Integer num) {
        if (inputTouchControlElementData.buttonShape != num.intValue()) {
            inputTouchControlElementData.SetButtonShape(num);
            iInputWindowElement.ResetEditor(false);
        }
    }

    static /* synthetic */ void lambda$InitButtonDefs$1(Context context, IInputWindowElement iInputWindowElement, InputTouchControlElementData inputTouchControlElementData, View view) {
        if (context instanceof TouchEditorActivity) {
            ((TouchEditorActivity) context).ToggleFineTuneView(iInputWindowElement, 0, inputTouchControlElementData.shapeFineTuneData);
        } else {
            D.E("Error check code, context is not activity");
        }
    }

    static /* synthetic */ void lambda$InitButtonDefs$2(Context context, IInputWindowElement iInputWindowElement, InputTouchControlElementData inputTouchControlElementData, View view) {
        if (context instanceof TouchEditorActivity) {
            ((TouchEditorActivity) context).ToggleFineTuneView(iInputWindowElement, 2, inputTouchControlElementData.textFineTuneData);
        } else {
            D.E("Error check code, context is not activity");
        }
    }

    static /* synthetic */ boolean lambda$InitButtonDefs$3(IInputWindowElement iInputWindowElement, View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 && keyEvent.getAction() != 0) {
            return false;
        }
        if (keyEvent.getKeyCode() != 66 && keyEvent.getKeyCode() != 4) {
            return false;
        }
        iInputWindowElement.Reinflate();
        return true;
    }
}
