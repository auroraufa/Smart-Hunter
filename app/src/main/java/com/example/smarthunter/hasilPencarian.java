package com.example.smarthunter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class hasilPencarian extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_pencarian);
    }

    public void main(View view) {
        Intent main= new Intent(this, MainActivity.class);
        startActivity(main);
    }

    public void posting(View view) {
        Intent post= new Intent(this, Posting.class);
        startActivity(post);
    }

    public void goprofile(View view) {
        Intent account= new Intent(this, Account.class);
        startActivity(account);
    }

    public void filter(View view) {
        Intent filter= new Intent(this, Filter.class);
        startActivity(filter);
    }
}