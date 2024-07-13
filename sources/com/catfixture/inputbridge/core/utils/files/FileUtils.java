package com.catfixture.inputbridge.core.utils.files;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import androidx.activity.result.ActivityResult;
import androidx.documentfile.provider.DocumentFile;
import com.catfixture.inputbridge.core.Const;
import com.catfixture.inputbridge.core.debug.D;
import com.catfixture.inputbridge.core.utils.android.IActivityLaunchable;
import com.catfixture.inputbridge.core.utils.types.delegates.Action;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileUtils {
    private static boolean hasPermissions() {
        if (Build.VERSION.SDK_INT >= 30) {
            return Environment.isExternalStorageManager();
        }
        return true;
    }

    public static void RequestFolderAccess(Activity activity, Uri uri, Action<IFileAccessAbstraction> action, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 30) {
            D.M("Using global file access as it Android 11+\n");
            if (!hasPermissions()) {
                IActivityLaunchable iActivityLaunchable = (IActivityLaunchable) activity;
                try {
                    Intent intent = new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION");
                    intent.addCategory("android.intent.category.DEFAULT");
                    intent.setData(Uri.parse(String.format("package:%s", new Object[]{activity.getPackageName()})));
                    iActivityLaunchable.Launch(intent, new FileUtils$$ExternalSyntheticLambda0(activity, uri, action, runnable));
                } catch (Exception e) {
                    D.E((Throwable) e);
                    Intent intent2 = new Intent();
                    intent2.setAction("android.settings.MANAGE_ALL_FILES_ACCESS_PERMISSION");
                    iActivityLaunchable.Launch(intent2, new FileUtils$$ExternalSyntheticLambda1(activity, uri, action, runnable));
                }
            } else {
                try {
                    action.Invoke(new AndroidRawFileAbstraction(activity, uri));
                } catch (Exception e2) {
                    D.E((Throwable) e2);
                    runnable.run();
                }
            }
        } else {
            Intent intent3 = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
            if (Build.VERSION.SDK_INT >= 26) {
                intent3.putExtra("android.provider.extra.INITIAL_URI", uri);
            }
            ((IActivityLaunchable) activity).Launch(intent3, new FileUtils$$ExternalSyntheticLambda2(activity, uri, action, runnable));
        }
    }

    static /* synthetic */ void lambda$RequestFolderAccess$0(Activity activity, Uri uri, Action action, Runnable runnable, ActivityResult activityResult) {
        try {
            action.Invoke(new AndroidRawFileAbstraction(activity, uri));
        } catch (Exception e) {
            D.E((Throwable) e);
            runnable.run();
        }
    }

    static /* synthetic */ void lambda$RequestFolderAccess$1(Activity activity, Uri uri, Action action, Runnable runnable, ActivityResult activityResult) {
        try {
            action.Invoke(new AndroidRawFileAbstraction(activity, uri));
        } catch (Exception e) {
            D.E((Throwable) e);
            runnable.run();
        }
    }

    static /* synthetic */ void lambda$RequestFolderAccess$2(Activity activity, Uri uri, Action action, Runnable runnable, ActivityResult activityResult) {
        try {
            Uri data = activityResult.getData().getData();
            PersistPerms(activity, data);
            activity.getSharedPreferences(Const.SHAPREF_ID, 0).edit().remove(uri.toString()).putString(uri.toString(), data.toString()).apply();
            try {
                action.Invoke(new AndroidSAFAbstraction(activity, DocumentFile.fromTreeUri(activity, data)));
            } catch (Exception e) {
                D.E((Throwable) e);
                runnable.run();
            }
        } catch (Exception e2) {
            D.E((Throwable) e2);
            runnable.run();
        }
    }

    public static File CopyRawToTemp(Context context, int i, String str) {
        InputStream openRawResource = context.getResources().openRawResource(i);
        File file = new File(context.getFilesDir(), str);
        try {
            if (file.exists()) {
                if (!file.delete()) {
                    throw new IOException("Cant delete file");
                }
            }
            if (file.createNewFile()) {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = openRawResource.read(bArr);
                    if (read > 0) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        D.M("Tempfile " + file.getAbsolutePath() + " created");
                        return file;
                    }
                }
            } else {
                throw new IOException("Cant create file");
            }
        } catch (IOException e) {
            e.printStackTrace();
            try {
                openRawResource.close();
                return null;
            } catch (IOException e2) {
                e2.printStackTrace();
                return null;
            }
        }
    }

    public static byte[] ReadUriBytes(Context context, Uri uri) throws Exception {
        InputStream openInputStream = context.getContentResolver().openInputStream(uri);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[512];
        while (true) {
            int read = openInputStream.read(bArr);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static String ReadUri(Context context, Uri uri) throws Exception {
        InputStream openInputStream = context.getContentResolver().openInputStream(uri);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[512];
        while (true) {
            int read = openInputStream.read(bArr);
            if (read == -1) {
                return byteArrayOutputStream.toString();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static File CopyUriToTemp(Context context, Uri uri, String str) throws Exception {
        InputStream openInputStream = context.getContentResolver().openInputStream(uri);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[512];
        while (true) {
            int read = openInputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                File file = new File(context.getFilesDir(), str);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(byteArrayOutputStream.toByteArray());
                fileOutputStream.close();
                byteArrayOutputStream.close();
                openInputStream.close();
                return file;
            }
        }
    }

    private static void PersistPerms(Context context, Uri uri) {
        context.getContentResolver().takePersistableUriPermission(uri, 3);
        D.M("URI GRANTED! " + uri.getPath());
    }

    private static Uri SubstitutePersistedPerm(Context context, Uri uri) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Const.SHAPREF_ID, 0);
        if (!sharedPreferences.contains(uri.toString())) {
            return null;
        }
        return Uri.parse(sharedPreferences.getString(uri.toString(), (String) null));
    }

    public static void ClearPersistedPerm(Context context, Uri uri) {
        context.getSharedPreferences(Const.SHAPREF_ID, 0).edit().remove(uri.toString()).apply();
        try {
            context.getContentResolver().releasePersistableUriPermission(uri, 3);
        } catch (Exception unused) {
        }
    }

    public static boolean IsESDirectoryExists(String str) {
        return new File(Environment.getExternalStorageDirectory() + "/" + str).isDirectory();
    }

    public static void OpenDirectoryChooser(Activity activity, Action<String> action) {
        ((IActivityLaunchable) activity).Launch(new Intent("android.intent.action.OPEN_DOCUMENT_TREE"), new FileUtils$$ExternalSyntheticLambda3(action));
    }

    static /* synthetic */ void lambda$OpenDirectoryChooser$3(Action action, ActivityResult activityResult) {
        if (action != null) {
            try {
                action.Invoke(ExtractPath(activityResult.getData().getData(), ":"));
            } catch (Exception unused) {
                D.E("error");
            }
        }
    }

    public static void OpenDirectoryChooserUri(Activity activity, Action<Uri> action) {
        ((IActivityLaunchable) activity).Launch(new Intent("android.intent.action.OPEN_DOCUMENT_TREE"), new FileUtils$$ExternalSyntheticLambda4(action));
    }

    static /* synthetic */ void lambda$OpenDirectoryChooserUri$4(Action action, ActivityResult activityResult) {
        if (action != null) {
            try {
                action.Invoke(activityResult.getData().getData());
            } catch (Exception unused) {
                D.E("error");
            }
        }
    }

    public static void OpenFileChooser(Activity activity, String str, Action<Uri> action) {
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.setType(str);
        ((IActivityLaunchable) activity).Launch(intent, new FileUtils$$ExternalSyntheticLambda5(action));
    }

    static /* synthetic */ void lambda$OpenFileChooser$5(Action action, ActivityResult activityResult) {
        if (action != null) {
            try {
                action.Invoke(activityResult.getData().getData());
            } catch (Exception unused) {
                D.E("error");
            }
        }
    }

    public static String ExtractPath(Uri uri, String str) {
        String path = uri.getPath();
        int lastIndexOf = path.lastIndexOf(str) + str.length();
        int length = path.length();
        return (lastIndexOf <= 0 || lastIndexOf >= length) ? path : path.substring(lastIndexOf, length);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:4|5|7) */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        return r4.substring(r4.lastIndexOf("/") + 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        return r4;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0018 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String ExtractNameFromPathWithoutExtension(java.lang.String r4) {
        /*
            java.lang.String r0 = "/"
            int r1 = r4.lastIndexOf(r0)     // Catch:{ Exception -> 0x0018 }
            int r1 = r1 + 1
            java.lang.String r1 = r4.substring(r1)     // Catch:{ Exception -> 0x0018 }
            r2 = 0
            java.lang.String r3 = "."
            int r3 = r1.lastIndexOf(r3)     // Catch:{ Exception -> 0x0018 }
            java.lang.String r4 = r1.substring(r2, r3)     // Catch:{ Exception -> 0x0018 }
            return r4
        L_0x0018:
            int r0 = r4.lastIndexOf(r0)     // Catch:{ Exception -> 0x0022 }
            int r0 = r0 + 1
            java.lang.String r4 = r4.substring(r0)     // Catch:{ Exception -> 0x0022 }
        L_0x0022:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.catfixture.inputbridge.core.utils.files.FileUtils.ExtractNameFromPathWithoutExtension(java.lang.String):java.lang.String");
    }

    public static String ExtractNameFromPath(String str) {
        return str.substring(str.lastIndexOf("/") + 1);
    }

    public static byte[] ReadAllBytes(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            int length = (int) file.length();
            byte[] bArr = new byte[length];
            int read = fileInputStream.read(bArr, 0, length);
            fileInputStream.close();
            if (read == length) {
                return bArr;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String TryGetName(Uri uri) {
        try {
            return new File(uri.getPath()).getPath();
        } catch (Exception unused) {
            return uri.getPath();
        }
    }
}
