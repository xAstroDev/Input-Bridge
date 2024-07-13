package com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.cheatCode;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.input.data.CheatCodeAction;
import com.catfixture.inputbridge.core.input.data.InputTouchControlElementData;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.CommonElementEditor;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.buttons.common.ButtonCommons;
import com.catfixture.inputbridge.core.input.utils.IInputWindowElement;
import com.catfixture.inputbridge.ui.utils.Utils;

public class CheatCodeEditable extends CommonElementEditor {
    private final LinearLayout root;

    public CheatCodeEditable(Context context, IInputWindowElement iInputWindowElement) {
        super(context, iInputWindowElement);
        View view;
        InputTouchControlElementData inputTouchControlElementData = (InputTouchControlElementData) iInputWindowElement.GetData();
        LinearLayout linearLayout = (LinearLayout) View.inflate(context, R.layout.editable_cheat_code_element, (ViewGroup) null);
        this.root = linearLayout;
        ButtonCommons.InitButtonDefs(context, linearLayout, inputTouchControlElementData, iInputWindowElement);
        CCType.Create(context);
        Spinner spinner = (Spinner) linearLayout.findViewById(R.id.actionsSpinner);
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) null);
        ArrayAdapter InitSpinner = Utils.InitSpinner(context, spinner, 0, R.layout.touch_controls_list_item);
        InitSpinner.addAll(CCType.types);
        spinner.setAdapter(InitSpinner);
        spinner.setSelection(inputTouchControlElementData.lastSelectedAction);
        Utils.AttachSpinnerAction(spinner, new CheatCodeEditable$$ExternalSyntheticLambda2(inputTouchControlElementData));
        LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(R.id.cheatCodeActionsContainer);
        linearLayout2.removeAllViews();
        for (CheatCodeAction next : inputTouchControlElementData.cheatCodeActions) {
            int i = next.type;
            if (i == 0) {
                view = CheatCodeKeyField.Create(context, next, linearLayout2);
            } else if (i == 1) {
                view = CheatCodeDelayField.Create(context, next, linearLayout2);
            } else if (i != 2) {
                view = null;
            } else {
                view = CheatCodeTextField.Create(context, next, linearLayout2);
            }
            view.setOnLongClickListener(new CheatCodeEditable$$ExternalSyntheticLambda1(inputTouchControlElementData, next, iInputWindowElement));
        }
        ((Button) this.root.findViewById(R.id.addAction)).setOnClickListener(new CheatCodeEditable$$ExternalSyntheticLambda0(inputTouchControlElementData, iInputWindowElement));
        LinearLayout linearLayout3 = (LinearLayout) this.root.findViewById(R.id.table);
        while (this.root.getChildCount() > 0) {
            View childAt = this.root.getChildAt(0);
            this.root.removeView(childAt);
            linearLayout3.addView(childAt);
        }
    }

    static /* synthetic */ void lambda$new$0(InputTouchControlElementData inputTouchControlElementData, Integer num) {
        if (inputTouchControlElementData.lastSelectedAction != num.intValue()) {
            inputTouchControlElementData.SetLastSelectedAction(num.intValue());
        }
    }

    static /* synthetic */ boolean lambda$new$1(InputTouchControlElementData inputTouchControlElementData, CheatCodeAction cheatCodeAction, IInputWindowElement iInputWindowElement, View view) {
        inputTouchControlElementData.cheatCodeActions.remove(cheatCodeAction);
        iInputWindowElement.ResetEditor(false);
        return true;
    }

    static /* synthetic */ void lambda$new$2(InputTouchControlElementData inputTouchControlElementData, IInputWindowElement iInputWindowElement, View view) {
        inputTouchControlElementData.AddCheatCodeAction();
        iInputWindowElement.ResetEditor(false);
    }
}
