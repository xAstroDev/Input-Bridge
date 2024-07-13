package com.catfixture.inputbridge.ui.common.genAdapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.utils.types.delegates.Action;
import com.catfixture.inputbridge.core.utils.types.delegates.Action3;
import java.util.List;

public class GenericSpinnerAdapter<T> extends ArrayAdapter<T> {
    private final Context context;
    private Action3<View, Integer, DisplayType> customTitleAction;
    private final Action<Integer> onRemove;
    private final int textViewResourceId;

    public GenericSpinnerAdapter(Context context2, int i, List<T> list, Action<Integer> action) {
        super(context2, R.layout.support_simple_spinner_dropdown_item, list);
        this.context = context2;
        this.textViewResourceId = i;
        this.onRemove = action;
    }

    public GenericSpinnerAdapter(Context context2, int i, T[] tArr, Action<Integer> action) {
        super(context2, R.layout.support_simple_spinner_dropdown_item, tArr);
        this.context = context2;
        this.textViewResourceId = i;
        this.onRemove = action;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return prepareView(i, view, viewGroup, DisplayType.Normal);
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        return prepareView(i, view, viewGroup, DisplayType.Dropdown);
    }

    public void EnableCustomItemAction(Action3<View, Integer, DisplayType> action3) {
        this.customTitleAction = action3;
    }

    private View prepareView(int i, View view, ViewGroup viewGroup, DisplayType displayType) {
        if (view == null) {
            view = View.inflate(this.context, this.textViewResourceId, (ViewGroup) null);
        }
        try {
            ((TextView) view.findViewById(R.id.text)).setText(getItem(i).toString());
            Action3<View, Integer, DisplayType> action3 = this.customTitleAction;
            if (action3 != null) {
                action3.Invoke(view, Integer.valueOf(i), displayType);
            }
        } catch (Exception unused) {
        }
        return view;
    }
}
