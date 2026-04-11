package com.example.allexercises;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class TD2Ex10Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_td2_ex10);

        Spinner spDays = findViewById(R.id.spDays);
        TextView tvSelectedDay = findViewById(R.id.tvSelectedDay);

        // 1. Fill an array with days of the week
        String[] days = {
                "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"
        };

        // 2. Use an ArrayAdapter to display them in the Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, days);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spDays.setAdapter(adapter);

        spDays.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selected = parent.getItemAtPosition(position).toString();
                tvSelectedDay.setText("Jour sélectionné : " + selected);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                tvSelectedDay.setText("");
            }
        });
    }
}