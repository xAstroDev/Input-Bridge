package androidx.navigation.fragment;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DialogFragmentNavigator$$ExternalSyntheticLambda1 implements LifecycleEventObserver {
    public final /* synthetic */ DialogFragmentNavigator f$0;

    public /* synthetic */ DialogFragmentNavigator$$ExternalSyntheticLambda1(DialogFragmentNavigator dialogFragmentNavigator) {
        this.f$0 = dialogFragmentNavigator;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        DialogFragmentNavigator.m19observer$lambda3(this.f$0, lifecycleOwner, event);
    }
}
