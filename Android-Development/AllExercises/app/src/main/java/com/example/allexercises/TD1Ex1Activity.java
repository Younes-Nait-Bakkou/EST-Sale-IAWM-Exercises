package com.example.allexercises;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class TD1Ex1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_td1_ex1);

        TextView tvExercice1 = findViewById(R.id.tvExercice1);

        tvExercice1.setText("Bonjour TD1 ! \n(Modifié depuis Java)");

        tvExercice1.setOnClickListener(v -> {
            String currentText = tvExercice1.getText().toString();

            Toast.makeText(this, "Contenu de la zone : " + currentText, Toast.LENGTH_LONG).show();

            tvExercice1.setAlpha(1.0f);
        });
    }
}