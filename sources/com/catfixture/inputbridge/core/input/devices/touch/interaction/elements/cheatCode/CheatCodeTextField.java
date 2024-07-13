package com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.cheatCode;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.input.data.CheatCodeAction;

public class CheatCodeTextField {
    public static View Create(Context context, final CheatCodeAction cheatCodeAction, LinearLayout linearLayout) {
        EditText editText = (EditText) View.inflate(context, R.layout.cheat_code_text_field, (ViewGroup) null);
        linearLayout.addView(editText);
        editText.setText(cheatCodeAction.text);
        editText.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                CheatCodeAction.this.SetText(charSequence.toString());
            }
        });
        return editText;
    }
}
