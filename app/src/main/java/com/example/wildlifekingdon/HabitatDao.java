package com.example.wildlifekingdon;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface HabitatDao {
    @Query("SELECT * FROM Habitat")
    List<Habitat> getAll();

    @Insert
    void insert(Habitat habitat);

    @Update
    void update(Habitat habitat);

    @Query("SELECT * FROM Habitat WHERE id = :id LIMIT 1")
    Habitat findById(int id);
}
