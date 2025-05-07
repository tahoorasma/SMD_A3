package com.example.a3_l215819.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import com.example.smdassignment3.R;

public class ProfileFragment extends Fragment {
    private EditText nameInput, emailInput;
    private Switch themeSwitch;
    private SharedPreferences prefs;

    public ProfileFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        nameInput = view.findViewById(R.id.editName);
        emailInput = view.findViewById(R.id.editEmail);
        themeSwitch = view.findViewById(R.id.switchTheme);
        Button saveBtn = view.findViewById(R.id.btnSave);

        prefs = getActivity().getSharedPreferences("user_prefs", Context.MODE_PRIVATE);
        nameInput.setText(prefs.getString("name", ""));
        emailInput.setText(prefs.getString("email", ""));
        themeSwitch.setChecked(prefs.getBoolean("dark_mode", false));

        themeSwitch.setOnCheckedChangeListener((CompoundButton buttonView, boolean isChecked) -> {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("dark_mode", isChecked);
            editor.apply();
            AppCompatDelegate.setDefaultNightMode(isChecked ?
                AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO);
        });

        saveBtn.setOnClickListener(v -> {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("name", nameInput.getText().toString());
            editor.putString("email", emailInput.getText().toString());
            editor.apply();
        });

        return view;
    }
}
