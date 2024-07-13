package com.catfixture.inputbridge.ui.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.catfixture.inputbridge.R;
import okhttp3.HttpUrl;

public class ServiceButton extends LinearLayout {
    public ServiceButton(Context context) {
        super(context);
        Create(context, HttpUrl.FRAGMENT_ENCODE_SET, (Drawable) null, (Drawable) null, 0);
    }

    public ServiceButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ServiceButton, 0, 0);
        String string = obtainStyledAttributes.getString(3);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        Drawable drawable2 = obtainStyledAttributes.getDrawable(0);
        int i = obtainStyledAttributes.getInt(2, 0);
        obtainStyledAttributes.recycle();
        Create(context, string, drawable, drawable2, i);
    }

    private void Create(Context context, String str, Drawable drawable, Drawable drawable2, int i) {
        inflate(context, R.layout.service_button_layout, this);
        TextView textView = (TextView) findViewById(R.id.text);
        textView.setText(str);
        if (drawable != null) {
            ((ImageView) findViewById(R.id.icon)).setImageDrawable(drawable);
        }
        if (drawable2 != null) {
            ((LinearLayout) findViewById(R.id.main)).setBackground(drawable2);
        }
        if (i != 0) {
            textView.setTextColor(i);
        }
    }
}
