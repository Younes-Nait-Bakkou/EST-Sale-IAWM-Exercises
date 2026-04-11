package com.example.allexercises;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.snackbar.Snackbar;

public class AlertActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);

        View rootLayout = findViewById(R.id.alertRootLayout);
        Button btnSnackbar = findViewById(R.id.btnShowSnackbar);
        Button btnAlertDialog = findViewById(R.id.btnShowAlertDialog);

        btnSnackbar.setOnClickListener(v -> {
            Snackbar snackbar = Snackbar.make(rootLayout, "Message deleted", Snackbar.LENGTH_LONG);

            snackbar.setAction("UNDO", new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(AlertActivity.this, "Action Undone!", Toast.LENGTH_SHORT).show();
                }
            });

            snackbar.show();
        });


        btnAlertDialog.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("Crucial Decision");
            builder.setMessage("Are you absolutely sure you want to learn Android?");

            builder.setPositiveButton("Yes!", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    Toast.makeText(getApplicationContext(), "Excellent choice!", Toast.LENGTH_SHORT).show();
                }
            });

            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                    Toast.makeText(getApplicationContext(), "Too bad!", Toast.LENGTH_SHORT).show();
                }
            });

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        });
    }
}