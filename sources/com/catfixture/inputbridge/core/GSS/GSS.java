package com.catfixture.inputbridge.core.GSS;

import android.app.ActivityManager;
import android.content.Context;
import android.hardware.SensorEventCallback;
import android.os.Handler;
import com.catfixture.inputbridge.core.GSS.overlay.GSSOverlayFragment;
import com.catfixture.inputbridge.core.input.data.InputConfigProfile;
import com.catfixture.inputbridge.core.overlay.IOverlayFragment;
import com.catfixture.inputbridge.core.overlay.OverlayManager;
import java.util.Timer;
import java.util.TimerTask;

public class GSS {
    public static final int GSS_UPDATE_RATE = 1000;
    /* access modifiers changed from: private */
    public final FrameDataTable frameDataTable = new FrameDataTable();
    /* access modifiers changed from: private */
    public GSSOverlayFragment gssOverlayFragment;
    /* access modifiers changed from: private */
    public boolean isRunning = true;
    final float lerpSpeed = 0.2f;
    private SensorEventCallback sensorEventCallback;

    public void Reset() {
    }

    public GSS(Context context, OverlayManager overlayManager, InputConfigProfile inputConfigProfile) {
        Context context2 = context;
        OverlayManager overlayManager2 = overlayManager;
        final Handler handler = new Handler();
        final ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        final ActivityManager activityManager = (ActivityManager) context2.getSystemService("activity");
        Timer timer = new Timer("gssTimer");
        final Timer timer2 = timer;
        final InputConfigProfile inputConfigProfile2 = inputConfigProfile;
        timer.schedule(new TimerTask() {
            public void run() {
                if (!GSS.this.isRunning) {
                    timer2.cancel();
                    timer2.purge();
                    return;
                }
                if (inputConfigProfile2.showRAM) {
                    activityManager.getMemoryInfo(memoryInfo);
                    GSS.this.frameDataTable.ram = (memoryInfo.totalMem / 1048576) - (memoryInfo.availMem / 1048576);
                }
                handler.post(new GSS$1$$ExternalSyntheticLambda0(this));
            }

            /* access modifiers changed from: package-private */
            /* renamed from: lambda$run$0$com-catfixture-inputbridge-core-GSS-GSS$1  reason: not valid java name */
            public /* synthetic */ void m40lambda$run$0$comcatfixtureinputbridgecoreGSSGSS$1() {
                GSS.this.gssOverlayFragment.UpdateStatistics(GSS.this.frameDataTable);
            }
        }, 0, 1000);
        GSSOverlayFragment gSSOverlayFragment = new GSSOverlayFragment(context2);
        this.gssOverlayFragment = gSSOverlayFragment;
        overlayManager2.Add(gSSOverlayFragment);
        overlayManager2.Hide((IOverlayFragment) this.gssOverlayFragment);
    }

    public void Stop() {
        this.isRunning = false;
    }

    public void SetFPS(short s) {
        this.frameDataTable.fps = s;
    }
}
