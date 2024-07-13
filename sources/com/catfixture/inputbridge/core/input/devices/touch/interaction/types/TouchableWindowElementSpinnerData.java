package com.catfixture.inputbridge.core.input.devices.touch.interaction.types;

public class TouchableWindowElementSpinnerData {
    public final int id;
    public final String name;

    public TouchableWindowElementSpinnerData(String str, int i) {
        this.name = str;
        this.id = i;
    }

    public String toString() {
        return this.name;
    }
}
