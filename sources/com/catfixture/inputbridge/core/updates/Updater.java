package com.catfixture.inputbridge.core.updates;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.appcompat.app.AppCompatActivity;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.context.ConfigContext;
import com.catfixture.inputbridge.core.utils.android.AndroidUtils;
import com.catfixture.inputbridge.core.utils.android.UpdateInfo;
import com.catfixture.inputbridge.core.utils.types.delegates.Action;
import com.catfixture.inputbridge.core.utils.windows.MinimalWindow;
import com.catfixture.inputbridge.ui.common.interactions.ConfirmDialog;
import com.catfixture.inputbridge.ui.common.interactions.OverlayActionProgressAsync;
import java.io.IOException;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Updater {
    private MinimalWindow mw;
    private final OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(5, TimeUnit.SECONDS).writeTimeout(5, TimeUnit.SECONDS).readTimeout(5, TimeUnit.SECONDS).build();
    private TextView processName;
    /* access modifiers changed from: private */
    public UpdateInfo updateInfo;

    public void CheckUpdatesAvailable(Activity activity, Action<Boolean> action, Runnable runnable) {
    }

    public void UpdateNow(Action<Response> action, Runnable runnable) {
    }

    private void Get(String str, Callback callback) {
        this.okHttpClient.newCall(new Request.Builder().url(str).get().build()).enqueue(callback);
    }

    private void RetrieveUpdatesFromServer(Context context, String str, final Action<UpdateInfo> action, Runnable runnable) {
        try {
            Get(str, new Callback() {
                public void onResponse(Call call, Response response) throws IOException {
                }

                public void onFailure(Call call, IOException iOException) {
                    UpdateInfo unused = Updater.this.updateInfo = new UpdateInfo("-1", -1, (String) null);
                    action.Invoke(Updater.this.updateInfo);
                }
            });
        } catch (IllegalArgumentException unused) {
            ShowFall(context, context.getString(R.string.server_addr_wrong));
            runnable.run();
        }
    }

    public void Update(Activity activity, Runnable runnable) {
        String string = activity.getString(R.string.new_version_available_text);
        ConfirmDialog.Show(activity, string, activity.getString(R.string.version_text) + this.updateInfo.versionName, activity.getString(R.string.update_text), new Updater$$ExternalSyntheticLambda3(this, activity, runnable), activity.getString(R.string.cancel_text), new Updater$$ExternalSyntheticLambda7(runnable));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$Update$6$com-catfixture-inputbridge-core-updates-Updater  reason: not valid java name */
    public /* synthetic */ void m116lambda$Update$6$comcatfixtureinputbridgecoreupdatesUpdater(Activity activity, Runnable runnable) {
        AndroidUtils.RequestInstallationPermission(activity, new Updater$$ExternalSyntheticLambda0(this, activity, runnable));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$Update$5$com-catfixture-inputbridge-core-updates-Updater  reason: not valid java name */
    public /* synthetic */ void m115lambda$Update$5$comcatfixtureinputbridgecoreupdatesUpdater(Activity activity, Runnable runnable, ActivityResult activityResult) {
        Handler handler = new Handler();
        OverlayActionProgressAsync overlayActionProgressAsync = new OverlayActionProgressAsync(activity, "Updating", false);
        overlayActionProgressAsync.Init("Downloading...");
        overlayActionProgressAsync.SetProgress(20, "Receiving...");
        UpdateNow(new Updater$$ExternalSyntheticLambda1(this, handler, overlayActionProgressAsync, activity.getFilesDir().getPath() + "/update.apk", activity, runnable), new Updater$$ExternalSyntheticLambda4(this, handler, overlayActionProgressAsync, activity));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$Update$2$com-catfixture-inputbridge-core-updates-Updater  reason: not valid java name */
    public /* synthetic */ void m112lambda$Update$2$comcatfixtureinputbridgecoreupdatesUpdater(Handler handler, OverlayActionProgressAsync overlayActionProgressAsync, String str, Activity activity, Runnable runnable, Response response) {
        handler.post(new Updater$$ExternalSyntheticLambda6(this, response, overlayActionProgressAsync, str, activity, runnable));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$Update$1$com-catfixture-inputbridge-core-updates-Updater  reason: not valid java name */
    public /* synthetic */ void m111lambda$Update$1$comcatfixtureinputbridgecoreupdatesUpdater(Response response, OverlayActionProgressAsync overlayActionProgressAsync, String str, Activity activity, Runnable runnable) {
        if (response.code() == 200) {
            try {
                byte[] bytes = response.body().bytes();
                overlayActionProgressAsync.SetProgress(60, "Saving...");
                AndroidUtils.WriteFile(str, bytes);
                overlayActionProgressAsync.SetProgress(80, activity.getString(R.string.installing_text));
                overlayActionProgressAsync.Close();
                AndroidUtils.InstallUpdate((AppCompatActivity) activity, str, (Runnable) null, new Updater$$ExternalSyntheticLambda2(this, activity, runnable));
            } catch (IOException e) {
                overlayActionProgressAsync.Close();
                ShowFall(activity, e.getLocalizedMessage());
            }
        } else {
            overlayActionProgressAsync.Close();
            ShowFall(activity, "An error occurred while loading.");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$Update$0$com-catfixture-inputbridge-core-updates-Updater  reason: not valid java name */
    public /* synthetic */ void m110lambda$Update$0$comcatfixtureinputbridgecoreupdatesUpdater(Activity activity, Runnable runnable) {
        ShowFall(activity, activity.getString(R.string.not_installed_text));
        runnable.run();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$Update$4$com-catfixture-inputbridge-core-updates-Updater  reason: not valid java name */
    public /* synthetic */ void m114lambda$Update$4$comcatfixtureinputbridgecoreupdatesUpdater(Handler handler, OverlayActionProgressAsync overlayActionProgressAsync, Activity activity) {
        handler.post(new Updater$$ExternalSyntheticLambda5(this, overlayActionProgressAsync, activity));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$Update$3$com-catfixture-inputbridge-core-updates-Updater  reason: not valid java name */
    public /* synthetic */ void m113lambda$Update$3$comcatfixtureinputbridgecoreupdatesUpdater(OverlayActionProgressAsync overlayActionProgressAsync, Activity activity) {
        overlayActionProgressAsync.Close();
        ShowFall(activity, activity.getString(R.string.error_server_dead));
    }

    static /* synthetic */ void lambda$Update$7(Runnable runnable) {
        runnable.run();
        ConfigContext.data.SetAppLaunchedDate(Calendar.getInstance().getTime().getTime());
    }

    private void ShowFall(Context context, String str) {
        ConfirmDialog.Show(context, context.getString(R.string.error_text), str);
    }
}
