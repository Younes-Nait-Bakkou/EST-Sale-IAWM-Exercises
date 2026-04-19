package com.example.allexercises;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Exam1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam1);

        setupButton(R.id.btnEx1Activity1, Exam1Activity1.class);

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