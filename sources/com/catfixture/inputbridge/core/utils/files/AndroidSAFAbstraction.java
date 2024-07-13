package com.catfixture.inputbridge.core.utils.files;

import android.app.Activity;
import android.net.Uri;
import androidx.documentfile.provider.DocumentFile;
import com.catfixture.inputbridge.core.debug.D;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class AndroidSAFAbstraction implements IFileAccessAbstraction {
    private final Activity context;
    private final DocumentFile root;

    public AndroidSAFAbstraction(Activity activity, DocumentFile documentFile) {
        this.context = activity;
        this.root = documentFile;
    }

    public void RemoveAllFilesInDir(Uri uri) {
        for (DocumentFile documentFile : DocumentFile.fromTreeUri(this.context, uri).listFiles()) {
            D.M("OK Removed " + documentFile.getUri().getPath());
            documentFile.delete();
        }
    }

    public void RemoveDir(String str) {
        for (DocumentFile documentFile : DocumentFile.fromTreeUri(this.context, this.root.getUri()).listFiles()) {
            if (documentFile.getName().equals(str)) {
                D.M("OK Removed " + documentFile.getUri().getPath());
                documentFile.delete();
            }
        }
    }

    public IFileAccessAbstraction Write(String str, byte[] bArr) {
        for (DocumentFile documentFile : this.root.listFiles()) {
            if (documentFile.getName().equals(str)) {
                D.M("OK Removed " + documentFile.getUri().getPath());
                documentFile.delete();
            }
        }
        DocumentFile createFile = this.root.createFile("*/*", str);
        try {
            OutputStream openOutputStream = this.context.getContentResolver().openOutputStream(createFile.getUri());
            openOutputStream.write(bArr);
            openOutputStream.flush();
            openOutputStream.close();
            return new AndroidSAFAbstraction(this.context, createFile);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public IFileAccessAbstraction CreateDir(String str) {
        D.M("Creating new dir " + str);
        for (DocumentFile documentFile : this.root.listFiles()) {
            if (documentFile.getName().equals(str)) {
                return new AndroidSAFAbstraction(this.context, documentFile);
            }
        }
        DocumentFile createDirectory = this.root.createDirectory(str);
        D.M("Dir creation done " + createDirectory.toString());
        return new AndroidSAFAbstraction(this.context, createDirectory);
    }

    public String ReadAllLines() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.context.getContentResolver().openInputStream(this.root.getUri())));
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
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<IFileAccessAbstraction> GetFilesList() {
        DocumentFile[] listFiles = DocumentFile.fromTreeUri(this.context, this.root.getUri()).listFiles();
        ArrayList arrayList = new ArrayList();
        for (DocumentFile androidSAFAbstraction : listFiles) {
            arrayList.add(new AndroidSAFAbstraction(this.context, androidSAFAbstraction));
        }
        return arrayList;
    }

    public IFileAccessAbstraction RemoveAllFiles() {
        for (DocumentFile delete : this.root.listFiles()) {
            if (!delete.delete()) {
                D.E("Error can't delete file!");
            }
        }
        return this;
    }

    public String GetEndSegment() {
        return FileUtils.ExtractPath(this.root.getUri(), ":");
    }

    public Uri GetUri() {
        return this.root.getUri();
    }

    public long GetSize() {
        return this.root.length();
    }

    public byte[] ReadAllBytes() {
        try {
            InputStream openInputStream = this.context.getContentResolver().openInputStream(this.root.getUri());
            int available = openInputStream.available();
            byte[] bArr = new byte[available];
            if (openInputStream.read(bArr, 0, available) == available) {
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
            if (!this.root.delete()) {
                D.E("Error can't delete file!");
            }
        } catch (Exception unused) {
            D.E("Error can't delete file!");
        }
    }
}
