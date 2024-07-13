package com.catfixture.inputbridge.core.utils.process;

import android.app.Service;

public abstract class AutoIDService extends Service {
    protected int serviceID;

    public AutoIDService() {
        if (this.serviceID == -1) {
            this.serviceID = ProcUtils.GetProcessIDByClassName(getClass());
        }
    }
}
