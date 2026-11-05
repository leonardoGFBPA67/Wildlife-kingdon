package com.example.wildlifekingdon;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MelhoriasFragment extends Fragment {

    private RecyclerView rv;
    private HabitatAdapter adapter;
    private GameRepository repo;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.wk_fragment_melhorias, container, false);
        rv = root.findViewById(R.id.wk_rv_habitats);
        rv.setLayoutManager(new LinearLayoutManager(requireContext()));

        final GameViewModel vm = new androidx.lifecycle.ViewModelProvider(requireActivity()).get(GameViewModel.class);
        repo = new GameRepository(requireContext());

        adapter = new HabitatAdapter(new ArrayList<>(), h -> {
            if (repo == null) return;
            repo.getPlayerAsync(player -> {
                int cost = Math.max(50, h.baseProduction * Math.max(1, h.level) * 10);
                if (player == null || player.coins < cost) {
                    Toast.makeText(requireContext(), "Moedas insuficientes", Toast.LENGTH_SHORT).show();
                    return;
                }

                repo.spendCoinsAsync(cost, () -> {
                    h.level += 1;
                    repo.updateHabitatAsync(h, () -> {
                        vm.refreshAll();
                        Toast.makeText(requireContext(), "Habitat melhorado!", Toast.LENGTH_SHORT).show();
                    });
                }, () -> Toast.makeText(requireContext(), "Moedas insuficientes", Toast.LENGTH_SHORT).show());
            });
        });
        rv.setAdapter(adapter);

        loadHabitats();
        return root;
    }

    private void loadHabitats(){
        repo.getAllHabitatsAsync(list -> {
            adapter.setItems(list);
            adapter.notifyDataSetChanged();
        });
    }
}
