package com.example.wildlifekingdon;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        fm = getSupportFragmentManager();

        if (savedInstanceState == null) {
            fm.beginTransaction().replace(R.id.fragment_container, new MundoFragment()).commit();
        }

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        bottomNav.setSelectedItemId(R.id.menu_world);
        bottomNav.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
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

        // async startup tasks
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
                        if (!isFinishing() && !getSupportFragmentManager().isStateSaved()) {
                            OfflineDialogFragment dlg = OfflineDialogFragment.newInstance(timeText, gained);
                            dlg.show(getSupportFragmentManager(), "offline");
                        }
                    }
                });
            });
        });
    }
}