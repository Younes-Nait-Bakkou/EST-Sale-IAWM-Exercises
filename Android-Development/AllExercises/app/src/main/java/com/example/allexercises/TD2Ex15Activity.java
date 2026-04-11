package com.example.allexercises;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.os.Looper;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.Priority;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class TD2Ex15Activity extends AppCompatActivity {

    private static final int LOCATION_PERMISSION_CODE = 100;

    private Button btnStartTracking;
    private TextView tvChildStatus;
    private ListView lvLocations;

    private ArrayList<String> locationHistory;
    private ArrayAdapter<String> adapter;

    // Real GPS Components
    private FusedLocationProviderClient fusedLocationClient;
    private LocationCallback locationCallback;
    private boolean isTracking = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_td2_ex15);

        btnStartTracking = findViewById(R.id.btnStartTracking);
        tvChildStatus = findViewById(R.id.tvChildStatus);
        lvLocations = findViewById(R.id.lvLocations);

        locationHistory = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, locationHistory);
        lvLocations.setAdapter(adapter);

        // 1. Initialize the GPS Client
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        // 2. Define what happens when the GPS gets a new coordinate
        locationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(@NonNull LocationResult locationResult) {
                for (Location location : locationResult.getLocations()) {
                    updateLocationUI(location);
                }
            }

        };

        btnStartTracking.setOnClickListener(v -> {
            if (!isTracking) {
                checkPermissionsAndStart();
            } else {
                stopRealTracking();
            }
        });
    }

    private void checkPermissionsAndStart() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // Ask the user for permission
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_PERMISSION_CODE);
        } else {
            startRealTracking();
        }
    }

    private void startRealTracking() {
        isTracking = true;
        btnStartTracking.setText("Arrêter le GPS");
        tvChildStatus.setText("Statut : Recherche signal GPS...");

        // Define how often we want updates (e.g., every 5 seconds)
        LocationRequest locationRequest = new LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY, 5000)
                .setMinUpdateIntervalMillis(2000)
                .build();

        // Start listening to the hardware
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            fusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, Looper.getMainLooper());
        }
    }

    private void stopRealTracking() {
        isTracking = false;
        btnStartTracking.setText("Démarrer le GPS");
        tvChildStatus.setText("Statut : Inactif");
        // Disconnect from the hardware to save battery
        fusedLocationClient.removeLocationUpdates(locationCallback);
    }

    private void updateLocationUI(Location location) {
        tvChildStatus.setText("Statut : Connecté au satellite");

        String timestamp = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date());
        String locEntry = "[" + timestamp + "] Lat: " + String.format("%.4f", location.getLatitude()) +
                ", Lon: " + String.format("%.4f", location.getLongitude());

        locationHistory.add(0, locEntry);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == LOCATION_PERMISSION_CODE && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            startRealTracking();
        } else {
            Toast.makeText(this, "Permission GPS refusée", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopRealTracking();
    }
}