package com.example.wildlifekingdon;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.DrawableRes;

import java.util.Random;

public class EventManager {
    private final Context ctx;
    private final FrameLayout container;
    private final Handler handler = new Handler();
    private final Random random = new Random();
    private boolean running = false;

    public EventManager(Context ctx, FrameLayout container){ this.ctx = ctx; this.container = container; }

    private final Runnable spawn = new Runnable() {
        @Override
        public void run() {
            if (!running) return;
            spawnRandomEvent();
            // schedule next between 15 and 40 seconds
            int next = 15000 + random.nextInt(25000);
            handler.postDelayed(this, next);
        }
    };

    public void start(){ if (running) return; running = true; handler.postDelayed(spawn, 5000); }
    public void stop(){ running = false; handler.removeCallbacks(spawn); }

    private void spawnRandomEvent(){
        if (container == null || container.getWidth() <= 0 || container.getHeight() <= 0) {
            return;
        }

        int t = random.nextInt(3);
        @DrawableRes int drawable = ctx.getResources().getIdentifier("animal_sprite", "drawable", ctx.getPackageName());
        if (drawable == 0) drawable = R.drawable.animal_placeholder;
        String message = "+500 moedas";
        long reward = 500;
        if (t == 1) { drawable = R.drawable.ic_collect; message = "+5 cristais"; reward = 5; }
        if (t == 2) { drawable = ctx.getResources().getIdentifier("tree_decoration", "drawable", ctx.getPackageName()); if (drawable==0) drawable = R.drawable.animal_placeholder; message = "+1000 moedas"; reward = 1000; }

        ImageView iv = new ImageView(ctx);
        iv.setImageResource(drawable);
        int size = 120;
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(size, size);
        int maxX = Math.max(1, container.getWidth() - size);
        int maxY = Math.max(1, container.getHeight() - size);
        lp.leftMargin = random.nextInt(maxX);
        lp.topMargin = random.nextInt(maxY);
        iv.setLayoutParams(lp);
        final String msg = message;
        final long rew = reward;
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ctx, "Evento: " + msg, Toast.LENGTH_SHORT).show();
                GameRepository repo = new GameRepository(ctx);
                repo.addCoinsToPlayerAsync(rew, null);
                container.removeView(iv);
            }
        });
        handler.post(() -> container.addView(iv));
        handler.postDelayed(() -> handler.post(() -> {
            if (container != null && iv.getParent() == container) {
                container.removeView(iv);
            }
        }), 8000);
    }
}
