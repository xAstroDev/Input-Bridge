package com.catfixture.inputbridge.core.input.devices.touch.interaction.elements;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.context.ConfigContext;
import com.catfixture.inputbridge.core.input.data.InputConfigData;
import com.catfixture.inputbridge.core.input.data.InputTouchControlElementData;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.editor.IEditable;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.types.TouchableWindowElementType;
import com.catfixture.inputbridge.core.input.utils.IInputWindowElement;
import com.catfixture.inputbridge.ui.activity.editors.touchEditor.TouchEditorActivity;
import com.catfixture.inputbridge.ui.utils.Utils;

public class CommonElementEditor implements IEditable {
    /* access modifiers changed from: private */
    public final TextView alphaText;
    protected final Context context;
    protected final IInputWindowElement parentItem;
    protected final ViewGroup root;
    /* access modifiers changed from: private */
    public final TextView sizeText;

    public CommonElementEditor(final Context context2, final IInputWindowElement iInputWindowElement) {
        this.context = context2;
        this.parentItem = iInputWindowElement;
        final InputTouchControlElementData inputTouchControlElementData = (InputTouchControlElementData) iInputWindowElement.GetData();
        ViewGroup viewGroup = (ViewGroup) View.inflate(context2, R.layout.editable_common_element, (ViewGroup) null);
        this.root = viewGroup;
        SeekBar seekBar = (SeekBar) viewGroup.findViewById(R.id.opacitySlider);
        TextView textView = (TextView) viewGroup.findViewById(R.id.opacitySliderText);
        this.alphaText = textView;
        SeekBar seekBar2 = (SeekBar) viewGroup.findViewById(R.id.sizeSlider);
        TextView textView2 = (TextView) viewGroup.findViewById(R.id.sizeSliderText);
        this.sizeText = textView2;
        Spinner spinner = (Spinner) viewGroup.findViewById(R.id.controlType);
        View findViewById = viewGroup.findViewById(R.id.removeControl);
        ScrollView scrollView = (ScrollView) viewGroup.findViewById(R.id.touch_element_settings_scroll);
        scrollView.getViewTreeObserver().addOnGlobalLayoutListener(new CommonElementEditor$$ExternalSyntheticLambda2(scrollView));
        scrollView.setOnTouchListener(new CommonElementEditor$$ExternalSyntheticLambda1(scrollView));
        seekBar.setProgress(((int) (inputTouchControlElementData.alpha * 100.0f)) - 20);
        seekBar2.setProgress(inputTouchControlElementData.scale - 20);
        textView.setText(context2.getString(R.string.opacity_local, new Object[]{Integer.valueOf((int) (inputTouchControlElementData.alpha * 100.0f))}));
        textView2.setText(context2.getString(R.string.size_text, new Object[]{Integer.valueOf(inputTouchControlElementData.scale)}));
        TouchableWindowElementType.Create(context2);
        ArrayAdapter InitSpinner = Utils.InitSpinner(context2, spinner, 0, R.layout.touch_controls_list_item);
        InitSpinner.addAll(TouchableWindowElementType.spinnerData);
        InitSpinner.notifyDataSetChanged();
        spinner.setSelection(TouchableWindowElementType.SpinnerDataPos(inputTouchControlElementData.type));
        Utils.AttachSpinnerAction(spinner, new CommonElementEditor$$ExternalSyntheticLambda3(inputTouchControlElementData, iInputWindowElement, context2));
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                float f = ((float) (i + 20)) / 100.0f;
                iInputWindowElement.SetAlpha(f);
                inputTouchControlElementData.SetAlpha(f);
                CommonElementEditor.this.alphaText.setText(context2.getString(R.string.opacity_local, new Object[]{Integer.valueOf((int) (f * 100.0f))}));
            }
        });
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                int i2 = i + 20;
                iInputWindowElement.SetScale(i2);
                inputTouchControlElementData.SetScale(i2);
                CommonElementEditor.this.sizeText.setText(context2.getString(R.string.size_text, new Object[]{Integer.valueOf(i2)}));
            }
        });
        findViewById.setOnClickListener(new CommonElementEditor$$ExternalSyntheticLambda0(inputTouchControlElementData, iInputWindowElement, context2));
    }

    static /* synthetic */ boolean lambda$new$1(ScrollView scrollView, View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 1 && motionEvent.getAction() != 6) {
            return false;
        }
        ConfigContext.data.GetCurrentProfile().SetTceScrollPos(scrollView.getScrollY());
        return false;
    }

    static /* synthetic */ void lambda$new$2(InputTouchControlElementData inputTouchControlElementData, IInputWindowElement iInputWindowElement, Context context2, Integer num) {
        int i = TouchableWindowElementType.spinnerData[num.intValue()].id;
        if (i != inputTouchControlElementData.type) {
            inputTouchControlElementData.SetType(i);
            iInputWindowElement.Reinflate();
            try {
                ((TouchEditorActivity) context2).DropContent(iInputWindowElement.GetId());
            } catch (Exception unused) {
            }
        }
    }

    static /* synthetic */ void lambda$new$3(InputTouchControlElementData inputTouchControlElementData, IInputWindowElement iInputWindowElement, Context context2, View view) {
        InputConfigData inputConfigData = ConfigContext.data;
        if (inputConfigData.HasCurrentProfile()) {
            inputConfigData.GetCurrentProfile().RemoveControlElement(inputTouchControlElementData.id);
            iInputWindowElement.ResetEditor(true);
            try {
                ((TouchEditorActivity) context2).DeselectAll();
            } catch (Exception unused) {
            }
        }
    }

    public View GetRoot() {
        return this.root;
    }
}
