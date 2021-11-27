package com.example.smarthunter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    public void toRegist(View view) {
        Intent registIntent = new Intent(this, Register.class);
        startActivity(registIntent);
    }

    public void toLogin(View view) {
        Intent loginIntent = new Intent(Welcome.this, Login.class);
        startActivity(loginIntent);
    }

}