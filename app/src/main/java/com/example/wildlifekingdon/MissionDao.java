package com.example.wildlifekingdon;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MissionDao {
    @Query("SELECT * FROM Mission")
    List<Mission> getAll();

    @Insert
    void insert(Mission m);

    @Update
    void update(Mission m);

    @Query("SELECT * FROM Mission WHERE id = :id LIMIT 1")
    Mission findById(int id);
}
