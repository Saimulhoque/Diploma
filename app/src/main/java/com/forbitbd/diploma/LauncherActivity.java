package com.forbitbd.diploma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.dragankrstic.autotypetextview.AutoTypeTextView;

public class LauncherActivity extends AppCompatActivity {

    Handler handler = new Handler();
    Runnable runnable;
    int delay = 2500;

    Animation blink,fadein;
    private ImageView image;
    private TextView title;
    private AutoTypeTextView subtitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        image = findViewById(R.id.image);
        title = findViewById(R.id.title);
        subtitle = findViewById(R.id.subtitle);
        blink = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink_animation);
        fadein = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein_animation);
    }

    @Override
    protected void onStart() {
        image.startAnimation(blink);
        title.startAnimation(fadein);
        subtitle.setTextAutoTyping("Country's First Result App For Diploma In Engineering");
        super.onStart();
    }

    @Override
    protected void onResume() {
        handler.postDelayed(runnable = new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(runnable,delay);
                Intent intent = new Intent(LauncherActivity.this, MainActivity.class);
                startActivity(intent);
            }

        },delay);

        super.onResume();
    }

    @Override
    protected void onPause() {
        handler.removeCallbacks(runnable);
        super.onPause();
    }
}