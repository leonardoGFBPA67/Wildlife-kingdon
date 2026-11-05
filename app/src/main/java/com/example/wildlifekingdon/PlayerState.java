package com.example.wildlifekingdon;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class PlayerState {
    @PrimaryKey
    public int id = 1; // singleton

    public long coins = 100;
    public long crystals = 0;
    public long lastSaved = 0; // timestamp ms
    public int currentBiomeId = 1;

    public PlayerState() {}
}
