package androidx.navigation.ui;

import android.view.MenuItem;
import androidx.navigation.NavController;
import com.google.android.material.navigation.NavigationBarView;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class NavigationUI$$ExternalSyntheticLambda2 implements NavigationBarView.OnItemSelectedListener {
    public final /* synthetic */ NavController f$0;

    public /* synthetic */ NavigationUI$$ExternalSyntheticLambda2(NavController navController) {
        this.f$0 = navController;
    }

    public final boolean onNavigationItemSelected(MenuItem menuItem) {
        return NavigationUI.m27setupWithNavController$lambda6(this.f$0, menuItem);
    }
}
