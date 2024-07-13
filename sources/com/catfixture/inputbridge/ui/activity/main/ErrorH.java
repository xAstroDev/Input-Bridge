package com.catfixture.inputbridge.ui.activity.main;

import android.content.Context;
import android.content.Intent;

public class ErrorH {
    public static void RaiseCrash(Context context, String str, String str2) {
        if (context != null) {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.addFlags(268435456);
            intent.putExtra("android.intent.extra.TEXT", "Greetings! Error occurred! \n" + str + " \n " + str2);
            intent.setType("text/plain");
            context.startActivity(intent);
        }
    }
}
