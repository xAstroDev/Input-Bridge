package com.catfixture.inputbridge.core.debug.email;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import androidx.core.content.FileProvider;
import com.catfixture.inputbridge.core.debug.D;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class ShareDialog {
    private final String authority;
    private final Context context;
    private final ArrayList<Uri> extraFiles = new ArrayList<>();
    private final StringBuilder extraText = new StringBuilder();
    private Intent intent;

    public ShareDialog(Context context2) {
        this.context = context2;
        this.authority = context2.getApplicationContext().getPackageName() + ".provider";
    }

    public ShareDialog Prepare(String[] strArr, String str) {
        Intent intent2 = new Intent("android.intent.action.SEND_MULTIPLE");
        this.intent = intent2;
        intent2.setType("*/*");
        this.intent.putExtra("android.intent.extra.EMAIL", strArr);
        this.intent.putExtra("android.intent.extra.SUBJECT", str);
        this.intent.addFlags(3);
        StringBuilder sb = this.extraText;
        sb.delete(0, sb.length());
        this.extraFiles.clear();
        return this;
    }

    public ShareDialog AddFileAttachment(String str) {
        File file = new File(str);
        if (!file.exists() || file.length() <= 0) {
            D.E("File not exists or empty and wouldn't be added");
        } else {
            this.extraFiles.add(FileProvider.getUriForFile(this.context, this.authority, file));
        }
        return this;
    }

    public void AddStringLine(String str) {
        StringBuilder sb = this.extraText;
        sb.append(str);
        sb.append("\n");
    }

    public ShareDialog Finalize() {
        this.intent.putParcelableArrayListExtra("android.intent.extra.STREAM", this.extraFiles);
        this.intent.putExtra("android.intent.extra.TEXT", this.extraText.toString());
        return this;
    }

    public void Send() {
        if (this.intent.resolveActivity(this.context.getPackageManager()) != null) {
            Intent createChooser = Intent.createChooser(this.intent, "Share");
            for (ResolveInfo resolveInfo : this.context.getPackageManager().queryIntentActivities(createChooser, 65536)) {
                String str = resolveInfo.activityInfo.packageName;
                Iterator<Uri> it = this.extraFiles.iterator();
                while (it.hasNext()) {
                    this.context.grantUriPermission(str, it.next(), 3);
                }
            }
            createChooser.addFlags(3);
            this.context.startActivity(createChooser);
        }
    }
}
