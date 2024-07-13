package com.catfixture.inputbridge.core.utils;

import android.view.View;
import java.util.HashMap;

public class ModeSwitcher {
    private int currentMode;
    private HashMap<Integer, ModeHolder> modes = new HashMap<>();

    public void SetMode(int i) {
        this.currentMode = i;
        if (this.modes.containsKey(Integer.valueOf(i))) {
            for (int i2 = 0; i2 < this.modes.size(); i2++) {
                ModeHolder modeHolder = this.modes.get(Integer.valueOf(i2));
                if (modeHolder.onOff != null) {
                    modeHolder.onOff.run();
                }
                modeHolder.root.setVisibility(8);
            }
            ModeHolder modeHolder2 = this.modes.get(Integer.valueOf(i));
            modeHolder2.root.setVisibility(0);
            modeHolder2.runnable.run();
        }
    }

    public void AddMode(int i, View view, Runnable runnable) {
        if (!this.modes.containsKey(Integer.valueOf(i))) {
            this.modes.put(Integer.valueOf(i), new ModeHolder(view, runnable));
        }
    }

    public void AddMode(int i, View view, Runnable runnable, Runnable runnable2) {
        if (!this.modes.containsKey(Integer.valueOf(i))) {
            this.modes.put(Integer.valueOf(i), new ModeHolder(view, runnable, runnable2));
        }
    }

    public int GetMode() {
        return this.currentMode;
    }
}
