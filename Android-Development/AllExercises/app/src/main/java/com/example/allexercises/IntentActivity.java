package com.example.allexercises;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class IntentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        Button btnSendExplicit = findViewById(R.id.btnSendExplicit);
        Button btnOpenWeb = findViewById(R.id.btnOpenWeb);
        Button btnDialNumber = findViewById(R.id.btnDialNumber);

        btnSendExplicit.setOnClickListener(v -> {
            Intent i = new Intent(this, IntentDestinationActivity.class);
            i.putExtra("secret_message", "Hello from the previous screen!");
            i.putExtra("user_age", 25);
            startActivity(i);
        });

        btnOpenWeb.setOnClickListener(v -> {
            Uri webpage = Uri.parse("http://www.google.com");

            Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
            startActivity(intent);
        });

        btnDialNumber.setOnClickListener(v -> {
            Uri telephone = Uri.parse("tel:0606060606");

            Intent i = new Intent(Intent.ACTION_DIAL, telephone);
            startActivity(i);
        });
    }
}
