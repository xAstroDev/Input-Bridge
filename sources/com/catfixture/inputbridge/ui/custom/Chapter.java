package com.catfixture.inputbridge.ui.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.catfixture.inputbridge.R;

public class Chapter extends LinearLayout {
    public Chapter(Context context) {
        super(context);
    }

    public Chapter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Chapter, 0, 0);
        String string = obtainStyledAttributes.getString(0);
        obtainStyledAttributes.recycle();
        Create(context, string);
    }

    private void Create(Context context, String str) {
        inflate(context, R.layout.chapter_layout, this);
        if (str != null) {
            ((TextView) findViewById(R.id.title)).setText(str);
        }
    }
}
