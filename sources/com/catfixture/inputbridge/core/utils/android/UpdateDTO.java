package com.catfixture.inputbridge.core.utils.android;

public class UpdateDTO {
    public final String changelog;
    public final int vcode;
    public final String vname;

    public UpdateDTO(int i, String str, String str2) {
        this.vcode = i;
        this.vname = str;
        this.changelog = str2;
    }
}
