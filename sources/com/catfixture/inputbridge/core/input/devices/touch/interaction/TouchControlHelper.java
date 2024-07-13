package com.catfixture.inputbridge.core.input.devices.touch.interaction;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import com.catfixture.inputbridge.R;

public class TouchControlHelper {
    public static TextView CreateButtonLabel(Context context) {
        TextView textView = new TextView(context);
        textView.setTextColor(context.getColor(R.color.white));
        textView.setTextSize(14.0f);
        textView.setSingleLine(false);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setLines(1);
        return textView;
    }
}
