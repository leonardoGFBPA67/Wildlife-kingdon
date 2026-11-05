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
import java.util.List;

public class ColecaoFragment extends Fragment {

    private RecyclerView rv;
    private AnimalAdapter adapter;
    private GameRepository repo;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.wk_fragment_colecao, container, false);
        rv = root.findViewById(R.id.wk_rv_animals);
        rv.setLayoutManager(new LinearLayoutManager(requireContext()));

        adapter = new AnimalAdapter(new ArrayList<>(), a -> {
            // TODO: open detail
        });
        rv.setAdapter(adapter);

        final GameViewModel vm = new androidx.lifecycle.ViewModelProvider(requireActivity()).get(GameViewModel.class);
        vm.getAnimals().observe(getViewLifecycleOwner(), list -> {
            adapter.setItems(list);
            adapter.notifyDataSetChanged();
        });

        repo = new GameRepository(requireContext()); // retained for actions if needed


        return root;
    }
}
