package com.example.allexercises;

import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class TD2Ex5Activity extends AppCompatActivity {

    private int clickCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_td2_ex5);

        Button btnIncrement = findViewById(R.id.btnIncrement);
        Button btnShowDialog = findViewById(R.id.btnShowDialog);

        btnIncrement.setOnClickListener(v -> {
            clickCount++;
        });

        btnShowDialog.setOnClickListener(v -> {
            new AlertDialog.Builder(this)
                    .setTitle("Compteur de clics")
                    .setMessage("Vous avez cliqué " + clickCount + " fois sur le bouton.")
                    .setPositiveButton("OK", null)
                    .show();
        });
    }
}