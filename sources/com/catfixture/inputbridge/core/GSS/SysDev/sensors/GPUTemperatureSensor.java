package com.catfixture.inputbridge.core.GSS.SysDev.sensors;

import com.catfixture.inputbridge.core.GSS.SysDev.sensors.base.ThermalSensor;

public class GPUTemperatureSensor extends ThermalSensor {
    public int GetType() {
        return 23;
    }

    public GPUTemperatureSensor(String str) throws Exception {
        super(str);
    }
}
