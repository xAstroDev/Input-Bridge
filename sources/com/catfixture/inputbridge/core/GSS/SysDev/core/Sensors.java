package com.catfixture.inputbridge.core.GSS.SysDev.core;

import com.catfixture.inputbridge.core.GSS.SysDev.discovery.SensorPresence;
import com.catfixture.inputbridge.core.GSS.SysDev.sensors.base.ISensor;
import java.util.HashMap;
import java.util.Map;

public class Sensors {
    private static final HashMap<SensorPresence, ISensor<?>> cachedSensors = new HashMap<>();

    public static ISensor<?> Get(SensorPresence sensorPresence) {
        HashMap<SensorPresence, ISensor<?>> hashMap = cachedSensors;
        if (hashMap.containsKey(sensorPresence)) {
            return hashMap.get(sensorPresence);
        }
        ISensor<?> Create = SensorsProvider.Create(sensorPresence);
        hashMap.put(sensorPresence, Create);
        return Create;
    }

    public static void Destroy(SensorPresence sensorPresence) {
        ISensor iSensor;
        HashMap<SensorPresence, ISensor<?>> hashMap = cachedSensors;
        if (hashMap.containsKey(sensorPresence) && (iSensor = hashMap.get(sensorPresence)) != null) {
            iSensor.Destroy();
        }
    }

    public static void DestroyAll() {
        try {
            for (Map.Entry<SensorPresence, ISensor<?>> value : cachedSensors.entrySet()) {
                ((ISensor) value.getValue()).Destroy();
            }
            cachedSensors.clear();
        } catch (Exception unused) {
        }
    }
}
