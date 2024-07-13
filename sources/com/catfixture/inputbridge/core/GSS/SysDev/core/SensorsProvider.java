package com.catfixture.inputbridge.core.GSS.SysDev.core;

import com.catfixture.inputbridge.core.GSS.SysDev.discovery.SensorPresence;
import com.catfixture.inputbridge.core.GSS.SysDev.sensors.BatterySensor;
import com.catfixture.inputbridge.core.GSS.SysDev.sensors.CPUTemperatureSensor;
import com.catfixture.inputbridge.core.GSS.SysDev.sensors.GPULoadSensor;
import com.catfixture.inputbridge.core.GSS.SysDev.sensors.GPUTemperatureSensor;
import com.catfixture.inputbridge.core.GSS.SysDev.sensors.base.ISensor;

public class SensorsProvider {
    public static ISensor<?> Create(SensorPresence sensorPresence) {
        try {
            int i = sensorPresence.type;
            if (i == 20) {
                return new CPUTemperatureSensor(sensorPresence.path);
            }
            if (i == 26) {
                return new BatterySensor(sensorPresence.path);
            }
            if (i == 23) {
                return new GPUTemperatureSensor(sensorPresence.path);
            }
            if (i != 24) {
                return null;
            }
            return new GPULoadSensor(sensorPresence.path);
        } catch (Exception unused) {
            return null;
        }
    }
}
