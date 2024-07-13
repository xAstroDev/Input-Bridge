package com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.cross;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.input.codes.KeyCodes;
import com.catfixture.inputbridge.core.input.data.InputTouchControlElementData;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.CommonElementEditor;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.icon.IconElementCommons;
import com.catfixture.inputbridge.core.input.utils.IInputWindowElement;
import com.catfixture.inputbridge.core.utils.types.delegates.Action;
import java.util.Objects;

public class CrossElementEditable extends CommonElementEditor {
    public CrossElementEditable(Context context, IInputWindowElement iInputWindowElement) {
        super(context, iInputWindowElement);
        InputTouchControlElementData inputTouchControlElementData = (InputTouchControlElementData) iInputWindowElement.GetData();
        LinearLayout linearLayout = (LinearLayout) View.inflate(context, R.layout.editable_cross_element, (ViewGroup) null);
        ((LinearLayout) this.root.findViewById(R.id.table)).addView(linearLayout);
        CheckBox checkBox = (CheckBox) linearLayout.findViewById(R.id.enableXInput);
        checkBox.setChecked(inputTouchControlElementData.enableXI);
        checkBox.setOnCheckedChangeListener(new CrossElementEditable$$ExternalSyntheticLambda0(this, inputTouchControlElementData));
        ToogleViews(inputTouchControlElementData.enableXI);
        IconElementCommons.InitIcons(context, linearLayout, inputTouchControlElementData.customIcon, iInputWindowElement, (String) null);
        int i = inputTouchControlElementData.codeUp;
        Objects.requireNonNull(inputTouchControlElementData);
        InitDir(linearLayout, R.id.codeUp, i, new CrossElementEditable$$ExternalSyntheticLambda5(inputTouchControlElementData));
        int i2 = inputTouchControlElementData.codeDown;
        Objects.requireNonNull(inputTouchControlElementData);
        InitDir(linearLayout, R.id.codeDown, i2, new CrossElementEditable$$ExternalSyntheticLambda2(inputTouchControlElementData));
        int i3 = inputTouchControlElementData.codeLeft;
        Objects.requireNonNull(inputTouchControlElementData);
        InitDir(linearLayout, R.id.codeLeft, i3, new CrossElementEditable$$ExternalSyntheticLambda3(inputTouchControlElementData));
        int i4 = inputTouchControlElementData.codeRight;
        Objects.requireNonNull(inputTouchControlElementData);
        InitDir(linearLayout, R.id.codeRight, i4, new CrossElementEditable$$ExternalSyntheticLambda4(inputTouchControlElementData));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$com-catfixture-inputbridge-core-input-devices-touch-interaction-elements-cross-CrossElementEditable  reason: not valid java name */
    public /* synthetic */ void m70lambda$new$0$comcatfixtureinputbridgecoreinputdevicestouchinteractionelementscrossCrossElementEditable(InputTouchControlElementData inputTouchControlElementData, CompoundButton compoundButton, boolean z) {
        inputTouchControlElementData.enableXI = z;
        ToogleViews(z);
    }

    private void ToogleViews(boolean z) {
        int i = z ? 8 : 0;
        this.root.findViewById(R.id.defConf1).setVisibility(i);
        this.root.findViewById(R.id.defConf2).setVisibility(i);
    }

    public static void InitDir(View view, int i, int i2, Action<Integer> action) {
        KeyCodes.PrepareAdapter((Spinner) view.findViewById(i), i2, R.layout.touch_controls_list_item, new CrossElementEditable$$ExternalSyntheticLambda1(i2, action));
    }

    static /* synthetic */ void lambda$InitDir$1(int i, Action action, Integer num) {
        if (i != num.intValue()) {
            action.Invoke(num);
        }
    }
}
