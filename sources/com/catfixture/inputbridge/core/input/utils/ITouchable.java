package com.catfixture.inputbridge.core.input.utils;

import com.catfixture.inputbridge.core.utils.types.Event;

public interface ITouchable {
    Event OnClick();

    Event OnDown();

    Event OnEnter();

    Event OnExit();

    Event OnMove();

    Event OnUp();
}
