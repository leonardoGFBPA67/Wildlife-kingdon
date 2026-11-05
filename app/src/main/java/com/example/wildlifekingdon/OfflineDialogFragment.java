package com.example.wildlifekingdon;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class OfflineDialogFragment extends DialogFragment {

    private static final String ARG_TIME = "arg_time";
    private static final String ARG_COINS = "arg_coins";

    public static OfflineDialogFragment newInstance(String timeText, long coins) {
        OfflineDialogFragment f = new OfflineDialogFragment();
        Bundle b = new Bundle();
        b.putString(ARG_TIME, timeText);
        b.putLong(ARG_COINS, coins);
        f.setArguments(b);
        return f;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        String time = getArguments() != null ? getArguments().getString(ARG_TIME) : "";
        long coins = getArguments() != null ? getArguments().getLong(ARG_COINS) : 0;

        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        View v = LayoutInflater.from(requireContext()).inflate(R.layout.wk_dialog_offline, null);
        TextView tvTime = v.findViewById(R.id.wk_tv_offline_time);
        TextView tvCoins = v.findViewById(R.id.wk_tv_offline_coins);
        Button btn = v.findViewById(R.id.wk_btn_collect_offline);

        tvTime.setText("Tempo ausente: " + time);
        tvCoins.setText("Produção acumulada: +" + coins + " moedas");

        btn.setOnClickListener(view -> {
            // add coins to player async
            GameRepository repo = new GameRepository(requireContext());
            repo.addCoinsToPlayerAsync(coins, () -> dismiss());
        });

        builder.setView(v);
        return builder.create();
    }
}
