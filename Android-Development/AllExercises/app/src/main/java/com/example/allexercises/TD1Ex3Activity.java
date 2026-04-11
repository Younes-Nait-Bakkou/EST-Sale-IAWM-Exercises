package com.example.allexercises;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class TD1Ex3Activity extends AppCompatActivity {

    private static final String TAG = "SaisieTexte";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_td1_ex3);

        EditText etInputData = findViewById(R.id.etInputData);
        Button btnCopyText = findViewById(R.id.btnCopyText);
        TextView tvResultButton = findViewById(R.id.tvResultButton);
        TextView tvResultWatcher = findViewById(R.id.tvResultWatcher);

        btnCopyText.setOnClickListener(v -> {
            String textToCopy = etInputData.getText().toString();
            tvResultButton.setText("Résultat du Bouton : " + textToCopy);
        });

        etInputData.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.i(TAG, "beforeTextChanged: " + s.toString());
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.i(TAG, "onTextChanged: " + s.toString());

                tvResultWatcher.setText("Résultat du TextWatcher : " + s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.i(TAG, "afterTextChanged: " + s.toString());
            }
        });

        etInputData.setOnKeyListener((v, keyCode, event) -> {
            if (event.getAction() == KeyEvent.ACTION_DOWN) {
                Log.i(TAG, "onKeyDown: Touche pressée (Code: " + keyCode + ")");
            }
            return false;
        });

        etInputData.setOnEditorActionListener((v, actionId, event) -> {
            Log.i(TAG, "onEditorAction: Action du clavier virtuel déclenchée (ActionId: " + actionId + ")");
            return false;
        });
    }
}