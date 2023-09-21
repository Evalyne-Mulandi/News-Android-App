package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;

public class welcome extends AppCompatActivity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        btn = findViewById(R.id.button2);

        btn.setOnClickListener(v -> {
            Intent i = new Intent(welcome.this, Signin.class);
            startActivity(i);
        });
    }
}