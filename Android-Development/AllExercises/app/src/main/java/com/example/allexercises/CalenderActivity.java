package com.example.allexercises;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class CalenderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        TextView tvSelectedDate = findViewById(R.id.tvSelectedDate);
        Button btnPickDate = findViewById(R.id.btnPickDate);

        btnPickDate.setOnClickListener(v -> {
            final Calendar c = Calendar.getInstance();
            int currentYear = c.get(Calendar.YEAR);
            int currentMonth = c.get(Calendar.MONTH);
            int currentDay = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    CalenderActivity.this,

                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                            int displayMonth = monthOfYear + 1;

                            String dateStr = dayOfMonth + "/" + displayMonth + "/" + year;
                            tvSelectedDate.setText("Selected: " + dateStr);
                        }
                    },
                    currentYear,
                    currentMonth,
                    currentDay
            );

            datePickerDialog.show();
        });
    }
}