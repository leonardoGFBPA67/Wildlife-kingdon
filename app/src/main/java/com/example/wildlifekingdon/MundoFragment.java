package com.example.wildlifekingdon;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MundoFragment extends Fragment {

    private TextView tvCoins, tvCrystals, tvProd;
    private FloatingActionButton fabCollect;
    private Button btnBosque, btnLago, btnCampo;
    private FrameLayout eventContainer;
    private Handler handler = new Handler();
    private GameRepository repo;
    private PlayerState player;
    private double prodAccumulator = 0.0;
    private EventManager eventManager;

    private List<Habitat> cachedHabitats = null;

    private final Runnable tick = new Runnable() {
        @Override
        public void run() {
            if (repo == null) {
                handler.postDelayed(this, 1000);
                return;
            }

            double totalPerSec = 0.0;
            if (cachedHabitats != null) {
                for (Habitat h : cachedHabitats) {
                    if (h.intervalSec <= 0) continue;
                    double perSec = ((double) h.baseProduction * Math.max(1, h.level)) / (double) h.intervalSec;
                    totalPerSec += perSec;
                }
            }

            prodAccumulator += totalPerSec;
            long toAdd = 0;
            if (prodAccumulator >= 1.0) {
                toAdd = (long) Math.floor(prodAccumulator);
                prodAccumulator -= toAdd;
                long finalToAdd = toAdd;
                repo.addCoinsToPlayerAsync(finalToAdd, null);
            }

            final long prodPerMin = Math.round(totalPerSec * 60.0);
            repo.getPlayerAsync(p -> updateUiWithValues(p, prodPerMin));

            handler.postDelayed(this, 1000);
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.wk_fragment_mundo, container, false);
        repo = new GameRepository(requireContext());
        tvCoins = root.findViewById(R.id.wk_tv_coins);
        tvCrystals = root.findViewById(R.id.wk_tv_crystals);
        tvProd = root.findViewById(R.id.wk_tv_prod);
        fabCollect = root.findViewById(R.id.wk_fab_collect);
        btnBosque = root.findViewById(R.id.wk_btn_bosque);
        btnLago = root.findViewById(R.id.wk_btn_lago);
        btnCampo = root.findViewById(R.id.wk_btn_campo);
        eventContainer = root.findViewById(R.id.wk_event_container);
        eventManager = new EventManager(requireContext(), eventContainer);

        final GameViewModel vm = new androidx.lifecycle.ViewModelProvider(requireActivity()).get(GameViewModel.class);
        vm.getPlayer().observe(getViewLifecycleOwner(), p -> {
            player = p;
            updateUiWithValues(player, computeProdMinPreviewFromCache());
        });
        vm.getHabitats().observe(getViewLifecycleOwner(), list -> {
            cachedHabitats = list;
            updateUiWithValues(player, computeProdMinPreviewFromCache());
        });

        btnBosque.setOnClickListener(v -> handleHabitatTap("Bosque", 25));
        btnLago.setOnClickListener(v -> handleHabitatTap("Lago", 45));
        btnCampo.setOnClickListener(v -> handleHabitatTap("Campo", 60));

        fabCollect.setOnClickListener(v -> {
            long bonus = 15L + Math.max(0L, computeProdMinPreviewFromCache() / 10L);
            repo.addCoinsToPlayerAsync(bonus, () -> {
                Toast.makeText(requireContext(), "Produção coletada: +" + bonus + " moedas", Toast.LENGTH_SHORT).show();
                repo.getPlayerAsync(p -> updateUiWithValues(p, computeProdMinPreviewFromCache()));
            });
        });

        return root;
    }

    private void handleHabitatTap(String name, long reward) {
        repo.addCoinsToPlayerAsync(reward, () -> {
            Toast.makeText(requireContext(), name + " melhorado: +" + reward + " moedas", Toast.LENGTH_SHORT).show();
            repo.getPlayerAsync(p -> updateUiWithValues(p, computeProdMinPreviewFromCache()));
        });
    }

    private long computeProdMinPreviewFromCache() {
        double totalPerSec = 0.0;
        if (cachedHabitats != null) {
            for (Habitat h : cachedHabitats) {
                if (h.intervalSec <= 0) continue;
                double perSec = ((double) h.baseProduction * Math.max(1, h.level)) / (double) h.intervalSec;
                totalPerSec += perSec;
            }
        }
        return Math.round(totalPerSec * 60.0);
    }

    private void updateUiWithValues(PlayerState p, long prodPerMinute) {
        if (tvCoins != null) tvCoins.setText("🪙 " + (p != null ? p.coins : 0));
        if (tvCrystals != null) tvCrystals.setText("💎 " + (p != null ? p.crystals : 0));
        if (tvProd != null) tvProd.setText("+" + prodPerMinute + "/min");
    }

    @Override
    public void onResume() {
        super.onResume();
        handler.post(tick);
        if (eventManager != null) eventManager.start();
    }

    @Override
    public void onPause() {
        super.onPause();
        handler.removeCallbacks(tick);
        if (eventManager != null) eventManager.stop();
    }
}
