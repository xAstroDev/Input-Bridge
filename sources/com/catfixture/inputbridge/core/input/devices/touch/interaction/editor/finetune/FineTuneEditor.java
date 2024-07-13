package com.catfixture.inputbridge.core.input.devices.touch.interaction.editor.finetune;

import android.view.ViewGroup;
import com.catfixture.inputbridge.core.input.utils.IInputWindowElement;

public class FineTuneEditor {
    public static void Load(IInputWindowElement iInputWindowElement, ViewGroup viewGroup, int i, Object obj) {
        if (i == 0) {
            ShapeFineTuneEditor.Init(iInputWindowElement, viewGroup.getContext(), viewGroup, (ShapeFineTuneData) obj);
        } else if (i == 1) {
            IconFineTuneEditor.Init(iInputWindowElement, viewGroup.getContext(), viewGroup, (IconFineTuneData) obj);
        } else if (i == 2) {
            TextFineTuneEditor.Init(iInputWindowElement, viewGroup.getContext(), viewGroup, (TextFineTuneData) obj);
        }
    }
}
