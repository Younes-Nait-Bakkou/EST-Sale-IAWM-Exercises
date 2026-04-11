package com.example.allexercises;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ListActivity extends AppCompatActivity {

    // 1. The Data Source
    String[] learningTopics = {
            "Layouts & Resources", "Basic Views", "Intents",
            "Lists & Adapters", "Databases", "Threads", "Services"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView myListView = findViewById(R.id.myListView);

        MyCustomAdapter adapter = new MyCustomAdapter(this, learningTopics);

        myListView.setAdapter(adapter);

        myListView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedItem = learningTopics[position];
            Toast.makeText(this, "You clicked: " + selectedItem, Toast.LENGTH_SHORT).show();
        });
    }

    class MyCustomAdapter extends ArrayAdapter<String> {

        public MyCustomAdapter(Context context, String[] items) {
            super(context, R.layout.list_item_row, items);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View rowView = convertView;

            if (rowView == null) {
                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                rowView = inflater.inflate(R.layout.list_item_row, parent, false);
            }

            TextView textView = rowView.findViewById(R.id.rowText);
            ImageView imageView = rowView.findViewById(R.id.rowIcon);

            textView.setText(getItem(position));

            return rowView;
        }
    }
}