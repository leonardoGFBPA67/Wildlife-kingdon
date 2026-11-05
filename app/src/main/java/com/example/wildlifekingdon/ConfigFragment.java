package com.example.wildlifekingdon;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ConfigFragment extends Fragment {

    private static final String PREFS = "wk_prefs";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.wk_fragment_config, container, false);
        Switch swSound = root.findViewById(R.id.wk_sw_sound);
        Button btnReset = root.findViewById(R.id.wk_btn_reset);

        SharedPreferences prefs = requireContext().getSharedPreferences(PREFS, 0);
        swSound.setChecked(prefs.getBoolean("sound", true));

        swSound.setOnCheckedChangeListener((CompoundButton buttonView, boolean isChecked) -> {
            prefs.edit().putBoolean("sound", isChecked).apply();
            Toast.makeText(requireContext(), "Som " + (isChecked?"ativado":"desativado"), Toast.LENGTH_SHORT).show();
        });

        btnReset.setOnClickListener(v -> {
            // simple reset: clear DB by reinstantiating using destructive migration (quick approach)
            AppDatabase db = AppDatabase.getInstance(requireContext());
            db.clearAllTables();
            Toast.makeText(requireContext(), "Progresso resetado (DB limpo)", Toast.LENGTH_SHORT).show();
        });

        return root;
    }
}
