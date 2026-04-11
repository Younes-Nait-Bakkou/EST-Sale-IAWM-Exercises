package com.example.allexercises;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class TD2Ex11CalcActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_td2_ex11_calc);

        double n1 = getIntent().getDoubleExtra("num1", 0);
        double n2 = getIntent().getDoubleExtra("num2", 0);

        TextView tvReceived = findViewById(R.id.tvReceivedNumbers);
        tvReceived.setText("Nombres reçus : " + n1 + " et " + n2);

        Button btnSend = findViewById(R.id.btnSendResult);
        btnSend.setOnClickListener(v -> {
            double sum = n1 + n2;
            Intent resultIntent = new Intent();
            resultIntent.putExtra("result", sum);
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}