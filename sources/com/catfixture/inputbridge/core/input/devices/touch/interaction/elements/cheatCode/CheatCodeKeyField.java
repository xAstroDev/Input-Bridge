package com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.cheatCode;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.input.codes.KeyCodes;
import com.catfixture.inputbridge.core.input.data.CheatCodeAction;

public class CheatCodeKeyField {
    public static View Create(Context context, CheatCodeAction cheatCodeAction, LinearLayout linearLayout) {
        Spinner spinner = (Spinner) View.inflate(context, R.layout.cheat_code_key_field, (ViewGroup) null);
        linearLayout.addView(spinner);
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) null);
        KeyCodes.PrepareAdapter(spinner, cheatCodeAction.keyCode, R.layout.touch_controls_list_item, new CheatCodeKeyField$$ExternalSyntheticLambda0(cheatCodeAction));
        return spinner;
    }

    static /* synthetic */ void lambda$Create$0(CheatCodeAction cheatCodeAction, Integer num) {
        if (cheatCodeAction.keyCode != num.intValue()) {
            cheatCodeAction.SetKeyCode(num.intValue());
        }
    }
}
