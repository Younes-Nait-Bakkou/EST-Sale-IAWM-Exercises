package com.example.tp1;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalenderActivity extends AppCompatActivity {
    private EditText eventInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);
        eventInput = findViewById(R.id.etEventInput);

        registerForContextMenu(eventInput);

        CalendarView calendarView = findViewById(R.id.calendarView);

        this.displayActionBarIfExists();
    }

    public void displayActionBarIfExists(){
        if (getSupportActionBar() != null) {
            // 2. Enable the "Up" button (the back arrow)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            // Optional: Set a nice title for this screen
            getSupportActionBar().setTitle("Main Screen");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == android.R.id.home){
            finish();
            return true;
        }

        if (id ==  R.id.action_delete){
            Toast.makeText(this, "Event deleted!", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.calendar_menu, menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if(v.getId() == R.id.etEventInput){
            getMenuInflater().inflate(R.menu.context_menu, menu);
            menu.setHeaderTitle("Text Actions");
        }

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.ctx_clear){
            eventInput.setText("");
        }
        if (id == R.id.ctx_edit){
            eventInput.requestFocus();
        }
        if(id == R.id.ctx_uppercase){
            eventInput.setText(eventInput.getText().toString().toUpperCase());
        }

        return super.onContextItemSelected(item);
    }
}