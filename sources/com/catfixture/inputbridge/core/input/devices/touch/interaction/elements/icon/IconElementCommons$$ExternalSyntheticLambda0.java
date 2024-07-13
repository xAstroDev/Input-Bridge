package com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.icon;

import android.content.Context;
import android.view.View;
import com.catfixture.inputbridge.core.input.data.IconData;
import com.catfixture.inputbridge.core.input.utils.IInputWindowElement;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class IconElementCommons$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ Context f$0;
    public final /* synthetic */ IInputWindowElement f$1;
    public final /* synthetic */ IconData f$2;

    public /* synthetic */ IconElementCommons$$ExternalSyntheticLambda0(Context context, IInputWindowElement iInputWindowElement, IconData iconData) {
        this.f$0 = context;
        this.f$1 = iInputWindowElement;
        this.f$2 = iconData;
    }

    public final void onClick(View view) {
        IconElementCommons.lambda$InitIcons$2(this.f$0, this.f$1, this.f$2, view);
    }
}
