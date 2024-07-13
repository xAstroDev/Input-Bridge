package com.catfixture.inputbridge.core.GSS.SysDev.scanner;

import com.catfixture.inputbridge.core.GSS.SysDev.core.ISensorReader;
import java.io.RandomAccessFile;

public class IntPercentage21SensorReader implements ISensorReader<Integer> {
    private final RandomAccessFile ras;
    private int resolution;

    public IntPercentage21SensorReader(String str) throws Exception {
        this.ras = new RandomAccessFile(str, "r");
    }

    public Integer Read() {
        try {
            this.ras.seek(0);
            String[] split = this.ras.readLine().trim().split(" ");
            return Integer.valueOf((int) ((Long.parseLong(split[0]) * 100) / Long.parseLong(split[1])));
        } catch (Exception unused) {
            return 0;
        }
    }

    public void Destroy() {
        try {
            this.ras.close();
        } catch (Exception unused) {
        }
    }
}
