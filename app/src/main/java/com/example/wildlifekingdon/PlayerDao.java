package com.example.wildlifekingdon;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface PlayerDao {
    @Query("SELECT * FROM PlayerState WHERE id = 1 LIMIT 1")
    PlayerState getPlayer();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(PlayerState player);

    @Update
    void update(PlayerState player);
}
