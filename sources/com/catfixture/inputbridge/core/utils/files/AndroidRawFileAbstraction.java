package com.catfixture.inputbridge.core.utils.files;

import android.app.Activity;
import android.net.Uri;
import com.catfixture.inputbridge.core.debug.D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AndroidRawFileAbstraction implements IFileAccessAbstraction {
    private final Activity context;
    private final Uri root;

    public AndroidRawFileAbstraction(Activity activity, Uri uri) {
        this.context = activity;
        this.root = uri;
    }

    public IFileAccessAbstraction Write(String str, byte[] bArr) {
        File file = new File(this.root.getPath(), str);
        if (file.exists()) {
            file.delete();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(bArr);
            fileOutputStream.close();
            return new AndroidRawFileAbstraction(this.context, Uri.fromFile(file));
        } catch (Exception e) {
            D.E((Throwable) e);
            return null;
        }
    }

    public void RemoveDir(String str) {
        File file = new File(this.root.getPath(), str);
        if (file.exists()) {
            try {
                delete(file);
            } catch (Exception e) {
                D.E((Throwable) e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void delete(File file) throws IOException {
        if (file.isDirectory()) {
            for (File delete : file.listFiles()) {
                delete(delete);
            }
        }
        if (!file.delete()) {
            throw new FileNotFoundException("Failed to delete file: " + file);
        }
    }

    public IFileAccessAbstraction CreateDir(String str) {
        File file = new File(this.root.getPath(), str);
        if (file.exists()) {
            return new AndroidRawFileAbstraction(this.context, Uri.fromFile(file));
        }
        if (!file.mkdirs()) {
            return null;
        }
        return new AndroidRawFileAbstraction(this.context, Uri.fromFile(file));
    }

    public String ReadAllLines() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(this.root.getPath()))));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                } else {
                    bufferedReader.close();
                    return sb.toString();
                }
            }
        } catch (Exception e) {
            D.E((Throwable) e);
            return null;
        }
    }

    public List<IFileAccessAbstraction> GetFilesList() {
        File[] listFiles = new File(this.root.getPath()).listFiles();
        ArrayList arrayList = new ArrayList();
        for (File fromFile : listFiles) {
            arrayList.add(new AndroidRawFileAbstraction(this.context, Uri.fromFile(fromFile)));
        }
        return arrayList;
    }

    public IFileAccessAbstraction RemoveAllFiles() {
        for (File delete : new File(this.root.getPath()).listFiles()) {
            if (!delete.delete()) {
                D.E("Error can't delete file!");
            }
        }
        return this;
    }

    public String GetEndSegment() {
        return FileUtils.ExtractPath(this.root, "/0/");
    }

    public Uri GetUri() {
        return this.root;
    }

    public long GetSize() {
        return new File(this.root.getPath()).length();
    }

    public byte[] ReadAllBytes() {
        File file = new File(this.root.getPath());
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            int length = (int) file.length();
            byte[] bArr = new byte[length];
            if (fileInputStream.read(bArr, 0, length) == length) {
                return bArr;
            }
            return null;
        } catch (Exception e) {
            D.E((Throwable) e);
            return null;
        }
    }

    public void RemoveSelf() {
        try {
            if (!new File(this.root.getPath()).delete()) {
                D.E("Error can't delete file!");
            }
        } catch (Exception unused) {
            D.E("Error can't delete file!");
        }
    }
}
