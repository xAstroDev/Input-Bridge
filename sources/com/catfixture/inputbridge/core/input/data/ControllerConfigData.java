package com.catfixture.inputbridge.core.input.data;

import android.view.InputDevice;
import com.catfixture.inputbridge.core.context.ConfigContext;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.editor.finetune.ColorData;
import java.util.ArrayList;
import java.util.List;

public class ControllerConfigData {
    public List<AxisBinding> axesBindings = new ArrayList();
    public int deviceID;
    public ColorData gamepadColor = new ColorData();
    public boolean isAlreadySetup = false;
    public String mac;
    public String name;
    public List<ControllerRebindRecord> rebinds = new ArrayList();
    public int type;
    public int vendorID;

    private void Save() {
        ConfigContext.Save();
    }

    public ControllerConfigData(String str) {
        this.name = str;
    }

    public ControllerConfigData() {
    }

    public void AddRebind(ControllerRebindRecord controllerRebindRecord) {
        this.rebinds.add(controllerRebindRecord);
        Save();
    }

    public boolean Equals(InputDevice inputDevice) {
        return this.deviceID == inputDevice.getProductId() && this.vendorID == inputDevice.getVendorId();
    }

    public ControllerRebindRecord FindBindingByLinkedCode(int i) {
        for (ControllerRebindRecord next : this.rebinds) {
            if (next.linkedCode == i) {
                return next;
            }
        }
        return null;
    }
}
