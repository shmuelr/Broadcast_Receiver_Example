package com.orbitdesign.broadcastreciverexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    private static final String TAG = "Broadcast Receiver";

    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive Broadcast from "+intent.getAction());

        if(intent.getAction().equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)){
            Log.d(TAG, "Airplane mode! Vroom Vroom!");
        }

        Toast.makeText(context, "Broadcast Received "+intent.getAction(), Toast.LENGTH_LONG).show();

    }
}
