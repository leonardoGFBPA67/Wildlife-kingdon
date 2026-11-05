package com.example.wildlifekingdon;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.view.MenuItem;

public class MainActivity_Sample extends AppCompatActivity {

    private FragmentManager fm;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = AppDatabase.getInstance(this);

        fm = getSupportFragmentManager();

        // show MundoFragment by default
        if (savedInstanceState == null) {
                    fm.beginTransaction()
                            .replace(R.id.fragment_container, new MundoFragment())
                            .commit();
                }

                BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
                bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selected = null;
                        int id = item.getItemId();
                        if (id == R.id.menu_world) {
                            selected = new MundoFragment();
                        } else if (id == R.id.menu_animals) {
                            selected = new ColecaoFragment();
                        } else if (id == R.id.menu_missions) {
                            selected = new MissoesFragment();
                        } else if (id == R.id.menu_upgrades) {
                            selected = new MelhoriasFragment();
                        } else if (id == R.id.menu_settings) {
                            selected = new ConfigFragment();
                        }
                        if (selected != null) {
                            fm.beginTransaction().replace(R.id.fragment_container, selected).commit();
                            return true;
                        }
                        return false;
                    }
                });

        // Check offline production on startup (async)
        GameRepository repo = new GameRepository(this);
        repo.prepopulateIfNeededAsync(() -> {
            repo.getOrCreatePlayerAsync(player -> {
                long last = player.lastSaved;
                repo.computeOfflineCoinsAsync(last, gained -> {
                    if (gained != null && gained > 0) {
                        long seconds = (System.currentTimeMillis() - last) / 1000;
                        long hours = seconds / 3600;
                        long minutes = (seconds % 3600) / 60;
                        String timeText = hours + "h " + minutes + "m";
                        OfflineDialogFragment dlg = OfflineDialogFragment.newInstance(timeText, gained);
                        dlg.show(getSupportFragmentManager(), "offline");
                    }
                });
            });
        });
    }

    public AppDatabase getDatabase(){ return db; }
}
