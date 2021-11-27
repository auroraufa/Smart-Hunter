package com.example.smarthunter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.smarthunter.adapter.webinarAdapter;
import com.example.smarthunter.model.webinarEvent;

import java.util.ArrayList;

public class List_webinar extends AppCompatActivity implements webinarAdapter.OnWebinarViewHolderClick{

    RecyclerView rvwebinar_list;
    webinarAdapter webinar_adapter;

    ImageButton back_listwebinar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_webinar);

        back_listwebinar = (ImageButton) findViewById(R.id.back_webinar);

        back_listwebinar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        webinar_adapter = new webinarAdapter();
        webinar_adapter.setListWebinar(getDataList_webinar());
        webinar_adapter.setListener(this);

        rvwebinar_list = findViewById(R.id.webinar_list);
        rvwebinar_list.setAdapter(webinar_adapter);
        LinearLayoutManager linearmanajer = new LinearLayoutManager(this);
        rvwebinar_list.setLayoutManager(linearmanajer);

    }

    public ArrayList<webinarEvent> getDataList_webinar() {
        ArrayList<webinarEvent> list = new ArrayList<>();
        list.add(new webinarEvent("webinar", "technopreneur", "The Making Of Creative Video Profile ", "Event : 2020-10-16", R.drawable.webinar1));
        list.add(new webinarEvent("webinar", "Lingkungan", "Give Our Earth Back ", "Event : 2021-04-25", R.drawable.webinar2));
        list.add(new webinarEvent("webinar", "Sosial", "Menjalin Hubungan dan Komunikasi yang Sehat di Masa Pandemi ", "Event : 2021-03-13", R.drawable.webinar3));
        list.add(new webinarEvent("webinar", "Psikilogi", "Menunda Pekerjaan: Masa DEPan Tenteram atau Suram? ", "Event : 2020-11-29", R.drawable.webinar4));
        list.add(new webinarEvent("webinar", "Motivasi", "Yang Muda Yang Berkarya ", "Event : 2020-06-09", R.drawable.webinar5));

        return list;

    }

    public void posting(View view) {
        Intent posting = new Intent(List_webinar.this, Posting.class);
        startActivity(posting);
    }

    public void main(View view) {
        Intent main = new Intent(List_webinar.this, MainActivity.class);
        startActivity(main);
    }

    public void account(View view) {
        Intent account= new Intent(this, Account.class);
        startActivity(account);
    }

    @Override
    public void onClick() {
        Intent listWebinar = new Intent(this,DetailWebinar.class);
        startActivity(listWebinar);
    }
}