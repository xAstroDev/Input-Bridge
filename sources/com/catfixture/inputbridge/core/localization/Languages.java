package com.catfixture.inputbridge.core.localization;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import com.catfixture.inputbridge.core.context.ConfigContext;
import com.catfixture.inputbridge.core.debug.D;
import java.util.Locale;

public class Languages {
    private static final String SELECTED_LANGUAGE = "Locale.Helper.Selected.Language";
    private static final LanguageEntry[] languages = {new LanguageEntry("Language : English", "en"), new LanguageEntry("Язык : Русский", "ru"), new LanguageEntry("Мова : Українська", "uk"), new LanguageEntry("Sprache : Deutsch", "de"), new LanguageEntry("语言 : 中文", "zh")};

    public static String GetCurrentLocale() {
        return languages[ConfigContext.data.language].locale;
    }

    public static LanguageEntry GetCurrentLanguage() {
        return languages[ConfigContext.data.language];
    }

    public static ContextWrapper CreateLanguageCTXWrapper(Context context) {
        try {
            return CTXWrapper.wrap(context, GetCurrentLanguage().locale);
        } catch (Exception unused) {
            ConfigContext.data.language = 0;
            return CreateLanguageCTXWrapper(context);
        }
    }

    public static LanguageEntry[] GetAll() {
        return languages;
    }

    public static String GetLocaleByNum(int i) {
        if (i >= 0) {
            LanguageEntry[] languageEntryArr = languages;
            if (i < languageEntryArr.length) {
                return languageEntryArr[i].locale;
            }
        }
        D.E("Language not exist");
        return languages[0].locale;
    }

    public static void SetTemporaryLanguage(Context context, int i) {
        Configuration configuration = context.getResources().getConfiguration();
        configuration.setLocale(new Locale(GetLocaleByNum(i)));
        context.getResources().updateConfiguration(configuration, context.getResources().getDisplayMetrics());
    }
}
