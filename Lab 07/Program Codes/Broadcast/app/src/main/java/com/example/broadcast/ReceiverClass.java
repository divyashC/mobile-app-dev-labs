package com.example.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class ReceiverClass extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
    // TODO: This method is called when the BroadcastReceiver is receiving
    // an Intent broadcast.
        String intentType = intent.getAction();
        if (intentType != null) {
            String toastMessage = "No intent Action";

            switch (intentType) {
                case Intent.ACTION_AIRPLANE_MODE_CHANGED:
                    boolean status = intent.getBooleanExtra("state", true);
                    if (status) {
                        toastMessage = "Airplane Mode Enabled";
                    } else {
                        toastMessage = "Airplane Mode Disabled";
                    }
                    break;

                case Intent.ACTION_BATTERY_LOW:
                    toastMessage = "Battery Low, Connect To A Power Source";
                    break;

                case Intent.ACTION_POWER_CONNECTED:
                    toastMessage = "Power Source Connected";
                    break;

                case Intent.ACTION_POWER_DISCONNECTED:
                    toastMessage = "Power Source Disconnected";
                    break;

                case MainActivity.CUSTOM_TOAST_MESSAGE:
                    toastMessage = "Custom Broadcast Received";
                    break;
            }

            Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show();
        }
    }
}
