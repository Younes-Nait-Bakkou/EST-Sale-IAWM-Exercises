package com.example.allexercises;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyCustomFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_custom, container, false);

        TextView tvFragmentData = view.findViewById(R.id.tvFragmentData);

        Bundle bundle = getArguments();
        if (bundle != null) {
            String receivedName = bundle.getString("names");
            tvFragmentData.setText("Data received: " + receivedName);
        }

        return view;
    }
}