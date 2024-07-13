package com.catfixture.inputbridge.core.input.data;

import com.catfixture.inputbridge.core.input.devices.touch.interaction.editor.finetune.ColorData;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.editor.finetune.ShapeFineTuneData;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.editor.finetune.TextFineTuneData;
import com.catfixture.inputbridge.core.utils.android.AndroidUtils;
import com.catfixture.inputbridge.core.utils.math.Int2;
import java.util.ArrayList;
import java.util.List;

public class InputTouchControlElementData {
    public float alpha = 1.0f;
    public int buttonShape;
    public int buttonType;
    public List<CheatCodeAction> cheatCodeActions = new ArrayList();
    public int codeDown = 83;
    public int codeLeft = 65;
    public int codeRight = 68;
    public int codeUp = 87;
    public List<KeyCombination> combinationCodes = new ArrayList();
    public IconData customIcon = new IconData();
    public String customText;
    public boolean eightDirMode = true;
    public boolean enableXI = false;
    public transient int firstMoveIndex;
    public int height = 400;
    public int id;
    public IconData innerCircleIcon = new IconData();
    public float innerCircleRadius = 1.0f;
    public transient boolean isDragging;
    public int lastSelectedAction;
    public int mouseCode;
    public int movementType;
    public Int2 position = new Int2(0, 0);
    public int scale = 100;
    public int sensivity = 100;
    public ShapeFineTuneData shapeFineTuneData = new ShapeFineTuneData();
    public int stickSide = 0;
    public AxisBinding swheelAxisBinding = new AxisBinding();
    public TextFineTuneData textFineTuneData = new TextFineTuneData();
    public ColorData triggerModeColor = new ColorData(-16776961);
    public int type = 1;
    public boolean useMouseMode;
    public boolean useTriggerMode;
    public int windowsKeyCode = -1;
    public int xinputCode = 1;

    public void SetEightDirMode(boolean z) {
        this.eightDirMode = z;
    }

    public void SetLastSelectedAction(int i) {
        this.lastSelectedAction = i;
    }

    public void SetCustomText(String str) {
        this.customText = str;
    }

    public void SetId(int i) {
        this.id = i;
    }

    public void SetHeight(int i) {
        this.height = i;
    }

    public void SetMouseCode(int i) {
        this.mouseCode = i;
    }

    public void SetPosition(Int2 int2) {
        this.position = int2;
    }

    public void SetAlpha(float f) {
        this.alpha = f;
    }

    public void SetScale(int i) {
        this.scale = i;
    }

    public void SetType(int i) {
        this.type = i;
    }

    public void SetKeyCode(int i) {
        this.windowsKeyCode = i;
    }

    public void SetSensivity(int i) {
        this.sensivity = i;
    }

    public void SetButtonType(Integer num) {
        this.buttonType = num.intValue();
    }

    public void SetMovementType(Integer num) {
        this.movementType = num.intValue();
    }

    public void SetButtonShape(Integer num) {
        this.buttonShape = num.intValue();
    }

    public void AddKeyToCombination(KeyCombination keyCombination) {
        this.combinationCodes.add(keyCombination);
    }

    public void RemoveCombination(KeyCombination keyCombination) {
        this.combinationCodes.remove(keyCombination);
    }

    public void SetUseTriggerMode(boolean z) {
        this.useTriggerMode = z;
    }

    public void SetUseMouseMode(boolean z) {
        this.useMouseMode = z;
    }

    public void SetCodeUp(Integer num) {
        this.codeUp = num.intValue();
    }

    public void SetCodeDown(Integer num) {
        this.codeDown = num.intValue();
    }

    public void SetCodeLeft(Integer num) {
        this.codeLeft = num.intValue();
    }

    public void SetCodeRight(Integer num) {
        this.codeRight = num.intValue();
    }

    public float GetSensivity() {
        return ((float) this.sensivity) / 100.0f;
    }

    public void AddCheatCodeAction() {
        CheatCodeAction cheatCodeAction = new CheatCodeAction();
        cheatCodeAction.type = this.lastSelectedAction;
        this.cheatCodeActions.add(cheatCodeAction);
    }

    public void CopyStyle(InputTouchControlElementData inputTouchControlElementData) {
        this.buttonShape = inputTouchControlElementData.buttonShape;
        this.shapeFineTuneData = (ShapeFineTuneData) AndroidUtils.DeepClone(inputTouchControlElementData.shapeFineTuneData, ShapeFineTuneData.class);
        this.textFineTuneData = (TextFineTuneData) AndroidUtils.DeepClone(inputTouchControlElementData.textFineTuneData, TextFineTuneData.class);
        this.customIcon = (IconData) AndroidUtils.DeepClone(inputTouchControlElementData.customIcon, IconData.class);
        this.alpha = inputTouchControlElementData.alpha;
    }

    public void SetXInputCode(int i) {
        this.xinputCode = i;
    }
}
