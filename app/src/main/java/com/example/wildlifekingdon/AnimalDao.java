package com.example.wildlifekingdon;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface AnimalDao {
    @Query("SELECT * FROM Animal")
    List<Animal> getAll();

    @Insert
    void insert(Animal a);

    @Update
    void update(Animal a);

    @Query("SELECT * FROM Animal WHERE id = :id LIMIT 1")
    Animal findById(int id);
}
