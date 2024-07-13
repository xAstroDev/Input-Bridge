package com.catfixture.inputbridge.core.inputbridge;

import android.content.Context;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.debug.D;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DriverCheck {
    public static int ReadVersion(Context context) {
        try {
            InputStream openRawResource = context.getResources().openRawResource(R.raw.driver);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openRawResource));
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            openRawResource.close();
            return Integer.parseInt(readLine.split(" ")[2]);
        } catch (Exception e) {
            e.printStackTrace();
            D.E((Throwable) e);
            return -1;
        }
    }
}
