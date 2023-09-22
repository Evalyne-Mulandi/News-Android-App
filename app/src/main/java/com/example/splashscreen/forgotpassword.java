package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;

public class forgotpassword extends AppCompatActivity {
        Button btn;
        TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);
        btn = findViewById(R.id.button4);
        textView=findViewById(R.id.textView16);


        textView.setOnClickListener(v -> {
            // Start the new activity here
            Intent intent = new Intent(forgotpassword.this, Signin.class);
            startActivity(intent);
        });

        btn.setOnClickListener(v -> {
            Intent i = new Intent(forgotpassword.this, verification.class);
            startActivity(i);
        });
    }
}