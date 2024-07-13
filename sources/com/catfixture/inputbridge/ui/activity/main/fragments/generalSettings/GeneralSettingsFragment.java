package com.catfixture.inputbridge.ui.activity.main.fragments.generalSettings;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.context.ConfigContext;
import com.catfixture.inputbridge.core.input.data.InputConfigData;
import com.catfixture.inputbridge.core.installer.InstallerUtils;
import com.catfixture.inputbridge.core.localization.Languages;
import com.catfixture.inputbridge.core.updates.Updater;
import com.catfixture.inputbridge.core.utils.android.ActivityActions;
import com.catfixture.inputbridge.core.utils.files.FileUtils;
import com.catfixture.inputbridge.core.utils.windows.MinimalWindow;
import com.catfixture.inputbridge.ui.activity.main.MainActivity;
import com.catfixture.inputbridge.ui.common.interactions.ConfirmDialog;
import com.catfixture.inputbridge.ui.tabs.DefaultTabFragment;
import com.catfixture.inputbridge.ui.utils.Utils;
import com.google.android.material.button.MaterialButton;

public class GeneralSettingsFragment extends DefaultTabFragment {
    private static final String KEY_RESTART_INTENT = "KRST_INT";

    public void OnDestroy() {
    }

    public void ReinflateAll() {
    }

    public void onResume() {
    }

    public GeneralSettingsFragment(Activity activity) {
        super(activity);
    }

    public static void TriggerRebirth(Context context, Intent intent) {
        Intent intent2 = new Intent(context, MainActivity.class);
        intent2.addFlags(268435456);
        intent2.putExtra(KEY_RESTART_INTENT, intent);
        if (context instanceof MainActivity) {
            ((MainActivity) context).finish();
        }
        context.startActivity(intent2);
        Runtime.getRuntime().exit(0);
    }

    public View OnCreate() {
        Context GetContext = GetContext();
        Activity GetActivity = GetActivity();
        View inflate = View.inflate(GetContext, R.layout.fragment_general_settings, (ViewGroup) null);
        ((Button) inflate.findViewById(R.id.copyInstaller)).setOnClickListener(new GeneralSettingsFragment$$ExternalSyntheticLambda0(GetActivity));
        ((Button) inflate.findViewById(R.id.rootInstall)).setOnClickListener(new GeneralSettingsFragment$$ExternalSyntheticLambda11(GetActivity, new Handler()));
        EditText editText = (EditText) inflate.findViewById(R.id.appFolder);
        editText.setText(ConfigContext.data.appFolder);
        ((MaterialButton) inflate.findViewById(R.id.editAppFolderButton)).setOnClickListener(new GeneralSettingsFragment$$ExternalSyntheticLambda14(GetActivity, editText));
        if (GetActivity != null) {
            inflate.postDelayed(new GeneralSettingsFragment$$ExternalSyntheticLambda5(GetActivity, GetContext), 200);
        }
        Spinner spinner = (Spinner) inflate.findViewById(R.id.languageSpinner);
        ArrayAdapter InitSpinner = Utils.InitSpinner(GetContext, spinner, 0, R.layout.basic_spinner_item);
        InitSpinner.addAll(Languages.GetAll());
        InitSpinner.notifyDataSetChanged();
        spinner.setSelection(ConfigContext.data.language);
        Utils.AttachSpinnerAction(spinner, new GeneralSettingsFragment$$ExternalSyntheticLambda1(GetContext, GetActivity, spinner.getSelectedItemPosition(), spinner));
        InputConfigData inputConfigData = ConfigContext.data;
        CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.enableDebug);
        checkBox.setOnCheckedChangeListener(new GeneralSettingsFragment$$ExternalSyntheticLambda19(inputConfigData));
        checkBox.setChecked(inputConfigData.debugEnabled);
        CheckBox checkBox2 = (CheckBox) inflate.findViewById(R.id.autoCheckUpdates);
        checkBox2.setOnCheckedChangeListener(new GeneralSettingsFragment$$ExternalSyntheticLambda20(inputConfigData));
        checkBox2.setChecked(inputConfigData.autoCheckUpdates);
        Button button = (Button) inflate.findViewById(R.id.update);
        button.setOnClickListener(new GeneralSettingsFragment$$ExternalSyntheticLambda16(button, GetContext, GetActivity));
        EditText editText2 = (EditText) inflate.findViewById(R.id.updateServerAddr);
        editText2.setText(ConfigContext.data.updateServerAddr);
        editText2.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                ConfigContext.data.SetUpdateServerAddr(editable.toString());
            }
        });
        ((Button) inflate.findViewById(R.id.openIconsManager)).setOnClickListener(new GeneralSettingsFragment$$ExternalSyntheticLambda15(GetContext));
        return inflate;
    }

    static /* synthetic */ void lambda$OnCreate$7(Activity activity, EditText editText, View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            MinimalWindow minimalWindow = new MinimalWindow(activity);
            minimalWindow.SetFullscreen().EnableEvents().SetOverlay().SetTranslucent().Create();
            ActivityActions.initializeCloseOnSuspend(activity, new GeneralSettingsFragment$$ExternalSyntheticLambda10(minimalWindow));
            ViewGroup viewGroup = (ViewGroup) View.inflate(activity, R.layout.folder_chooser_android11_layout, minimalWindow.GetContainer());
            ((Button) viewGroup.findViewById(R.id.closeButton)).setOnClickListener(new GeneralSettingsFragment$$ExternalSyntheticLambda18(minimalWindow));
            ((Button) viewGroup.findViewById(R.id.chooseDownloadFolderButton)).setOnClickListener(new GeneralSettingsFragment$$ExternalSyntheticLambda17(editText, minimalWindow));
            ((Button) viewGroup.findViewById(R.id.chooseOtherFolderButton)).setOnClickListener(new GeneralSettingsFragment$$ExternalSyntheticLambda13(activity, editText));
            return;
        }
        FileUtils.OpenDirectoryChooser(activity, new GeneralSettingsFragment$$ExternalSyntheticLambda3(editText));
    }

    static /* synthetic */ void lambda$OnCreate$3(EditText editText, MinimalWindow minimalWindow, View view) {
        ConfigContext.data.SetAppFolder("Download");
        editText.setText(ConfigContext.data.appFolder);
        minimalWindow.Destroy();
    }

    static /* synthetic */ void lambda$OnCreate$4(EditText editText, String str) {
        ConfigContext.data.SetAppFolder(str);
        editText.setText(ConfigContext.data.appFolder);
    }

    static /* synthetic */ void lambda$OnCreate$6(EditText editText, String str) {
        ConfigContext.data.SetAppFolder(str);
        editText.setText(ConfigContext.data.appFolder);
    }

    static /* synthetic */ void lambda$OnCreate$9(Activity activity, Context context) {
        Intent intent = activity.getIntent();
        if (intent != null) {
            String action = intent.getAction();
            if ("AutoInstallRun".equals(action)) {
                InstallerUtils.CopyInstallerToDownload(activity, new GeneralSettingsFragment$$ExternalSyntheticLambda6(context));
            } else {
                "Open".equals(action);
            }
        }
    }

    static /* synthetic */ void lambda$OnCreate$12(Context context, Activity activity, int i, Spinner spinner, Integer num) {
        if (num.intValue() != ConfigContext.data.language) {
            Languages.SetTemporaryLanguage(context, num.intValue());
            ConfirmDialog.Show(context, context.getString(R.string.app_lan_set_tit), context.getString(R.string.confirm_lang_set), context.getString(R.string.yes_text), new GeneralSettingsFragment$$ExternalSyntheticLambda12(num, context, activity), context.getString(R.string.no_text), new GeneralSettingsFragment$$ExternalSyntheticLambda7(context, i, spinner));
        }
    }

    static /* synthetic */ void lambda$OnCreate$10(Integer num, Context context, Activity activity) {
        ConfigContext.data.SetLanguage(num.intValue());
        TriggerRebirth(context, activity.getIntent());
    }

    static /* synthetic */ void lambda$OnCreate$11(Context context, int i, Spinner spinner) {
        Languages.SetTemporaryLanguage(context, i);
        spinner.setSelection(i);
    }

    static /* synthetic */ void lambda$OnCreate$18(Button button, Context context, Activity activity, View view) {
        button.setEnabled(false);
        Updater updater = new Updater();
        button.setText(context.getString(R.string.rtv_text_lab));
        updater.CheckUpdatesAvailable(activity, new GeneralSettingsFragment$$ExternalSyntheticLambda4(updater, activity, button, context), new GeneralSettingsFragment$$ExternalSyntheticLambda9(button, context));
    }

    static /* synthetic */ void lambda$OnCreate$16(Updater updater, Activity activity, Button button, Context context, Boolean bool) {
        if (bool.booleanValue()) {
            updater.Update(activity, new GeneralSettingsFragment$$ExternalSyntheticLambda8(button, context));
            return;
        }
        button.setText(context.getString(R.string.up_to_date));
        button.setEnabled(true);
    }

    static /* synthetic */ void lambda$OnCreate$15(Button button, Context context) {
        button.setText(context.getString(R.string.check_for_updates));
        button.setEnabled(true);
    }

    static /* synthetic */ void lambda$OnCreate$17(Button button, Context context) {
        button.setText(context.getString(R.string.check_for_updates));
        button.setEnabled(true);
    }
}
