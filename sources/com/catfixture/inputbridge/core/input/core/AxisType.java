package com.catfixture.inputbridge.core.input.core;

import android.content.Context;
import com.catfixture.inputbridge.R;

public class AxisType {
    public static final int TYPE_MOUSE = 1;
    public static final int TYPE_NONE = 0;
    public static final int TYPE_XINPUT = 2;
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
        types = new String[]{"None", context.getString(R.string.mouse_text), "XInput"};
    }
}
