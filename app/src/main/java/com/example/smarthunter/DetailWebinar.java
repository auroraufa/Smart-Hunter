package com.example.smarthunter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DetailWebinar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_webinar);
    }

    public void toListWebinar(View view) {
        Intent listWebinar = new Intent(this,List_webinar.class);
        startActivity(listWebinar);
    }
}