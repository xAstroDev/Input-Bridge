package com.catfixture.inputbridge.core.inputbridge;

import com.catfixture.inputbridge.core.utils.process.ThreadUtils;

public class PreciseSync {
    private long lastMeasureTime;
    private long targetFrameTime;
    private long targetSleepTime;

    public PreciseSync() {
        SetTargetFrameRate(60);
    }

    public boolean Process() {
        long nanoTime = System.nanoTime();
        if (nanoTime - this.lastMeasureTime >= this.targetFrameTime) {
            this.lastMeasureTime = nanoTime;
            return true;
        }
        ThreadUtils.Sleep(this.targetSleepTime);
        return false;
    }

    public void SetTargetFrameRate(int i) {
        double d = (double) i;
        this.targetFrameTime = ((long) (1000.0d / d)) * 1000000;
        this.targetSleepTime = (long) (250.0d / d);
    }
}
