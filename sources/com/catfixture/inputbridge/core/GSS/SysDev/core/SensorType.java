package com.catfixture.inputbridge.core.GSS.SysDev.core;

public class SensorType {
    public static final int SENSOR_TYPE_BATTERY = 26;
    public static final int SENSOR_TYPE_CPU_FREQUENCY = 22;
    public static final int SENSOR_TYPE_CPU_LOAD = 21;
    public static final int SENSOR_TYPE_CPU_TEMPERATURE = 20;
    public static final int SENSOR_TYPE_GPU_FREQUENCY = 25;
    public static final int SENSOR_TYPE_GPU_LOAD = 24;
    public static final int SENSOR_TYPE_GPU_TEMPERATURE = 23;

    public static String TypeToString(int i) {
        switch (i) {
            case 20:
                return "CPU temperature";
            case 21:
                return "CPU load";
            case 22:
                return "CPU frequency";
            case 23:
                return "GPU temperature";
            case 24:
                return "GPU load";
            case 25:
                return "CPU frequency";
            case 26:
                return "Battery";
            default:
                return "Ultra idiotic fault";
        }
    }
}
