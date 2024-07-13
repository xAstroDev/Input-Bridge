package com.catfixture.inputbridge.core.input.devices.controller;

import com.catfixture.inputbridge.core.input.data.ControllerConfigData;
import com.catfixture.inputbridge.ui.common.genAdapter.IAdapterItem;

public class Controller implements IAdapterItem {
    public ControllerConfigData controllerCfg;
    public boolean isOnline;

    public int GetSpacing() {
        return 0;
    }

    public boolean IsVisible() {
        return true;
    }

    public void SetSpacing(int i) {
    }

    public void ToggleVisibility(boolean z) {
    }

    public void SetData(ControllerConfigData controllerConfigData) {
        this.controllerCfg = controllerConfigData;
    }

    public void SetOnline() {
        this.isOnline = true;
    }
}
