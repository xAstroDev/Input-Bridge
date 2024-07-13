package com.catfixture.inputbridge.core.GSS.SysDev;

public class SensorsNames {
    public static String[] names = {"GPU", "CPU", "BAT", "NET"};

    public static String GetByIndex(int i) {
        if (i < 0) {
            return "_";
        }
        String[] strArr = names;
        return i > strArr.length ? "_" : strArr[i];
    }
}
