package com.catfixture.inputbridge.ui.common.interactions;

import android.content.DialogInterface;
import android.widget.EditText;
import com.catfixture.inputbridge.core.utils.types.delegates.Action;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class InputDialog$$ExternalSyntheticLambda1 implements DialogInterface.OnClickListener {
    public final /* synthetic */ Action f$0;
    public final /* synthetic */ EditText f$1;

    public /* synthetic */ InputDialog$$ExternalSyntheticLambda1(Action action, EditText editText) {
        this.f$0 = action;
        this.f$1 = editText;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        InputDialog.lambda$ShowLabeled$1(this.f$0, this.f$1, dialogInterface, i);
    }
}
