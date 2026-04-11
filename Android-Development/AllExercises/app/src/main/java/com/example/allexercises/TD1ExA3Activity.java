package com.example.allexercises;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class TD1ExA3Activity extends AppCompatActivity {

    private int votesAlice = 0;
    private int votesBob = 0;
    private int votesCharlie = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_td1_exa3);

        RadioGroup rgCandidates = findViewById(R.id.rgCandidates);
        Button btnVote = findViewById(R.id.btnVote);
        TextView tvResults = findViewById(R.id.tvResults);

        btnVote.setOnClickListener(v -> {
            int selectedId = rgCandidates.getCheckedRadioButtonId();

            if (selectedId == -1) {
                Toast.makeText(this, "Veuillez choisir un candidat avant de voter !", Toast.LENGTH_SHORT).show();
                return;
            }

            if (selectedId == R.id.rbCandidateA) {
                votesAlice++;
            } else if (selectedId == R.id.rbCandidateB) {
                votesBob++;
            } else if (selectedId == R.id.rbCandidateC) {
                votesCharlie++;
            }

            String resultsText = "Alice : " + votesAlice + " vote(s)\n" +
                    "Bob : " + votesBob + " vote(s)\n" +
                    "Charlie : " + votesCharlie + " vote(s)";

            tvResults.setText(resultsText);

            Toast.makeText(this, "A voté !", Toast.LENGTH_SHORT).show();
            rgCandidates.clearCheck();
        });
    }
}