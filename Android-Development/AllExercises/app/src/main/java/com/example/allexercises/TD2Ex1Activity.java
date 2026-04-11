package com.example.allexercises;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class TD2Ex1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_td2_ex1);

        TextView tvExercice1 = findViewById(R.id.tvExercice1);

        // Test cliquable via Java
        tvExercice1.setOnLongClickListener(v -> {
            Toast.makeText(this, "Clic Long (Java) : " + tvExercice1.getText(), Toast.LENGTH_SHORT).show();
            return true;
        });
    }

    // Test cliquable via XML (android:onClick)
    public void onTextClickXML(View view) {
        TextView tv = (TextView) view;
        Toast.makeText(this, "Clic Simple (XML) : " + tv.getText(), Toast.LENGTH_SHORT).show();
    }
}