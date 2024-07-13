package com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.buttons.buttonCombination;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.input.codes.KeyCodes;
import com.catfixture.inputbridge.core.input.data.InputTouchControlElementData;
import com.catfixture.inputbridge.core.input.data.KeyCombination;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.CommonElementEditor;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.buttons.common.ButtonCommons;
import com.catfixture.inputbridge.core.input.utils.IInputWindowElement;
import com.catfixture.inputbridge.ui.common.genAdapter.GenericListAdapter;

public class ButtonCombinationElementEditable extends CommonElementEditor {
    private GenericListAdapter<KeyCombination> combinationViewAdapter = null;

    public ButtonCombinationElementEditable(Context context, IInputWindowElement iInputWindowElement) {
        super(context, iInputWindowElement);
        InputTouchControlElementData inputTouchControlElementData = (InputTouchControlElementData) iInputWindowElement.GetData();
        LinearLayout linearLayout = (LinearLayout) View.inflate(context, R.layout.editable_button_combination_element, (ViewGroup) null);
        ButtonCommons.InitButtonDefs(context, linearLayout, inputTouchControlElementData, iInputWindowElement);
        ((Button) linearLayout.findViewById(R.id.addKey)).setOnClickListener(new ButtonCombinationElementEditable$$ExternalSyntheticLambda0(this, inputTouchControlElementData));
        RecyclerView recyclerView = (RecyclerView) linearLayout.findViewById(R.id.combinationView);
        this.combinationViewAdapter = new GenericListAdapter<>(R.layout.key_combination_list_item, new ButtonCombinationElementEditable$$ExternalSyntheticLambda2(this, inputTouchControlElementData));
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(this.combinationViewAdapter);
        InflateCombination(inputTouchControlElementData);
        LinearLayout linearLayout2 = (LinearLayout) this.root.findViewById(R.id.table);
        while (linearLayout.getChildCount() > 0) {
            View childAt = linearLayout.getChildAt(0);
            linearLayout.removeView(childAt);
            linearLayout2.addView(childAt);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$com-catfixture-inputbridge-core-input-devices-touch-interaction-elements-buttons-buttonCombination-ButtonCombinationElementEditable  reason: not valid java name */
    public /* synthetic */ void m66lambda$new$0$comcatfixtureinputbridgecoreinputdevicestouchinteractionelementsbuttonsbuttonCombinationButtonCombinationElementEditable(InputTouchControlElementData inputTouchControlElementData, View view) {
        inputTouchControlElementData.AddKeyToCombination(new KeyCombination());
        InflateCombination(inputTouchControlElementData);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$new$3$com-catfixture-inputbridge-core-input-devices-touch-interaction-elements-buttons-buttonCombination-ButtonCombinationElementEditable  reason: not valid java name */
    public /* synthetic */ void m68lambda$new$3$comcatfixtureinputbridgecoreinputdevicestouchinteractionelementsbuttonsbuttonCombinationButtonCombinationElementEditable(InputTouchControlElementData inputTouchControlElementData, KeyCombination keyCombination, View view) {
        KeyCodes.PrepareAdapter((Spinner) view.findViewById(R.id.keyCode), keyCombination.code, R.layout.touch_controls_list_item, new ButtonCombinationElementEditable$$ExternalSyntheticLambda3(keyCombination));
        ((Button) view.findViewById(R.id.remove)).setOnClickListener(new ButtonCombinationElementEditable$$ExternalSyntheticLambda1(this, inputTouchControlElementData, keyCombination));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$new$2$com-catfixture-inputbridge-core-input-devices-touch-interaction-elements-buttons-buttonCombination-ButtonCombinationElementEditable  reason: not valid java name */
    public /* synthetic */ void m67lambda$new$2$comcatfixtureinputbridgecoreinputdevicestouchinteractionelementsbuttonsbuttonCombinationButtonCombinationElementEditable(InputTouchControlElementData inputTouchControlElementData, KeyCombination keyCombination, View view) {
        inputTouchControlElementData.RemoveCombination(keyCombination);
        InflateCombination(inputTouchControlElementData);
    }

    private void InflateCombination(InputTouchControlElementData inputTouchControlElementData) {
        this.combinationViewAdapter.Flush();
        for (KeyCombination AddItem : inputTouchControlElementData.combinationCodes) {
            this.combinationViewAdapter.AddItem(AddItem);
        }
        this.combinationViewAdapter.notifyDataSetChanged();
    }
}
