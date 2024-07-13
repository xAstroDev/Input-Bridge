package androidx.navigation.fragment;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavGraphBuilder;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a#\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\b\u001a?\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\nH\bø\u0001\u0000\u001a!\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\b\u001a=\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\nH\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\r"}, d2 = {"fragment", "", "F", "Landroidx/fragment/app/Fragment;", "Landroidx/navigation/NavGraphBuilder;", "id", "", "builder", "Lkotlin/Function1;", "Landroidx/navigation/fragment/FragmentNavigatorDestinationBuilder;", "Lkotlin/ExtensionFunctionType;", "route", "", "navigation-fragment_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: FragmentNavigatorDestinationBuilder.kt */
public final class FragmentNavigatorDestinationBuilderKt {
    @Deprecated(message = "Use routes to create your FragmentDestination instead", replaceWith = @ReplaceWith(expression = "fragment<F>(route = id.toString()) { builder.invoke() }", imports = {}))
    public static final /* synthetic */ <F extends Fragment> void fragment(NavGraphBuilder navGraphBuilder, int i, Function1<? super FragmentNavigatorDestinationBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(navGraphBuilder, "<this>");
        Intrinsics.checkNotNullParameter(function1, "builder");
        Intrinsics.reifiedOperationMarker(4, "F");
        FragmentNavigatorDestinationBuilder fragmentNavigatorDestinationBuilder = new FragmentNavigatorDestinationBuilder((FragmentNavigator) navGraphBuilder.getProvider().getNavigator(FragmentNavigator.class), i, (KClass<? extends Fragment>) Reflection.getOrCreateKotlinClass(Fragment.class));
        function1.invoke(fragmentNavigatorDestinationBuilder);
        navGraphBuilder.destination(fragmentNavigatorDestinationBuilder);
    }

    public static final /* synthetic */ <F extends Fragment> void fragment(NavGraphBuilder navGraphBuilder, String str, Function1<? super FragmentNavigatorDestinationBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(navGraphBuilder, "<this>");
        Intrinsics.checkNotNullParameter(str, "route");
        Intrinsics.checkNotNullParameter(function1, "builder");
        Intrinsics.reifiedOperationMarker(4, "F");
        FragmentNavigatorDestinationBuilder fragmentNavigatorDestinationBuilder = new FragmentNavigatorDestinationBuilder((FragmentNavigator) navGraphBuilder.getProvider().getNavigator(FragmentNavigator.class), str, (KClass<? extends Fragment>) Reflection.getOrCreateKotlinClass(Fragment.class));
        function1.invoke(fragmentNavigatorDestinationBuilder);
        navGraphBuilder.destination(fragmentNavigatorDestinationBuilder);
    }

    @Deprecated(message = "Use routes to create your FragmentDestination instead", replaceWith = @ReplaceWith(expression = "fragment<F>(route = id.toString())", imports = {}))
    public static final /* synthetic */ <F extends Fragment> void fragment(NavGraphBuilder navGraphBuilder, int i) {
        Intrinsics.checkNotNullParameter(navGraphBuilder, "<this>");
        Intrinsics.reifiedOperationMarker(4, "F");
        FragmentNavigatorDestinationBuilder fragmentNavigatorDestinationBuilder = new FragmentNavigatorDestinationBuilder((FragmentNavigator) navGraphBuilder.getProvider().getNavigator(FragmentNavigator.class), i, (KClass<? extends Fragment>) Reflection.getOrCreateKotlinClass(Fragment.class));
        FragmentNavigatorDestinationBuilder fragmentNavigatorDestinationBuilder2 = fragmentNavigatorDestinationBuilder;
        navGraphBuilder.destination(fragmentNavigatorDestinationBuilder);
    }

    public static final /* synthetic */ <F extends Fragment> void fragment(NavGraphBuilder navGraphBuilder, String str) {
        Intrinsics.checkNotNullParameter(navGraphBuilder, "<this>");
        Intrinsics.checkNotNullParameter(str, "route");
        Intrinsics.reifiedOperationMarker(4, "F");
        FragmentNavigatorDestinationBuilder fragmentNavigatorDestinationBuilder = new FragmentNavigatorDestinationBuilder((FragmentNavigator) navGraphBuilder.getProvider().getNavigator(FragmentNavigator.class), str, (KClass<? extends Fragment>) Reflection.getOrCreateKotlinClass(Fragment.class));
        FragmentNavigatorDestinationBuilder fragmentNavigatorDestinationBuilder2 = fragmentNavigatorDestinationBuilder;
        navGraphBuilder.destination(fragmentNavigatorDestinationBuilder);
    }
}
