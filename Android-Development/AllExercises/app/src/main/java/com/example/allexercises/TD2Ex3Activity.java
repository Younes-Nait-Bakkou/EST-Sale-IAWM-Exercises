package com.example.allexercises;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class TD2Ex3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_td2_ex3);

        EditText etInput = findViewById(R.id.etInput);
        Button btnCopy = findViewById(R.id.btnCopy);
        TextView tvLabel = findViewById(R.id.tvLabel);

        // 1. Copy on Button Click
        btnCopy.setOnClickListener(v -> {
            String text = etInput.getText().toString();
            tvLabel.setText(text);
        });

        // 2. Copy via TextWatcher (Real-time)
        etInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tvLabel.setText(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }
}