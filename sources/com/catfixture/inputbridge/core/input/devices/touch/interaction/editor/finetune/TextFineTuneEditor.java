package com.catfixture.inputbridge.core.input.devices.touch.interaction.editor.finetune;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.colorpicker.ColorPickerUtils;
import com.catfixture.inputbridge.core.input.utils.IInputWindowElement;
import com.catfixture.inputbridge.core.utils.math.Int2;
import com.catfixture.inputbridge.ui.utils.Utils;
import java.util.Objects;

public class TextFineTuneEditor {
    public static void Init(final IInputWindowElement iInputWindowElement, final Context context, ViewGroup viewGroup, final TextFineTuneData textFineTuneData) {
        LinearLayout linearLayout = (LinearLayout) LinearLayout.inflate(context, R.layout.text_fine_tune_layout, (ViewGroup) null);
        ColorData colorData = textFineTuneData.color;
        Objects.requireNonNull(iInputWindowElement);
        ColorPickerUtils.InitColorPicker(context, "Tint color", (LinearLayout) linearLayout.findViewById(R.id.fontColor), colorData, new IconFineTuneEditor$$ExternalSyntheticLambda1(iInputWindowElement));
        Spinner spinner = (Spinner) linearLayout.findViewById(R.id.fontWeight);
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) null);
        ArrayAdapter InitSpinner = Utils.InitSpinner(context, spinner, 0, R.layout.touch_controls_list_item);
        InitSpinner.add("Normal");
        InitSpinner.add("Bold");
        InitSpinner.add("Italic");
        InitSpinner.add("ItalicBold");
        InitSpinner.add("Underline");
        spinner.setAdapter(InitSpinner);
        spinner.setSelection(textFineTuneData.weight);
        Utils.AttachSpinnerAction(spinner, new TextFineTuneEditor$$ExternalSyntheticLambda1(textFineTuneData, iInputWindowElement));
        final TextView textView = (TextView) linearLayout.findViewById(R.id.positionText);
        SeekBar seekBar = (SeekBar) linearLayout.findViewById(R.id.positionX);
        SeekBar seekBar2 = (SeekBar) linearLayout.findViewById(R.id.positionY);
        seekBar.setProgress(textFineTuneData.position.x + 50);
        seekBar2.setProgress(textFineTuneData.position.y + 50);
        UpdatePositionText(textView, textFineTuneData.position);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                TextFineTuneData.this.position.x = i - 50;
                TextFineTuneEditor.UpdatePositionText(textView, TextFineTuneData.this.position);
                iInputWindowElement.Reinflate();
            }
        });
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                TextFineTuneData.this.position.y = i - 50;
                TextFineTuneEditor.UpdatePositionText(textView, TextFineTuneData.this.position);
                iInputWindowElement.Reinflate();
            }
        });
        FineTuneEditorCommon.InitShadowEditor(linearLayout, textFineTuneData.shadowData, iInputWindowElement);
        final TextView textView2 = (TextView) linearLayout.findViewById(R.id.scaleLabel);
        SeekBar seekBar3 = (SeekBar) linearLayout.findViewById(R.id.scaleSlider);
        textView2.setText(context.getString(R.string.size_no_percent, new Object[]{Integer.valueOf(textFineTuneData.size)}));
        seekBar3.setProgress(textFineTuneData.size);
        seekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                TextFineTuneData.this.size = seekBar.getProgress();
                textView2.setText(context.getString(R.string.size_no_percent, new Object[]{Integer.valueOf(TextFineTuneData.this.size)}));
                iInputWindowElement.Reinflate();
            }
        });
        ((Button) linearLayout.findViewById(R.id.back)).setOnClickListener(new TextFineTuneEditor$$ExternalSyntheticLambda0(context));
        viewGroup.removeAllViews();
        viewGroup.addView(linearLayout);
    }

    static /* synthetic */ void lambda$Init$0(TextFineTuneData textFineTuneData, IInputWindowElement iInputWindowElement, Integer num) {
        if (textFineTuneData.weight != num.intValue()) {
            textFineTuneData.weight = num.intValue();
            iInputWindowElement.Reinflate();
        }
    }

    /* access modifiers changed from: private */
    public static void UpdatePositionText(TextView textView, Int2 int2) {
        textView.setText("x = " + int2.x + " : y = " + int2.y);
    }
}
