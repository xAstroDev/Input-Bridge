package com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.buttons.button;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.colorpicker.ColorPickerUtils;
import com.catfixture.inputbridge.core.input.codes.KeyCodes;
import com.catfixture.inputbridge.core.input.codes.MouseCodes;
import com.catfixture.inputbridge.core.input.codes.XInputCodes;
import com.catfixture.inputbridge.core.input.data.InputTouchControlElementData;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.CommonElementEditor;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.buttons.common.BType;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.buttons.common.ButtonCommons;
import com.catfixture.inputbridge.core.input.utils.IInputWindowElement;
import com.catfixture.inputbridge.ui.utils.Utils;

public class ButtonElementEditable extends CommonElementEditor {
    private final LinearLayout root;

    static /* synthetic */ void lambda$new$2() {
    }

    public ButtonElementEditable(Context context, IInputWindowElement iInputWindowElement) {
        super(context, iInputWindowElement);
        InputTouchControlElementData inputTouchControlElementData = (InputTouchControlElementData) iInputWindowElement.GetData();
        LinearLayout linearLayout = (LinearLayout) View.inflate(context, R.layout.editable_button_element, (ViewGroup) null);
        this.root = linearLayout;
        ButtonCommons.InitButtonDefs(context, linearLayout, inputTouchControlElementData, iInputWindowElement);
        SetupButtonType(inputTouchControlElementData);
        BType.Create(context);
        Spinner spinner = (Spinner) linearLayout.findViewById(R.id.buttonType);
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) null);
        ArrayAdapter InitSpinner = Utils.InitSpinner(context, spinner, 0, R.layout.touch_controls_list_item);
        InitSpinner.addAll(BType.types);
        spinner.setAdapter(InitSpinner);
        spinner.setSelection(inputTouchControlElementData.buttonType);
        Utils.AttachSpinnerAction(spinner, new ButtonElementEditable$$ExternalSyntheticLambda2(inputTouchControlElementData, iInputWindowElement));
        LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(R.id.triggerModeColor);
        CheckBox checkBox = (CheckBox) linearLayout.findViewById(R.id.buttonTriggerMode);
        checkBox.setChecked(inputTouchControlElementData.useTriggerMode);
        checkBox.setOnCheckedChangeListener(new ButtonElementEditable$$ExternalSyntheticLambda1(inputTouchControlElementData, linearLayout2));
        linearLayout2.setVisibility(inputTouchControlElementData.useTriggerMode ? 0 : 8);
        ColorPickerUtils.InitColorPicker(context, "Trigger mode color", linearLayout2, inputTouchControlElementData.triggerModeColor, ButtonElementEditable$$ExternalSyntheticLambda6.INSTANCE);
        CheckBox checkBox2 = (CheckBox) linearLayout.findViewById(R.id.buttonMouseMode);
        checkBox2.setChecked(inputTouchControlElementData.useMouseMode);
        checkBox2.setOnCheckedChangeListener(new ButtonElementEditable$$ExternalSyntheticLambda0(inputTouchControlElementData));
        LinearLayout linearLayout3 = (LinearLayout) this.root.findViewById(R.id.table);
        while (this.root.getChildCount() > 0) {
            View childAt = this.root.getChildAt(0);
            this.root.removeView(childAt);
            linearLayout3.addView(childAt);
        }
    }

    static /* synthetic */ void lambda$new$0(InputTouchControlElementData inputTouchControlElementData, IInputWindowElement iInputWindowElement, Integer num) {
        if (inputTouchControlElementData.buttonType != num.intValue()) {
            inputTouchControlElementData.SetButtonType(num);
            iInputWindowElement.ResetEditor(false);
        }
    }

    static /* synthetic */ void lambda$new$1(InputTouchControlElementData inputTouchControlElementData, LinearLayout linearLayout, CompoundButton compoundButton, boolean z) {
        inputTouchControlElementData.useTriggerMode = z;
        linearLayout.setVisibility(z ? 0 : 8);
    }

    private void SetupButtonType(InputTouchControlElementData inputTouchControlElementData) {
        LinearLayout linearLayout = (LinearLayout) this.root.findViewById(R.id.kbcodeRow);
        LinearLayout linearLayout2 = (LinearLayout) this.root.findViewById(R.id.mscodeRow);
        LinearLayout linearLayout3 = (LinearLayout) this.root.findViewById(R.id.xinputcodeRow);
        int i = 0;
        linearLayout.setVisibility(inputTouchControlElementData.buttonType == 0 ? 0 : 8);
        linearLayout2.setVisibility(inputTouchControlElementData.buttonType == 1 ? 0 : 8);
        if (inputTouchControlElementData.buttonType != 2) {
            i = 8;
        }
        linearLayout3.setVisibility(i);
        int i2 = inputTouchControlElementData.buttonType;
        if (i2 == 0) {
            Spinner spinner = (Spinner) this.root.findViewById(R.id.buttonCode);
            spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) null);
            KeyCodes.PrepareAdapter(spinner, inputTouchControlElementData.windowsKeyCode, R.layout.touch_controls_list_item, new ButtonElementEditable$$ExternalSyntheticLambda3(this, inputTouchControlElementData));
        } else if (i2 == 1) {
            MouseCodes.PrepareAdapter((Spinner) this.root.findViewById(R.id.mouseCode), inputTouchControlElementData.mouseCode, R.layout.touch_controls_list_item, new ButtonElementEditable$$ExternalSyntheticLambda4(this, inputTouchControlElementData));
        } else if (i2 == 2) {
            XInputCodes.PrepareAdapter((Spinner) this.root.findViewById(R.id.xinputcode), inputTouchControlElementData.xinputCode, R.layout.touch_controls_list_item, new ButtonElementEditable$$ExternalSyntheticLambda5(this, inputTouchControlElementData));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$SetupButtonType$4$com-catfixture-inputbridge-core-input-devices-touch-interaction-elements-buttons-button-ButtonElementEditable  reason: not valid java name */
    public /* synthetic */ void m61lambda$SetupButtonType$4$comcatfixtureinputbridgecoreinputdevicestouchinteractionelementsbuttonsbuttonButtonElementEditable(InputTouchControlElementData inputTouchControlElementData, Integer num) {
        if (inputTouchControlElementData.windowsKeyCode != num.intValue()) {
            inputTouchControlElementData.SetKeyCode(num.intValue());
            this.parentItem.Reinflate();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$SetupButtonType$5$com-catfixture-inputbridge-core-input-devices-touch-interaction-elements-buttons-button-ButtonElementEditable  reason: not valid java name */
    public /* synthetic */ void m62lambda$SetupButtonType$5$comcatfixtureinputbridgecoreinputdevicestouchinteractionelementsbuttonsbuttonButtonElementEditable(InputTouchControlElementData inputTouchControlElementData, Integer num) {
        if (inputTouchControlElementData.mouseCode != num.intValue()) {
            inputTouchControlElementData.SetMouseCode(num.intValue());
            this.parentItem.Reinflate();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$SetupButtonType$6$com-catfixture-inputbridge-core-input-devices-touch-interaction-elements-buttons-button-ButtonElementEditable  reason: not valid java name */
    public /* synthetic */ void m63lambda$SetupButtonType$6$comcatfixtureinputbridgecoreinputdevicestouchinteractionelementsbuttonsbuttonButtonElementEditable(InputTouchControlElementData inputTouchControlElementData, Integer num) {
        if (inputTouchControlElementData.xinputCode != num.intValue()) {
            inputTouchControlElementData.SetXInputCode(num.intValue());
            this.parentItem.Reinflate();
        }
    }
}
