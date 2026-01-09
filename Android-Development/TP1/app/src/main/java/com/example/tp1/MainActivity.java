package com.example.tp1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public String print(String text) {
        return "this is text";
    }

    public String print(int text2) {
        return "this is integer";
    }


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button btnAlert = findViewById(R.id.btnOpenAlerts);
        btnAlert.setOnClickListener(v -> {
            // Create the intent
            Intent intent = new Intent(this, AlertActivity.class);
            // Start the new screen
            startActivity(intent);
        });

        Button btnCalender = findViewById(R.id.btnOpenCalendar);
        btnCalender.setOnClickListener(v -> {
            Intent intent = new Intent(this, CalenderActivity.class);
            startActivity(intent);
        });

        Button btnAdapter = findViewById(R.id.btnOpenAdapter);
        btnAdapter.setOnClickListener(v -> {
            Intent intent = new Intent(this, ListActivity.class);
            startActivity(intent);
        });


//        View rootView = findViewById(android.R.id.content);
//
//        Button alertBtn = findViewById(R.id.alertButton);
//
//        alertBtn.setOnClickListener(V -> {
//            new AlertDialog.Builder(this)
//                    .setTitle("Alert")
//                    .setMessage("DO NOT CLICK THIS BTN")
//                    .setIcon(android.R.drawable.ic_dialog_alert)
//                    .setPositiveButton("Yes", (dialog, which) -> {
//                        Toast.makeText(this, "Confirmed", Toast.LENGTH_LONG).show();
//                    })
//                    .setNegativeButton("No", (dialog, which) -> {
//                        dialog.dismiss();
//                    })
//                    .create()
//                    .show();
//
//        });



//        changeButton.setOnLongClickListener(new View.OnLongClickListener(){
//            @Override
//            public boolean onLongClick(View v){
//                changeButton.setText("Long Press Detected");
//                rootView.setBackgroundColor(Color.GRAY);
//
//                return true;
//            }
//        });
//
//        changeButton.setOnTouchListener(new View.OnTouchListener(){
//            @Override
//            public boolean onTouch(View v, MotionEvent event){
//                return false;
//            }
//        });
    }
}
