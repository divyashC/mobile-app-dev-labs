package com.example.broadcast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String CUSTOM_TOAST_MESSAGE = "com.example.broadcast.CUSTOM_TOAST_MESSAGE";
    public static final String CUSTOM_TOAST_MESSAGE_FOR_LOCAL_BROADCAST = "com.example.broadcast.CUSTOM_TOAST_MESSAGE_FOR_LOCAL_BROADCAST";

    Button customBtn, localBtn;

    ReceiverClass myReceiver = new ReceiverClass();
    IntentFilter filter = new IntentFilter();

    private LocalBroadcastManager localBroadcastManager = null;
    private LocalReceiver localBReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customBtn = findViewById(R.id.sendBroadcast);

        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        filter.addAction(Intent.ACTION_POWER_CONNECTED);
        filter.addAction(CUSTOM_TOAST_MESSAGE);
        this.registerReceiver(myReceiver, filter);
        customBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setAction(MainActivity.CUSTOM_TOAST_MESSAGE);
                sendBroadcast(i);
            }
        });

        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        localBReceiver = new LocalReceiver();
        filter.addAction(CUSTOM_TOAST_MESSAGE_FOR_LOCAL_BROADCAST);
        localBroadcastManager.registerReceiver(localBReceiver, filter);

        localBtn = findViewById(R.id.localBroadcast);

        localBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CUSTOM_TOAST_MESSAGE_FOR_LOCAL_BROADCAST);
                localBroadcastManager.sendBroadcast(i);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MainActivity.this.unregisterReceiver(myReceiver);
        if (localBroadcastManager != null) {
            localBroadcastManager.unregisterReceiver(localBReceiver);
        }
    }
}

