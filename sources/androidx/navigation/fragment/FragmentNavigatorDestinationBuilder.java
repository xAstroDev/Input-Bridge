package androidx.navigation.fragment;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavDestinationBuilder;
import androidx.navigation.NavDestinationDsl;
import androidx.navigation.fragment.FragmentNavigator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B)\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b¢\u0006\u0002\u0010\nB'\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u0002H\u0016R\u0016\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/navigation/fragment/FragmentNavigatorDestinationBuilder;", "Landroidx/navigation/NavDestinationBuilder;", "Landroidx/navigation/fragment/FragmentNavigator$Destination;", "navigator", "Landroidx/navigation/fragment/FragmentNavigator;", "id", "", "fragmentClass", "Lkotlin/reflect/KClass;", "Landroidx/fragment/app/Fragment;", "(Landroidx/navigation/fragment/FragmentNavigator;ILkotlin/reflect/KClass;)V", "route", "", "(Landroidx/navigation/fragment/FragmentNavigator;Ljava/lang/String;Lkotlin/reflect/KClass;)V", "build", "navigation-fragment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@NavDestinationDsl
/* compiled from: FragmentNavigatorDestinationBuilder.kt */
public final class FragmentNavigatorDestinationBuilder extends NavDestinationBuilder<FragmentNavigator.Destination> {
    private KClass<? extends Fragment> fragmentClass;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "Use routes to build your FragmentNavigatorDestination instead", replaceWith = @ReplaceWith(expression = "FragmentNavigatorDestinationBuilder(navigator, route = id.toString(), fragmentClass) ", imports = {}))
    public FragmentNavigatorDestinationBuilder(FragmentNavigator fragmentNavigator, int i, KClass<? extends Fragment> kClass) {
        super(fragmentNavigator, i);
        Intrinsics.checkNotNullParameter(fragmentNavigator, "navigator");
        Intrinsics.checkNotNullParameter(kClass, "fragmentClass");
        this.fragmentClass = kClass;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FragmentNavigatorDestinationBuilder(FragmentNavigator fragmentNavigator, String str, KClass<? extends Fragment> kClass) {
        super(fragmentNavigator, str);
        Intrinsics.checkNotNullParameter(fragmentNavigator, "navigator");
        Intrinsics.checkNotNullParameter(str, "route");
        Intrinsics.checkNotNullParameter(kClass, "fragmentClass");
        this.fragmentClass = kClass;
    }

    public FragmentNavigator.Destination build() {
        FragmentNavigator.Destination destination = (FragmentNavigator.Destination) super.build();
        String name = JvmClassMappingKt.getJavaClass(this.fragmentClass).getName();
        Intrinsics.checkNotNullExpressionValue(name, "fragmentClass.java.name");
        destination.setClassName(name);
        return destination;
    }
}
