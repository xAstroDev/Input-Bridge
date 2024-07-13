package com.catfixture.inputbridge.ui.activity.main.fragments.generalSettings;

import android.content.Context;
import com.catfixture.inputbridge.core.Const;
import com.catfixture.inputbridge.core.weakmsg.WeakMsg;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class GeneralSettingsFragment$$ExternalSyntheticLambda6 implements Runnable {
    public final /* synthetic */ Context f$0;

    public /* synthetic */ GeneralSettingsFragment$$ExternalSyntheticLambda6(Context context) {
        this.f$0 = context;
    }

    public final void run() {
        WeakMsg.Send(this.f$0, (int) Const.BCAST_ACTION_STOP_SERVER);
    }
}
