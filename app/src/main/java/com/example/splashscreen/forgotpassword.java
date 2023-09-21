package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;

public class forgotpassword extends AppCompatActivity {
        Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);
        btn = findViewById(R.id.button4);

        btn.setOnClickListener(v -> {
            Intent i = new Intent(forgotpassword.this, verification.class);
            startActivity(i);
        });
    }
}