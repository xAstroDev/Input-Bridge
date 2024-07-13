package com.catfixture.inputbridge.core.utils.data;

import com.catfixture.inputbridge.core.debug.D;
import com.catfixture.inputbridge.core.utils.android.AndroidUtils;
import com.catfixture.inputbridge.ui.utils.GsonUtils;
import java.io.BufferedReader;
import java.io.FileReader;

public class GenericConfig<T> {
    private final Class<T> clazz;
    private T config;
    private final String path;

    public GenericConfig(String str, Class<T> cls) {
        this.path = str;
        this.clazz = cls;
        Load(str);
    }

    private void Load(String str) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(str));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                } else {
                    bufferedReader.close();
                    this.config = GsonUtils.Create().fromJson(sb.toString(), this.clazz);
                    D.M("Loaded config from path = " + str);
                    return;
                }
            }
        } catch (Exception unused) {
            D.E("File not found, so creating new!");
            Save();
        }
    }

    public void Save() {
        if (this.config == null) {
            try {
                this.config = this.clazz.newInstance();
            } catch (Exception e) {
                D.E((Throwable) e);
            }
        }
        AndroidUtils.WriteFile(this.path, GsonUtils.Create().toJson((Object) this.config));
    }

    public T GetData() {
        return this.config;
    }
}
