package com.catfixture.inputbridge.core.GSS.SysDev.discovery;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class LoadSensorsDiscover {
    public static List<SensorPresence> Discover() {
        ArrayList arrayList = new ArrayList();
        File file = new File("/sys/class/kgsl/kgsl-3d0/gpubusy");
        if (file.exists()) {
            arrayList.add(new SensorPresence(24, file.getAbsolutePath(), "kgsl3d"));
        }
        return arrayList;
    }
}
