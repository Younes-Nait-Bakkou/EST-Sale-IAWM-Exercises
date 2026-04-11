package com.example.allexercises;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class IntentDestinationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_destination);

        TextView tvReceivedData = findViewById(R.id.tvReceivedData);

        Intent i = getIntent();

        String message = i.getStringExtra("secret_message");
        int age = i.getIntExtra("user_age", 0);

        tvReceivedData.setText("Message: " + message + "\nAge: " + age);
    }
}