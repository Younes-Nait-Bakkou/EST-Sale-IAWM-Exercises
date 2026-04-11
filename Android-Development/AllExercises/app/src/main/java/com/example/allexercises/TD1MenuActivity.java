package com.example.allexercises;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class TD1MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_td1_menu);

        Button btnEx1 = findViewById(R.id.btnTD1Ex1);

        btnEx1.setOnClickListener(v -> {
            Intent intent = new Intent(this, TD1Ex1Activity.class);
            startActivity(intent);
        });

        Button btnEx2 = findViewById(R.id.btnTD1Ex2);

        btnEx2.setOnClickListener(v -> {
            Intent intent = new Intent(this, TD1Ex2Activity.class);
            startActivity(intent);
        });

        Button btnEx3 = findViewById(R.id.btnTD1Ex3);

        btnEx3.setOnClickListener(v -> {
            Intent intent = new Intent(this, TD1Ex3Activity.class);
            startActivity(intent);
        });

        Button btnEx4 = findViewById(R.id.btnTD1Ex4);

        btnEx4.setOnClickListener(v -> {
            Intent intent = new Intent(this, TD1Ex4Activity.class);
            startActivity(intent);
        });

        Button btnEx5 = findViewById(R.id.btnTD1Ex5);

        btnEx5.setOnClickListener(v -> {
            Intent intent = new Intent(this, TD1Ex5Activity.class);
            startActivity(intent);
        });

        Button btnEx6 = findViewById(R.id.btnTD1Ex6);

        btnEx6.setOnClickListener(v -> {
            Intent intent = new Intent(this, TD1Ex6Activity.class);
            startActivity(intent);
        });

        Button btnExA1 = findViewById(R.id.btnTD1ExA1);

        btnExA1.setOnClickListener(v -> {
            Intent intent = new Intent(this, TD1ExA1Activity.class);
            startActivity(intent);
        });

        Button btnExA2 = findViewById(R.id.btnTD1ExA2);

        btnExA2.setOnClickListener(v -> {
            Intent intent = new Intent(this, TD1ExA2Activity.class);
            startActivity(intent);
        });
        Button btnExA3 = findViewById(R.id.btnTD1ExA3);

        btnExA3.setOnClickListener(v -> {
            Intent intent = new Intent(this, TD1ExA3Activity.class);
            startActivity(intent);
        });

        Button btnExA4 = findViewById(R.id.btnTD1ExA4);
        btnExA4.setOnClickListener(v -> {
            Intent intent = new Intent(this, TD1ExA4Activity.class);
            startActivity(intent);
        });
    }
}