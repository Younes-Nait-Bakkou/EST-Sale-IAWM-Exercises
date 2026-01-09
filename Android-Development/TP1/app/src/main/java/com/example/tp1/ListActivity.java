package com.example.tp1;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ListActivity extends AppCompatActivity {

    // 1. The Data Source
    String[] codingLanguages = {"Java", "Python", "Kotlin", "C++", "C#", "JavaScript", "Swift", "Dart", "Rust", "Go"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView listView = findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_checked,
                codingLanguages
        );

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String clickedValue = codingLanguages[position];

                Toast.makeText(ListActivity.this, "You clicked: " + clickedValue, Toast.LENGTH_SHORT).show();
            }
        });


        this.displayActionBarIfExists();
    }

    public void displayActionBarIfExists(){
        if (getSupportActionBar() != null) {
            // 2. Enable the "Up" button (the back arrow)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            // Optional: Set a nice title for this screen
            getSupportActionBar().setTitle("Lesson 3: ListView");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == android.R.id.home){
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}