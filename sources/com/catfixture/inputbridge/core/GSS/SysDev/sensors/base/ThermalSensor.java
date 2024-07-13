package com.catfixture.inputbridge.core.GSS.SysDev.sensors.base;

import com.catfixture.inputbridge.core.GSS.SysDev.scanner.Float1SensorReader;

public abstract class ThermalSensor implements ISensor<Float> {
    private final Float1SensorReader reader;

    public ThermalSensor(String str) throws Exception {
        this.reader = new Float1SensorReader(str, 1000);
    }

    public Float Read() {
        return this.reader.Read();
    }

    public void Destroy() {
        this.reader.Destroy();
    }
}
