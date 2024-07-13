package com.catfixture.inputbridge.ui.common;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.input.core.AxisType;
import com.catfixture.inputbridge.core.input.core.MouseAxisValue;
import com.catfixture.inputbridge.core.input.core.XIStickAxisValue;
import com.catfixture.inputbridge.core.input.data.AxisBinding;
import com.catfixture.inputbridge.ui.utils.Utils;

public class AxisBindingsHelper {
    public static void LoadSelectedAxisSettings(Context context, View view, int i, AxisBinding axisBinding, Runnable runnable) {
        AxisType.Create(context);
        Spinner spinner = (Spinner) view.findViewById(R.id.axisType);
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) null);
        Utils.InitSpinner(context, spinner, axisBinding.axisType, i).addAll(AxisType.types);
        Utils.AttachSpinnerAction(spinner, new AxisBindingsHelper$$ExternalSyntheticLambda0(axisBinding, context, view, i, runnable));
        ReloadAxisSubtype(context, view, i, axisBinding, runnable);
    }

    static /* synthetic */ void lambda$LoadSelectedAxisSettings$0(AxisBinding axisBinding, Context context, View view, int i, Runnable runnable, Integer num) {
        if (axisBinding.axisType != num.intValue()) {
            axisBinding.axisType = num.intValue();
            ReloadAxisSubtype(context, view, i, axisBinding, runnable);
            runnable.run();
        }
    }

    public static void ReloadAxisSubtype(Context context, View view, int i, AxisBinding axisBinding, Runnable runnable) {
        int i2 = axisBinding.axisType == 0 ? 8 : 0;
        view.findViewById(R.id.axisSelectorLabel).setVisibility(i2);
        view.findViewById(R.id.axisSelector).setVisibility(i2);
        MouseAxisValue.Create(context);
        XIStickAxisValue.Create(context);
        Spinner spinner = (Spinner) view.findViewById(R.id.axisSelector);
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) null);
        Utils.InitSpinner(context, spinner, axisBinding.axisValue, i).addAll(axisBinding.axisType == 1 ? MouseAxisValue.types : XIStickAxisValue.types);
        Utils.AttachSpinnerAction(spinner, new AxisBindingsHelper$$ExternalSyntheticLambda1(axisBinding, runnable));
    }

    static /* synthetic */ void lambda$ReloadAxisSubtype$1(AxisBinding axisBinding, Runnable runnable, Integer num) {
        if (axisBinding.axisValue != num.intValue()) {
            axisBinding.axisValue = num.intValue();
            runnable.run();
        }
    }
}
