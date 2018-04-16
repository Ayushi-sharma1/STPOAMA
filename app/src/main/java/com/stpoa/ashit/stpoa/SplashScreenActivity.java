package com.stpoa.ashit.stpoa;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class SplashScreenActivity extends AppCompatActivity {

    private static final int SPLASH_DISPLAY_LENGTH = 1500;

    LinearLayout splashTop, splashBottom;
    Animation upToDown, downToUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        splashTop = (LinearLayout) findViewById(R.id.splashTop);
        splashBottom = (LinearLayout) findViewById(R.id.splashBottom);
        upToDown = AnimationUtils.loadAnimation(this,R.anim.uptodown);
        downToUp = AnimationUtils.loadAnimation(this,R.anim.downtoup);
        splashTop.setAnimation(upToDown);
        splashBottom.setAnimation(downToUp);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mIntent = new Intent(SplashScreenActivity.this, HomeActivity.class);
                SplashScreenActivity.this.startActivity(mIntent);
                SplashScreenActivity.this.finish();
            }
        },SPLASH_DISPLAY_LENGTH);
    }
}