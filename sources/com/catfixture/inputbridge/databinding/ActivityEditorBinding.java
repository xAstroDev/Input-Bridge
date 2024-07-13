package com.catfixture.inputbridge.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.ui.custom.Crosshair;
import com.catfixture.inputbridge.ui.custom.WarningComponent;

public final class ActivityEditorBinding implements ViewBinding {
    public final LinearLayout controlsContainer;
    public final RelativeLayout controlsView;
    public final Button createControl;
    public final LinearLayout customContainer;
    public final ColorPickerFieldLayoutBinding editorBgColor;
    public final Button editorSettings;
    public final LinearLayout editorWin;
    public final Button exit;
    public final LinearLayout fineTuneContainer;
    public final SeekBar globalSensivity;
    public final TextView globalSensivityText;
    public final Crosshair mainCrosshair;
    public final WarningComponent noItemErr;
    public final ColorPickerFieldLayoutBinding pressTintColor;
    private final RelativeLayout rootView;
    public final CheckBox screenAsMouse;
    public final LinearLayout settingsContainer;
    public final CheckBox showBackground;
    public final ImageView showToolbar;
    public final SeekBar snappingSize;
    public final TextView snappingSizeText;
    public final EditorToolbarLayoutBinding toolbar;
    public final SeekBar uiOpacity;
    public final TextView uiOpacityText;

    private ActivityEditorBinding(RelativeLayout relativeLayout, LinearLayout linearLayout, RelativeLayout relativeLayout2, Button button, LinearLayout linearLayout2, ColorPickerFieldLayoutBinding colorPickerFieldLayoutBinding, Button button2, LinearLayout linearLayout3, Button button3, LinearLayout linearLayout4, SeekBar seekBar, TextView textView, Crosshair crosshair, WarningComponent warningComponent, ColorPickerFieldLayoutBinding colorPickerFieldLayoutBinding2, CheckBox checkBox, LinearLayout linearLayout5, CheckBox checkBox2, ImageView imageView, SeekBar seekBar2, TextView textView2, EditorToolbarLayoutBinding editorToolbarLayoutBinding, SeekBar seekBar3, TextView textView3) {
        this.rootView = relativeLayout;
        this.controlsContainer = linearLayout;
        this.controlsView = relativeLayout2;
        this.createControl = button;
        this.customContainer = linearLayout2;
        this.editorBgColor = colorPickerFieldLayoutBinding;
        this.editorSettings = button2;
        this.editorWin = linearLayout3;
        this.exit = button3;
        this.fineTuneContainer = linearLayout4;
        this.globalSensivity = seekBar;
        this.globalSensivityText = textView;
        this.mainCrosshair = crosshair;
        this.noItemErr = warningComponent;
        this.pressTintColor = colorPickerFieldLayoutBinding2;
        this.screenAsMouse = checkBox;
        this.settingsContainer = linearLayout5;
        this.showBackground = checkBox2;
        this.showToolbar = imageView;
        this.snappingSize = seekBar2;
        this.snappingSizeText = textView2;
        this.toolbar = editorToolbarLayoutBinding;
        this.uiOpacity = seekBar3;
        this.uiOpacityText = textView3;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityEditorBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityEditorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_editor, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityEditorBinding bind(View view) {
        View view2 = view;
        int i = R.id.controlsContainer;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.controlsContainer);
        if (linearLayout != null) {
            i = R.id.controlsView;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.controlsView);
            if (relativeLayout != null) {
                i = R.id.createControl;
                Button button = (Button) ViewBindings.findChildViewById(view2, R.id.createControl);
                if (button != null) {
                    i = R.id.customContainer;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.customContainer);
                    if (linearLayout2 != null) {
                        i = R.id.editorBgColor;
                        View findChildViewById = ViewBindings.findChildViewById(view2, R.id.editorBgColor);
                        if (findChildViewById != null) {
                            ColorPickerFieldLayoutBinding bind = ColorPickerFieldLayoutBinding.bind(findChildViewById);
                            i = R.id.editorSettings;
                            Button button2 = (Button) ViewBindings.findChildViewById(view2, R.id.editorSettings);
                            if (button2 != null) {
                                i = R.id.editorWin;
                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.editorWin);
                                if (linearLayout3 != null) {
                                    i = R.id.exit;
                                    Button button3 = (Button) ViewBindings.findChildViewById(view2, R.id.exit);
                                    if (button3 != null) {
                                        i = R.id.fineTuneContainer;
                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.fineTuneContainer);
                                        if (linearLayout4 != null) {
                                            i = R.id.globalSensivity;
                                            SeekBar seekBar = (SeekBar) ViewBindings.findChildViewById(view2, R.id.globalSensivity);
                                            if (seekBar != null) {
                                                i = R.id.globalSensivityText;
                                                TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.globalSensivityText);
                                                if (textView != null) {
                                                    i = R.id.mainCrosshair;
                                                    Crosshair crosshair = (Crosshair) ViewBindings.findChildViewById(view2, R.id.mainCrosshair);
                                                    if (crosshair != null) {
                                                        i = R.id.noItemErr;
                                                        WarningComponent warningComponent = (WarningComponent) ViewBindings.findChildViewById(view2, R.id.noItemErr);
                                                        if (warningComponent != null) {
                                                            i = R.id.pressTintColor;
                                                            View findChildViewById2 = ViewBindings.findChildViewById(view2, R.id.pressTintColor);
                                                            if (findChildViewById2 != null) {
                                                                ColorPickerFieldLayoutBinding bind2 = ColorPickerFieldLayoutBinding.bind(findChildViewById2);
                                                                i = R.id.screenAsMouse;
                                                                CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view2, R.id.screenAsMouse);
                                                                if (checkBox != null) {
                                                                    i = R.id.settingsContainer;
                                                                    LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.settingsContainer);
                                                                    if (linearLayout5 != null) {
                                                                        i = R.id.showBackground;
                                                                        CheckBox checkBox2 = (CheckBox) ViewBindings.findChildViewById(view2, R.id.showBackground);
                                                                        if (checkBox2 != null) {
                                                                            i = R.id.showToolbar;
                                                                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.showToolbar);
                                                                            if (imageView != null) {
                                                                                i = R.id.snappingSize;
                                                                                SeekBar seekBar2 = (SeekBar) ViewBindings.findChildViewById(view2, R.id.snappingSize);
                                                                                if (seekBar2 != null) {
                                                                                    i = R.id.snappingSizeText;
                                                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, R.id.snappingSizeText);
                                                                                    if (textView2 != null) {
                                                                                        i = R.id.toolbar;
                                                                                        View findChildViewById3 = ViewBindings.findChildViewById(view2, R.id.toolbar);
                                                                                        if (findChildViewById3 != null) {
                                                                                            EditorToolbarLayoutBinding bind3 = EditorToolbarLayoutBinding.bind(findChildViewById3);
                                                                                            i = R.id.uiOpacity;
                                                                                            SeekBar seekBar3 = (SeekBar) ViewBindings.findChildViewById(view2, R.id.uiOpacity);
                                                                                            if (seekBar3 != null) {
                                                                                                i = R.id.uiOpacityText;
                                                                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, R.id.uiOpacityText);
                                                                                                if (textView3 != null) {
                                                                                                    return new ActivityEditorBinding((RelativeLayout) view2, linearLayout, relativeLayout, button, linearLayout2, bind, button2, linearLayout3, button3, linearLayout4, seekBar, textView, crosshair, warningComponent, bind2, checkBox, linearLayout5, checkBox2, imageView, seekBar2, textView2, bind3, seekBar3, textView3);
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
