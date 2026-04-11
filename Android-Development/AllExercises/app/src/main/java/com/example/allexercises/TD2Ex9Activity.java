package com.example.allexercises;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;

public class TD2Ex9Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_td2_ex9);

        RadioGroup rgAnimals = findViewById(R.id.rgAnimals);
        ImageView ivAnimal = findViewById(R.id.ivAnimal);

        rgAnimals.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.rbBird) {
                ivAnimal.setImageResource(android.R.drawable.ic_menu_gallery); // Placeholder
            } else if (checkedId == R.id.rbCat) {
                ivAnimal.setImageResource(android.R.drawable.ic_menu_camera); // Placeholder
            } else if (checkedId == R.id.rbDog) {
                ivAnimal.setImageResource(android.R.drawable.ic_menu_slideshow); // Placeholder
            } else if (checkedId == R.id.rbRabbit) {
                ivAnimal.setImageResource(android.R.drawable.ic_menu_compass); // Placeholder
            }
        });
    }
}