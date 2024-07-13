package com.catfixture.inputbridge.ui.activity.sensorsView;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import com.catfixture.inputbridge.R;
import com.catfixture.inputbridge.core.GSS.SysDev.core.Sensors;
import com.catfixture.inputbridge.core.GSS.SysDev.discovery.LoadSensorsDiscover;
import com.catfixture.inputbridge.core.GSS.SysDev.discovery.SensorPresence;
import com.catfixture.inputbridge.core.GSS.SysDev.discovery.ThermalSensorsDiscover;
import com.catfixture.inputbridge.core.context.ConfigContext;
import com.catfixture.inputbridge.ui.activity.main.ErrorH;
import com.catfixture.inputbridge.ui.custom.SensorBox;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class SensorsViewActivity extends AppCompatActivity {
    private List<SensorBox> toUpdate;
    private Timer updaterTimer;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(View.inflate(this, R.layout.activity_sensors_view, (ViewGroup) null));
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        FullyReinflateAll();
        final Handler handler = new Handler();
        Timer timer = new Timer();
        this.updaterTimer = timer;
        timer.schedule(new TimerTask() {
            /* access modifiers changed from: package-private */
            /* renamed from: lambda$run$0$com-catfixture-inputbridge-ui-activity-sensorsView-SensorsViewActivity$1  reason: not valid java name */
            public /* synthetic */ void m231lambda$run$0$comcatfixtureinputbridgeuiactivitysensorsViewSensorsViewActivity$1() {
                SensorsViewActivity.this.UpdateSensors();
            }

            public void run() {
                handler.post(new SensorsViewActivity$1$$ExternalSyntheticLambda0(this));
            }
        }, 0, 1000);
    }

    /* access modifiers changed from: private */
    public void UpdateSensors() {
        try {
            for (SensorBox Update : this.toUpdate) {
                Update.Update();
            }
        } catch (Exception e) {
            ErrorH.RaiseCrash(this, e.getMessage(), Arrays.toString(e.getStackTrace()));
        }
    }

    private void FullyReinflateAll() {
        try {
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.rootCont);
            viewGroup.removeAllViews();
            this.toUpdate = new ArrayList();
            List<SensorPresence> Discover = ThermalSensorsDiscover.Discover();
            InflateSensorPresence(viewGroup, LoadSensorsDiscover.Discover());
            InflateSensorPresence(viewGroup, Discover);
        } catch (Exception e) {
            ErrorH.RaiseCrash(this, e.getMessage(), Arrays.toString(e.getStackTrace()));
        }
    }

    private void InflateSensorPresence(ViewGroup viewGroup, List<SensorPresence> list) {
        for (SensorPresence next : list) {
            SensorBox sensorBox = new SensorBox(this);
            boolean z = false;
            Iterator<SensorPresence> it = ConfigContext.data.sensorsSet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                SensorPresence next2 = it.next();
                if (next2.equals(next)) {
                    sensorBox.InitAsUsed(next2);
                    this.toUpdate.add(sensorBox);
                    z = true;
                    break;
                }
            }
            if (!z) {
                sensorBox.InitAsUnused(next);
            }
            sensorBox.SetOnEnabledStateChanged(new SensorsViewActivity$$ExternalSyntheticLambda0(this, next));
            viewGroup.addView(sensorBox);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$InflateSensorPresence$0$com-catfixture-inputbridge-ui-activity-sensorsView-SensorsViewActivity  reason: not valid java name */
    public /* synthetic */ void m230lambda$InflateSensorPresence$0$comcatfixtureinputbridgeuiactivitysensorsViewSensorsViewActivity(SensorPresence sensorPresence, Boolean bool) {
        if (bool.booleanValue()) {
            ConfigContext.data.AddSensorToSet(sensorPresence);
        } else {
            ConfigContext.data.RemoveSensorFromSet(sensorPresence);
        }
        FullyReinflateAll();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        try {
            this.updaterTimer.cancel();
            this.updaterTimer.purge();
        } catch (Exception unused) {
        }
        Sensors.DestroyAll();
        try {
            this.toUpdate.clear();
        } catch (Exception unused2) {
        }
    }
}
