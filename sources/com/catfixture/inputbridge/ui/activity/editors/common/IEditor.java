package com.catfixture.inputbridge.ui.activity.editors.common;

import java.util.Observable;

public interface IEditor {
    Observable OnNewAxisInput();

    Observable OnNewButtonInput();
}
