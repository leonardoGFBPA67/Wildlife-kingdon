package com.example.wildlifekingdon;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.ViewHolder> {
    private List<Animal> items;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Animal a);
    }

    public AnimalAdapter(List<Animal> items, OnItemClickListener l) {
        this.items = items;
        this.listener = l;
    }

    public void setItems(List<Animal> items){ this.items = items; }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.wk_item_animal_card, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Animal a = items.get(position);
        holder.name.setText(a.name != null ? a.name : "--");
        holder.info.setText((a.rarity != null ? a.rarity : "?") + " • Nível " + a.level);
        // TODO: load sprite or silhouette depending on discovered
        // prefer webp sprite when available
        int resId = holder.img.getContext().getResources().getIdentifier("animal_sprite", "drawable", holder.img.getContext().getPackageName());
        if (resId != 0) holder.img.setImageResource(resId); else holder.img.setImageResource(R.drawable.animal_placeholder);
        holder.itemView.setOnClickListener(v -> { if (listener != null) listener.onItemClick(a); });
    }

    @Override
    public int getItemCount() { return items != null ? items.size() : 0; }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name, info;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.wk_img_animal);
            name = itemView.findViewById(R.id.wk_tv_animal_name);
            info = itemView.findViewById(R.id.wk_tv_animal_info);
        }
    }
}
