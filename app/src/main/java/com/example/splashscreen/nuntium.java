package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class nuntium extends AppCompatActivity {

    Button btn;
    TextView textView;
    EditText etusername;
    EditText etMail;
    EditText etPassword;
    EditText etreapeatPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuntium);
        btn = findViewById(R.id.button7);
        textView = findViewById(R.id.textView22);
        etusername = findViewById(R.id.username);
        etMail = findViewById(R.id.email_address);
        etPassword = findViewById(R.id.password);
        etreapeatPassword = findViewById(R.id.repeat_password);


        // Add a TextWatcher to etMail for changing the background drawable
        etusername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // No need to do anything before text changes
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Change the background drawable when text is being typed
                etusername.setBackgroundResource(R.drawable.backgrounchange);
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Change the background drawable back to the default when text input is done
                etusername.setBackgroundResource(R.drawable.background);
            }
        });


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

        // Add a TextWatcher to etMail for changing the background drawable
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

        // Add a TextWatcher to etMail for changing the background drawable
        etreapeatPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // No need to do anything before text changes
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Change the background drawable when text is being typed
                etreapeatPassword.setBackgroundResource(R.drawable.backgrounchange);
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Change the background drawable back to the default when text input is done
                etreapeatPassword.setBackgroundResource(R.drawable.background);
            }
        });

        textView.setOnClickListener(v -> {
            // Start the new activity here
            Intent intent = new Intent(nuntium.this, Signin.class);
            startActivity(intent);
        });

        btn.setOnClickListener(v -> {
            if (validateFields()) {
                // If all fields are valid, proceed to the next activityS
                createUser();
            }
        });
    }




    // Function to validate the input fields
    private boolean validateFields() {
        String username = etusername.getText().toString();
        String email = etMail.getText().toString();
        String password = etPassword.getText().toString();
        String repeatPassword = etreapeatPassword.getText().toString();

        if (username.isEmpty()) {
            showToast("Please enter a username");
            return false;
        }

        if (email.isEmpty()) {
            showToast("Please enter an email address");
            return false;
        }

        if (password.isEmpty()) {
            showToast("Please enter a password");
            return false;
        }

        if (repeatPassword.isEmpty()) {
            showToast("Please repeat the password");
            return false;
        }

        if (!password.equals(repeatPassword)) {
            showToast("Passwords do not match");
            return false;
        }

        return true;
    }

    // Function to display a toast message
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    // Function to create the user and execute the UserCreationTask
    private void createUser() {
        String username = etusername.getText().toString();
        String email = etMail.getText().toString();
        String password = etPassword.getText().toString();

        // Construct the JSON data for user creation
        String userData = "{\"username\":\"" + username + "\", \"email\":\"" + email + "\", \"password\":\"" + password + "\"}";
//        String userData = "{\"firstName\":\"" + username + "\", \"lastName\":\"\", \"username\":\"" + username + "\", \"email\":\"" + email + "\", \"password\":\"" + password + "\"}";


        // Execute the UserCreationTask
        new RegisterFunTask(nuntium.this).execute(userData);

        Intent intent = new Intent(nuntium.this, Signin.class);
        startActivity(intent);
    }
}
