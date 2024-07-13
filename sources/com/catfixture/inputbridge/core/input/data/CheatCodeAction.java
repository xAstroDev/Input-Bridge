package com.catfixture.inputbridge.core.input.data;

import com.catfixture.inputbridge.core.context.ConfigContext;

public class CheatCodeAction {
    public int delay;
    public int keyCode;
    public String text;
    public int type;

    public void SetDelay(int i) {
        this.delay = i;
        ConfigContext.Save();
    }

    public void SetKeyCode(int i) {
        this.keyCode = i;
        ConfigContext.Save();
    }

    public void SetText(String str) {
        this.text = str;
        ConfigContext.Save();
    }
}
