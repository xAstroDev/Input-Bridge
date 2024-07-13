package com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.buttons.common;

import android.content.Context;
import com.catfixture.inputbridge.R;

public class Shapes {
    public static final int BUTTON_SHAPE_CIRCLE = 0;
    public static final int BUTTON_SHAPE_NONE = 3;
    public static final int BUTTON_SHAPE_RECT = 2;
    public static final int BUTTON_SHAPE_ROUNDED = 1;
    public static String[] shapes;

    public static void Create(Context context) {
        shapes = new String[]{context.getString(R.string.circle_shape_text), context.getString(R.string.rounded_shape_text), context.getString(R.string.rect_shape_text), "None"};
    }

    public static int SpinnerShapePos(String str) {
        int i = 0;
        for (String equals : shapes) {
            if (equals.equals(str)) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
