package com.example.wildlifekingdon;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MissionAdapter extends RecyclerView.Adapter<MissionAdapter.ViewHolder> {
    private List<Mission> items;
    private OnCollectListener listener;

    public interface OnCollectListener { void onCollect(Mission m); }

    public MissionAdapter(List<Mission> items, OnCollectListener l){ this.items = items; this.listener = l; }

    public void setItems(List<Mission> items){ this.items = items; }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_2, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Mission m = items.get(position);
        holder.title.setText(m.title);
        holder.desc.setText(m.description + " — Recompensa: " + m.rewardCoins + " coins");
        holder.btn.setText(m.completed ? "COLETADO" : "COLETAR");
        holder.btn.setEnabled(m.completed);
        holder.btn.setOnClickListener(v -> { if (listener != null) listener.onCollect(m); });
    }

    @Override
    public int getItemCount() { return items != null ? items.size() : 0; }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView title, desc; Button btn;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            title = itemView.findViewById(android.R.id.text1);
            desc = itemView.findViewById(android.R.id.text2);
            btn = new Button(itemView.getContext());
            ((ViewGroup)itemView).addView(btn);
        }
    }
}
