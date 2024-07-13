package com.catfixture.inputbridge.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.catfixture.inputbridge.R;

public final class OverlayStatisticsBinding implements ViewBinding {
    public final TextView apiText;
    public final TextView fpsSmLab;
    public final TextView fpsText;
    public final TableRow fpsTextCC;
    public final TextView ramSmLab;
    public final TextView ramText;
    public final TableRow ramTextCC;
    public final TextView ramTextLab;
    private final TableLayout rootView;

    private OverlayStatisticsBinding(TableLayout tableLayout, TextView textView, TextView textView2, TextView textView3, TableRow tableRow, TextView textView4, TextView textView5, TableRow tableRow2, TextView textView6) {
        this.rootView = tableLayout;
        this.apiText = textView;
        this.fpsSmLab = textView2;
        this.fpsText = textView3;
        this.fpsTextCC = tableRow;
        this.ramSmLab = textView4;
        this.ramText = textView5;
        this.ramTextCC = tableRow2;
        this.ramTextLab = textView6;
    }

    public TableLayout getRoot() {
        return this.rootView;
    }

    public static OverlayStatisticsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static OverlayStatisticsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.overlay_statistics, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static OverlayStatisticsBinding bind(View view) {
        int i = R.id.apiText;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.apiText);
        if (textView != null) {
            i = R.id.fpsSmLab;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.fpsSmLab);
            if (textView2 != null) {
                i = R.id.fpsText;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.fpsText);
                if (textView3 != null) {
                    i = R.id.fpsTextCC;
                    TableRow tableRow = (TableRow) ViewBindings.findChildViewById(view, R.id.fpsTextCC);
                    if (tableRow != null) {
                        i = R.id.ramSmLab;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.ramSmLab);
                        if (textView4 != null) {
                            i = R.id.ramText;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.ramText);
                            if (textView5 != null) {
                                i = R.id.ramTextCC;
                                TableRow tableRow2 = (TableRow) ViewBindings.findChildViewById(view, R.id.ramTextCC);
                                if (tableRow2 != null) {
                                    i = R.id.ramTextLab;
                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.ramTextLab);
                                    if (textView6 != null) {
                                        return new OverlayStatisticsBinding((TableLayout) view, textView, textView2, textView3, tableRow, textView4, textView5, tableRow2, textView6);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
