package com.example.smarthunter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Filter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
    }

    public void main(View view) {
        Intent main= new Intent(Filter.this, MainActivity.class);
        startActivity(main);
    }

    public void post(View view) {
        Intent post= new Intent(this, Posting.class);
        startActivity(post);
    }

    public void gprofile(View view) {
        Intent profile= new Intent(this, Account.class);
        startActivity(profile);
    }

    public void checkok(View view) {
        Intent mainIntent = new Intent(this, hasilPencarian.class);
        startActivity(mainIntent);
    }
}