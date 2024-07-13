package com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.buttons.common;

import android.content.Context;
import com.catfixture.inputbridge.R;

public class BType {
    public static final int BUTTON_TYPE_KEYBOARD = 0;
    public static final int BUTTON_TYPE_MOUSE = 1;
    public static final int BUTTON_TYPE_XINPUT = 2;
    public static String[] types;

    public static void Create(Context context) {
        types = new String[]{context.getString(R.string.keyb_text), context.getString(R.string.mouse_text), "XInput"};
    }
}
