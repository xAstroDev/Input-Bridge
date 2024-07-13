package com.catfixture.inputbridge.ui.custom;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.context.AppContext;
import com.catfixture.inputbridge.core.utils.android.LayoutUtils;
import com.catfixture.inputbridge.core.utils.types.delegates.Action;
import okhttp3.HttpUrl;

public class Spoiler extends LinearLayout {
    private LinearLayout content;
    private RelativeLayout head;
    private boolean isExpanded;
    private ImageView spoilerStatus;

    public Spoiler(Context context) {
        super(context);
        Create(context, HttpUrl.FRAGMENT_ENCODE_SET, false, 0);
    }

    public Spoiler(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Spoiler, 0, 0);
        int integer = obtainStyledAttributes.getInteger(1, 0);
        String string = obtainStyledAttributes.getString(2);
        boolean z = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        Create(context, string, z, integer);
    }

    private void Create(Context context, String str, boolean z, int i) {
        inflate(context, R.layout.spoiler_layout, this);
        TextView textView = (TextView) findViewById(R.id.titleText);
        this.head = (RelativeLayout) findViewById(R.id.head);
        this.content = (LinearLayout) findViewById(R.id.content);
        this.spoilerStatus = (ImageView) findViewById(R.id.spoilerStatus);
        if (str != null) {
            textView.setText(str);
        }
        SharedPreferences sharedPreferences = AppContext.app.spoilerShaPrefs;
        boolean z2 = false;
        if (sharedPreferences.getBoolean("ISS" + i, false) || z) {
            z2 = true;
        }
        this.isExpanded = z2;
        SetExpanded(z2);
        this.head.setOnClickListener(new Spoiler$$ExternalSyntheticLambda0(this, i));
        LayoutUtils.RunJustBeforeBeingDrawn(this, new Spoiler$$ExternalSyntheticLambda2(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$Create$1$com-catfixture-inputbridge-ui-custom-Spoiler  reason: not valid java name */
    public /* synthetic */ void m238lambda$Create$1$comcatfixtureinputbridgeuicustomSpoiler(int i, View view) {
        this.isExpanded = !this.isExpanded;
        SharedPreferences.Editor edit = AppContext.app.spoilerShaPrefs.edit();
        SharedPreferences.Editor remove = edit.remove("ISS" + i);
        remove.putBoolean("ISS" + i, this.isExpanded).apply();
        SetExpanded(this.isExpanded);
        if (!this.isExpanded) {
            EnumChilds(this, Spoiler$$ExternalSyntheticLambda1.INSTANCE);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$Create$2$com-catfixture-inputbridge-ui-custom-Spoiler  reason: not valid java name */
    public /* synthetic */ void m239lambda$Create$2$comcatfixtureinputbridgeuicustomSpoiler() {
        int childCount = getChildCount();
        for (int i = 1; i <= childCount; i++) {
            View childAt = getChildAt(1);
            if (childAt != null) {
                removeView(childAt);
                this.content.addView(childAt);
            }
        }
    }

    public void EnumChilds(ViewGroup viewGroup, Action<Spoiler> action) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i <= childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof ViewGroup) {
                ViewGroup viewGroup2 = (ViewGroup) childAt;
                if (viewGroup2 instanceof Spoiler) {
                    action.Invoke((Spoiler) viewGroup2);
                }
                EnumChilds(viewGroup2, action);
            }
        }
    }

    public void SetExpanded(boolean z) {
        ImageView imageView = this.spoilerStatus;
        imageView.setBackground(ContextCompat.getDrawable(imageView.getContext(), z ? R.drawable.tc_minus_1 : R.drawable.tc_plus_1));
        this.content.setVisibility(z ? 0 : 8);
    }
}
