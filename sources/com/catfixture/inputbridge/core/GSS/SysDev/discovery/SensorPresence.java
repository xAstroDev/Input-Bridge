package com.catfixture.inputbridge.core.GSS.SysDev.discovery;

import com.catfixture.inputbridge.core.input.devices.touch.interaction.editor.finetune.ColorData;

public class SensorPresence {
    public Object cachedValue = 0;
    public String description;
    public int displayName;
    public int displayPostfix;
    public String path;
    public ColorData primaryColorData = new ColorData(-1522125);
    public ColorData secondaryColorData = new ColorData(-1);
    public int type;

    public SensorPresence() {
    }

    public SensorPresence(int i, String str, String str2) {
        this.type = i;
        this.path = str;
        this.description = str2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SensorPresence)) {
            return false;
        }
        SensorPresence sensorPresence = (SensorPresence) obj;
        if (this.type != sensorPresence.type || !this.path.equals(sensorPresence.path)) {
            return false;
        }
        return true;
    }
}
