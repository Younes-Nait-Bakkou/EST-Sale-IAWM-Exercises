package com.example.allexercises;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;

public class TD2Ex6Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_td2_ex6);

        RelativeLayout rlContainer = findViewById(R.id.rlContainer);
        ImageView ivFollow = findViewById(R.id.ivFollow);

        rlContainer.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_MOVE || event.getAction() == MotionEvent.ACTION_DOWN) {
                // Center the image on the finger
                float x = event.getX() - (ivFollow.getWidth() / 2f);
                float y = event.getY() - (ivFollow.getHeight() / 2f);
                
                ivFollow.setX(x);
                ivFollow.setY(y);
                return true;
            }
            return false;
        });
    }
}