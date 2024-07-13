package androidx.navigation.ui;

import android.view.View;
import androidx.navigation.NavController;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class NavigationUI$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ NavController f$0;
    public final /* synthetic */ AppBarConfiguration f$1;

    public /* synthetic */ NavigationUI$$ExternalSyntheticLambda0(NavController navController, AppBarConfiguration appBarConfiguration) {
        this.f$0 = navController;
        this.f$1 = appBarConfiguration;
    }

    public final void onClick(View view) {
        NavigationUI.m23setupWithNavController$lambda1(this.f$0, this.f$1, view);
    }
}
