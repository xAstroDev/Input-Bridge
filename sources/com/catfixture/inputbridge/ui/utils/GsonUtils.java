package com.catfixture.inputbridge.ui.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtils {
    public static Gson Create() {
        return new GsonBuilder().serializeNulls().setLenient().enableComplexMapKeySerialization().disableHtmlEscaping().create();
    }
}
