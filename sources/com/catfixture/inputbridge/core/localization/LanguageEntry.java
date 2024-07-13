package com.catfixture.inputbridge.core.localization;

public class LanguageEntry {
    public final String locale;
    public final String name;

    public LanguageEntry(String str, String str2) {
        this.name = str;
        this.locale = str2;
    }

    public String toString() {
        return this.name;
    }
}
