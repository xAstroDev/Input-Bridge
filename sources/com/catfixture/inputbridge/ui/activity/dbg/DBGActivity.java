package com.catfixture.inputbridge.ui.activity.dbg;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.context.AppContext;
import com.catfixture.inputbridge.core.context.ConfigContext;
import com.catfixture.inputbridge.core.utils.android.IActivityLaunchable;
import com.catfixture.inputbridge.core.utils.files.FileUtils;
import com.catfixture.inputbridge.core.utils.files.IFileAccessAbstraction;
import com.catfixture.inputbridge.core.utils.types.delegates.Action;
import com.catfixture.inputbridge.ui.common.interactions.ConfirmDialog;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import okhttp3.HttpUrl;

public class DBGActivity extends AppCompatActivity implements IActivityLaunchable {
    private Button clearAllLogs;
    private Button clearLog;
    private ActivityResultLauncher<Intent> launchSomeActivity;
    private Action<ActivityResult> onResult;
    private Button saveLog;

    private String ReadLog() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(getFilesDir() + "/error.log")));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                    sb.append(10);
                } else {
                    bufferedReader.close();
                    return sb.toString();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return HttpUrl.FRAGMENT_ENCODE_SET;
        } catch (IOException e2) {
            e2.printStackTrace();
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) (ViewGroup) View.inflate(this, R.layout.activity_dbgactivity, (ViewGroup) null));
        this.launchSomeActivity = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new DBGActivity$$ExternalSyntheticLambda3(this));
        Recreate();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$0$com-catfixture-inputbridge-ui-activity-dbg-DBGActivity  reason: not valid java name */
    public /* synthetic */ void m121lambda$onCreate$0$comcatfixtureinputbridgeuiactivitydbgDBGActivity(ActivityResult activityResult) {
        this.onResult.Invoke(activityResult);
    }

    private void Recreate() {
        String ReadLog = ReadLog();
        TextView textView = (TextView) findViewById(R.id.logOut);
        textView.setText(ReadLog);
        this.clearAllLogs = (Button) findViewById(R.id.clearAllLogs);
        this.clearLog = (Button) findViewById(R.id.clearLog);
        this.saveLog = (Button) findViewById(R.id.saveLog);
        this.clearAllLogs.setOnClickListener(new DBGActivity$$ExternalSyntheticLambda0(textView));
        this.clearLog.setOnClickListener(new DBGActivity$$ExternalSyntheticLambda1(textView));
        this.saveLog.setOnClickListener(new DBGActivity$$ExternalSyntheticLambda2(this, ReadLog));
    }

    static /* synthetic */ void lambda$Recreate$1(TextView textView, View view) {
        textView.setText(R.string.dummy);
        AppContext.app.debugContext.ClearLog();
    }

    static /* synthetic */ void lambda$Recreate$2(TextView textView, View view) {
        textView.setText(R.string.dummy);
        AppContext.app.debugContext.ClearLog();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$Recreate$5$com-catfixture-inputbridge-ui-activity-dbg-DBGActivity  reason: not valid java name */
    public /* synthetic */ void m120lambda$Recreate$5$comcatfixtureinputbridgeuiactivitydbgDBGActivity(String str, View view) {
        FileUtils.RequestFolderAccess(this, Uri.parse(Environment.getExternalStorageDirectory() + "/" + ConfigContext.data.appFolder), new DBGActivity$$ExternalSyntheticLambda4(this, str), new DBGActivity$$ExternalSyntheticLambda5(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$Recreate$3$com-catfixture-inputbridge-ui-activity-dbg-DBGActivity  reason: not valid java name */
    public /* synthetic */ void m118lambda$Recreate$3$comcatfixtureinputbridgeuiactivitydbgDBGActivity(String str, IFileAccessAbstraction iFileAccessAbstraction) {
        if (!ConfigContext.data.appFolder.equals(iFileAccessAbstraction.GetEndSegment())) {
            ConfirmDialog.Show(this, getString(R.string.error_text), getString(R.string.error_use_only_downloads, new Object[]{ConfigContext.data.appFolder}), getString(R.string.close_text), (Runnable) null);
            FileUtils.ClearPersistedPerm(this, iFileAccessAbstraction.GetUri());
            return;
        }
        IFileAccessAbstraction CreateDir = iFileAccessAbstraction.CreateDir("InputBridge").CreateDir("Logs");
        CreateDir.Write("InputBridgeLog_" + Calendar.getInstance().getTime().getTime() + ".log", str.getBytes(StandardCharsets.UTF_8));
        String string = getString(R.string.done_text);
        ConfirmDialog.Show(this, string, getString(R.string.log_save_text, new Object[]{ConfigContext.data.appFolder + "/InputBridge/Logs"}), getString(R.string.close_text), (Runnable) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$Recreate$4$com-catfixture-inputbridge-ui-activity-dbg-DBGActivity  reason: not valid java name */
    public /* synthetic */ void m119lambda$Recreate$4$comcatfixtureinputbridgeuiactivitydbgDBGActivity() {
        ConfirmDialog.Show(this, getString(R.string.error_text), getString(R.string.permissions_not_granted_text));
    }

    public void Launch(Intent intent, Action<ActivityResult> action) {
        this.onResult = action;
        this.launchSomeActivity.launch(intent);
    }

    private void SetButtonsState(Button button, boolean z) {
        button.setAlpha(!z ? 1.0f : 0.5f);
        button.setEnabled(z);
        button.setClickable(!z);
    }
}
