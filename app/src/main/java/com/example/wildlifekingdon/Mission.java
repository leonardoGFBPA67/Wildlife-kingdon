package com.example.wildlifekingdon;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Mission {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String title;
    public String description;
    public String goalType; // e.g., HABITAT_LEVEL, ANIMALS_FOUND
    public int goalTarget;
    public int progress;
    public long rewardCoins;
    public long rewardCrystals;
    public boolean completed;

    public Mission() {}
}
