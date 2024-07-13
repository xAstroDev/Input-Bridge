package com.catfixture.inputbridge.core.utils.types;

public class AutoResetEvent extends Event {
    public void notifyObservers() {
        setChanged();
        super.notifyObservers();
        deleteObservers();
    }

    public void notifyObservers(Object obj) {
        setChanged();
        super.notifyObservers(obj);
        deleteObservers();
    }
}
