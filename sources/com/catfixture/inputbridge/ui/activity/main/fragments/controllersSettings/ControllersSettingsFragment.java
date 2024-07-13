package com.catfixture.inputbridge.ui.activity.main.fragments.controllersSettings;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.context.ConfigContext;
import com.catfixture.inputbridge.core.input.data.ControllerConfigData;
import com.catfixture.inputbridge.core.input.data.InputConfigData;
import com.catfixture.inputbridge.core.input.devices.controller.Controller;
import com.catfixture.inputbridge.core.input.devices.controller.Controllers;
import com.catfixture.inputbridge.core.utils.android.AndroidUtils;
import com.catfixture.inputbridge.ui.activity.editors.phyDeviceEditor.GamepadDefaultControlsHelper;
import com.catfixture.inputbridge.ui.activity.editors.phyDeviceEditor.PhyDeviceEditorActivity;
import com.catfixture.inputbridge.ui.common.genAdapter.GenericListAdapter;
import com.catfixture.inputbridge.ui.common.interactions.ConfirmDialog;
import com.catfixture.inputbridge.ui.common.interactions.InputDialog;
import com.catfixture.inputbridge.ui.tabs.DefaultTabFragment;
import java.util.List;

public class ControllersSettingsFragment extends DefaultTabFragment {
    private GenericListAdapter<Controller> controllers;
    private RecyclerView controllersList;
    private View noControllersFound;
    /* access modifiers changed from: private */
    public View root;
    private BroadcastReceiver sysBRR;

    public ControllersSettingsFragment(Activity activity) {
        super(activity);
    }

    private void ReinflateAll() {
        InputConfigData inputConfigData = ConfigContext.data;
        if (inputConfigData.HasCurrentProfile()) {
            Context GetContext = GetContext();
            this.noControllersFound = this.root.findViewById(R.id.noControllersFound);
            this.controllersList = (RecyclerView) this.root.findViewById(R.id.controllersList);
            this.controllers = new GenericListAdapter<>(R.layout.controller_list_item, new ControllersSettingsFragment$$ExternalSyntheticLambda8(this, GetContext, inputConfigData));
            this.controllersList.setLayoutManager(new LinearLayoutManager(GetContext));
            this.controllersList.setAdapter(this.controllers);
            UpdateControllers();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$ReinflateAll$10$com-catfixture-inputbridge-ui-activity-main-fragments-controllersSettings-ControllersSettingsFragment  reason: not valid java name */
    public /* synthetic */ void m203lambda$ReinflateAll$10$comcatfixtureinputbridgeuiactivitymainfragmentscontrollersSettingsControllersSettingsFragment(Context context, InputConfigData inputConfigData, Controller controller, View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.icon);
        TextView textView = (TextView) view.findViewById(R.id.contName);
        TextView textView2 = (TextView) view.findViewById(R.id.contMac);
        TextView textView3 = (TextView) view.findViewById(R.id.contType);
        String VidPidToDeviceName = AndroidUtils.VidPidToDeviceName(controller.controllerCfg.vendorID, controller.controllerCfg.deviceID, controller.controllerCfg.name);
        StringBuilder sb = new StringBuilder();
        sb.append(controller.isOnline ? "🟢" : "🔴");
        sb.append(" ");
        sb.append(VidPidToDeviceName);
        textView.setText(sb.toString());
        textView2.setText("VID:" + controller.controllerCfg.vendorID + " PID:" + controller.controllerCfg.deviceID);
        switch (controller.controllerCfg.type) {
            case 10:
                textView3.setText(R.string.gamepad_input_device);
                imageView.setImageResource(R.drawable.gamepad_icon);
                view.setOnClickListener(new ControllersSettingsFragment$$ExternalSyntheticLambda7(this, controller, context));
                break;
            case 11:
                textView3.setText(R.string.mouse_input_device);
                imageView.setImageResource(R.drawable.mouse_icon);
                view.setOnClickListener(new ControllersSettingsFragment$$ExternalSyntheticLambda0(controller, context));
                break;
            case 12:
                textView3.setText(R.string.keyboard_input_device);
                imageView.setImageResource(R.drawable.keyboard_icon);
                view.setOnClickListener(new ControllersSettingsFragment$$ExternalSyntheticLambda2(controller, context));
                break;
        }
        ((Button) view.findViewById(R.id.removeCont)).setOnClickListener(new ControllersSettingsFragment$$ExternalSyntheticLambda3(this, view, context, inputConfigData, controller));
    }

    static /* synthetic */ void lambda$ReinflateAll$0(Controller controller, Context context, View view) {
        if (!controller.isOnline) {
            ConfirmDialog.Show(context, context.getString(R.string.im_sorry), context.getString(R.string.in_further));
        }
    }

    static /* synthetic */ void lambda$ReinflateAll$1(Controller controller, Context context, View view) {
        if (!controller.isOnline) {
            ConfirmDialog.Show(context, context.getString(R.string.im_sorry), context.getString(R.string.in_further));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$ReinflateAll$6$com-catfixture-inputbridge-ui-activity-main-fragments-controllersSettings-ControllersSettingsFragment  reason: not valid java name */
    public /* synthetic */ void m208lambda$ReinflateAll$6$comcatfixtureinputbridgeuiactivitymainfragmentscontrollersSettingsControllersSettingsFragment(Controller controller, Context context, View view) {
        if (!controller.isOnline) {
            ConfirmDialog.Show(context, context.getString(R.string.please_connect_dev), context.getString(R.string.p_conn_dev_hint));
        } else if (!controller.controllerCfg.isAlreadySetup) {
            InputDialog.ShowMegaCustom(context, R.layout.gamepad_default_setup_prompt, "How do you want to setup this device?", new ControllersSettingsFragment$$ExternalSyntheticLambda9(this, controller, context));
        } else {
            OpenPhysicalDevicesEditor(context, controller.controllerCfg);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$ReinflateAll$5$com-catfixture-inputbridge-ui-activity-main-fragments-controllersSettings-ControllersSettingsFragment  reason: not valid java name */
    public /* synthetic */ void m207lambda$ReinflateAll$5$comcatfixtureinputbridgeuiactivitymainfragmentscontrollersSettingsControllersSettingsFragment(Controller controller, Context context, LinearLayout linearLayout, AlertDialog alertDialog) {
        ((Button) linearLayout.findViewById(R.id.useWasd)).setOnClickListener(new ControllersSettingsFragment$$ExternalSyntheticLambda4(this, alertDialog, controller, context));
        ((Button) linearLayout.findViewById(R.id.useXI)).setOnClickListener(new ControllersSettingsFragment$$ExternalSyntheticLambda5(this, alertDialog, controller, context));
        ((Button) linearLayout.findViewById(R.id.useEmpty)).setOnClickListener(new ControllersSettingsFragment$$ExternalSyntheticLambda6(this, alertDialog, controller, context));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$ReinflateAll$2$com-catfixture-inputbridge-ui-activity-main-fragments-controllersSettings-ControllersSettingsFragment  reason: not valid java name */
    public /* synthetic */ void m204lambda$ReinflateAll$2$comcatfixtureinputbridgeuiactivitymainfragmentscontrollersSettingsControllersSettingsFragment(AlertDialog alertDialog, Controller controller, Context context, View view) {
        alertDialog.dismiss();
        GamepadDefaultControlsHelper.ConfigureDefaultWASDControls(controller.controllerCfg);
        SaveSettledState(controller.controllerCfg);
        OpenPhysicalDevicesEditor(context, controller.controllerCfg);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$ReinflateAll$3$com-catfixture-inputbridge-ui-activity-main-fragments-controllersSettings-ControllersSettingsFragment  reason: not valid java name */
    public /* synthetic */ void m205lambda$ReinflateAll$3$comcatfixtureinputbridgeuiactivitymainfragmentscontrollersSettingsControllersSettingsFragment(AlertDialog alertDialog, Controller controller, Context context, View view) {
        alertDialog.dismiss();
        GamepadDefaultControlsHelper.ConfigureDefaultXIControls(controller.controllerCfg);
        SaveSettledState(controller.controllerCfg);
        OpenPhysicalDevicesEditor(context, controller.controllerCfg);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$ReinflateAll$4$com-catfixture-inputbridge-ui-activity-main-fragments-controllersSettings-ControllersSettingsFragment  reason: not valid java name */
    public /* synthetic */ void m206lambda$ReinflateAll$4$comcatfixtureinputbridgeuiactivitymainfragmentscontrollersSettingsControllersSettingsFragment(AlertDialog alertDialog, Controller controller, Context context, View view) {
        alertDialog.dismiss();
        SaveSettledState(controller.controllerCfg);
        OpenPhysicalDevicesEditor(context, controller.controllerCfg);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$ReinflateAll$9$com-catfixture-inputbridge-ui-activity-main-fragments-controllersSettings-ControllersSettingsFragment  reason: not valid java name */
    public /* synthetic */ void m211lambda$ReinflateAll$9$comcatfixtureinputbridgeuiactivitymainfragmentscontrollersSettingsControllersSettingsFragment(View view, Context context, InputConfigData inputConfigData, Controller controller, View view2) {
        view.post(new ControllersSettingsFragment$$ExternalSyntheticLambda10(this, context, inputConfigData, controller));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$ReinflateAll$8$com-catfixture-inputbridge-ui-activity-main-fragments-controllersSettings-ControllersSettingsFragment  reason: not valid java name */
    public /* synthetic */ void m210lambda$ReinflateAll$8$comcatfixtureinputbridgeuiactivitymainfragmentscontrollersSettingsControllersSettingsFragment(Context context, InputConfigData inputConfigData, Controller controller) {
        ConfirmDialog.Show(context, context.getString(R.string.remove_controller), context.getString(R.string.remove_controller_text), context.getString(R.string.yes_text), new ControllersSettingsFragment$$ExternalSyntheticLambda1(this, inputConfigData, controller, context), context.getString(R.string.no_text), (Runnable) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$ReinflateAll$7$com-catfixture-inputbridge-ui-activity-main-fragments-controllersSettings-ControllersSettingsFragment  reason: not valid java name */
    public /* synthetic */ void m209lambda$ReinflateAll$7$comcatfixtureinputbridgeuiactivitymainfragmentscontrollersSettingsControllersSettingsFragment(InputConfigData inputConfigData, Controller controller, Context context) {
        inputConfigData.GetCurrentProfile().RemoveController(controller.controllerCfg);
        UpdateControllers();
        ConfirmDialog.Show(context, context.getString(R.string.config_removed), context.getString(R.string.config_removed_text));
    }

    private void OpenPhysicalDevicesEditor(Context context, ControllerConfigData controllerConfigData) {
        Intent intent = new Intent(context, PhyDeviceEditorActivity.class);
        intent.putExtra("DeviceID", controllerConfigData.deviceID);
        intent.putExtra("VendorID", controllerConfigData.vendorID);
        context.startActivity(intent);
    }

    private void SaveSettledState(ControllerConfigData controllerConfigData) {
        controllerConfigData.isAlreadySetup = true;
        ConfigContext.Save();
    }

    /* access modifiers changed from: private */
    public void UpdateControllers() {
        GenericListAdapter<Controller> genericListAdapter;
        if (ConfigContext.data.HasCurrentProfile() && (genericListAdapter = this.controllers) != null) {
            genericListAdapter.Flush();
            List<Controller> FindAllControllers = Controllers.FindAllControllers(GetContext());
            for (Controller AddItem : FindAllControllers) {
                this.controllers.AddItem(AddItem);
            }
            this.controllers.notifyDataSetChanged();
            ToggleNoControllersError(FindAllControllers.isEmpty());
        }
    }

    private void ToggleNoControllersError(boolean z) {
        int i = 0;
        this.noControllersFound.setVisibility(z ? 0 : 8);
        RecyclerView recyclerView = this.controllersList;
        if (z) {
            i = 8;
        }
        recyclerView.setVisibility(i);
    }

    public View OnCreate() {
        this.root = View.inflate(GetContext(), R.layout.fragment_controllers_settings, (ViewGroup) null);
        this.sysBRR = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                if (ControllersSettingsFragment.this.root != null) {
                    ControllersSettingsFragment.this.root.postDelayed(new ControllersSettingsFragment$1$$ExternalSyntheticLambda0(this), 1000);
                }
            }

            /* access modifiers changed from: package-private */
            /* renamed from: lambda$onReceive$0$com-catfixture-inputbridge-ui-activity-main-fragments-controllersSettings-ControllersSettingsFragment$1  reason: not valid java name */
            public /* synthetic */ void m212lambda$onReceive$0$comcatfixtureinputbridgeuiactivitymainfragmentscontrollersSettingsControllersSettingsFragment$1() {
                ControllersSettingsFragment.this.UpdateControllers();
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.device.action.ACL_CONNECTED");
        intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECT_REQUESTED");
        intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        intentFilter.addAction("android.hardware.usb.action.USB_STATE");
        intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
        intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
        GetContext().registerReceiver(this.sysBRR, intentFilter);
        return this.root;
    }

    public void OnDestroy() {
        if (this.sysBRR != null) {
            GetContext().unregisterReceiver(this.sysBRR);
        }
    }

    public void onResume() {
        ReinflateAll();
        UpdateControllers();
    }
}
