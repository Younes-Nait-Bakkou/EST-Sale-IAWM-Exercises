package com.example.allexercises;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class BasicViewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_views);

        TextView tvMessage = findViewById(R.id.tvMessage);
        Button btnClickMe = findViewById(R.id.btnClickMe);

        btnClickMe.setOnClickListener(v -> {
            tvMessage.setText("Button was clicked !");

            Toast.makeText(this, "Hello from the Toast!", Toast.LENGTH_SHORT).show(); 
        });
    }
}