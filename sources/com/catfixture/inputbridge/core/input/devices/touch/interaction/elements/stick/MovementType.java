package com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.stick;

import android.content.Context;
import com.catfixture.inputbridge.R;

public class MovementType {
    public static final int TYPE_LOOK = 1;
    public static final int TYPE_WALK = 0;
    public static final int TYPE_XI_STICK = 2;
    public static String[] types;

    public static int SpinnerMovementTypePos(String str) {
        int i = 0;
        for (String equals : types) {
            if (equals.equals(str)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static void Create(Context context) {
        types = new String[]{context.getString(R.string.movement_type_walk), context.getString(R.string.movement_type_look), "XInput stick"};
    }
}
