package com.example.allexercises;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MealFragment extends Fragment {

    // Clés pour récupérer les données du Bundle
    private static final String ARG_TITLE = "title";
    private static final String ARG_MENU = "menu";

    // Une méthode statique (Factory method) pour créer facilement un fragment avec ses données
    public static MealFragment newInstance(String title, String menu) {
        MealFragment fragment = new MealFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);
        args.putString(ARG_MENU, menu);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meal, container, false);

        TextView tvMealTitle = view.findViewById(R.id.tvMealTitle);
        TextView tvMealMenu = view.findViewById(R.id.tvMealMenu);

        // Récupérer et afficher les données envoyées par l'Activité
        if (getArguments() != null) {
            tvMealTitle.setText(getArguments().getString(ARG_TITLE));
            tvMealMenu.setText(getArguments().getString(ARG_MENU));
        }

        return view;
    }
}
