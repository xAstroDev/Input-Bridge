package com.catfixture.inputbridge.core.GSS.SysDev.sensors;

import com.catfixture.inputbridge.core.GSS.SysDev.sensors.base.ThermalSensor;

public class BatterySensor extends ThermalSensor {
    public int GetType() {
        return 26;
    }

    public BatterySensor(String str) throws Exception {
        super(str);
    }
}
