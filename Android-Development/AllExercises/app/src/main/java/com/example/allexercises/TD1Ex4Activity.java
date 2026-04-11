package com.example.allexercises;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class TD1Ex4Activity extends AppCompatActivity {

    private ImageView ivSwipeImage;
    private float initialX = 0f; // Stores the starting X coordinate
    private int currentImageIndex = 0;
    private final int[] images = {
            android.R.drawable.ic_menu_camera,
            android.R.drawable.ic_menu_gallery,
            android.R.drawable.ic_menu_compass,
            android.R.drawable.ic_menu_mapmode
    };

    @SuppressLint("ClickableViewAccessibility") // Suppresses a warning about visually impaired users not being able to swipe
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_td1_ex4);

        ivSwipeImage = findViewById(R.id.ivSwipeImage);
        ivSwipeImage.setImageResource(images[currentImageIndex]);

        ivSwipeImage.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        initialX = event.getX();
                        return true;

                    case MotionEvent.ACTION_UP:
                        float finalX = event.getX();

                        float deltaX = finalX - initialX;

                        if (Math.abs(deltaX) > 50) {
                            if (deltaX > 0) {
                                swipeRight();
                            } else {
                                swipeLeft();
                            }
                        }
                        return true;
                }
                return false;
            }
        });
    }

    private void swipeLeft() {
        currentImageIndex++;
        if (currentImageIndex >= images.length) {
            currentImageIndex = 0;
        }
        ivSwipeImage.setImageResource(images[currentImageIndex]);
        Toast.makeText(this, "Suivant (Swipe Gauche)", Toast.LENGTH_SHORT).show();
    }

    private void swipeRight() {
        currentImageIndex--;
        if (currentImageIndex < 0) {
            currentImageIndex = images.length - 1;
        }
        ivSwipeImage.setImageResource(images[currentImageIndex]);
        Toast.makeText(this, "Précédent (Swipe Droite)", Toast.LENGTH_SHORT).show();
    }
}