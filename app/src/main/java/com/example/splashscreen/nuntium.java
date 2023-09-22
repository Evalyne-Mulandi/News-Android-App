package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class nuntium extends AppCompatActivity {

    Button btn;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuntium);
        btn = findViewById(R.id.button7);
        textView= findViewById(R.id.textView22);


        textView.setOnClickListener(v -> {
            // Start the new activity here
            Intent intent = new Intent(nuntium.this, Signin.class);
            startActivity(intent);
        });




        btn.setOnClickListener(v -> {
            Intent i = new Intent(nuntium.this, selecetfavorite.class);
            startActivity(i);
        });
    }
}