package com.example.allexercises;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadActivity extends AppCompatActivity {

    private ExecutorService executorService;
    private Handler handler;
    private TextView tvTaskStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);

        tvTaskStatus = findViewById(R.id.tvTaskStatus);
        Button btnStartTask = findViewById(R.id.btnStartTask);

        executorService = Executors.newSingleThreadExecutor();

        handler = new Handler(Looper.getMainLooper());

        btnStartTask.setOnClickListener(v -> {
            tvTaskStatus.setText("Downloading... (App is not frozen!)");
            btnStartTask.setEnabled(false);

            executeTask(btnStartTask);
        });
    }

    private void executeTask(Button btnStartTask) {
        // 3. Move the work to the background thread
        executorService.execute(() -> {
            final String data = downloadData();

            handler.post(() -> {
                tvTaskStatus.setText(data);
                btnStartTask.setEnabled(true);
            });
        });
    }

    private String downloadData() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Download Complete! Data saved.";
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (executorService != null) {
            executorService.shutdown();
        }
    }
}