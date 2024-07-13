package com.catfixture.inputbridge.ui.utils;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import com.catfixture.inputbridge.core.utils.types.delegates.Action;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Utils$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ Spinner f$0;
    public final /* synthetic */ Action f$1;

    public /* synthetic */ Utils$$ExternalSyntheticLambda0(Spinner spinner, Action action) {
        this.f$0 = spinner;
        this.f$1 = action;
    }

    public final void run() {
        this.f$0.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                Action.this.Invoke(Integer.valueOf(i));
            }
        });
    }
}
