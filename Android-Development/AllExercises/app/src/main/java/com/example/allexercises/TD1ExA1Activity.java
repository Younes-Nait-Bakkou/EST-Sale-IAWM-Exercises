package com.example.allexercises;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class TD1ExA1Activity extends AppCompatActivity {

    private final double TAUX_CHANGE = 10.8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_td1_exa1);

        EditText etMontant = findViewById(R.id.etMontant);
        RadioGroup rgConversionChoice = findViewById(R.id.rgConversionChoice);
        Button btnConvertir = findViewById(R.id.btnConvertir);
        TextView tvResultatConversion = findViewById(R.id.tvResultatConversion);

        btnConvertir.setOnClickListener(v -> {
            String montantStr = etMontant.getText().toString();

            if (montantStr.isEmpty()) {
                Toast.makeText(this, "Veuillez entrer un montant !", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                double montant = Double.parseDouble(montantStr);
                double resultat = 0.0;
                String symbole = "";

                int selectedId = rgConversionChoice.getCheckedRadioButtonId();

                if (selectedId == R.id.rbEuroToMad) {
                    resultat = montant * TAUX_CHANGE;
                    symbole = " MAD";
                } else if (selectedId == R.id.rbMadToEuro) {
                    resultat = montant / TAUX_CHANGE;
                    symbole = " €";
                }
                String resultatFormate = String.format("%.2f", resultat);

                tvResultatConversion.setText("Résultat : " + resultatFormate + symbole);

            } catch (NumberFormatException e) {
                Toast.makeText(this, "Montant invalide !", Toast.LENGTH_SHORT).show();
            }
        });
    }
}