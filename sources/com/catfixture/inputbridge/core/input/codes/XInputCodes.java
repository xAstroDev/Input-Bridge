package com.catfixture.inputbridge.core.input.codes;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.catfixture.inputbridge.core.utils.types.delegates.Action;

public class XInputCodes {
    public static XInputCode[] codes;

    public static void Load(Context context) {
        codes = new XInputCode[]{new XInputCode("A", "A", 4096), new XInputCode("B", "B", 8192), new XInputCode("X", "X", 16384), new XInputCode("Y", "Y", 32768), new XInputCode("LS", "LS", 256), new XInputCode("RS", "RS", 512), new XInputCode("LTHUMB", "LB", 64), new XInputCode("RTHUMB", "RB", 128), new XInputCode("LTRIGGER", "LT", 65), new XInputCode("RTRIGGER", "RT", 66), new XInputCode("START", "START", 16), new XInputCode("BACK", "BACK", 32), new XInputCode("DPAD_UP", "DUP", 1), new XInputCode("DPAD_DOWN", "DDOWN", 2), new XInputCode("DPAD_LEFT", "DLEFT", 4), new XInputCode("DPAD_RIGHT", "DRIGHT", 8)};
    }

    public static String GetCodeName(int i) {
        for (XInputCode xInputCode : codes) {
            if (xInputCode.code == i) {
                return xInputCode.smallName;
            }
        }
        return null;
    }

    public static int GetCodeIndex(int i) {
        int i2 = 0;
        for (XInputCode xInputCode : codes) {
            if (xInputCode.code == i) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static String GetCodeSmallName(int i) {
        for (XInputCode xInputCode : codes) {
            if (xInputCode.code == i) {
                return xInputCode.smallName;
            }
        }
        return null;
    }

    public static ArrayAdapter<XInputCode> PrepareAdapter(Spinner spinner, int i, int i2, final Action<Integer> action) {
        Context context = spinner.getContext();
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) null);
        final ArrayAdapter<XInputCode> arrayAdapter = new ArrayAdapter<>(context, i2);
        arrayAdapter.addAll(codes);
        spinner.setAdapter(arrayAdapter);
        spinner.setSelection(GetCodeIndex(i));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                action.Invoke(Integer.valueOf(((XInputCode) arrayAdapter.getItem(i)).code));
            }
        });
        return arrayAdapter;
    }
}
