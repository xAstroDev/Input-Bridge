package com.catfixture.inputbridge.core.context;

import com.catfixture.inputbridge.core.input.data.InputConfigData;
import com.catfixture.inputbridge.core.utils.data.GenericConfig;

public class ConfigContext {
    public static InputConfigData data;
    private static GenericConfig<InputConfigData> inputConfig;

    public static void Save() {
        inputConfig.Save();
    }

    public static void Init(String str) {
        GenericConfig<InputConfigData> genericConfig = new GenericConfig<>(str + "/input.json", InputConfigData.class);
        inputConfig = genericConfig;
        data = genericConfig.GetData();
    }
}
