package com.example.scheduleapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void scheduleJob(View v) {
        ComponentName componentName = new ComponentName(this, JobServiceExample.class);
        JobInfo info = new JobInfo.Builder(123, componentName)
                .setRequiresCharging(true)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
                .setPersisted(true).setPeriodic(15 * 60 * 1000)
                .build();

        JobScheduler scheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        int resultCode = scheduler.schedule(info);

        if (resultCode == JobScheduler.RESULT_SUCCESS) {
            Log.d(TAG, "Job scheduled");
            Toast.makeText(getApplicationContext(),"Job Scheduled", Toast.LENGTH_SHORT).show();
        } else {
            Log.d(TAG, "Job scheduling failed");
            Toast.makeText(getApplicationContext(),"Job Scheduling Failed", Toast.LENGTH_SHORT).show();

        }
    }

    public void cancelJob(View v) {
        JobScheduler scheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        scheduler.cancel(123);
        Log.d(TAG, "Job cancelled");
        Toast.makeText(getApplicationContext(),"Job Schedule Cancelled", Toast.LENGTH_SHORT).show();

    }
}