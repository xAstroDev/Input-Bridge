package com.catfixture.inputbridge.core.colorpicker;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.editor.finetune.ColorData;

public class ColorPickerUtils {
    public static void InitColorPicker(Context context, String str, View view, ColorData colorData, Runnable runnable) {
        View findViewById = view.findViewById(R.id.color);
        findViewById.setBackgroundColor(colorData.color);
        ((TextView) view.findViewById(R.id.text)).setText(str);
        findViewById.setOnClickListener(new ColorPickerUtils$$ExternalSyntheticLambda0(findViewById, context, colorData, runnable, view));
    }

    static /* synthetic */ void lambda$InitColorPicker$1(View view, Context context, ColorData colorData, Runnable runnable, View view2, View view3) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        new ColorPickerDialog(context, new ColorPickerUtils$$ExternalSyntheticLambda1(view, colorData, runnable)).Show(view2, iArr[0], iArr[1], colorData.color);
    }

    static /* synthetic */ void lambda$InitColorPicker$0(View view, ColorData colorData, Runnable runnable, Integer num) {
        view.setBackgroundColor(num.intValue());
        colorData.color = num.intValue();
        if (runnable != null) {
            runnable.run();
        }
    }
}
