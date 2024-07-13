package com.catfixture.inputbridge.core.utils.code;

import com.catfixture.inputbridge.core.debug.D;

public class FPSCounter {
    private int currCounter;
    private long lastMeasureTime;

    public void Measure() {
        if (System.currentTimeMillis() - this.lastMeasureTime > 1000) {
            int i = this.currCounter;
            this.currCounter = 0;
            D.M("FPS : " + i);
            this.lastMeasureTime = System.currentTimeMillis();
        }
        this.currCounter++;
    }
}
