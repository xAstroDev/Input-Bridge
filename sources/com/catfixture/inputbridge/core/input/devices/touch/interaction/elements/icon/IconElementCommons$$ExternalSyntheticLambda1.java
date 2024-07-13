package com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.icon;

import android.view.View;
import com.catfixture.inputbridge.core.context.IconsCache;
import com.catfixture.inputbridge.core.utils.types.delegates.Action3;
import com.catfixture.inputbridge.ui.common.genAdapter.DisplayType;
import com.catfixture.inputbridge.ui.common.genAdapter.GenericSpinnerAdapter;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class IconElementCommons$$ExternalSyntheticLambda1 implements Action3 {
    public final /* synthetic */ GenericSpinnerAdapter f$0;
    public final /* synthetic */ IconsCache f$1;

    public /* synthetic */ IconElementCommons$$ExternalSyntheticLambda1(GenericSpinnerAdapter genericSpinnerAdapter, IconsCache iconsCache) {
        this.f$0 = genericSpinnerAdapter;
        this.f$1 = iconsCache;
    }

    public final void Invoke(Object obj, Object obj2, Object obj3) {
        IconElementCommons.lambda$InitIcons$1(this.f$0, this.f$1, (View) obj, (Integer) obj2, (DisplayType) obj3);
    }
}
