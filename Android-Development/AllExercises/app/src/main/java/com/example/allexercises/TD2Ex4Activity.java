package com.example.allexercises;

import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class TD2Ex4Activity extends AppCompatActivity {

    private boolean isAltImage = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_td2_ex4);

        ImageView ivTouchImage = findViewById(R.id.ivTouchImage);

        ivTouchImage.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                if (isAltImage) {
                    ivTouchImage.setImageResource(android.R.drawable.ic_menu_camera);
                } else {
                    ivTouchImage.setImageResource(android.R.drawable.ic_menu_gallery);
                }
                isAltImage = !isAltImage;
                return true;
            }
            return false;
        });
    }
}