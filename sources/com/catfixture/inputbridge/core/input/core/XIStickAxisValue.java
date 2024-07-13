package com.catfixture.inputbridge.core.input.core;

import android.content.Context;

public class XIStickAxisValue {
    public static String[] types;

    public static void Create(Context context) {
        types = new String[]{"Axis LX", "Axis LY", "Axis RX", "Axis RY", "Axis LT", "Axis RT"};
    }
}
