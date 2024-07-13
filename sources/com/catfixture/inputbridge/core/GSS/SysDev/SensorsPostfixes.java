package com.catfixture.inputbridge.core.GSS.SysDev;

import okhttp3.HttpUrl;

public class SensorsPostfixes {
    public static String[] names = {HttpUrl.FRAGMENT_ENCODE_SET, "%", "℃", "mAh", "Ah", "mW", "mA", "W"};

    public static String GetByIndex(int i) {
        if (i < 0) {
            return "_";
        }
        String[] strArr = names;
        return i > strArr.length ? "_" : strArr[i];
    }
}
