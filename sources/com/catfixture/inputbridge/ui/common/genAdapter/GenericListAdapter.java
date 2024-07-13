package com.catfixture.inputbridge.ui.common.genAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.catfixture.inputbridge.core.utils.types.delegates.Action2;
import com.catfixture.inputbridge.ui.common.genAdapter.IAdapterItem;
import java.util.ArrayList;
import java.util.List;

public class GenericListAdapter<T extends IAdapterItem> extends RecyclerView.Adapter<GenericViewHolder> {
    protected final List<T> items = new ArrayList();
    private final int layout;
    private final Action2<T, View> onBind;

    public GenericListAdapter(int i, Action2<T, View> action2) {
        this.layout = i;
        this.onBind = action2;
    }

    public GenericViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new GenericViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(this.layout, viewGroup, false));
    }

    public void onBindViewHolder(GenericViewHolder genericViewHolder, int i) {
        IAdapterItem iAdapterItem = (IAdapterItem) this.items.get(i);
        if (!iAdapterItem.IsVisible()) {
            genericViewHolder.Hide();
        } else {
            genericViewHolder.Show();
        }
        genericViewHolder.SetMarginTop(iAdapterItem.GetSpacing());
        this.onBind.Invoke(iAdapterItem, genericViewHolder.itemView);
    }

    public int getItemCount() {
        return this.items.size();
    }

    public void AddItem(T t) {
        this.items.add(t);
        notifyItemInserted(this.items.size() - 1);
    }

    public void RemoveItem(int i) {
        this.items.remove(i);
        notifyItemRemoved(i);
    }

    public List<T> GetItems() {
        return this.items;
    }

    public void Flush() {
        this.items.clear();
        notifyDataSetChanged();
    }
}
