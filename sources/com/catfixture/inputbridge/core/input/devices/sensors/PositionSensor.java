package com.catfixture.inputbridge.core.input.devices.sensors;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.catfixture.inputbridge.core.input.data.PosSensorData;
import com.catfixture.inputbridge.core.utils.math.Lerp;
import com.catfixture.inputbridge.core.utils.types.delegates.Action;

public class PositionSensor {
    public Runnable OnChanged;
    /* access modifiers changed from: private */
    public final float[] accelerometerReading = new float[3];
    /* access modifiers changed from: private */
    public boolean calibrationRequired;
    /* access modifiers changed from: private */
    public PosSensorData data = new PosSensorData();
    /* access modifiers changed from: private */
    public float gain = 1.0f;
    /* access modifiers changed from: private */
    public Action<PosSensorData> handler;
    /* access modifiers changed from: private */
    public final float[] magnetometerReading = new float[3];
    final float[] orientationAngles = new float[3];
    private final SensorEventListener sensorListener = new SensorEventListener() {
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            if (PositionSensor.this.data.enable) {
                if (sensorEvent.sensor.getType() == 1) {
                    System.arraycopy(sensorEvent.values, 0, PositionSensor.this.accelerometerReading, 0, PositionSensor.this.accelerometerReading.length);
                } else if (sensorEvent.sensor.getType() == 2) {
                    System.arraycopy(sensorEvent.values, 0, PositionSensor.this.magnetometerReading, 0, PositionSensor.this.magnetometerReading.length);
                }
                float[] fArr = new float[9];
                SensorManager.getRotationMatrix(fArr, (float[]) null, PositionSensor.this.accelerometerReading, PositionSensor.this.magnetometerReading);
                float[] fArr2 = new float[3];
                SensorManager.getOrientation(fArr, fArr2);
                PositionSensor positionSensor = PositionSensor.this;
                float unused = positionSensor.gain = (((float) positionSensor.data.gain) / 100.0f) + 0.5f;
                PositionSensor positionSensor2 = PositionSensor.this;
                float unused2 = positionSensor2.smooth = ((float) positionSensor2.data.smooth) / 100.0f;
                fArr2[0] = (float) Math.toDegrees((double) (fArr2[0] * PositionSensor.this.gain));
                fArr2[1] = (float) Math.toDegrees((double) (fArr2[1] * PositionSensor.this.gain));
                fArr2[2] = (float) Math.toDegrees((double) (fArr2[2] * PositionSensor.this.gain));
                if (PositionSensor.this.calibrationRequired) {
                    PositionSensor.this.data.calib.x = fArr2[0];
                    PositionSensor.this.data.calib.y = fArr2[1];
                    PositionSensor.this.data.calib.z = fArr2[2];
                    PositionSensor.this.handler.Invoke(PositionSensor.this.data);
                    boolean unused3 = PositionSensor.this.calibrationRequired = false;
                    return;
                }
                fArr2[0] = fArr2[0] - PositionSensor.this.data.calib.x;
                fArr2[1] = fArr2[1] - PositionSensor.this.data.calib.y;
                fArr2[2] = fArr2[2] - PositionSensor.this.data.calib.z;
                if (PositionSensor.this.data.clamps.size() > 0) {
                    ClampMinMaxPosNeg(fArr2, PositionSensor.this.data.clamps.get(0).floatValue(), PositionSensor.this.data.clamps.get(1).floatValue());
                }
                PositionSensor.this.orientationAngles[0] = Lerp.Lerp(PositionSensor.this.orientationAngles[0], fArr2[0], 1.0f - PositionSensor.this.smooth);
                PositionSensor.this.orientationAngles[1] = Lerp.Lerp(PositionSensor.this.orientationAngles[1], fArr2[1], 1.0f - PositionSensor.this.smooth);
                PositionSensor.this.orientationAngles[2] = Lerp.Lerp(PositionSensor.this.orientationAngles[2], fArr2[2], 1.0f - PositionSensor.this.smooth);
                if (PositionSensor.this.OnChanged != null) {
                    PositionSensor.this.OnChanged.run();
                }
            }
        }

        private void ClampMinMaxPosNeg(float[] fArr, float f, float f2) {
            for (int i = 0; i < fArr.length; i++) {
                float f3 = 0.0f;
                if (f != 0.0f) {
                    float f4 = -f;
                    if (fArr[i] <= f4 || fArr[i] >= f) {
                        float f5 = fArr[i];
                        if (fArr[i] <= 0.0f) {
                            f4 = f;
                        }
                        f3 = f5 + f4;
                    }
                    fArr[i] = f3;
                }
                if (f2 != 360.0f) {
                    fArr[i] = fArr[i] > f2 ? f2 : Math.max(fArr[i], -f2);
                }
            }
        }
    };
    private SensorManager sensorManager;
    /* access modifiers changed from: private */
    public float smooth = 0.0f;

    public void Calibrate(Action<PosSensorData> action) {
        this.handler = action;
        this.calibrationRequired = true;
    }

    public PositionSensor(Context context) {
        this.sensorManager = (SensorManager) context.getSystemService("sensor");
    }

    public void OnDestroy() {
        this.sensorManager.unregisterListener(this.sensorListener);
    }

    public float GetXRot() {
        return this.orientationAngles[2] * ((float) this.data.axisX.invert);
    }

    public float GetYRot() {
        return this.orientationAngles[1] * ((float) this.data.axisY.invert);
    }

    public float GetZRot() {
        return this.orientationAngles[0] * ((float) this.data.axisZ.invert);
    }

    public void SetData(PosSensorData posSensorData) {
        this.data = posSensorData;
        OnDestroy();
        Sensor defaultSensor = this.sensorManager.getDefaultSensor(1);
        if (defaultSensor != null) {
            this.sensorManager.registerListener(this.sensorListener, defaultSensor, posSensorData.latency, posSensorData.latency);
        }
        Sensor defaultSensor2 = this.sensorManager.getDefaultSensor(2);
        if (defaultSensor2 != null) {
            this.sensorManager.registerListener(this.sensorListener, defaultSensor2, posSensorData.latency, posSensorData.latency);
        }
    }
}
