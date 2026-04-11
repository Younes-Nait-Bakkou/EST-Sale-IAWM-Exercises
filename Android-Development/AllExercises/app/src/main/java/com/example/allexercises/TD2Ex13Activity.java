package com.example.allexercises;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class TD2Ex13Activity extends AppCompatActivity {

    private ListView lvMeals;
    private TextView tvTotalPrice;
    private MealAdapter adapter;
    private List<MealTD2> mealList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_td2_ex13);

        lvMeals = findViewById(R.id.lvMeals);
        tvTotalPrice = findViewById(R.id.tvTotalPrice);

        // Prepare Data
        mealList = new ArrayList<>();
        mealList.add(new MealTD2("Pizza Poulet", "Spicy Chicken Pizza with extra cheese", 310.00));
        mealList.add(new MealTD2("Beef Burger", "Double beef patty with special sauce", 350.00));
        mealList.add(new MealTD2("Pizza Margherita", "Fresh tomato and mozzarella", 250.00));
        mealList.add(new MealTD2("Chicken Burger", "Grilled chicken breast with lettuce", 350.00));

        adapter = new MealAdapter(this, mealList);
        lvMeals.setAdapter(adapter);

        // 1. Long click for more info
        lvMeals.setOnItemLongClickListener((parent, view, position, id) -> {
            MealTD2 selected = mealList.get(position);
            new AlertDialog.Builder(this)
                    .setTitle(selected.getName())
                    .setMessage(selected.getDescription() + "\n\nPrix: RS " + selected.getPrice())
                    .setPositiveButton("Fermer", null)
                    .show();
            return true;
        });

        // 2 & 3. Click to select and calculate sum
        lvMeals.setOnItemClickListener((parent, view, position, id) -> {
            MealTD2 selected = mealList.get(position);
            selected.setSelected(!selected.isSelected());
            adapter.notifyDataSetChanged();
            updateTotal();
        });
    }

    private void updateTotal() {
        double total = 0;
        for (MealTD2 meal : mealList) {
            if (meal.isSelected()) {
                total += meal.getPrice();
            }
        }
        tvTotalPrice.setText(String.format("RS %.2f", total));
    }

    private class MealAdapter extends ArrayAdapter<MealTD2> {

        public MealAdapter(Context context, List<MealTD2> meals) {
            super(context, R.layout.list_item_meal_td2, meals);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_meal_td2, parent, false);
            }

            MealTD2 meal = getItem(position);

            TextView name = convertView.findViewById(R.id.tvMealName);
            TextView desc = convertView.findViewById(R.id.tvMealDesc);
            TextView price = convertView.findViewById(R.id.tvMealPrice);
            CheckBox cb = convertView.findViewById(R.id.cbSelectMeal);
            ImageView img = convertView.findViewById(R.id.ivMealThumb);

            name.setText(meal.getName());
            desc.setText(meal.getDescription());
            price.setText(String.format("RS %.2f", meal.getPrice()));
            cb.setChecked(meal.isSelected());
            
            // Set row background if selected
            if (meal.isSelected()) {
                convertView.setBackgroundColor(0xFFFFCC80); // Light orange
            } else {
                convertView.setBackgroundColor(0x00000000);
            }

            return convertView;
        }
    }
}