package com.catfixture.inputbridge.core.input.data;

import android.view.InputDevice;
import androidx.core.view.ViewCompat;
import com.catfixture.inputbridge.core.context.ConfigContext;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.editor.finetune.ColorData;
import com.catfixture.inputbridge.core.utils.math.Float2;
import com.catfixture.inputbridge.core.utils.math.Int2;
import com.catfixture.inputbridge.ui.common.genAdapter.IAdapterItem;
import java.util.ArrayList;
import java.util.List;

public class InputConfigProfile implements IAdapterItem {
    public List<ControllerConfigData> controllersDatas = new ArrayList();
    public boolean disableHook;
    public ColorData editorBgColor = new ColorData(ViewCompat.MEASURED_STATE_MASK);
    public boolean enableTouchRumble = false;
    public boolean enableXInput = true;
    public boolean enableXInputRumble = false;
    public boolean filterActions = true;
    public boolean forceEvents = true;
    public int globalSensivity = 100;
    public int gssFontSize = 0;
    public int ibDriverRate = 60;
    public boolean icHidePanels = true;
    public boolean icMaximize = true;
    public boolean integrateControls;
    public int integrateControlsType;
    public int internalId;
    public boolean isMiceInRelativeMode;
    public boolean isToolbarShown;
    private transient boolean isVisible = true;
    public Float2 lastTouchPos = new Float2(0.0f, 0.0f);
    public boolean miceToggled;
    public String name = "Input profile";
    public int pipeRate = 60;
    public PosSensorData posSensorData = new PosSensorData();
    public ColorData pressTintColor = new ColorData(-12369085);
    public Int2 refResolution = new Int2(-1, -1);
    public boolean screenAsMouse = true;
    public boolean showBackground = false;
    public boolean showControlsWhenConnected;
    public boolean showRAM;
    public boolean showXIFPS;
    public int snappingSize = 10;
    public int tceScrollPos;
    public List<InputTouchControlElementData> touchControlElements = new ArrayList();
    public boolean touchControlsHidden;
    public int touchRumbleImpetusTime = 15;
    public int uiOpacity = 100;

    public int GetSpacing() {
        return 0;
    }

    public void SetSpacing(int i) {
    }

    public void SetUiOpacity(int i) {
        this.uiOpacity = i;
    }

    public void SetIcMaximize(boolean z) {
        this.icMaximize = z;
        Save();
    }

    public void SetIcHidePanels(boolean z) {
        this.icHidePanels = z;
        Save();
    }

    public void SetShowControlsWhenConnected(boolean z) {
        this.showControlsWhenConnected = z;
        Save();
    }

    public void SetIntegrateControls(boolean z) {
        this.integrateControls = z;
        Save();
    }

    public void SetIntegrateControlsType(int i) {
        this.integrateControlsType = i;
        Save();
    }

    public void ToggleVisibility(boolean z) {
        this.isVisible = z;
    }

    public boolean IsVisible() {
        return this.isVisible;
    }

    public void SetRefResolution(Int2 int2) {
        this.refResolution = int2;
        Save();
    }

    public void SetScreenAsMouse(boolean z) {
        this.screenAsMouse = z;
    }

    public void SetPipeRate(int i) {
        this.pipeRate = i;
        Save();
    }

    public void SetIBDriverRate(int i) {
        this.ibDriverRate = i;
        Save();
    }

    public void SetGlobalSensitivity(int i) {
        this.globalSensivity = i;
    }

    public String GetName() {
        return this.name;
    }

    public void AddControlElement(int i, Float2 float2) {
        InputTouchControlElementData inputTouchControlElementData = new InputTouchControlElementData();
        inputTouchControlElementData.SetId(i);
        this.touchControlElements.add(inputTouchControlElementData);
        inputTouchControlElementData.SetPosition(new Int2((int) (float2.x - 75.0f), (int) (float2.y - 75.0f)));
    }

    public void Save() {
        ConfigContext.Save();
    }

    public void RemoveControlElement(int i) {
        for (InputTouchControlElementData next : this.touchControlElements) {
            if (next.id == i) {
                this.touchControlElements.remove(next);
                return;
            }
        }
    }

    public void SetName(String str) {
        this.name = str;
    }

    public float GetGlobalSensivity() {
        return ((float) this.globalSensivity) / 100.0f;
    }

    public String toString() {
        return this.name;
    }

    public ControllerConfigData GetControllerConfig(InputDevice inputDevice) {
        if (inputDevice == null) {
            return null;
        }
        for (ControllerConfigData next : this.controllersDatas) {
            if (next.Equals(inputDevice)) {
                return next;
            }
        }
        return null;
    }

    public ControllerConfigData GetControllerConfig(int i, int i2) {
        for (ControllerConfigData next : this.controllersDatas) {
            if (next.deviceID == i && next.vendorID == i2) {
                return next;
            }
        }
        return null;
    }

    public void AddController(ControllerConfigData controllerConfigData) {
        this.controllersDatas.add(controllerConfigData);
        Save();
    }

    public void RemoveController(ControllerConfigData controllerConfigData) {
        this.controllersDatas.remove(controllerConfigData);
        Save();
    }

    public void SetSnappingSize(int i) {
        this.snappingSize = i;
    }

    public int GetInternalId() {
        int i = this.internalId;
        this.internalId = i + 1;
        return i;
    }

    public void SetTceScrollPos(int i) {
        this.tceScrollPos = i;
    }

    public void SetLastTouchPos(Float2 float2) {
        this.lastTouchPos = float2;
    }

    public void SetDisableHook(boolean z) {
        this.disableHook = z;
        Save();
    }

    public void SetShowRAM(boolean z) {
        this.showRAM = z;
        Save();
    }

    public void SetTouchControlsHidden(boolean z) {
        this.touchControlsHidden = z;
        Save();
    }

    public void SetShowBackground(boolean z) {
        this.showBackground = z;
    }

    public void SetFilterActions(boolean z) {
        this.filterActions = z;
        Save();
    }

    public void SetForceEvents(boolean z) {
        this.forceEvents = z;
        Save();
    }
}
