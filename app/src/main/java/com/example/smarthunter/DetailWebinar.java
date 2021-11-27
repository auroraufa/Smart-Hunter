package com.example.smarthunter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class DetailWebinar extends AppCompatActivity {

    ImageView back_detailwebinar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_webinar);

        back_detailwebinar = (ImageView) findViewById(R.id.back_detailwebinar);

        back_detailwebinar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}