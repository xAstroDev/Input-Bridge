package com.catfixture.inputbridge.core.utils.datetime;

public class DateTimeUtils {
    public static int LongToDays(long j) {
        return (int) (j / 86400000);
    }

    public static int LongToMinutes(long j) {
        return (int) (j / 60000);
    }
}
