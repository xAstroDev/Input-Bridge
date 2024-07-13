package com.catfixture.inputbridge.ui.common.genAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.catfixture.inputbridge.core.utils.types.delegates.Action2;
import com.catfixture.inputbridge.ui.common.genAdapter.IMultiViewAdapterItem;

public class GenericMultiViewListAdapter<T extends IMultiViewAdapterItem> extends GenericListAdapter<T> {
    private final int[] layouts;

    public GenericMultiViewListAdapter(int[] iArr, Action2<T, View> action2) {
        super(iArr[0], action2);
        this.layouts = iArr;
    }

    public GenericViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new GenericViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(this.layouts[i], viewGroup, false));
    }

    public int getItemViewType(int i) {
        return ((IMultiViewAdapterItem) this.items.get(i)).GetViewType();
    }
}
