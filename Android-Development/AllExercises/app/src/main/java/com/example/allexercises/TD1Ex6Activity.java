package com.example.allexercises;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class TD1Ex6Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_td1_ex6);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        ViewPager2 viewPager = findViewById(R.id.viewPager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                    switch (position) {
                        case 0:
                            tab.setText("Petit Déj.");
                            break;
                        case 1:
                            tab.setText("Déjeuner");
                            break;
                        case 2:
                            tab.setText("Dîner");
                            break;
                    }
                }
        ).attach();
    }

    private class ViewPagerAdapter extends FragmentStateAdapter {

        public ViewPagerAdapter(@NonNull AppCompatActivity activity) {
            super(activity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case 0:
                    return MealFragment.newInstance("Petit Déjeuner", "• Café / Thé\n• Croissants\n• Jus d'orange\n• Confiture");
                case 1:
                    return MealFragment.newInstance("Déjeuner", "• Salade Niçoise\n• Steak Frites\n• Tarte aux pommes\n• Eau minérale");
                case 2:
                    return MealFragment.newInstance("Dîner", "• Soupe de légumes\n• Poulet rôti\n• Yaourt nature\n• Tisane");
                default:
                    return MealFragment.newInstance("Erreur", "Aucun menu trouvé");
            }
        }

        @Override
        public int getItemCount() {
            return 3;
        }
    }
}