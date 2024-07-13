package com.catfixture.inputbridge.ui.utils;

import com.catfixture.inputbridge.core.context.ConfigContext;
import com.catfixture.inputbridge.core.input.data.InputConfigData;
import com.catfixture.inputbridge.core.input.data.InputConfigProfile;
import com.catfixture.inputbridge.core.utils.types.delegates.Action;

public class ProfileUtils {
    public static void ImportProfile(String str, Action<InputConfigData> action, Action<Exception> action2) {
        InputConfigData inputConfigData = ConfigContext.data;
        try {
            InputConfigProfile inputConfigProfile = (InputConfigProfile) GsonUtils.Create().fromJson(str, InputConfigProfile.class);
            if (inputConfigProfile != null) {
                inputConfigData.AddProfile(inputConfigProfile);
                inputConfigData.SetCurrentProfile(inputConfigData.profiles.size() - 1);
                if (action != null) {
                    action.Invoke(inputConfigData);
                }
            } else if (action2 != null) {
                action2.Invoke(new RuntimeException("GSON ERROR"));
            }
        } catch (Exception e) {
            if (action2 != null) {
                action2.Invoke(e);
            }
        }
    }
}
