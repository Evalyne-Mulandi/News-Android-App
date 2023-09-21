package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

public class Onboarding extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        btn = findViewById(R.id.button);

        btn.setOnClickListener(v -> {
            Intent i = new Intent(Onboarding.this, welcome.class);
            startActivity(i);
        });

//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                //This method will be executed once the timer is over
//                // Start your app main activity
//                Intent i = new Intent(Onboarding.this, welcome.class);
//                startActivity(i);
//                // close this activity
//                finish();
//            }
//        }, 2000);
    }
}