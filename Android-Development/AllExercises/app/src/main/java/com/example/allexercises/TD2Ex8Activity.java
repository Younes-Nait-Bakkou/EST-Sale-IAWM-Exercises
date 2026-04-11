package com.example.allexercises;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashMap;
import java.util.Map;

public class TD2Ex8Activity extends AppCompatActivity {

    private Spinner spFrom, spTo;
    private EditText etAmount;
    private TextView tvResult;
    private Button btnConvert;

    // Simplified exchange rates relative to USD
    private final Map<String, Double> rates = new HashMap<String, Double>() {{
        put("Dollar américain (USD)", 1.0);
        put("Euro (EUR)", 0.92);
        put("Dirham Marocain (MAD)", 10.10);
        put("Livre Sterling (GBP)", 0.79);
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_td2_ex8);

        spFrom = findViewById(R.id.spFrom);
        spTo = findViewById(R.id.spTo);
        etAmount = findViewById(R.id.etAmount);
        tvResult = findViewById(R.id.tvResult);
        btnConvert = findViewById(R.id.btnConvert);

        String[] currencies = rates.keySet().toArray(new String[0]);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, currencies);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spFrom.setAdapter(adapter);
        spTo.setAdapter(adapter);

        btnConvert.setOnClickListener(v -> convert());
    }

    private void convert() {
        String from = spFrom.getSelectedItem().toString();
        String to = spTo.getSelectedItem().toString();
        String amountStr = etAmount.getText().toString();

        if (amountStr.isEmpty()) {
            Toast.makeText(this, "Veuillez entrer un montant", Toast.LENGTH_SHORT).show();
            return;
        }

        double amount = Double.parseDouble(amountStr);
        double fromRate = rates.get(from);
        double toRate = rates.get(to);

        // Convert to USD then to target currency
        double result = (amount / fromRate) * toRate;

        tvResult.setText(String.format("%.2f", result));
    }
}