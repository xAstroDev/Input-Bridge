package com.catfixture.inputbridge.core.weakmsg;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.catfixture.inputbridge.core.utils.types.delegates.Action2;

public class WeakMsg {
    public static final String BCAST_ACTION_NAME = "IB_GBCASTNE";
    public static final String BCAST_ACTION_TYPE = "IB_GBCASTTP";
    public static final int BCAST_ERR_CODE = -1;

    public static BroadcastReceiver CreateListener(Context context, final Action2<Integer, Intent> action2) {
        AnonymousClass1 r0 = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                Action2.this.Invoke(Integer.valueOf(intent.getIntExtra(WeakMsg.BCAST_ACTION_TYPE, -1)), intent);
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BCAST_ACTION_NAME);
        context.registerReceiver(r0, intentFilter);
        return r0;
    }

    public static void DestroyListener(Context context, BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver != null) {
            try {
                context.unregisterReceiver(broadcastReceiver);
            } catch (Exception unused) {
            }
        }
    }

    public static Intent PrepareMessage(int i) {
        Intent intent = new Intent(BCAST_ACTION_NAME);
        intent.setAction(BCAST_ACTION_NAME).setFlags(67108864).putExtra(BCAST_ACTION_TYPE, i);
        return intent;
    }

    public static void Send(Context context, int i) {
        context.sendBroadcast(PrepareMessage(i));
    }

    public static void Send(Context context, Intent intent) {
        context.sendBroadcast(intent);
    }
}
