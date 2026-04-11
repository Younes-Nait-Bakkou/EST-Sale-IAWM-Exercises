package com.example.allexercises;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class TD2Ex2Activity extends AppCompatActivity {

    private static final String TAG = "TD2Ex2Activity";

    private void showStatus(String message) {
        Log.i(TAG, message);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_td2_ex1); // Reuse simple layout or keep empty
        showStatus("onCreate invoked");
    }

    @Override
    protected void onStart() {
        super.onStart();
        showStatus("onStart invoked");
    }

    @Override
    protected void onResume() {
        super.onResume();
        showStatus("onResume invoked");
    }

    @Override
    protected void onPause() {
        super.onPause();
        showStatus("onPause invoked");
    }

    @Override
    protected void onStop() {
        super.onStop();
        showStatus("onStop invoked");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showStatus("onDestroy invoked");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        showStatus("onRestart invoked");
    }
}