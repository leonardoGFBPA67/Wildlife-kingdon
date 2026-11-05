package com.example.wildlifekingdon;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HabitatAdapter extends RecyclerView.Adapter<HabitatAdapter.ViewHolder> {
    private List<Habitat> items;
    private OnUpgradeClickListener listener;

    public interface OnUpgradeClickListener { void onUpgrade(Habitat h); }

    public HabitatAdapter(List<Habitat> items, OnUpgradeClickListener l){ this.items = items; this.listener = l; }

    public void setItems(List<Habitat> items){ this.items = items; }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.wk_item_habitat_card, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Habitat h = items.get(position);
        holder.name.setText(h.name + " — Nível " + h.level);
        holder.prod.setText("Produção: " + (h.baseProduction * Math.max(1, h.level)) + " / " + h.intervalSec + "s");
        holder.cost.setText("Custo: " + computeCost(h));
        holder.btnUpgrade.setOnClickListener(v -> { if (listener != null) listener.onUpgrade(h); });
    }

    private int computeCost(Habitat h){
        // simple formula: base * level * 10
        return Math.max(50, h.baseProduction * Math.max(1, h.level) * 10);
    }

    @Override
    public int getItemCount() { return items != null ? items.size() : 0; }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView name, prod, cost;
        Button btnUpgrade;
        ViewHolder(@NonNull View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.wk_tv_habitat_name);
            prod = itemView.findViewById(R.id.wk_tv_habitat_prod);
            cost = itemView.findViewById(R.id.wk_tv_cost);
            btnUpgrade = itemView.findViewById(R.id.wk_btn_upgrade);
        }
    }
}
