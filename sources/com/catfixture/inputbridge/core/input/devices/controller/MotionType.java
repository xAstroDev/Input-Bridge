package com.catfixture.inputbridge.core.input.devices.controller;

import android.content.Context;
import com.catfixture.inputbridge.R;

public class MotionType {
    public static final int MOTION_TYPE_LOOK_HORIZ = 2;
    public static final int MOTION_TYPE_LOOK_VERT = 3;
    public static final int MOTION_TYPE_MOVE_HORIZ = 0;
    public static final int MOTION_TYPE_MOVE_VERT = 1;
    public static final int MOTION_TYPE_MULTIBIND = 4;
    public static String[] types;

    public static int SpinnerPos(String str) {
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
        types = new String[]{context.getString(R.string.motion_type_move_hor), context.getString(R.string.motion_type_move_ver), context.getString(R.string.motion_type_look_hor), context.getString(R.string.motion_type_look_ver), context.getString(R.string.multibind_text)};
    }
}
