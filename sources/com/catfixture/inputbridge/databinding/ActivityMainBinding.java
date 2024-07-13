package com.catfixture.inputbridge.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.ui.custom.WarningComponent;

public final class ActivityMainBinding implements ViewBinding {
    public final Button addProfile;
    public final LinearLayout cont;
    public final Button dublikProf;
    public final Button editProfileName;
    public final Button exportProf;
    public final LinearLayout importExportCont;
    public final Button importProf;
    public final Spinner inputProfiles;
    public final TextView mainAppLabel;
    public final View marker;
    public final WarningComponent noProfilesErr;
    public final Button removeProfile;
    private final LinearLayout rootView;
    public final TextView serviceStatus;
    public final Button shareProfile;
    public final LinearLayout tabsButtonsContainer;
    public final LinearLayout tabsContentContainer;
    public final TextView textView;

    private ActivityMainBinding(LinearLayout linearLayout, Button button, LinearLayout linearLayout2, Button button2, Button button3, Button button4, LinearLayout linearLayout3, Button button5, Spinner spinner, TextView textView2, View view, WarningComponent warningComponent, Button button6, TextView textView3, Button button7, LinearLayout linearLayout4, LinearLayout linearLayout5, TextView textView4) {
        this.rootView = linearLayout;
        this.addProfile = button;
        this.cont = linearLayout2;
        this.dublikProf = button2;
        this.editProfileName = button3;
        this.exportProf = button4;
        this.importExportCont = linearLayout3;
        this.importProf = button5;
        this.inputProfiles = spinner;
        this.mainAppLabel = textView2;
        this.marker = view;
        this.noProfilesErr = warningComponent;
        this.removeProfile = button6;
        this.serviceStatus = textView3;
        this.shareProfile = button7;
        this.tabsButtonsContainer = linearLayout4;
        this.tabsContentContainer = linearLayout5;
        this.textView = textView4;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_main, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityMainBinding bind(View view) {
        View view2 = view;
        int i = R.id.addProfile;
        Button button = (Button) ViewBindings.findChildViewById(view2, R.id.addProfile);
        if (button != null) {
            i = R.id.cont;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.cont);
            if (linearLayout != null) {
                i = R.id.dublikProf;
                Button button2 = (Button) ViewBindings.findChildViewById(view2, R.id.dublikProf);
                if (button2 != null) {
                    i = R.id.editProfileName;
                    Button button3 = (Button) ViewBindings.findChildViewById(view2, R.id.editProfileName);
                    if (button3 != null) {
                        i = R.id.exportProf;
                        Button button4 = (Button) ViewBindings.findChildViewById(view2, R.id.exportProf);
                        if (button4 != null) {
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.importExportCont);
                            i = R.id.importProf;
                            Button button5 = (Button) ViewBindings.findChildViewById(view2, R.id.importProf);
                            if (button5 != null) {
                                i = R.id.inputProfiles;
                                Spinner spinner = (Spinner) ViewBindings.findChildViewById(view2, R.id.inputProfiles);
                                if (spinner != null) {
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, R.id.mainAppLabel);
                                    i = R.id.marker;
                                    View findChildViewById = ViewBindings.findChildViewById(view2, R.id.marker);
                                    if (findChildViewById != null) {
                                        i = R.id.noProfilesErr;
                                        WarningComponent warningComponent = (WarningComponent) ViewBindings.findChildViewById(view2, R.id.noProfilesErr);
                                        if (warningComponent != null) {
                                            i = R.id.removeProfile;
                                            Button button6 = (Button) ViewBindings.findChildViewById(view2, R.id.removeProfile);
                                            if (button6 != null) {
                                                i = R.id.serviceStatus;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, R.id.serviceStatus);
                                                if (textView3 != null) {
                                                    i = R.id.shareProfile;
                                                    Button button7 = (Button) ViewBindings.findChildViewById(view2, R.id.shareProfile);
                                                    if (button7 != null) {
                                                        i = R.id.tabsButtonsContainer;
                                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.tabsButtonsContainer);
                                                        if (linearLayout3 != null) {
                                                            i = R.id.tabsContentContainer;
                                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.tabsContentContainer);
                                                            if (linearLayout4 != null) {
                                                                return new ActivityMainBinding((LinearLayout) view2, button, linearLayout, button2, button3, button4, linearLayout2, button5, spinner, textView2, findChildViewById, warningComponent, button6, textView3, button7, linearLayout3, linearLayout4, (TextView) ViewBindings.findChildViewById(view2, R.id.textView));
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
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
