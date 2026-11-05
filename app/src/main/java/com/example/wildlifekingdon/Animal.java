package com.example.wildlifekingdon;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Animal {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String name;
    public int biomeId;
    public String rarity;
    public boolean discovered;
    public int level;
    public int countOwned;
    public int productionBonus;
    public String sprite;

    public Animal() {}
}
