package com.example.allexercises;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class BootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            Log.i("BootReceiver", "Le téléphone a démarré !");
            Toast.makeText(context, "Boot Completed: Application AllExercises prête.", Toast.LENGTH_LONG).show();
        }
    }
}