package com.catfixture.inputbridge.core.input.devices.touch.interaction.types;

import android.content.Context;
import com.catfixture.inputbridge.R;

public class TouchableWindowElementType {
    public static final int TYPE_BUTTON = 1;
    public static final int TYPE_BUTTON_COMBINATION = 2;
    public static final int TYPE_CHEAT_CODE = 7;
    public static final int TYPE_CROSS = 3;
    public static final int TYPE_MOUSE_ZONE = 5;
    public static final int TYPE_SCROLL = 6;
    public static final int TYPE_STICK = 4;
    public static final int TYPE_SWHEEL = 9;
    public static final int TYPE_SWIPE = 8;
    public static TouchableWindowElementSpinnerData[] spinnerData;

    public static void Create(Context context) {
        spinnerData = new TouchableWindowElementSpinnerData[]{new TouchableWindowElementSpinnerData(context.getString(R.string.button_el_text), 1), new TouchableWindowElementSpinnerData(context.getString(R.string.button_el_combine_text), 2), new TouchableWindowElementSpinnerData(context.getString(R.string.cross_el_text), 3), new TouchableWindowElementSpinnerData(context.getString(R.string.stick_el_text), 4), new TouchableWindowElementSpinnerData(context.getString(R.string.swipe_text), 8), new TouchableWindowElementSpinnerData(context.getString(R.string.mouse_zone_el_text), 5), new TouchableWindowElementSpinnerData(context.getString(R.string.scroll_el_text), 6), new TouchableWindowElementSpinnerData(context.getString(R.string.swheel_el_text), 9), new TouchableWindowElementSpinnerData(context.getString(R.string.cheat_code_text), 7)};
    }

    public static int SpinnerDataPos(int i) {
        int i2 = 0;
        for (TouchableWindowElementSpinnerData touchableWindowElementSpinnerData : spinnerData) {
            if (touchableWindowElementSpinnerData.id == i) {
                return i2;
            }
            i2++;
        }
        return -1;
    }
}
