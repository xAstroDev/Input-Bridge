package com.catfixture.inputbridge.core.inputbridge;

public class XIState {
    public short buttons;
    boolean isDirty = false;
    public byte leftTrigger;
    public byte rightTrigger;
    public short thumbLX;
    public short thumbLY;
    public short thumbRX;
    public short thumbRY;

    public void SetDirty() {
        this.isDirty = true;
    }

    public void Reset() {
        this.isDirty = false;
    }
}
