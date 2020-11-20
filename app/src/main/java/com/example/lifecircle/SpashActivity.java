package com.example.lifecircle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SpashActivity extends AppCompatActivity {
    ImageView fox;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spash);

        fox = findViewById(R.id.image_fox);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        intent = new Intent(SpashActivity.this, MainActivity.class);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(intent);
                SpashActivity.this.finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        fox.startAnimation(animation);
    }
}
