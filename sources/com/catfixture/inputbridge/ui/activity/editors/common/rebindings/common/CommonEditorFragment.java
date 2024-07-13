package com.catfixture.inputbridge.ui.activity.editors.common.rebindings.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.context.ConfigContext;
import com.catfixture.inputbridge.core.input.codes.KeyCodes;
import com.catfixture.inputbridge.core.input.codes.MouseCodes;
import com.catfixture.inputbridge.core.input.data.ControllerConfigData;
import com.catfixture.inputbridge.core.input.data.ControllerRebindRecord;
import com.catfixture.inputbridge.core.input.data.KeyboardRebinding;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.buttons.common.BType;
import com.catfixture.inputbridge.ui.common.genAdapter.GenericListAdapter;
import com.catfixture.inputbridge.ui.tabs.DefaultTabFragment;
import com.catfixture.inputbridge.ui.utils.Utils;

public abstract class CommonEditorFragment extends DefaultTabFragment {
    protected ControllerConfigData controllerCfg;
    protected GenericListAdapter<ControllerRebindRecord> rebindRecordGenericListAdapter;
    protected int selectedItem;

    public void OnDestroy() {
    }

    /* access modifiers changed from: protected */
    public abstract void UpdateBindings();

    public CommonEditorFragment(Activity activity) {
        super(activity);
    }

    /* access modifiers changed from: protected */
    public void Init() {
        Intent intent = GetActivity().getIntent();
        this.controllerCfg = ConfigContext.data.GetCurrentProfile().GetControllerConfig(intent.getIntExtra("DeviceID", -1), intent.getIntExtra("VendorID", -1));
    }

    /* access modifiers changed from: protected */
    public void SetupBType(View view, KeyboardRebinding keyboardRebinding) {
        Spinner spinner = (Spinner) view.findViewById(R.id.buttonType);
        Context context = view.getContext();
        BType.Create(context);
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) null);
        ArrayAdapter InitSpinner = Utils.InitSpinner(context, spinner, 0, R.layout.touch_controls_list_item);
        InitSpinner.addAll(BType.types);
        spinner.setAdapter(InitSpinner);
        spinner.setSelection(keyboardRebinding.buttonType);
        Utils.AttachSpinnerAction(spinner, new CommonEditorFragment$$ExternalSyntheticLambda2(this, keyboardRebinding));
        SetupButtonType(view, keyboardRebinding, new CommonEditorFragment$$ExternalSyntheticLambda3(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$SetupBType$0$com-catfixture-inputbridge-ui-activity-editors-common-rebindings-common-CommonEditorFragment  reason: not valid java name */
    public /* synthetic */ void m122lambda$SetupBType$0$comcatfixtureinputbridgeuiactivityeditorscommonrebindingscommonCommonEditorFragment(KeyboardRebinding keyboardRebinding, Integer num) {
        if (keyboardRebinding.buttonType != num.intValue()) {
            keyboardRebinding.SetButtonType(num);
            UpdateBindings();
        }
    }

    /* access modifiers changed from: protected */
    public void SetupButtonType(View view, KeyboardRebinding keyboardRebinding, Runnable runnable) {
        Spinner spinner = (Spinner) view.findViewById(R.id.buttonCode);
        Spinner spinner2 = (Spinner) view.findViewById(R.id.mouseCode);
        int i = 0;
        spinner.setVisibility(keyboardRebinding.buttonType == 0 ? 0 : 8);
        if (keyboardRebinding.buttonType != 1) {
            i = 8;
        }
        spinner2.setVisibility(i);
        int i2 = keyboardRebinding.buttonType;
        if (i2 == 0) {
            KeyCodes.PrepareAdapter(spinner, keyboardRebinding.targetCode, R.layout.touch_controls_list_item, new CommonEditorFragment$$ExternalSyntheticLambda0(keyboardRebinding, runnable));
        } else if (i2 == 1) {
            MouseCodes.PrepareAdapter(spinner2, keyboardRebinding.targetCode, R.layout.touch_controls_list_item, new CommonEditorFragment$$ExternalSyntheticLambda1(keyboardRebinding, runnable));
        }
    }

    static /* synthetic */ void lambda$SetupButtonType$1(KeyboardRebinding keyboardRebinding, Runnable runnable, Integer num) {
        if (keyboardRebinding.targetCode != num.intValue()) {
            keyboardRebinding.SetTargetCode(num.intValue());
            runnable.run();
        }
    }

    static /* synthetic */ void lambda$SetupButtonType$2(KeyboardRebinding keyboardRebinding, Runnable runnable, Integer num) {
        if (keyboardRebinding.targetCode != num.intValue()) {
            keyboardRebinding.SetTargetCode(num.intValue());
            runnable.run();
        }
    }
}
