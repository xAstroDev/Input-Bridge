package androidx.navigation.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.transition.TransitionManager;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\"\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001c\u0010\u0011\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0001\u0010\u0014\u001a\u00020\u0015H\u0014J\u0012\u0010\u0016\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Landroidx/navigation/ui/ToolbarOnDestinationChangedListener;", "Landroidx/navigation/ui/AbstractAppBarOnDestinationChangedListener;", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "configuration", "Landroidx/navigation/ui/AppBarConfiguration;", "(Landroidx/appcompat/widget/Toolbar;Landroidx/navigation/ui/AppBarConfiguration;)V", "toolbarWeakReference", "Ljava/lang/ref/WeakReference;", "onDestinationChanged", "", "controller", "Landroidx/navigation/NavController;", "destination", "Landroidx/navigation/NavDestination;", "arguments", "Landroid/os/Bundle;", "setNavigationIcon", "icon", "Landroid/graphics/drawable/Drawable;", "contentDescription", "", "setTitle", "title", "", "navigation-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ToolbarOnDestinationChangedListener.kt */
public final class ToolbarOnDestinationChangedListener extends AbstractAppBarOnDestinationChangedListener {
    private final WeakReference<Toolbar> toolbarWeakReference;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ToolbarOnDestinationChangedListener(androidx.appcompat.widget.Toolbar r3, androidx.navigation.ui.AppBarConfiguration r4) {
        /*
            r2 = this;
            java.lang.String r0 = "toolbar"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "configuration"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            android.content.Context r0 = r3.getContext()
            java.lang.String r1 = "toolbar.context"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r2.<init>(r0, r4)
            java.lang.ref.WeakReference r4 = new java.lang.ref.WeakReference
            r4.<init>(r3)
            r2.toolbarWeakReference = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.ui.ToolbarOnDestinationChangedListener.<init>(androidx.appcompat.widget.Toolbar, androidx.navigation.ui.AppBarConfiguration):void");
    }

    public void onDestinationChanged(NavController navController, NavDestination navDestination, Bundle bundle) {
        Intrinsics.checkNotNullParameter(navController, "controller");
        Intrinsics.checkNotNullParameter(navDestination, "destination");
        if (((Toolbar) this.toolbarWeakReference.get()) == null) {
            navController.removeOnDestinationChangedListener(this);
        } else {
            super.onDestinationChanged(navController, navDestination, bundle);
        }
    }

    /* access modifiers changed from: protected */
    public void setTitle(CharSequence charSequence) {
        Toolbar toolbar = (Toolbar) this.toolbarWeakReference.get();
        if (toolbar != null) {
            toolbar.setTitle(charSequence);
        }
    }

    /* access modifiers changed from: protected */
    public void setNavigationIcon(Drawable drawable, int i) {
        Toolbar toolbar = (Toolbar) this.toolbarWeakReference.get();
        if (toolbar != null) {
            boolean z = drawable == null && toolbar.getNavigationIcon() != null;
            toolbar.setNavigationIcon(drawable);
            toolbar.setNavigationContentDescription(i);
            if (z) {
                TransitionManager.beginDelayedTransition(toolbar);
            }
        }
    }
}
