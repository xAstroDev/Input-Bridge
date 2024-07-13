package com.catfixture.inputbridge.ui.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.utils.android.LayoutUtils;

public class Crosshair extends LinearLayout {
    private final int lineWidthDP = 1;
    private RelativeLayout.LayoutParams xAxisLp;
    private View xAxisView;
    private RelativeLayout.LayoutParams yAxisLp;
    private View yAxisView;

    public Crosshair(Context context) {
        super(context);
        Create(context);
    }

    public Crosshair(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Create(context);
    }

    private void Create(Context context) {
        inflate(context, R.layout.crosshair_layout, this);
        this.xAxisView = findViewById(R.id.xAxis);
        this.yAxisView = findViewById(R.id.yAxis);
        int GetDP = LayoutUtils.GetDP(context, 1);
        this.xAxisLp = new RelativeLayout.LayoutParams(GetDP, -1);
        this.yAxisLp = new RelativeLayout.LayoutParams(-1, GetDP);
    }

    public void SetXY(int i, int i2) {
        this.xAxisLp.leftMargin = i;
        this.yAxisLp.topMargin = i2;
        this.xAxisView.setLayoutParams(this.xAxisLp);
        this.yAxisView.setLayoutParams(this.yAxisLp);
    }
}
