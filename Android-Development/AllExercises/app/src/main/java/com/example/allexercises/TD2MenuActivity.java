package com.example.allexercises;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class TD2MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_td2_menu);

        setupButton(R.id.btnTD2Ex1, TD2Ex1Activity.class);
        setupButton(R.id.btnTD2Ex2, TD2Ex2Activity.class);
        setupButton(R.id.btnTD2Ex3, TD2Ex3Activity.class);
        setupButton(R.id.btnTD2Ex4, TD2Ex4Activity.class);
        setupButton(R.id.btnTD2Ex5, TD2Ex5Activity.class);
        setupButton(R.id.btnTD2Ex6, TD2Ex6Activity.class);
        setupButton(R.id.btnTD2Ex7, TD2Ex7Activity.class);
        setupButton(R.id.btnTD2Ex8, TD2Ex8Activity.class);
        setupButton(R.id.btnTD2Ex9, TD2Ex9Activity.class);
        setupButton(R.id.btnTD2Ex10, TD2Ex10Activity.class);
        setupButton(R.id.btnTD2Ex11, TD2Ex11Activity.class);
        setupButton(R.id.btnTD2Ex12, TD2Ex12Activity.class);
        setupButton(R.id.btnTD2Ex13, TD2Ex13Activity.class);
        setupButton(R.id.btnTD2Ex14, TD2Ex14Activity.class);
        setupButton(R.id.btnTD2Ex15, TD2Ex15Activity.class);
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