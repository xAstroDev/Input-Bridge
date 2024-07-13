package com.catfixture.inputbridge.core.iconmanager;

import android.app.Activity;
import android.content.Context;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.context.AppContext;
import com.catfixture.inputbridge.core.debug.D;
import com.catfixture.inputbridge.core.utils.files.FileUtils;
import com.catfixture.inputbridge.ui.common.interactions.ConfirmDialog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class IconPacksManager {
    public List<IconPack> iconPacks = new ArrayList();

    private void LoadAllIconPacks() {
        this.iconPacks.clear();
    }

    public void LookupAllIconPacks(Activity activity) {
        this.iconPacks.clear();
        File file = new File(activity.getFilesDir().getPath() + "/IconPacks");
        if (!file.exists()) {
            file.mkdirs();
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File AddIconPackFromFile : listFiles) {
                AddIconPackFromFile(activity, AddIconPackFromFile);
            }
        }
    }

    public void AddIconPack(Activity activity, IconPack iconPack) {
        this.iconPacks.add(iconPack);
        SavePack(activity, iconPack);
    }

    public void SavePack(Activity activity, IconPack iconPack) {
        AppContext.cache.iconsCache.ClearCache();
        File file = new File(activity.getFilesDir().getPath() + "/IconPacks");
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file + "/" + iconPack.name + ".ipk");
            fileOutputStream.write(IconPackToBytes(iconPack));
            fileOutputStream.close();
        } catch (IOException e) {
            D.E((Throwable) e);
        }
    }

    public void RemovePack(Activity activity, IconPack iconPack) {
        this.iconPacks.remove(iconPack);
        File file = new File(activity.getFilesDir().getPath() + "/IconPacks");
        if (!file.exists()) {
            file.mkdirs();
        }
        if (!new File(file + "/" + iconPack.name + ".ipk").delete()) {
            D.E("Can't remove file");
        }
    }

    public byte[] IconPackToBytes(IconPack iconPack) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(iconPack);
            objectOutputStream.flush();
            objectOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (IOException e) {
            D.E((Throwable) e);
            return null;
        }
    }

    public IconPack AddIconPackFromFile(Activity activity, File file) {
        return DecodeIconPack(activity, file.getName(), FileUtils.ReadAllBytes(file));
    }

    public IconPack AddIconPackFromBytes(Context context, String str, byte[] bArr) {
        return DecodeIconPack(context, str, bArr);
    }

    private IconPack DecodeIconPack(Context context, String str, byte[] bArr) {
        if (ContainsPack(str)) {
            String string = context.getString(R.string.error_text);
            ConfirmDialog.Show(context, string, "Icon pack " + str + " already loaded, remove it first.");
            return null;
        }
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(bArr));
            IconPack iconPack = (IconPack) objectInputStream.readObject();
            objectInputStream.close();
            iconPack.packSize = (long) bArr.length;
            this.iconPacks.add(iconPack);
            return iconPack;
        } catch (Exception unused) {
            String string2 = context.getString(R.string.error_text);
            ConfirmDialog.Show(context, string2, "Icon pack " + str + " can't be loaded.");
            return null;
        }
    }

    private boolean ContainsPack(String str) {
        for (IconPack iconPack : this.iconPacks) {
            if (iconPack.name.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void Destroy() {
        this.iconPacks.clear();
    }
}
