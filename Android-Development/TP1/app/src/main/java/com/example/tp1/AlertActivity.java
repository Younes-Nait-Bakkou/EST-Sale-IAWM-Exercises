package com.example.tp1;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AlertActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_alert);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button alertBtn = findViewById(R.id.alertButton);

        alertBtn.setOnClickListener(V -> {
            new AlertDialog.Builder(this)
                    .setTitle("Alert")
                    .setMessage("DO NOT CLICK THIS BTN")
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setPositiveButton("Yes", (dialog, which) -> {
                        Toast.makeText(this, "Confirmed", Toast.LENGTH_LONG).show();
                    })
                    .setNegativeButton("No", (dialog, which) -> {
                        dialog.dismiss();
                    })
                    .create()
                    .show();
        });

        this.displayActionBarIfExists();
    }

    public void displayActionBarIfExists(){
        if (getSupportActionBar() != null) {
            // 2. Enable the "Up" button (the back arrow)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            // Optional: Set a nice title for this screen
            getSupportActionBar().setTitle("Main Screen");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // 1. Check if the clicked item is the "Up" button
        // The specific ID for that back arrow is always "android.R.id.home"
        if (item.getItemId() == android.R.id.home){
            // 2. Finish this activity
            // This closes the current screen and returns to the previous one (MainActivity)
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}