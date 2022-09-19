package com.example.alarmandnotificaton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.provider.AlarmClock;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NotificationChannel();
        Button notify = (Button) findViewById(R.id.notify);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "Hello")
                .setSmallIcon(R.drawable.ic_baseline_access_alarm_24)
                .setContentTitle("Alarm").setContentText("Setting Alarm...").setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

        notify.setOnClickListener(view -> {
            notificationManager.notify(100, builder.build());
            Intent i = new Intent(AlarmClock.ACTION_SHOW_ALARMS);
            startActivity(i);
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void NotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "HelloWorldChannel";
            String description = "Channel for Hello World Notification";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel channel = new NotificationChannel("Hello", name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}