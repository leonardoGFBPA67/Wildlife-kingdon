package com.example.wildlifekingdon;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Habitat {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public int biomeId;
    public String name;
    public int level;
    public int baseProduction;
    public int intervalSec;
    public long lastCollected;

    public Habitat() {}
}
