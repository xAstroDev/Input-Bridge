package com.catfixture.inputbridge.ui.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.catfixture.inputbridge.R;

public class WarningComponent extends LinearLayout {
    public WarningComponent(Context context) {
        super(context);
        Create(context, "Warning!");
    }

    public WarningComponent(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.WarningComponent, 0, 0);
        String string = obtainStyledAttributes.getString(0);
        obtainStyledAttributes.recycle();
        Create(context, string);
    }

    private void Create(Context context, String str) {
        inflate(context, R.layout.warning_component, this);
        ((TextView) findViewById(R.id.text)).setText(str);
    }
}
