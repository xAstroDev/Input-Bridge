package com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.cheatCode;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.input.data.CheatCodeAction;
import okhttp3.HttpUrl;

public class CheatCodeDelayField {
    public static View Create(Context context, final CheatCodeAction cheatCodeAction, ViewGroup viewGroup) {
        EditText editText = (EditText) View.inflate(context, R.layout.cheat_code_delay_field, (ViewGroup) null);
        viewGroup.addView(editText);
        editText.setText(cheatCodeAction.delay + HttpUrl.FRAGMENT_ENCODE_SET);
        editText.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                try {
                    CheatCodeAction.this.SetDelay(Integer.parseInt(charSequence.toString()));
                } catch (Exception unused) {
                }
            }
        });
        return editText;
    }
}
