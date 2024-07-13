package com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.cheatCode;

import android.content.Context;
import com.catfixture.inputbridge.R;

public class CCType {
    public static final int CHEAT_CODE_ACTION_TYPE_DELAY = 1;
    public static final int CHEAT_CODE_ACTION_TYPE_KEY = 0;
    public static final int CHEAT_CODE_ACTION_TYPE_TEXT = 2;
    public static String[] types;

    public static int SpinnerCheatCodeActionTypePos(String str) {
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
        types = new String[]{context.getString(R.string.key_code_text), context.getString(R.string.delay_text), context.getString(R.string.text_text)};
    }
}
