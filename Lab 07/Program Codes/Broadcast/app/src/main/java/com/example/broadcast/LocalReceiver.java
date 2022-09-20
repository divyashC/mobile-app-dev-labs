package com.example.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class LocalReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
    // TODO: This method is called when the BroadcastReceiver is receiving
    // an Intent broadcast.

        String action = intent.getAction();

        if(MainActivity.CUSTOM_TOAST_MESSAGE_FOR_LOCAL_BROADCAST.equals(action)) {
            Toast.makeText(context, "Local Broadcast Received ", Toast.LENGTH_LONG).show();
        }
    }
}