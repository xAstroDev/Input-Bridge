package com.catfixture.inputbridge.core.input.data;

import android.renderscript.Float3;
import java.util.ArrayList;
import java.util.List;

public class PosSensorData {
    public AxisBinding axisX = new AxisBinding();
    public AxisBinding axisY = new AxisBinding();
    public AxisBinding axisZ = new AxisBinding();
    public Float3 calib = new Float3();
    public List<Float> clamps = new ArrayList(2);
    public boolean enable = false;
    public int gain = 100;
    public int interpolType = 0;
    public int latency = 2;
    public int selectedAxis = 0;
    public int sensitivity = 100;
    public int smooth = 90;

    public PosSensorData() {
        this.clamps.clear();
        this.clamps.add(Float.valueOf(5.0f));
        this.clamps.add(Float.valueOf(90.0f));
    }

    public AxisBinding GetAxisBindingByIndex(int i) {
        if (i == 0) {
            return this.axisX;
        }
        if (i == 1) {
            return this.axisY;
        }
        if (i == 2) {
            return this.axisZ;
        }
        return null;
    }

    public AxisBinding GetSelectedAxis() {
        return GetAxisBindingByIndex(this.selectedAxis);
    }
}
