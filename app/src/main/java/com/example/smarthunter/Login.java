package com.example.smarthunter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void toRegist(View view) {
        Intent registIntent = new Intent(Login.this, Register.class);
        startActivity(registIntent);
    }

    public void toMain(View view) {

        EditText editUsername;
        EditText editPassword;

        editUsername = findViewById(R.id.textInputUser);
        editPassword = findViewById(R.id.textInputPass);

        String username = editUsername.getText().toString();
        String password = editPassword.getText().toString();

        if (username.equals("admin") && password.equals("12345")) {
            Intent homeIntent = new Intent(Login.this, MainActivity.class);
            startActivity(homeIntent);
            finish();
        } else{
            Toast.makeText(this, "Password/Username Anda Salah", Toast.LENGTH_SHORT).show();
        }
    }
}