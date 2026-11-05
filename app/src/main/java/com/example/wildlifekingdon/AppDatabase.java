package com.example.wildlifekingdon;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {PlayerState.class, Habitat.class, Animal.class, Mission.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static final String DB_NAME = "wildlife_db";
    private static AppDatabase instance;

    public abstract PlayerDao playerDao();
    public abstract HabitatDao habitatDao();
    public abstract AnimalDao animalDao();
    public abstract MissionDao missionDao();

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DB_NAME)
                                .fallbackToDestructiveMigration()
                                .build();
        }
        return instance;
    }
}
