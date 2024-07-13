package com.catfixture.inputbridge.core.input.codes;

public class MouseCode {
    public final int code;
    public final String name;
    public final String smallName;

    public MouseCode(String str, String str2, int i) {
        this.name = str;
        this.code = i;
        this.smallName = str2;
    }

    public String toString() {
        return this.name;
    }
}
