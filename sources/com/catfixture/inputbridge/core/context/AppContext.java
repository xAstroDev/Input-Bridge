package com.catfixture.inputbridge.core.context;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.Vibrator;
import android.widget.Toast;
import com.catfixture.inputbridge.core.input.devices.sensors.PositionSensor;

public class AppContext extends Application {
    public static AppContext app;
    public static Cache cache;
    public DebugContext debugContext;
    private PositionSensor positionSensor;
    public SharedPreferences spoilerShaPrefs;
    public Vibrator vibrator;

    public void onCreate() {
        super.onCreate();
        app = this;
        this.spoilerShaPrefs = getSharedPreferences("SHA_SPOIL_SET", 0);
        this.debugContext = new DebugContext(this);
        ConfigContext.Init(getFilesDir().toString());
        this.vibrator = (Vibrator) getSystemService("vibrator");
        this.positionSensor = new PositionSensor(this);
        cache = new Cache(this);
    }

    public void onTerminate() {
        super.onTerminate();
        app = null;
        cache.Destroy();
        cache = null;
        this.positionSensor.OnDestroy();
        this.debugContext.Terminate();
    }

    public void onLowMemory() {
        super.onLowMemory();
        Toast.makeText(this, "Low mem, lags become soon 😈", 1);
    }

    public PositionSensor GetPositionSensor() {
        return this.positionSensor;
    }
}
