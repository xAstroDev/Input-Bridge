package com.catfixture.inputbridge.core.input.data;

import com.catfixture.inputbridge.ui.common.genAdapter.IAdapterItem;

public class ControllerRebindRecord implements IAdapterItem {
    public int buttonType = 0;
    public int codeDown = -1;
    public int codeLeft = -1;
    public int codeRight = -1;
    public int codeUp = -1;
    public int linkedCode;
    public int mouseCode = -1;
    public int movementType = -1;
    public int stickSide;
    public int windowsKeyCode = -1;
    public int xAxis;
    public int xinputCode = -1;
    public int yAxis;

    public int GetSpacing() {
        return 0;
    }

    public boolean IsVisible() {
        return true;
    }

    public void SetSpacing(int i) {
    }

    public void ToggleVisibility(boolean z) {
    }

    public void SetWindowsKeyCode(int i) {
        this.windowsKeyCode = i;
    }

    public void SetMouseCode(int i) {
        this.mouseCode = i;
    }

    public void SetXInputCode(int i) {
        this.xinputCode = i;
    }

    public void SetMovementType(int i) {
        this.movementType = i;
    }

    public void SetCodeUp(int i) {
        this.codeUp = i;
    }

    public void SetCodeDown(int i) {
        this.codeDown = i;
    }

    public void SetCodeLeft(int i) {
        this.codeLeft = i;
    }

    public void SetCodeRight(int i) {
        this.codeRight = i;
    }
}
