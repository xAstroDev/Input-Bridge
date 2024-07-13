package com.catfixture.inputbridge.core.input.devices.touch.interaction.elements.fullscreen;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.catfixture.inputbridge.core.input.utils.EventUtils;
import com.catfixture.inputbridge.core.input.utils.ITouchable;
import com.catfixture.inputbridge.core.utils.android.LayoutUtils;
import com.catfixture.inputbridge.core.utils.types.Event;

public class FullscreenElement extends FrameLayout implements ITouchable {
    public Event onClick = new Event();
    public Event onDown = new Event();
    public Event onMove = new Event();
    public Event onUp = new Event();

    public FullscreenElement(Context context) {
        super(context);
        EventUtils.InitializeITouchableEvents(this, this);
        LayoutUtils.SetMatchMatch(this);
    }

    public FullscreenElement(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        EventUtils.InitializeITouchableEvents(this, this);
        LayoutUtils.SetMatchMatch(this);
    }

    public Event OnDown() {
        return this.onDown;
    }

    public Event OnMove() {
        return this.onMove;
    }

    public Event OnUp() {
        return this.onUp;
    }

    public Event OnClick() {
        return this.onClick;
    }

    public Event OnEnter() {
        return this.onMove;
    }

    public Event OnExit() {
        return this.onMove;
    }
}
