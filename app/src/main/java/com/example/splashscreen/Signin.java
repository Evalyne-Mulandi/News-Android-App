package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.EditText;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;
import android.widget.TextView;


public class Signin extends AppCompatActivity {
    Button bValidate;
    EditText etMail;
    EditText etPassword;
    TextView textView;
    TextView forgotPassTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        etMail = findViewById(R.id.email_address);
        etPassword=findViewById(R.id.password);

        bValidate = findViewById(R.id.button3);

        textView = findViewById(R.id.textView10);

        forgotPassTextView = findViewById(R.id.textView6);



        textView.setOnClickListener(v -> {
            // Start the new activity here
            Intent intent = new Intent(Signin.this, nuntium.class);
            startActivity(intent);
        });


        forgotPassTextView.setOnClickListener(v -> {
            // Start the new activity here
            Intent intent = new Intent(Signin.this, forgotpassword.class);
            startActivity(intent);
        });



        bValidate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                emailValidator(etMail);


            }
        });



    }
    public void emailValidator(EditText etMail) {


        String emailToText = etMail.getText().toString();
        String passwordText = etPassword.getText().toString();


        if (!emailToText.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailToText).matches())
             {
                 if (!passwordText.isEmpty()){
            Toast.makeText(this, "Email Verified !", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Signin.this, forgotpassword.class);
            startActivity(intent);
             } else {
            Toast.makeText(Signin.this, "Password cannot be empty!", Toast.LENGTH_SHORT).show();

        }
        } else {
            Toast.makeText(this, "Enter valid Email address !", Toast.LENGTH_SHORT).show();
        }
    }





}







