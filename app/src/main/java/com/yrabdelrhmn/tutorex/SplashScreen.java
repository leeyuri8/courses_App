package com.yrabdelrhmn.tutorex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.yrabdelrhmn.tutorex.auth.Register;
import com.yrabdelrhmn.tutorex.student.MainActivity;


public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        ImageView backgroundImage = findViewById(R.id.logo);
        Animation slideAnimation = AnimationUtils.loadAnimation(this, R.anim.side_slide);
        backgroundImage.startAnimation(slideAnimation);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(getApplicationContext(), Register.class);
                startActivity(i);
                Log.d("Handler", "Running Handler");
            }
        }, 4000);
    }
}