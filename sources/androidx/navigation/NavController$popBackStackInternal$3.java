package androidx.navigation;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/navigation/NavDestination;", "destination", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: NavController.kt */
final class NavController$popBackStackInternal$3 extends Lambda implements Function1<NavDestination, NavDestination> {
    public static final NavController$popBackStackInternal$3 INSTANCE = new NavController$popBackStackInternal$3();

    NavController$popBackStackInternal$3() {
        super(1);
    }

    public final NavDestination invoke(NavDestination navDestination) {
        Intrinsics.checkNotNullParameter(navDestination, "destination");
        NavGraph parent = navDestination.getParent();
        boolean z = false;
        if (parent != null && parent.getStartDestinationId() == navDestination.getId()) {
            z = true;
        }
        if (z) {
            return navDestination.getParent();
        }
        NavDestination navDestination2 = null;
        return null;
    }
}
