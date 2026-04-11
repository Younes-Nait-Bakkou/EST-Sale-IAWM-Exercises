package com.example.allexercises;

import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class FragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        Button btnLoadFragment = findViewById(R.id.btnLoadFragment);

        btnLoadFragment.setOnClickListener(v -> {
            MyCustomFragment fragment = new MyCustomFragment();

            Bundle bundle = new Bundle();
            bundle.putString("names", "Hello from the Host Activity!");
            fragment.setArguments(bundle);

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            transaction.replace(R.id.fragment_container, fragment);

            transaction.commit();

            btnLoadFragment.setEnabled(false);
        });
    }
}