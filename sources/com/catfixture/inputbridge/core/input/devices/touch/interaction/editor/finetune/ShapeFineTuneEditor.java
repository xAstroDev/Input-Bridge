package com.catfixture.inputbridge.core.input.devices.touch.interaction.editor.finetune;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.colorpicker.ColorPickerUtils;
import com.catfixture.inputbridge.core.input.utils.IInputWindowElement;
import java.util.Objects;

public class ShapeFineTuneEditor {
    public static void Init(final IInputWindowElement iInputWindowElement, final Context context, ViewGroup viewGroup, final ShapeFineTuneData shapeFineTuneData) {
        LinearLayout linearLayout = (LinearLayout) LinearLayout.inflate(context, R.layout.shape_fine_tune_layout, (ViewGroup) null);
        final TextView textView = (TextView) linearLayout.findViewById(R.id.strokeWidthLabel);
        SeekBar seekBar = (SeekBar) linearLayout.findViewById(R.id.strokeWidthSlider);
        CheckBox checkBox = (CheckBox) linearLayout.findViewById(R.id.enableFill);
        final TextView textView2 = (TextView) linearLayout.findViewById(R.id.cornerRadiusText);
        SeekBar seekBar2 = (SeekBar) linearLayout.findViewById(R.id.cornerRadiusSlider);
        textView.setText(context.getString(R.string.strokeWidth_local, new Object[]{Integer.valueOf((int) shapeFineTuneData.strokeWidth)}));
        seekBar.setProgress((int) shapeFineTuneData.strokeWidth);
        textView2.setText(context.getString(R.string.cornerRadius_local, new Object[]{Integer.valueOf((int) shapeFineTuneData.cornerRadius)}));
        seekBar2.setProgress((int) shapeFineTuneData.cornerRadius);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                ShapeFineTuneData.this.strokeWidth = (float) seekBar.getProgress();
                textView.setText(context.getString(R.string.strokeWidth_local, new Object[]{Integer.valueOf((int) ShapeFineTuneData.this.strokeWidth)}));
                iInputWindowElement.Reinflate();
            }
        });
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                ShapeFineTuneData.this.cornerRadius = (float) seekBar.getProgress();
                textView2.setText(context.getString(R.string.cornerRadius_local, new Object[]{Integer.valueOf((int) ShapeFineTuneData.this.cornerRadius)}));
                iInputWindowElement.Reinflate();
            }
        });
        ColorData colorData = shapeFineTuneData.fillColor;
        Objects.requireNonNull(iInputWindowElement);
        ColorPickerUtils.InitColorPicker(context, "Fill color", (LinearLayout) linearLayout.findViewById(R.id.fillColor), colorData, new IconFineTuneEditor$$ExternalSyntheticLambda1(iInputWindowElement));
        ColorData colorData2 = shapeFineTuneData.strokeColor;
        Objects.requireNonNull(iInputWindowElement);
        ColorPickerUtils.InitColorPicker(context, "Stroke color", (LinearLayout) linearLayout.findViewById(R.id.strokeColor), colorData2, new IconFineTuneEditor$$ExternalSyntheticLambda1(iInputWindowElement));
        checkBox.setChecked(shapeFineTuneData.enableFill);
        checkBox.setOnCheckedChangeListener(new ShapeFineTuneEditor$$ExternalSyntheticLambda1(shapeFineTuneData, iInputWindowElement));
        FineTuneEditorCommon.InitShadowEditor(linearLayout, shapeFineTuneData.shadowData, iInputWindowElement);
        ((Button) linearLayout.findViewById(R.id.back)).setOnClickListener(new ShapeFineTuneEditor$$ExternalSyntheticLambda0(context));
        viewGroup.removeAllViews();
        viewGroup.addView(linearLayout);
    }

    static /* synthetic */ void lambda$Init$0(ShapeFineTuneData shapeFineTuneData, IInputWindowElement iInputWindowElement, CompoundButton compoundButton, boolean z) {
        shapeFineTuneData.enableFill = z;
        iInputWindowElement.Reinflate();
    }
}
