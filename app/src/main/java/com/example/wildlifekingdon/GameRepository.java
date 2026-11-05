package com.example.wildlifekingdon;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GameRepository {
    private AppDatabase db;
    private ExecutorService exec = Executors.newSingleThreadExecutor();
    private Handler main = new Handler(Looper.getMainLooper());

    public GameRepository(Context context) {
        db = AppDatabase.getInstance(context);
    }

    public interface Callback<T> { void onComplete(T result); }

    public void getOrCreatePlayerAsync(Callback<PlayerState> cb) {
        exec.execute(() -> {
            PlayerState p = db.playerDao().getPlayer();
            if (p == null) {
                p = new PlayerState();
                p.coins = 100;
                p.crystals = 0;
                p.lastSaved = System.currentTimeMillis();
                db.playerDao().insert(p);
            }
            PlayerState result = p;
            if (cb != null) {
                main.post(() -> cb.onComplete(result));
            }
        });
    }

    public void getPlayerAsync(Callback<PlayerState> cb){
        exec.execute(() -> {
            PlayerState p = db.playerDao().getPlayer();
            if (cb != null) {
                main.post(() -> cb.onComplete(p));
            }
        });
    }

    // Prepopulate default habitats and animals if DB empty
    public void prepopulateIfNeededAsync(Runnable onComplete) {
        exec.execute(() -> {
            if (db.habitatDao().getAll() == null || db.habitatDao().getAll().isEmpty()) {
                Habitat h1 = new Habitat(); h1.biomeId = 1; h1.name = "Bosque"; h1.level = 1; h1.baseProduction = 1; h1.intervalSec = 3;
                Habitat h2 = new Habitat(); h2.biomeId = 1; h2.name = "Lago"; h2.level = 1; h2.baseProduction = 1; h2.intervalSec = 3;
                Habitat h3 = new Habitat(); h3.biomeId = 1; h3.name = "Campo"; h3.level = 1; h3.baseProduction = 1; h3.intervalSec = 4;
                Habitat h4 = new Habitat(); h4.biomeId = 1; h4.name = "Caverna"; h4.level = 1; h4.baseProduction = 2; h4.intervalSec = 5;
                Habitat h5 = new Habitat(); h5.biomeId = 1; h5.name = "Árvore Ancestral"; h5.level = 1; h5.baseProduction = 5; h5.intervalSec = 10;
                db.habitatDao().insert(h1); db.habitatDao().insert(h2); db.habitatDao().insert(h3); db.habitatDao().insert(h4); db.habitatDao().insert(h5);
            }

            if (db.animalDao().getAll() == null || db.animalDao().getAll().isEmpty()) {
                Animal a1 = new Animal(); a1.name = "Coelho"; a1.biomeId = 1; a1.rarity = "COMUM"; a1.discovered = true; a1.level = 1; a1.countOwned = 1; a1.productionBonus = 1; a1.sprite = "rabbit";
                Animal a2 = new Animal(); a2.name = "Esquilo"; a2.biomeId = 1; a2.rarity = "COMUM"; a2.discovered = false; a2.level = 1; a2.countOwned = 0; a2.productionBonus = 1; a2.sprite = "squirrel";
                Animal a3 = new Animal(); a3.name = "Cervo"; a3.biomeId = 1; a3.rarity = "INCOMUM"; a3.discovered = false; a3.level = 1; a3.countOwned = 0; a3.productionBonus = 5; a3.sprite = "deer";
                db.animalDao().insert(a1); db.animalDao().insert(a2); db.animalDao().insert(a3);
            }

            // prepopulate simple missions
            if (db.missionDao() != null && (db.missionDao().getAll() == null || db.missionDao().getAll().isEmpty())) {
                Mission m1 = new Mission(); m1.title = "Melhore o Lago para nível 5"; m1.description = "Aumente o nível do Lago para 5."; m1.goalType = "HABITAT_LEVEL"; m1.goalTarget = 5; m1.progress = 0; m1.rewardCoins = 500; m1.rewardCrystals = 0; m1.completed = false;
                Mission m2 = new Mission(); m2.title = "Descubra 3 animais"; m2.description = "Encontre 3 animais na Floresta."; m2.goalType = "ANIMALS_FOUND"; m2.goalTarget = 3; m2.progress = 0; m2.rewardCoins = 200; m2.rewardCrystals = 10; m2.completed = false;
                db.missionDao().insert(m1); db.missionDao().insert(m2);
            }

            if (onComplete != null) main.post(onComplete);
        });
    }

    // Async list retrieval
    public void getAllHabitatsAsync(Callback<List<Habitat>> cb){
        exec.execute(() -> { List<Habitat> list = db.habitatDao().getAll(); main.post(() -> cb.onComplete(list)); });
    }

    public void getAllAnimalsAsync(Callback<List<Animal>> cb){
        exec.execute(() -> { List<Animal> list = db.animalDao().getAll(); main.post(() -> cb.onComplete(list)); });
    }

    public void getAllMissionsAsync(Callback<List<Mission>> cb){
        exec.execute(() -> { List<Mission> list = db.missionDao().getAll(); main.post(() -> cb.onComplete(list)); });
    }

    // compute offline coins in background
    public void computeOfflineCoinsAsync(long lastSaved, Callback<Long> cb) {
        exec.execute(() -> {
            long now = System.currentTimeMillis();
            if (lastSaved <= 0 || lastSaved >= now) { main.post(() -> cb.onComplete(0L)); return; }
            long deltaSec = (now - lastSaved) / 1000;
            long maxSec = 8L * 3600L;
            if (deltaSec > maxSec) deltaSec = maxSec;
            List<Habitat> habitats = db.habitatDao().getAll();
            long total = 0;
            for (Habitat h : habitats) {
                if (h.intervalSec <= 0) continue;
                long cycles = deltaSec / h.intervalSec;
                long perCycle = (long) h.baseProduction * Math.max(1, h.level);
                total += cycles * perCycle;
            }
            long result = total;
            main.post(() -> cb.onComplete(result));
        });
    }

    public void addCoinsToPlayerAsync(long amount, Runnable onDone) {
        exec.execute(() -> {
            PlayerState p = db.playerDao().getPlayer();
            if (p == null) return;
            p.coins += amount;
            p.lastSaved = System.currentTimeMillis();
            db.playerDao().update(p);
            if (onDone != null) main.post(onDone);
        });
    }

    public void spendCoinsAsync(long amount, Runnable onSuccess, Runnable onFailure) {
        exec.execute(() -> {
            PlayerState p = db.playerDao().getPlayer();
            if (p == null) {
                if (onFailure != null) main.post(onFailure);
                return;
            }
            if (p.coins < amount) {
                if (onFailure != null) main.post(onFailure);
                return;
            }
            p.coins -= amount;
            p.lastSaved = System.currentTimeMillis();
            db.playerDao().update(p);
            if (onSuccess != null) main.post(onSuccess);
        });
    }

    public void updateHabitatAsync(Habitat h, Runnable onDone){
        exec.execute(() -> { db.habitatDao().update(h); if (onDone != null) main.post(onDone); });
    }

    public AppDatabase getDatabase(){ return db; }
}
