package com.example.smarthunter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.smarthunter.adapter.seminarAdapter;
import com.example.smarthunter.model.seminarEvent;

import java.util.ArrayList;

public class List_seminar extends AppCompatActivity implements seminarAdapter.OnSeminarViewHolderClick{

    RecyclerView rvseminar_list;
    seminarAdapter seminar_adapter;

    ImageButton back_listseminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_seminar);

        back_listseminar= (ImageButton) findViewById(R.id.back_seminar);

        back_listseminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        seminar_adapter = new seminarAdapter();
        seminar_adapter.setListSeminar(getDataList_seminar());
        seminar_adapter.setListener(this);

        rvseminar_list = findViewById(R.id.seminar_list);
        rvseminar_list.setAdapter(seminar_adapter);
        LinearLayoutManager linearmanajer = new LinearLayoutManager(this);
        rvseminar_list.setLayoutManager(linearmanajer);

    }

    public ArrayList<seminarEvent> getDataList_seminar() {
        ArrayList<seminarEvent> list = new ArrayList<>();
        list.add(new seminarEvent("seminar", "finansial", "Tantangan dan Peluang perpajakan di Era Revolusi Indutri 4.0", "Event : 2020-01-23", R.drawable.poster_png));
        list.add(new seminarEvent("seminar", "Enterpreneur", "Social Enterpreneurship", "Event : 2017-06-16", R.drawable.seminar1 ));
        list.add(new seminarEvent("seminar", "bisnis", "Peluang Bisnis di Era Milenium", "Event : 2017-11-12", R.drawable.seminar2));
        list.add(new seminarEvent("seminar", "religius", "Islamic youngpreneur in Milenium Era", "Event : 2019-11-15", R.drawable.seminar3 ));
        list.add(new seminarEvent("seminar", "kesehatan", "Peran Contractor Safety Management System(CSMS) Pada Industri Migas & Konstruksi Untuk Meminimalisir Risiko Kecelakaan Kerja ", "Event : 2020-01-23", R.drawable.seminar4));

        return list;
    }
    public void posting(View view) {
        Intent posting = new Intent(List_seminar.this, Posting.class);
        startActivity(posting);
    }

    public void main(View view) {
        Intent main= new Intent(List_seminar.this, MainActivity.class);
        startActivity(main);
    }

    public void account(View view) {
        Intent account= new Intent(this, Account.class);
        startActivity(account);
    }

    @Override
    public void onClick() {
        Intent detailSeminar = new Intent(this,DetailSeminar.class);
        startActivity(detailSeminar);
    }
}