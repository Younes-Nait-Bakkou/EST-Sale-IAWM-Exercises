package com.example.allexercises;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyAlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "⏰ WAKE UP! Your Alarm just went off!", Toast.LENGTH_LONG).show();
    }
}