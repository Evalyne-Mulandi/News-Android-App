package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class newpassword extends AppCompatActivity {

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newpassword);

        btn = findViewById(R.id.button5);

        btn.setOnClickListener(v -> {
            Intent i = new Intent(newpassword.this, nuntium.class);
            startActivity(i);
        });
    }
}