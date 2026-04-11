package com.example.allexercises;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.widget.Toast;
import androidx.annotation.Nullable;

public class MyMusicService extends Service {

    private MediaPlayer player;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        // 1. Initialize the player with the device's default ringtone
        player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);

        // 2. Set it to loop so the music doesn't just play once and stop
        player.setLooping(true);

        // 3. Start the playback
        player.start();

        Toast.makeText(this, "Music Service Started", Toast.LENGTH_SHORT).show();

        // START_STICKY tells the OS to recreate the service if it needs to kill it for memory
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        // CRITICAL: Stop the music and release the resources when the service dies
        if (player != null) {
            player.stop();
            player.release();
        }

        Toast.makeText(this, "Music Service Stopped", Toast.LENGTH_SHORT).show();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        // We aren't binding this service to the UI, so return null
        return null;
    }
}