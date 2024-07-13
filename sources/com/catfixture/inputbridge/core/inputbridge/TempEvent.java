package com.catfixture.inputbridge.core.inputbridge;

public class TempEvent {
    public byte cmd;
    public int data;

    public TempEvent(byte b, int i) {
        this.cmd = b;
        this.data = i;
    }
}
