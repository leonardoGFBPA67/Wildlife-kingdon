package com.example.wildlifekingdon;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class GameViewModel extends AndroidViewModel {
    private GameRepository repo;
    private MutableLiveData<PlayerState> player = new MutableLiveData<>();
    private MutableLiveData<List<Habitat>> habitats = new MutableLiveData<>();
    private MutableLiveData<List<Animal>> animals = new MutableLiveData<>();
    private MutableLiveData<List<Mission>> missions = new MutableLiveData<>();

    public GameViewModel(@NonNull Application application) {
        super(application);
        repo = new GameRepository(application);
        repo.prepopulateIfNeededAsync(() -> {
            repo.getOrCreatePlayerAsync(p -> player.postValue(p));
            repo.getAllHabitatsAsync(list -> habitats.postValue(list));
            repo.getAllAnimalsAsync(list -> animals.postValue(list));
            repo.getAllMissionsAsync(list -> missions.postValue(list));
        });
    }

    public LiveData<PlayerState> getPlayer(){ return player; }
    public LiveData<List<Habitat>> getHabitats(){ return habitats; }
    public LiveData<List<Animal>> getAnimals(){ return animals; }
    public LiveData<List<Mission>> getMissions(){ return missions; }

    public void refreshAll(){
        repo.getPlayerAsync(p -> player.postValue(p));
        repo.getAllHabitatsAsync(list -> habitats.postValue(list));
        repo.getAllAnimalsAsync(list -> animals.postValue(list));
        repo.getAllMissionsAsync(list -> missions.postValue(list));
    }

    public void upgradeHabitat(Habitat h, Runnable onDone){
        repo.updateHabitatAsync(h, onDone);
    }

    public void collectOffline(long coins, Runnable onDone){ repo.addCoinsToPlayerAsync(coins, onDone); }
}
