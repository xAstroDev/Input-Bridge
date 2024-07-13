package com.catfixture.inputbridge.core.input.codes;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.debug.D;
import com.catfixture.inputbridge.core.utils.types.delegates.Action;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import okhttp3.HttpUrl;

public class KeyCodes {
    public static LinkedHashMap<Integer, KeyCode> androidPrimaryCodes = new LinkedHashMap<>();
    public static LinkedHashMap<Integer, KeyCode> windowsPrimaryCodes = new LinkedHashMap<>();

    public static void LoadKeyCodes(Context context) {
        windowsPrimaryCodes.clear();
        androidPrimaryCodes.clear();
        InputStream openRawResource = context.getResources().openRawResource(R.raw.key);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openRawResource));
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    if (!readLine.equals(HttpUrl.FRAGMENT_ENCODE_SET)) {
                        String[] split = readLine.split("=");
                        int parseInt = Integer.parseInt(split[1]);
                        int parseInt2 = Integer.parseInt(split[2]);
                        KeyCode keyCode = new KeyCode(split[0], parseInt, parseInt2);
                        windowsPrimaryCodes.put(Integer.valueOf(parseInt), keyCode);
                        androidPrimaryCodes.put(Integer.valueOf(parseInt2), keyCode);
                    }
                }
            } catch (Exception e) {
                D.E((Throwable) e);
            }
            try {
                break;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        openRawResource.close();
    }

    public static KeyCode GetKeyCodeByWindowsKeyCode(int i) {
        if (windowsPrimaryCodes.containsKey(Integer.valueOf(i))) {
            return windowsPrimaryCodes.get(Integer.valueOf(i));
        }
        return null;
    }

    public static KeyCode GetKeyCodeByAndroidKeyCode(int i) {
        if (androidPrimaryCodes.containsKey(Integer.valueOf(i))) {
            return androidPrimaryCodes.get(Integer.valueOf(i));
        }
        return null;
    }

    private static void Inflate(ArrayAdapter<KeyCode> arrayAdapter) {
        for (Map.Entry<Integer, KeyCode> value : windowsPrimaryCodes.entrySet()) {
            arrayAdapter.add((KeyCode) value.getValue());
        }
    }

    public static ArrayAdapter<KeyCode> PrepareAdapter(Spinner spinner, int i, int i2, final Action<Integer> action) {
        Context context = spinner.getContext();
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) null);
        final ArrayAdapter<KeyCode> arrayAdapter = new ArrayAdapter<>(context, i2);
        Inflate(arrayAdapter);
        spinner.setAdapter(arrayAdapter);
        spinner.setSelection(arrayAdapter.getPosition(GetKeyCodeByWindowsKeyCode(i)));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                action.Invoke(Integer.valueOf(((KeyCode) arrayAdapter.getItem(i)).windowsKeyCode));
            }
        });
        return arrayAdapter;
    }

    public static int CharToKeyCode(char c) {
        return Character.toUpperCase(c);
    }
}
