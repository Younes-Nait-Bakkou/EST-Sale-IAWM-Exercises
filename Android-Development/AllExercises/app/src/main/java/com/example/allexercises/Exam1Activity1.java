package com.example.allexercises;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Exam1Activity1 extends AppCompatActivity {


    private static final int REQ_CODE_SUM = 100;

    private EditText etLogin, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam1_1);

        etLogin = findViewById(R.id.etLogin);
        etPassword = findViewById(R.id.etPassword);

        Button btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v -> {
            String user = etLogin.getText().toString();
            String pass = etPassword.getText().toString();

            if (user.equals("admin") && pass.equals("123")) {
                Intent intent = new Intent(this, TD2Ex11HomeActivity.class);
                startActivity(intent);
            } else {
                Intent intent = new Intent(this, Exam1AuthErrorActivity.class);
                startActivity(intent);
            }
        });
    }
}