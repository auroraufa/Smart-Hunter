package com.example.smarthunter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DetailSeminar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_seminar);
    }

    public void toListSeminar(View view) {
        Intent listSeminar = new Intent(this,List_seminar.class);
        startActivity(listSeminar);
    }
}