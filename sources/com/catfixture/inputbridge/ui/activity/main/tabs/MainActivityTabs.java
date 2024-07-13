package com.catfixture.inputbridge.ui.activity.main.tabs;

import android.app.Activity;
import android.view.ViewGroup;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.context.ConfigContext;
import com.catfixture.inputbridge.ui.activity.main.fragments.controllersSettings.ControllersSettingsFragment;
import com.catfixture.inputbridge.ui.activity.main.fragments.generalSettings.GeneralSettingsFragment;
import com.catfixture.inputbridge.ui.activity.main.fragments.helpSettings.HelpFragment;
import com.catfixture.inputbridge.ui.activity.main.fragments.performanceSettings.PerformanceSettingsFragment;
import com.catfixture.inputbridge.ui.activity.main.fragments.sensorsSettings.SensorsFragment;
import com.catfixture.inputbridge.ui.activity.main.fragments.touchSettings.TouchSettingsFragment;
import com.catfixture.inputbridge.ui.tabs.TabController;

public class MainActivityTabs {
    private final TabController tabsController;

    public MainActivityTabs(Activity activity, ViewGroup viewGroup) {
        TabController tabController = new TabController((ViewGroup) viewGroup.findViewById(R.id.tabsButtonsContainer), (ViewGroup) viewGroup.findViewById(R.id.tabsContentContainer), R.layout.layout_no_text_tab_button);
        this.tabsController = tabController;
        tabController.AddTab(activity.getResources().getString(R.string.generalSettingsTab), R.drawable.home_ico, new GeneralSettingsFragment(activity));
        tabController.AddTab(activity.getResources().getString(R.string.performance), R.drawable.perf_ico, new PerformanceSettingsFragment(activity));
        tabController.AddTab(activity.getResources().getString(R.string.physical_controllers), R.drawable.gamepad_icon, new ControllersSettingsFragment(activity));
        tabController.AddTab(activity.getResources().getString(R.string.controlsSettingsTab), R.drawable.touch_finger_icon, new TouchSettingsFragment(activity));
        tabController.AddTab("Sensors", R.drawable.sensors_ico, new SensorsFragment(activity));
        tabController.AddTab(activity.getResources().getString(R.string.helpTab), R.drawable.help_ico, new HelpFragment(activity));
        tabController.SetTab(ConfigContext.data.currentMainTab);
        tabController.OnTabsSelectionChanged(MainActivityTabs$$ExternalSyntheticLambda0.INSTANCE);
        tabController.SetPortrait(activity.getResources().getConfiguration().orientation != 1 ? false : true);
        tabController.Create();
    }

    public void OnResume() {
        this.tabsController.OnResume();
    }

    public void OnDestroy() {
        this.tabsController.OnDestroy();
    }

    public void SetTab(int i) {
        this.tabsController.SetTab(i);
    }
}
