package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;

public class verification extends AppCompatActivity {
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);

        btn = findViewById(R.id.button6);

        btn.setOnClickListener(v -> {
            Intent i = new Intent(verification.this, newpassword.class);
            startActivity(i);
        });

    }

}