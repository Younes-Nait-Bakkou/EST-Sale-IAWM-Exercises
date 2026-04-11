package com.example.allexercises;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class ServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        Button btnStartService = findViewById(R.id.btnStartService);
        Button btnStopService = findViewById(R.id.btnStopService);

        Intent serviceIntent = new Intent(this, MyMusicService.class);

        btnStartService.setOnClickListener(v -> {
            startService(serviceIntent);
        });

        btnStopService.setOnClickListener(v -> {
            stopService(serviceIntent);
        });
    }
}