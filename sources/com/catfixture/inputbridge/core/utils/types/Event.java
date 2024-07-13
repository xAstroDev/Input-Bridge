package com.catfixture.inputbridge.core.utils.types;

import java.util.Observable;

public class Event extends Observable {
    public void notifyObservers() {
        setChanged();
        super.notifyObservers();
    }

    public void notifyObservers(Object obj) {
        setChanged();
        super.notifyObservers(obj);
    }
}
