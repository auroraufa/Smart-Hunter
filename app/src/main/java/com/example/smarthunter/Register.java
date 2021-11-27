package com.example.smarthunter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void toLogin(View view) {
        Intent loginIntent = new Intent(Register.this, Login.class);
        startActivity(loginIntent);
    }

    public void toFavorite(View view) {
        Intent favoriteIntent = new Intent(Register.this, Favorite.class);
        startActivity(favoriteIntent);
    }
}