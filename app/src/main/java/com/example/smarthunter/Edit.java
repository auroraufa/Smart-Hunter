package com.example.smarthunter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Edit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
    }

    public void goupdate(View view) {
        Intent mainIntent = new Intent(this, Account.class);
        startActivity(mainIntent);
    }

    public void gprofil(View view) {
        Intent mainIntent = new Intent(this, Account.class);
        startActivity(mainIntent);
    }

    public void posting(View view) {
        Intent mainIntent = new Intent(this, Posting.class);
        startActivity(mainIntent);
    }

    public void main(View view) {
        Intent mainIntent = new Intent(this, MainActivity.class);
        startActivity(mainIntent);
    }

    public void account(View view) {
        Intent account= new Intent(Edit.this, Account.class);
        startActivity(account);
    }



}