package com.catfixture.inputbridge.core.input.codes;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.utils.types.delegates.Action;

public class MouseCodes {
    public static MouseCode[] codes;

    public static void Load(Context context) {
        codes = new MouseCode[]{new MouseCode(context.getString(R.string.left_button), "LB", 0), new MouseCode(context.getString(R.string.right_button), "RB", 1), new MouseCode(context.getString(R.string.middle_button), "MB", 2)};
    }

    public static String GetCodeName(int i) {
        for (MouseCode mouseCode : codes) {
            if (mouseCode.code == i) {
                return mouseCode.name;
            }
        }
        return null;
    }

    public static int GetCodeIndex(int i) {
        int i2 = 0;
        for (MouseCode mouseCode : codes) {
            if (mouseCode.code == i) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static String GetCodeSmallName(int i) {
        for (MouseCode mouseCode : codes) {
            if (mouseCode.code == i) {
                return mouseCode.smallName;
            }
        }
        return null;
    }

    public static ArrayAdapter<MouseCode> PrepareAdapter(Spinner spinner, int i, int i2, final Action<Integer> action) {
        Context context = spinner.getContext();
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) null);
        final ArrayAdapter<MouseCode> arrayAdapter = new ArrayAdapter<>(context, i2);
        arrayAdapter.addAll(codes);
        spinner.setAdapter(arrayAdapter);
        spinner.setSelection(GetCodeIndex(i));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                action.Invoke(Integer.valueOf(((MouseCode) arrayAdapter.getItem(i)).code));
            }
        });
        return arrayAdapter;
    }
}
