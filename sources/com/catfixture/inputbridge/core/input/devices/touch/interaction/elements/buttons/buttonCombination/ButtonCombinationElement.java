package com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.buttons.buttonCombination;

import android.content.Context;
import android.view.ViewGroup;
import com.catfixture.inputbridge.core.input.data.InputTouchControlElementData;
import com.catfixture.inputbridge.core.input.data.KeyCombination;
import com.catfixture.inputbridge.core.input.devices.IInputDevice;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.CommonElementView;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.buttons.button.ButtonElement;
import com.catfixture.inputbridge.core.utils.types.Event;
import java.util.Observable;

public class ButtonCombinationElement extends ButtonElement {
    public void CreateEditorEvents() {
    }

    public ButtonCombinationElement(Context context, InputTouchControlElementData inputTouchControlElementData) {
        super(context, inputTouchControlElementData);
        CommonElementView.InitCommon(context, this);
    }

    public void CreateEventActions(IInputDevice iInputDevice) {
        this.onDown.addObserver(new ButtonCombinationElement$$ExternalSyntheticLambda0(this, iInputDevice));
        this.onUp.addObserver(new ButtonCombinationElement$$ExternalSyntheticLambda1(this, iInputDevice));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$CreateEventActions$0$com-catfixture-inputbridge-core-input-devices-touch-interaction-elements-buttons-buttonCombination-ButtonCombinationElement  reason: not valid java name */
    public /* synthetic */ void m64lambda$CreateEventActions$0$comcatfixtureinputbridgecoreinputdevicestouchinteractionelementsbuttonsbuttonCombinationButtonCombinationElement(IInputDevice iInputDevice, Observable observable, Object obj) {
        for (KeyCombination keyCombination : this.data.combinationCodes) {
            iInputDevice.SendKeyDown(keyCombination.code);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$CreateEventActions$1$com-catfixture-inputbridge-core-input-devices-touch-interaction-elements-buttons-buttonCombination-ButtonCombinationElement  reason: not valid java name */
    public /* synthetic */ void m65lambda$CreateEventActions$1$comcatfixtureinputbridgecoreinputdevicestouchinteractionelementsbuttonsbuttonCombinationButtonCombinationElement(IInputDevice iInputDevice, Observable observable, Object obj) {
        for (KeyCombination keyCombination : this.data.combinationCodes) {
            iInputDevice.SendKeyUp(keyCombination.code);
        }
    }

    public void Select(ViewGroup viewGroup) {
        super.Select(viewGroup);
        ButtonCombinationElementEditable buttonCombinationElementEditable = new ButtonCombinationElementEditable(this.context, this);
        viewGroup.removeAllViews();
        viewGroup.addView(buttonCombinationElementEditable.GetRoot());
    }

    public Event OnEnter() {
        return this.onEnter;
    }

    public Event OnExit() {
        return this.onExit;
    }
}
