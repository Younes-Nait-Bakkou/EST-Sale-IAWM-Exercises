package com.example.allexercises;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class TD2Ex7Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_td2_ex7);

        Button btnPickDate = findViewById(R.id.btnPickDate);
        TextView tvSelectedDate = findViewById(R.id.tvSelectedDate);

        btnPickDate.setOnClickListener(v -> {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    (view, year1, monthOfYear, dayOfMonth) -> {
                        String date = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year1;
                        tvSelectedDate.setText("Date de naissance : " + date);
                        
                        int age = Calendar.getInstance().get(Calendar.YEAR) - year1;
                        // Basic adjustment for month/day
                        if (Calendar.getInstance().get(Calendar.MONTH) < monthOfYear || 
                           (Calendar.getInstance().get(Calendar.MONTH) == monthOfYear && Calendar.getInstance().get(Calendar.DAY_OF_MONTH) < dayOfMonth)) {
                            age--;
                        }

                        new AlertDialog.Builder(this)
                                .setTitle("Résultat")
                                .setMessage("Votre âge est : " + age + " ans")
                                .setPositiveButton("D'accord", null)
                                .show();

                    }, year, month, day);
            datePickerDialog.show();
        });
    }
}