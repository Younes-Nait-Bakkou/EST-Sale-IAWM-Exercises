package com.example.allexercises;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Switch;
import androidx.appcompat.app.AppCompatActivity;

public class TD1Ex5Activity extends AppCompatActivity {

    private ImageView ivLamp;
    private Switch switchPower;
    private SeekBar seekBarBrightness;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_td1_ex5);

        ivLamp = findViewById(R.id.ivLamp);
        switchPower = findViewById(R.id.switchPower);
        seekBarBrightness = findViewById(R.id.seekBarBrightness);

        ivLamp.setAlpha(0.1f);
        seekBarBrightness.setEnabled(false);

        switchPower.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    seekBarBrightness.setEnabled(true);
                    float brightness = seekBarBrightness.getProgress() / 100f;
                    ivLamp.setAlpha(brightness);
                } else {
                    seekBarBrightness.setEnabled(false);
                    ivLamp.setAlpha(0.1f);
                }
            }
        });

        seekBarBrightness.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (switchPower.isChecked()) {
                    float brightness = progress / 100f;

                    if (brightness < 0.1f) brightness = 0.1f;

                    ivLamp.setAlpha(brightness);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Appelé quand on commence à toucher le curseur (non utilisé ici)
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Appelé quand on lâche le curseur (non utilisé ici)
            }
        });
    }
}