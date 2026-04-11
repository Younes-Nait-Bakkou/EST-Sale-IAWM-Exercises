package com.example.allexercises;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class TD1ExA4Activity extends AppCompatActivity {

    private MealDBHelper dbHelper;
    private ArrayList<Meal> mealList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_td1_exa4);

        ListView lvMeals = findViewById(R.id.lvMeals);
        Button btnOrder = findViewById(R.id.btnOrder);

        dbHelper = new MealDBHelper(this);
        mealList = dbHelper.getAllMeals();

        ArrayAdapter<Meal> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_multiple_choice,
                mealList
        );

        lvMeals.setAdapter(adapter);
        lvMeals.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        lvMeals.setOnItemLongClickListener((parent, view, position, id) -> {
            Meal selectedMeal = mealList.get(position);

            new AlertDialog.Builder(this)
                    .setTitle(selectedMeal.getName())
                    .setMessage(selectedMeal.getDescription())
                    .setPositiveButton("Fermer", null)
                    .show();

            return true;
        });

        btnOrder.setOnClickListener(v -> {
            SparseBooleanArray checkedItemPositions = lvMeals.getCheckedItemPositions();
            StringBuilder orderSummary = new StringBuilder("Vous avez commandé :\n");
            int orderCount = 0;

            for (int i = 0; i < checkedItemPositions.size(); i++) {
                int position = checkedItemPositions.keyAt(i);
                if (checkedItemPositions.valueAt(i)) {
                    orderSummary.append("- ").append(mealList.get(position).getName()).append("\n");
                    orderCount++;
                }
            }

            if (orderCount > 0) {
                Toast.makeText(this, orderSummary.toString(), Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Veuillez sélectionner au moins un plat.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}