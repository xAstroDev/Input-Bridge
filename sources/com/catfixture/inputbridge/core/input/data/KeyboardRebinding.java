package com.catfixture.inputbridge.core.input.data;

import com.catfixture.inputbridge.core.context.ConfigContext;

public class KeyboardRebinding {
    public int buttonType;
    public int targetCode;

    public void SetButtonType(Integer num) {
        this.buttonType = num.intValue();
        Save();
    }

    public void SetTargetCode(int i) {
        this.targetCode = i;
        Save();
    }

    private void Save() {
        ConfigContext.Save();
    }
}
