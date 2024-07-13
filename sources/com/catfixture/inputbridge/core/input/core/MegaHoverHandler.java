package com.catfixture.inputbridge.core.input.core;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.collection.ArraySet;
import com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.TouchableWindowElement;
import java.util.Iterator;

public class MegaHoverHandler extends View {
    private final ArraySet<TouchableWindowElement> hovered = new ArraySet<>();
    private final ArraySet<TouchableWindowElement> views = new ArraySet<>();

    /* access modifiers changed from: package-private */
    public void Init() {
    }

    public MegaHoverHandler(Context context) {
        super(context);
        Init();
    }

    public MegaHoverHandler(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Init();
    }

    public MegaHoverHandler(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Init();
    }

    public void RegisterView(TouchableWindowElement touchableWindowElement) {
        this.views.add(touchableWindowElement);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float rawX = motionEvent.getRawX();
                    float rawY = motionEvent.getRawY();
                    Iterator<TouchableWindowElement> it = this.views.iterator();
                    while (it.hasNext()) {
                        TouchableWindowElement next = it.next();
                        int left = next.getLeft();
                        int top = next.getTop();
                        int width = next.getWidth();
                        int height = next.getHeight();
                        if (rawX <= ((float) left) || rawX >= ((float) (left + width)) || rawY <= ((float) top) || rawY >= ((float) (top + height))) {
                            if (this.hovered.contains(next)) {
                                this.hovered.remove(next);
                                next.OnExit().notifyObservers(motionEvent);
                            }
                        } else if (!this.hovered.contains(next)) {
                            this.hovered.add(next);
                            next.OnEnter().notifyObservers(motionEvent);
                        }
                    }
                    return true;
                } else if (action != 5) {
                    if (action != 6) {
                        return false;
                    }
                }
            }
            Iterator<TouchableWindowElement> it2 = this.hovered.iterator();
            while (it2.hasNext()) {
                it2.next().OnExit().notifyObservers(motionEvent);
            }
            this.hovered.clear();
        }
        return true;
    }
}
