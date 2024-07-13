package com.catfixture.inputbridge.core.input.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

public class HomeWatcher {
    private boolean isWatching;
    private Context mContext;
    private IntentFilter mFilter = new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    /* access modifiers changed from: private */
    public OnHomePressedListener mListener;
    private InnerReceiver mReceiver;

    public interface OnHomePressedListener {
        void onHomeLongPressed();

        void onHomePressed();
    }

    public boolean isWatching() {
        return this.isWatching;
    }

    public HomeWatcher(Context context) {
        this.mContext = context;
    }

    public void setOnHomePressedListener(OnHomePressedListener onHomePressedListener) {
        this.mListener = onHomePressedListener;
        this.mReceiver = new InnerReceiver();
    }

    public void startWatch() {
        InnerReceiver innerReceiver = this.mReceiver;
        if (innerReceiver != null) {
            this.mContext.registerReceiver(innerReceiver, this.mFilter);
            this.isWatching = true;
        }
    }

    public void stopWatch() {
        InnerReceiver innerReceiver = this.mReceiver;
        if (innerReceiver != null) {
            this.mContext.unregisterReceiver(innerReceiver);
            this.isWatching = false;
        }
    }

    class InnerReceiver extends BroadcastReceiver {
        final String SYSTEM_DIALOG_REASON_GLOBAL_ACTIONS = "globalactions";
        final String SYSTEM_DIALOG_REASON_HOME_KEY = "homekey";
        final String SYSTEM_DIALOG_REASON_KEY = "reason";
        final String SYSTEM_DIALOG_REASON_RECENT_APPS = "recentapps";

        InnerReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra("reason")) != null && HomeWatcher.this.mListener != null) {
                if (stringExtra.equals("homekey")) {
                    HomeWatcher.this.mListener.onHomePressed();
                } else if (stringExtra.equals("recentapps")) {
                    HomeWatcher.this.mListener.onHomeLongPressed();
                }
            }
        }
    }
}
