package com.catfixture.inputbridge.core.GSS.SysDev.sensors;

import com.catfixture.inputbridge.core.GSS.SysDev.sensors.base.ThermalSensor;

public class CPUTemperatureSensor extends ThermalSensor {
    public int GetType() {
        return 20;
    }

    public CPUTemperatureSensor(String str) throws Exception {
        super(str);
    }
}
