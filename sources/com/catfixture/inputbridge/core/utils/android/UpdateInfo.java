package com.catfixture.inputbridge.core.utils.android;

public class UpdateInfo {
    public final String changelog;
    public final int versionCode;
    public final String versionName;

    public UpdateInfo(String str, int i, String str2) {
        this.versionName = str;
        this.versionCode = i;
        this.changelog = str2;
    }
}
