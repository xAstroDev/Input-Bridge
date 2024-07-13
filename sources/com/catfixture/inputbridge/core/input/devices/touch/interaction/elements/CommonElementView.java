package com.catfixture.inputbridge.core.input.devices.touch.interaction.elements;

import android.content.Context;
import com.catfixture.inputbridge.core.input.codes.KeyCodes;
import com.catfixture.inputbridge.core.input.codes.MouseCodes;
import com.catfixture.inputbridge.core.input.codes.XInputCodes;

public class CommonElementView {
    public static void InitCommon(Context context, TouchableWindowElement touchableWindowElement) {
        if (touchableWindowElement.data.buttonShape == 2) {
            touchableWindowElement.initialSize.Set(200.0f, 100.0f);
        } else {
            touchableWindowElement.initialSize.Set(150.0f, 150.0f);
        }
        MouseCodes.Load(context);
        KeyCodes.LoadKeyCodes(context);
        XInputCodes.Load(context);
    }
}
