package com.catfixture.inputbridge.core.input.utils;

import android.view.MotionEvent;
import android.view.View;
import com.catfixture.inputbridge.core.utils.math.Int2;

public class EventUtils {
    public static void InitializeITouchableEvents(View view, ITouchable iTouchable) {
        view.setOnTouchListener(new EventUtils$$ExternalSyntheticLambda0(iTouchable, new Int2(0, 0)));
    }

    static /* synthetic */ boolean lambda$InitializeITouchableEvents$0(ITouchable iTouchable, Int2 int2, View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    iTouchable.OnMove().notifyObservers(motionEvent);
                    return true;
                } else if (action != 5) {
                    if (action != 6) {
                        return false;
                    }
                }
            }
            iTouchable.OnUp().notifyObservers(motionEvent);
            if (int2.Distance(motionEvent.getRawX(), motionEvent.getRawY()) < 5) {
                iTouchable.OnClick().notifyObservers(motionEvent);
            }
            return true;
        }
        iTouchable.OnDown().notifyObservers(motionEvent);
        int2.Set(motionEvent.getRawX(), motionEvent.getRawY());
        return true;
    }
}
