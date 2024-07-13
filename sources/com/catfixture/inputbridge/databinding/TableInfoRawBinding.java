package com.catfixture.inputbridge.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.catfixture.inputbridge.R;

public final class TableInfoRawBinding implements ViewBinding {
    public final TextView mainLabel;
    private final TableRow rootView;
    public final TextView smLabel;
    public final TextView valueLabel;

    private TableInfoRawBinding(TableRow tableRow, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = tableRow;
        this.mainLabel = textView;
        this.smLabel = textView2;
        this.valueLabel = textView3;
    }

    public TableRow getRoot() {
        return this.rootView;
    }

    public static TableInfoRawBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static TableInfoRawBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.table_info_raw, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TableInfoRawBinding bind(View view) {
        int i = R.id.mainLabel;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.mainLabel);
        if (textView != null) {
            i = R.id.smLabel;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.smLabel);
            if (textView2 != null) {
                i = R.id.valueLabel;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.valueLabel);
                if (textView3 != null) {
                    return new TableInfoRawBinding((TableRow) view, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
