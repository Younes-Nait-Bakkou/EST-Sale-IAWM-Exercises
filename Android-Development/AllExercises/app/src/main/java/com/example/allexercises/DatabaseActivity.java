package com.example.allexercises;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class DatabaseActivity extends AppCompatActivity {

    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        dbHandler = new DBHandler(this);

        EditText etNom = findViewById(R.id.etNom);
        EditText etPrenom = findViewById(R.id.etPrenom);
        Button btnSaveData = findViewById(R.id.btnSaveData);
        Button btnLoadData = findViewById(R.id.btnLoadData);
        TextView tvDatabaseResults = findViewById(R.id.tvDatabaseResults);

        btnSaveData.setOnClickListener(v -> {
            String nom = etNom.getText().toString().trim();
            String prenom = etPrenom.getText().toString().trim();

            if (!nom.isEmpty() && !prenom.isEmpty()) {
                dbHandler.addPersonne(nom, prenom);
                Toast.makeText(this, "Saved successfully!", Toast.LENGTH_SHORT).show();

                etNom.setText("");
                etPrenom.setText("");
            } else {
                Toast.makeText(this, "Please fill in both fields", Toast.LENGTH_SHORT).show();
            }
        });

        btnLoadData.setOnClickListener(v -> {
            String data = dbHandler.getAllPersonnes();

            if (data.isEmpty()) {
                tvDatabaseResults.setText("No records found.");
            } else {
                tvDatabaseResults.setText(data);
            }
        });
    }
}