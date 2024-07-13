package com.catfixture.inputbridge.core.utils.android;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.util.Size;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.debug.D;
import com.catfixture.inputbridge.core.utils.types.delegates.Action;
import com.catfixture.inputbridge.ui.utils.GsonUtils;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import okhttp3.HttpUrl;

public class AndroidUtils {
    public static final int PERMISSION_REQUEST_CODE = 1457;

    public static String VidPidToDeviceName(int i, int i2, String str) {
        return (i2 == 3302 && i == 1356) ? "Dualsense X" : (i2 == 2508 && i == 1356) ? "Dualshock 4" : str;
    }

    public static String InExternalStorage(String str) {
        return Environment.getExternalStorageDirectory() + "/" + str;
    }

    public static boolean IsAccessibilityEnabled(Context context) {
        int i;
        try {
            i = Settings.Secure.getInt(context.getContentResolver(), "accessibility_enabled");
        } catch (Exception e) {
            D.M("Error accessibility" + e.getMessage());
            i = 0;
        }
        if (i == 1) {
            try {
                if (Settings.Secure.getString(context.getContentResolver(), "enabled_accessibility_services").contains("Touch")) {
                    return true;
                }
            } catch (Exception e2) {
                D.M("Error accessibility" + e2.getMessage());
            }
        }
        return false;
    }

    public static Size GetRealDisplaySize(WindowManager windowManager) {
        Point point = new Point();
        windowManager.getDefaultDisplay().getRealSize(point);
        if (point.x < point.y) {
            int i = point.x;
            point.x = point.y;
            point.y = i;
        }
        return new Size(point.x, point.y);
    }

    public static void RequestInstallationPermission(Activity activity, Action<ActivityResult> action) {
        if (Build.VERSION.SDK_INT < 26) {
            action.Invoke(null);
        } else if (!activity.getPackageManager().canRequestPackageInstalls()) {
            ((IActivityLaunchable) activity).Launch(new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES").setData(Uri.parse(String.format("package:%s", new Object[]{activity.getPackageName()}))), action);
        } else {
            action.Invoke(null);
        }
    }

    static Uri UriFromFile(Context context, File file) {
        if (Build.VERSION.SDK_INT >= 24) {
            return FileProvider.getUriForFile(context, "com.catfixture.inputbridge.provider", file);
        }
        return Uri.fromFile(file);
    }

    public static void InstallUpdate(AppCompatActivity appCompatActivity, String str, Runnable runnable, Runnable runnable2) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(UriFromFile(appCompatActivity, new File(str)), "application/vnd.android.package-archive");
            intent.addFlags(268435456);
            intent.addFlags(1);
            if (appCompatActivity instanceof IActivityLaunchable) {
                ((IActivityLaunchable) appCompatActivity).Launch(intent, new AndroidUtils$$ExternalSyntheticLambda0(runnable, runnable2));
            } else {
                D.E("FATAL ACTIVITY DOESN'T IMPLEMENT IACTIVITYLAUNCHANBLE!!!");
                System.exit(-1);
            }
            appCompatActivity.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            D.E("Error in opening the file!");
            D.E((Throwable) e);
        }
    }

    static /* synthetic */ void lambda$InstallUpdate$0(Runnable runnable, Runnable runnable2, ActivityResult activityResult) {
        if (activityResult.getResultCode() == -1) {
            runnable.run();
        } else {
            runnable2.run();
        }
    }

    public static void WriteFile(String str, String str2) {
        WriteFile(str, str2.getBytes(StandardCharsets.UTF_8));
    }

    public static void WriteFile(String str, byte[] bArr) {
        try {
            File file = new File(str);
            if (!file.exists() && !file.createNewFile()) {
                D.E("Error couldn't create file!");
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(bArr);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (IOException e) {
            D.E((Throwable) e);
        }
    }

    public static String createNotificationChannel(NotificationManager notificationManager) {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel("ib_notifid", "Input Bridge", 2);
            notificationChannel.setImportance(0);
            notificationChannel.setLockscreenVisibility(0);
            notificationManager.createNotificationChannel(notificationChannel);
        }
        return "ib_notifid";
    }

    public static void HideSystemUI(View view) {
        view.post(new AndroidUtils$$ExternalSyntheticLambda1(view));
    }

    public static String BytesToPrefixedString(long j) {
        if (j >= 1000 && j < 1000000) {
            return (j / 1000) + "kB";
        } else if (j >= 1000000) {
            return (j / 1000000) + "MB";
        } else {
            return j + "B";
        }
    }

    public static String BitmapSizeToString(Bitmap bitmap) {
        if (bitmap == null) {
            return "Bitmap not initialized";
        }
        return bitmap.getWidth() + "x" + bitmap.getHeight();
    }

    public static Object DeepClone(Object obj, Class<?> cls) {
        Gson Create = GsonUtils.Create();
        return Create.fromJson(Create.toJson(obj), cls);
    }

    public static void RequestBtPermission(Activity activity) {
        if (Build.VERSION.SDK_INT >= 31) {
            ActivityCompat.requestPermissions(activity, new String[]{"android.permission.BLUETOOTH_CONNECT"}, 2);
        }
    }

    public static class BroadcastBlank {
        private Intent intent;

        public BroadcastBlank(String str) {
            Intent intent2 = new Intent();
            this.intent = intent2;
            intent2.setAction(str);
        }

        public BroadcastBlank putIntExtra(String str, int i) {
            this.intent.putExtra(str, i);
            return this;
        }

        public BroadcastBlank putStringExtra(String str, String str2) {
            this.intent.putExtra(str, str2);
            return this;
        }

        public void Send(Context context) {
            context.sendBroadcast(this.intent);
            this.intent = null;
        }
    }

    public static byte[] GetRawBytes(Context context, int i) {
        InputStream openRawResource = context.getResources().openRawResource(i);
        try {
            int available = openRawResource.available();
            if (available > 0) {
                byte[] bArr = new byte[available];
                if (openRawResource.read(bArr) == available) {
                    openRawResource.close();
                    return bArr;
                }
            }
        } catch (IOException e) {
            D.E((Throwable) e);
        }
        try {
            openRawResource.close();
            return null;
        } catch (IOException e2) {
            D.E((Throwable) e2);
            return null;
        }
    }

    public static BroadcastBlank BroadcastBuilder(String str) {
        return new BroadcastBlank(str);
    }

    public static void OpenLink(Context context, String str) {
        context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }

    public static void CopyTextToClipboard(Context context, String str) {
        ((ClipboardManager) context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(HttpUrl.FRAGMENT_ENCODE_SET, str));
        Toast.makeText(context, R.string.copy_to_clipboard_text, 1).show();
    }
}
