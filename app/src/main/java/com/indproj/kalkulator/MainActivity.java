package com.indproj.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.google.android.material.snackbar.Snackbar;


public class MainActivity extends AppCompatActivity {

    ImageView logoImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logoImage = findViewById(R.id.logo);
        startAnim();
        final Intent intent = new Intent(this, StartActivity.class);
        logoImage.setOnClickListener(v -> startActivity(intent));
    }

    @Override
    protected void onResume() {
        super.onResume();
        startAnim();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        View rootView = this.getWindow().getDecorView().findViewById(android.R.id.content);
        Snackbar.make(rootView, R.string.exit, Snackbar.LENGTH_SHORT).show();
    }

    private void startAnim() {
        Animation alpha = new AlphaAnimation(1f, 0f);
        alpha.setDuration(1000);
        alpha.setRepeatCount(2);
        logoImage.startAnimation(alpha);
        final Intent intent = new Intent(this, StartActivity.class);

        alpha.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(intent);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}

