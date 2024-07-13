package com.catfixture.inputbridge.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.catfixture.inputbridge.R;

public final class FragmentGeneralSettingsBinding implements ViewBinding {
    public final EditText appFolder;
    public final CheckBox autoCheckUpdates;
    public final Button copyInstaller;
    public final Button editAppFolderButton;
    public final CheckBox enableDebug;
    public final Spinner languageSpinner;
    public final Button openIconsManager;
    public final Button rootInstall;
    private final LinearLayout rootView;
    public final Button update;
    public final EditText updateServerAddr;

    private FragmentGeneralSettingsBinding(LinearLayout linearLayout, EditText editText, CheckBox checkBox, Button button, Button button2, CheckBox checkBox2, Spinner spinner, Button button3, Button button4, Button button5, EditText editText2) {
        this.rootView = linearLayout;
        this.appFolder = editText;
        this.autoCheckUpdates = checkBox;
        this.copyInstaller = button;
        this.editAppFolderButton = button2;
        this.enableDebug = checkBox2;
        this.languageSpinner = spinner;
        this.openIconsManager = button3;
        this.rootInstall = button4;
        this.update = button5;
        this.updateServerAddr = editText2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentGeneralSettingsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentGeneralSettingsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_general_settings, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentGeneralSettingsBinding bind(View view) {
        int i = R.id.appFolder;
        EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.appFolder);
        if (editText != null) {
            i = R.id.autoCheckUpdates;
            CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.autoCheckUpdates);
            if (checkBox != null) {
                i = R.id.copyInstaller;
                Button button = (Button) ViewBindings.findChildViewById(view, R.id.copyInstaller);
                if (button != null) {
                    i = R.id.editAppFolderButton;
                    Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.editAppFolderButton);
                    if (button2 != null) {
                        i = R.id.enableDebug;
                        CheckBox checkBox2 = (CheckBox) ViewBindings.findChildViewById(view, R.id.enableDebug);
                        if (checkBox2 != null) {
                            i = R.id.languageSpinner;
                            Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.languageSpinner);
                            if (spinner != null) {
                                i = R.id.openIconsManager;
                                Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.openIconsManager);
                                if (button3 != null) {
                                    i = R.id.rootInstall;
                                    Button button4 = (Button) ViewBindings.findChildViewById(view, R.id.rootInstall);
                                    if (button4 != null) {
                                        i = R.id.update;
                                        Button button5 = (Button) ViewBindings.findChildViewById(view, R.id.update);
                                        if (button5 != null) {
                                            i = R.id.updateServerAddr;
                                            EditText editText2 = (EditText) ViewBindings.findChildViewById(view, R.id.updateServerAddr);
                                            if (editText2 != null) {
                                                return new FragmentGeneralSettingsBinding((LinearLayout) view, editText, checkBox, button, button2, checkBox2, spinner, button3, button4, button5, editText2);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
