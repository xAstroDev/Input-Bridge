package com.catfixture.inputbridge.core.utils.files;

import android.net.Uri;
import java.util.List;

public interface IFileAccessAbstraction {
    IFileAccessAbstraction CreateDir(String str);

    String GetEndSegment();

    List<IFileAccessAbstraction> GetFilesList();

    long GetSize();

    Uri GetUri();

    byte[] ReadAllBytes();

    String ReadAllLines();

    IFileAccessAbstraction RemoveAllFiles();

    void RemoveDir(String str);

    void RemoveSelf();

    IFileAccessAbstraction Write(String str, byte[] bArr);
}
