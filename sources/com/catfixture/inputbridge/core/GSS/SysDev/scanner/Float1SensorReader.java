package com.catfixture.inputbridge.core.GSS.SysDev.scanner;

import com.catfixture.inputbridge.core.GSS.SysDev.core.ISensorReader;
import java.io.RandomAccessFile;

public class Float1SensorReader implements ISensorReader<Float> {
    private final RandomAccessFile ras;
    private int resolution = 1000;

    public Float1SensorReader(String str, int i) throws Exception {
        this.ras = new RandomAccessFile(str, "r");
        this.resolution = i;
    }

    public Float Read() {
        try {
            this.ras.seek(0);
            return Float.valueOf(Float.parseFloat(this.ras.readLine()) / ((float) this.resolution));
        } catch (Exception unused) {
            return Float.valueOf(-1.0f);
        }
    }

    public void Destroy() {
        try {
            this.ras.close();
        } catch (Exception unused) {
        }
    }
}
