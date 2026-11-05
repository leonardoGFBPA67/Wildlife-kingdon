package com.example.wildlifekingdon;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MissoesFragment extends Fragment {

    private RecyclerView rv;
    private MissionAdapter adapter;
    private GameRepository repo;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.wk_fragment_missoes, container, false);
        rv = root.findViewById(R.id.wk_rv_missions);
        rv.setLayoutManager(new LinearLayoutManager(requireContext()));

        adapter = new MissionAdapter(new ArrayList<>(), m -> {
            // collect
            if (m.completed) {
                long coins = m.rewardCoins;
                GameRepository repo = new GameRepository(requireContext());
                repo.addCoinsToPlayerAsync(coins, () -> {
                    m.completed = false; // in this simple version mark as collected
                    repo.getAllMissionsAsync(list -> {
                        adapter.setItems(list);
                        adapter.notifyDataSetChanged();
                    });
                });
            }
        });
        rv.setAdapter(adapter);

        final GameViewModel vm = new androidx.lifecycle.ViewModelProvider(requireActivity()).get(GameViewModel.class);
        repo = new GameRepository(requireContext());
        vm.getMissions().observe(getViewLifecycleOwner(), list -> {
            adapter.setItems(list);
            adapter.notifyDataSetChanged();
        });

        return root;
    }
}
