package com.catfixture.inputbridge.ui.activity.main.tabs;

import com.catfixture.inputbridge.core.context.ConfigContext;
import com.catfixture.inputbridge.core.utils.types.delegates.Action;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class MainActivityTabs$$ExternalSyntheticLambda0 implements Action {
    public static final /* synthetic */ MainActivityTabs$$ExternalSyntheticLambda0 INSTANCE = new MainActivityTabs$$ExternalSyntheticLambda0();

    private /* synthetic */ MainActivityTabs$$ExternalSyntheticLambda0() {
    }

    public final void Invoke(Object obj) {
        ConfigContext.data.SetCurrentMainTab(((Integer) obj).intValue());
    }
}
