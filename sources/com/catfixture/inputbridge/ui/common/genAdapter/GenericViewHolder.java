package com.catfixture.inputbridge.ui.common.genAdapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;

public class GenericViewHolder extends RecyclerView.ViewHolder {
    private final ViewGroup.LayoutParams hiddenParams = new LinearLayout.LayoutParams(0, 0);
    private final ViewGroup.LayoutParams shownParams;

    public GenericViewHolder(View view) {
        super(view);
        this.shownParams = view.getLayoutParams();
    }

    public void Show() {
        this.itemView.setLayoutParams(this.shownParams);
    }

    public void Hide() {
        this.itemView.setLayoutParams(this.hiddenParams);
    }

    public void SetMarginTop(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.itemView.getLayoutParams().width, this.itemView.getLayoutParams().height);
        layoutParams.setMargins(0, i, 0, 0);
        this.itemView.setLayoutParams(layoutParams);
    }
}
