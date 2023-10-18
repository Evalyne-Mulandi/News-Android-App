package com.example.splashscreen;
import com.example.splashscreen.LoginFunTask;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.text.Editable;
import android.text.TextWatcher;


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
        etPassword = findViewById(R.id.password);


        bValidate = findViewById(R.id.button3);
        textView = findViewById(R.id.textView10);
        forgotPassTextView = findViewById(R.id.textView6);

        // Add a TextWatcher to etMail for changing the background drawable
        etMail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // No need to do anything before text changes
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Change the background drawable when text is being typed
                etMail.setBackgroundResource(R.drawable.backgrounchange);
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Change the background drawable back to the default when text input is done
                etMail.setBackgroundResource(R.drawable.background);
            }
        });


        // Add a TextWatcher to etPassword for changing the background drawable
        etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // No need to do anything before text changes
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Change the background drawable when text is being typed
                etPassword.setBackgroundResource(R.drawable.backgrounchange);
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Change the background drawable back to the default when text input is done
                etPassword.setBackgroundResource(R.drawable.background);
            }
        });

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

        bValidate.setOnClickListener(v -> emailValidator(etMail));
    }

    public void emailValidator(EditText etMail) {
        String email = etMail.getText().toString();
        String password = etPassword.getText().toString();
        // Construct the JSON data for user creation
        String userData = "{\"email\":\"" + email + "\", \"password\":\"" + password + "\"}";
//        String userData = "{\"firstName\":\"" + username + "\", \"lastName\":\"\", \"username\":\"" + username + "\", \"email\":\"" + email + "\", \"password\":\"" + password + "\"}";


        if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            if (!password.isEmpty()) {
                Toast.makeText(this, "Email Verified !", Toast.LENGTH_SHORT).show();


            } else {
                Toast.makeText(Signin.this, "Password cannot be empty!", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Enter a valid Email address !", Toast.LENGTH_SHORT).show();
        }
        new LoginFunTask(Signin.this).execute(userData);
        Intent intent = new Intent(Signin.this, selecetfavorite.class);
        startActivity(intent);
    }


}
