package com.catfixture.inputbridge.core.input.devices.touch.interaction.editor.finetune;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.colorpicker.ColorPickerUtils;
import com.catfixture.inputbridge.core.input.utils.IInputWindowElement;
import com.catfixture.inputbridge.core.utils.math.Int2;
import java.util.Objects;

public class IconFineTuneEditor {
    public static void Init(final IInputWindowElement iInputWindowElement, final Context context, ViewGroup viewGroup, final IconFineTuneData iconFineTuneData) {
        LinearLayout linearLayout = (LinearLayout) LinearLayout.inflate(context, R.layout.icon_fine_tune_layout, (ViewGroup) null);
        ColorData colorData = iconFineTuneData.tintColor;
        Objects.requireNonNull(iInputWindowElement);
        ColorPickerUtils.InitColorPicker(context, "Tint color", (LinearLayout) linearLayout.findViewById(R.id.tintColor), colorData, new IconFineTuneEditor$$ExternalSyntheticLambda1(iInputWindowElement));
        final TextView textView = (TextView) linearLayout.findViewById(R.id.scaleLabel);
        SeekBar seekBar = (SeekBar) linearLayout.findViewById(R.id.scaleSlider);
        textView.setText(context.getString(R.string.size_text, new Object[]{Integer.valueOf((int) (iconFineTuneData.scale * 100.0f))}));
        seekBar.setProgress((int) (iconFineTuneData.scale * 100.0f));
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                IconFineTuneData.this.scale = ((float) seekBar.getProgress()) / 100.0f;
                textView.setText(context.getString(R.string.size_text, new Object[]{Integer.valueOf((int) (IconFineTuneData.this.scale * 100.0f))}));
                iInputWindowElement.Reinflate();
            }
        });
        final TextView textView2 = (TextView) linearLayout.findViewById(R.id.positionText);
        SeekBar seekBar2 = (SeekBar) linearLayout.findViewById(R.id.positionX);
        SeekBar seekBar3 = (SeekBar) linearLayout.findViewById(R.id.positionY);
        seekBar2.setProgress(iconFineTuneData.position.x + 50);
        seekBar3.setProgress(iconFineTuneData.position.y + 50);
        UpdatePositionText(textView2, iconFineTuneData.position);
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                IconFineTuneData.this.position.x = i - 50;
                IconFineTuneEditor.UpdatePositionText(textView2, IconFineTuneData.this.position);
                iInputWindowElement.Reinflate();
            }
        });
        seekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                IconFineTuneData.this.position.y = i - 50;
                IconFineTuneEditor.UpdatePositionText(textView2, IconFineTuneData.this.position);
                iInputWindowElement.Reinflate();
            }
        });
        ((Button) linearLayout.findViewById(R.id.back)).setOnClickListener(new IconFineTuneEditor$$ExternalSyntheticLambda0(context));
        viewGroup.removeAllViews();
        viewGroup.addView(linearLayout);
    }

    /* access modifiers changed from: private */
    public static void UpdatePositionText(TextView textView, Int2 int2) {
        textView.setText("x = " + int2.x + " : y = " + int2.y);
    }
}
