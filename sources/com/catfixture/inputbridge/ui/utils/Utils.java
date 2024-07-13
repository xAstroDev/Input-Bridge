package com.catfixture.inputbridge.ui.utils;

import android.content.Context;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import com.catfixture.inputbridge.core.utils.types.delegates.Action;

public class Utils {
    public static float DigitsAfterComma(float f, int i) {
        float f2 = (float) ((int) f);
        return f2 + (((float) ((int) ((f - f2) * 100.0f))) / 100.0f);
    }

    public static float Map(float f, float f2, float f3, float f4, float f5) {
        return (((f - f2) * (f5 - f4)) / (f3 - f2)) + f4;
    }

    public static <T> ArrayAdapter<T> InitSpinner(Context context, Spinner spinner, int i, int i2) {
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) null);
        ArrayAdapter<T> arrayAdapter = new ArrayAdapter<>(context, i2);
        spinner.setAdapter(arrayAdapter);
        spinner.setSelection(i);
        return arrayAdapter;
    }

    public static void AttachSpinnerAction(Spinner spinner, Action<Integer> action) {
        spinner.post(new Utils$$ExternalSyntheticLambda0(spinner, action));
    }

    public static void InitSeekBar(SeekBar seekBar, final TextView textView, int i, final Action<Integer> action) {
        seekBar.setProgress(i);
        textView.setText(Integer.toString(i));
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                textView.setText(Integer.toString(i));
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                action.Invoke(Integer.valueOf(seekBar.getProgress()));
            }
        });
    }
}
