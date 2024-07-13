package com.catfixture.inputbridge.core.GSS.SysDev.sensors;

import com.catfixture.inputbridge.core.GSS.SysDev.scanner.IntPercentage21SensorReader;
import com.catfixture.inputbridge.core.GSS.SysDev.sensors.base.ISensor;

public class GPULoadSensor implements ISensor<Integer> {
    private final IntPercentage21SensorReader reader;

    public int GetType() {
        return 24;
    }

    public GPULoadSensor(String str) throws Exception {
        this.reader = new IntPercentage21SensorReader(str);
    }

    public Integer Read() {
        return this.reader.Read();
    }

    public void Destroy() {
        this.reader.Destroy();
    }
}
