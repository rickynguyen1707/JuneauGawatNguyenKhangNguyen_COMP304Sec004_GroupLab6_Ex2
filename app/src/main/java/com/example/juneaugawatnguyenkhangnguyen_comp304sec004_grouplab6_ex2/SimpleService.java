package com.example.juneaugawatnguyenkhangnguyen_comp304sec004_grouplab6_ex2;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class SimpleService extends Service {
    //replace with your package name
    public static final String INFO_INTENT = "com.example.juneaugawatnguyenkhangnguyen_comp304sec004_grouplab6_ex2";


    public SimpleService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
    // We want this service to continue running until it is explicitly
    // stopped, so return sticky.
        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();

        Intent broadcastIntent = new Intent();
        broadcastIntent.setAction(INFO_INTENT);
        broadcastIntent.putExtra(INFO_INTENT,
                "Hello there! A simple service is sending this message to you!");
        this.sendBroadcast(broadcastIntent);

//
        return START_STICKY;

    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show();
    }

}
