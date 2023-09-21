package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class nuntium extends AppCompatActivity {

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuntium);
        btn = findViewById(R.id.button7);

        btn.setOnClickListener(v -> {
            Intent i = new Intent(nuntium.this, selecetfavorite.class);
            startActivity(i);
        });
    }
}