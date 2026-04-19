package com.example.allexercises;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        setupButton(R.id.btnOpenBasicViews, BasicViewsActivity.class);
        setupButton(R.id.btnOpenAlerts, AlertActivity.class);
        setupButton(R.id.btnOpenCalendar, CalenderActivity.class);
        setupButton(R.id.btnOpenAdapter, ListActivity.class);
        setupButton(R.id.btnOpenIntents, IntentActivity.class);
        setupButton(R.id.btnOpenDatabase, DatabaseActivity.class);
        setupButton(R.id.btnOpenThreads, ThreadActivity.class);
        setupButton(R.id.btnOpenServices, ServiceActivity.class);
        setupButton(R.id.btnOpenFragments, FragmentActivity.class);
        setupButton(R.id.btnOpenAlarms, AlarmActivity.class);

        // --------- Travaux pratiques -------------
        setupButton(R.id.btnOpenTD1, TD1MenuActivity.class);
        setupButton(R.id.btnOpenTD2, TD2MenuActivity.class);
        setupButton(R.id.btnOpenEx1, Exam1.class);

    }
    private void setupButton(int id, Class<?> activityClass) {
        Button button = findViewById(id);
        if (button != null) {
            button.setOnClickListener(v -> {
                Intent intent = new Intent(this, activityClass);
                startActivity(intent);
            });
        }
    }
}