package com.example.allexercises;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TD2Ex11Activity extends AppCompatActivity {

    private static final int REQ_CODE_SUM = 100;

    private EditText etLogin, etPassword, etNum1, etNum2;
    private TextView tvResultSum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_td2_ex11);

        etLogin = findViewById(R.id.etLogin);
        etPassword = findViewById(R.id.etPassword);
        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);
        tvResultSum = findViewById(R.id.tvResultSum);

        Button btnLogin = findViewById(R.id.btnLogin);
        Button btnCalculate = findViewById(R.id.btnCalculate);

        // Part 1: Login Logic
        btnLogin.setOnClickListener(v -> {
            String user = etLogin.getText().toString();
            String pass = etPassword.getText().toString();

            if (user.equals("admin") && pass.equals("123")) {
                Intent intent = new Intent(this, TD2Ex11HomeActivity.class);
                startActivity(intent);
            } else {
                Intent intent = new Intent(this, TD2Ex11ErrorActivity.class);
                startActivity(intent);
            }
        });

        // Part 2: Communication Logic (ActivityResult)
        btnCalculate.setOnClickListener(v -> {
            String s1 = etNum1.getText().toString();
            String s2 = etNum2.getText().toString();

            if (s1.isEmpty() || s2.isEmpty()) {
                Toast.makeText(this, "Entrez deux nombres", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intent = new Intent(this, TD2Ex11CalcActivity.class);
            intent.putExtra("num1", Double.parseDouble(s1));
            intent.putExtra("num2", Double.parseDouble(s2));
            startActivityForResult(intent, REQ_CODE_SUM);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_CODE_SUM && resultCode == RESULT_OK && data != null) {
            double sum = data.getDoubleExtra("result", 0);
            tvResultSum.setText("Résultat : " + sum);
        }
    }
}