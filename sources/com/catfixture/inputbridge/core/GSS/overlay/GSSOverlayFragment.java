package com.catfixture.inputbridge.core.GSS.overlay;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableRow;
import android.widget.TextView;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.GSS.FrameDataTable;
import com.catfixture.inputbridge.core.GSS.SysDev.SensorsNames;
import com.catfixture.inputbridge.core.GSS.SysDev.SensorsPostfixes;
import com.catfixture.inputbridge.core.GSS.SysDev.core.Sensors;
import com.catfixture.inputbridge.core.GSS.SysDev.discovery.SensorPresence;
import com.catfixture.inputbridge.core.GSS.SysDev.sensors.base.ISensor;
import com.catfixture.inputbridge.core.context.ConfigContext;
import com.catfixture.inputbridge.core.input.data.InputConfigProfile;
import com.catfixture.inputbridge.core.overlay.IOverlayFragment;
import com.catfixture.inputbridge.core.utils.android.LayoutUtils;
import java.util.HashMap;
import java.util.Map;
import okhttp3.HttpUrl;

public class GSSOverlayFragment implements IOverlayFragment {
    public static final int ID_GSS_OVERLAY_FRAGMENT = 10110;
    private final TextView apiText;
    private final TextView fpsSmLab;
    private final TextView fpsText;
    private final TableRow fpsTextCC;
    private final TextView ramSmLab;
    private final TextView ramText;
    private final TableRow ramTextCC;
    private final TextView ramTextLab;
    private final ViewGroup root;
    private HashMap<SensorPresence, TextView> toUpdate = new HashMap<>();

    public void Destroy() {
    }

    public int GetID() {
        return ID_GSS_OVERLAY_FRAGMENT;
    }

    public void OnFragmentHidden() {
    }

    public GSSOverlayFragment(Context context) {
        ViewGroup viewGroup = (ViewGroup) View.inflate(context, R.layout.overlay_statistics, (ViewGroup) null);
        this.root = viewGroup;
        LayoutUtils.SetWrapWrap(viewGroup);
        this.apiText = (TextView) viewGroup.findViewById(R.id.apiText);
        this.fpsText = (TextView) viewGroup.findViewById(R.id.fpsText);
        this.ramText = (TextView) viewGroup.findViewById(R.id.ramText);
        this.ramTextLab = (TextView) viewGroup.findViewById(R.id.ramTextLab);
        this.ramSmLab = (TextView) viewGroup.findViewById(R.id.ramSmLab);
        this.fpsSmLab = (TextView) viewGroup.findViewById(R.id.fpsSmLab);
        this.fpsTextCC = (TableRow) viewGroup.findViewById(R.id.fpsTextCC);
        this.ramTextCC = (TableRow) viewGroup.findViewById(R.id.ramTextCC);
    }

    public ViewGroup GetContainer() {
        return this.root;
    }

    public void OnFragmentShown() {
        float f;
        Context context = this.root.getContext();
        InputConfigProfile GetCurrentProfile = ConfigContext.data.GetCurrentProfile();
        if (GetCurrentProfile != null) {
            this.root.setAlpha(((float) GetCurrentProfile.uiOpacity) / 100.0f);
            int i = 0;
            this.ramTextCC.setVisibility(GetCurrentProfile.showRAM ? 0 : 8);
            TableRow tableRow = this.fpsTextCC;
            if (!GetCurrentProfile.showXIFPS) {
                i = 8;
            }
            tableRow.setVisibility(i);
            float f2 = 0.0f;
            if (GetCurrentProfile.gssFontSize != 0) {
                f2 = (float) LayoutUtils.GetDP(context, GetCurrentProfile.gssFontSize);
                f = f2 / 2.0f;
                this.ramText.setTextSize(f2);
                this.fpsText.setTextSize(f2);
                this.apiText.setTextSize(f2);
                this.ramTextLab.setTextSize(f2);
                this.ramSmLab.setTextSize(f);
                this.fpsSmLab.setTextSize(f);
            } else {
                f = 0.0f;
            }
            this.toUpdate.clear();
            while (this.root.getChildCount() > 2) {
                this.root.removeViewAt(2);
            }
            for (SensorPresence next : ConfigContext.data.sensorsSet) {
                ViewGroup viewGroup = (ViewGroup) View.inflate(context, R.layout.table_info_raw, (ViewGroup) null);
                TextView textView = (TextView) viewGroup.findViewById(R.id.mainLabel);
                TextView textView2 = (TextView) viewGroup.findViewById(R.id.valueLabel);
                TextView textView3 = (TextView) viewGroup.findViewById(R.id.smLabel);
                textView.setTextSize(f2);
                textView2.setTextSize(f2);
                textView3.setTextSize(f);
                textView.setTextColor(next.primaryColorData.color);
                textView2.setTextColor(next.secondaryColorData.color);
                textView3.setTextColor(next.secondaryColorData.color);
                textView.setText(SensorsNames.GetByIndex(next.displayName));
                textView2.setText(next.cachedValue + HttpUrl.FRAGMENT_ENCODE_SET);
                textView3.setText(SensorsPostfixes.GetByIndex(next.displayPostfix));
                this.toUpdate.put(next, textView2);
                this.root.addView(viewGroup);
            }
        }
    }

    public void UpdateStatistics(FrameDataTable frameDataTable) {
        this.fpsText.setText(Integer.toString(frameDataTable.fps));
        this.ramText.setText(Long.toString(frameDataTable.ram));
        for (Map.Entry next : this.toUpdate.entrySet()) {
            SensorPresence sensorPresence = (SensorPresence) next.getKey();
            ISensor<?> Get = Sensors.Get(sensorPresence);
            if (Get != null) {
                sensorPresence.cachedValue = Get.Read();
                ((TextView) next.getValue()).setText(sensorPresence.cachedValue + HttpUrl.FRAGMENT_ENCODE_SET);
            }
        }
    }
}
