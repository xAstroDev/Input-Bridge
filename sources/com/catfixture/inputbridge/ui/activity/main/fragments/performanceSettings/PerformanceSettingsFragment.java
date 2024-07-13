package com.catfixture.inputbridge.ui.activity.main.fragments.performanceSettings;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.context.ConfigContext;
import com.catfixture.inputbridge.core.input.data.InputConfigProfile;
import com.catfixture.inputbridge.core.utils.android.IActivityLaunchable;
import com.catfixture.inputbridge.ui.activity.sensorsView.SensorsViewActivity;
import com.catfixture.inputbridge.ui.tabs.DefaultTabFragment;
import com.catfixture.inputbridge.ui.utils.Utils;
import java.util.Objects;

public class PerformanceSettingsFragment extends DefaultTabFragment {
    private View root;

    static /* synthetic */ void lambda$ReinflateAll$3(ActivityResult activityResult) {
    }

    public void OnDestroy() {
    }

    public PerformanceSettingsFragment(Activity activity) {
        super(activity);
    }

    public View OnCreate() {
        View inflate = View.inflate(GetContext(), R.layout.fragment_performance_settings, (ViewGroup) null);
        this.root = inflate;
        return inflate;
    }

    private void ReinflateAll() {
        Context GetContext = GetContext();
        if (ConfigContext.data.HasCurrentProfile()) {
            final InputConfigProfile GetCurrentProfile = ConfigContext.data.GetCurrentProfile();
            int i = GetCurrentProfile.pipeRate;
            Objects.requireNonNull(GetCurrentProfile);
            Utils.InitSeekBar((SeekBar) this.root.findViewById(R.id.pipeRate), (TextView) this.root.findViewById(R.id.buttonEngineRateText), i, new PerformanceSettingsFragment$$ExternalSyntheticLambda5(GetCurrentProfile));
            int i2 = GetCurrentProfile.ibDriverRate;
            Objects.requireNonNull(GetCurrentProfile);
            Utils.InitSeekBar((SeekBar) this.root.findViewById(R.id.ibDriverRate), (TextView) this.root.findViewById(R.id.ibDriverRateText), i2, new PerformanceSettingsFragment$$ExternalSyntheticLambda4(GetCurrentProfile));
            CheckBox checkBox = (CheckBox) this.root.findViewById(R.id.filterActions);
            checkBox.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
            checkBox.setChecked(GetCurrentProfile.filterActions);
            checkBox.setOnCheckedChangeListener(new PerformanceSettingsFragment$$ExternalSyntheticLambda1(GetCurrentProfile));
            CheckBox checkBox2 = (CheckBox) this.root.findViewById(R.id.forceEvents);
            checkBox2.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
            checkBox2.setChecked(GetCurrentProfile.forceEvents);
            checkBox2.setOnCheckedChangeListener(new PerformanceSettingsFragment$$ExternalSyntheticLambda2(GetCurrentProfile));
            CheckBox checkBox3 = (CheckBox) this.root.findViewById(R.id.showRAM);
            checkBox3.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
            checkBox3.setChecked(GetCurrentProfile.showRAM);
            checkBox3.setOnCheckedChangeListener(new PerformanceSettingsFragment$$ExternalSyntheticLambda3(GetCurrentProfile));
            ((Button) this.root.findViewById(R.id.addSensor)).setOnClickListener(new PerformanceSettingsFragment$$ExternalSyntheticLambda0(this, GetContext));
            final SeekBar seekBar = (SeekBar) this.root.findViewById(R.id.gssFontSize);
            if (GetCurrentProfile.gssFontSize != 0) {
                seekBar.setProgress(GetCurrentProfile.gssFontSize);
            }
            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                }

                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                public void onStopTrackingTouch(SeekBar seekBar) {
                    GetCurrentProfile.gssFontSize = seekBar.getProgress();
                    GetCurrentProfile.Save();
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$ReinflateAll$4$com-catfixture-inputbridge-ui-activity-main-fragments-performanceSettings-PerformanceSettingsFragment  reason: not valid java name */
    public /* synthetic */ void m214lambda$ReinflateAll$4$comcatfixtureinputbridgeuiactivitymainfragmentsperformanceSettingsPerformanceSettingsFragment(Context context, View view) {
        ((IActivityLaunchable) GetActivity()).Launch(new Intent(context, SensorsViewActivity.class), PerformanceSettingsFragment$$ExternalSyntheticLambda6.INSTANCE);
    }

    public void onResume() {
        ReinflateAll();
    }
}
