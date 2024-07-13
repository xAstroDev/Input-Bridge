package com.catfixture.inputbridge.core.utils.files;

import android.app.Activity;
import android.net.Uri;
import androidx.activity.result.ActivityResult;
import com.catfixture.inputbridge.core.utils.types.delegates.Action;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FileUtils$$ExternalSyntheticLambda1 implements Action {
    public final /* synthetic */ Activity f$0;
    public final /* synthetic */ Uri f$1;
    public final /* synthetic */ Action f$2;
    public final /* synthetic */ Runnable f$3;

    public /* synthetic */ FileUtils$$ExternalSyntheticLambda1(Activity activity, Uri uri, Action action, Runnable runnable) {
        this.f$0 = activity;
        this.f$1 = uri;
        this.f$2 = action;
        this.f$3 = runnable;
    }

    public final void Invoke(Object obj) {
        FileUtils.lambda$RequestFolderAccess$1(this.f$0, this.f$1, this.f$2, this.f$3, (ActivityResult) obj);
    }
}
