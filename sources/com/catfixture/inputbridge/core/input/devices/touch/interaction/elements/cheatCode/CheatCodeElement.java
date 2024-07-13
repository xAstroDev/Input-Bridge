package com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.cheatCode;

import android.content.Context;
import android.view.ViewGroup;
import com.catfixture.inputbridge.core.input.codes.KeyCodes;
import com.catfixture.inputbridge.core.input.data.CheatCodeAction;
import com.catfixture.inputbridge.core.input.data.InputTouchControlElementData;
import com.catfixture.inputbridge.core.input.devices.IInputDevice;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.CommonElementView;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.buttons.button.ButtonElement;
import com.catfixture.inputbridge.core.utils.process.ThreadUtils;
import java.util.Observable;

public class CheatCodeElement extends ButtonElement {
    public void CreateEditorEvents() {
    }

    public CheatCodeElement(Context context, InputTouchControlElementData inputTouchControlElementData) {
        super(context, inputTouchControlElementData);
        CommonElementView.InitCommon(context, this);
    }

    public void CreateEventActions(IInputDevice iInputDevice) {
        CreateNormalEvents(iInputDevice);
    }

    private void CreateNormalEvents(IInputDevice iInputDevice) {
        this.onUp.addObserver(new CheatCodeElement$$ExternalSyntheticLambda0(this, iInputDevice));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$CreateNormalEvents$0$com-catfixture-inputbridge-core-input-devices-touch-interaction-elements-cheatCode-CheatCodeElement  reason: not valid java name */
    public /* synthetic */ void m69lambda$CreateNormalEvents$0$comcatfixtureinputbridgecoreinputdevicestouchinteractionelementscheatCodeCheatCodeElement(IInputDevice iInputDevice, Observable observable, Object obj) {
        for (CheatCodeAction next : this.data.cheatCodeActions) {
            int i = next.type;
            if (i == 0) {
                iInputDevice.SendKeyDown(next.keyCode);
                ThreadUtils.Sleep(10);
                iInputDevice.SendKeyUp(next.keyCode);
            } else if (i == 1) {
                ThreadUtils.Sleep((long) next.delay);
            } else if (i == 2) {
                for (char CharToKeyCode : next.text.toCharArray()) {
                    int CharToKeyCode2 = KeyCodes.CharToKeyCode(CharToKeyCode);
                    iInputDevice.SendKeyDown(CharToKeyCode2);
                    ThreadUtils.Sleep(10);
                    iInputDevice.SendKeyUp(CharToKeyCode2);
                    ThreadUtils.Sleep(10);
                }
            }
        }
    }

    public void Select(ViewGroup viewGroup) {
        this.isSelected = true;
        CheatCodeEditable cheatCodeEditable = new CheatCodeEditable(this.context, this);
        viewGroup.removeAllViews();
        viewGroup.addView(cheatCodeEditable.GetRoot());
    }

    public void Deselect() {
        this.isSelected = false;
        invalidate();
    }
}
