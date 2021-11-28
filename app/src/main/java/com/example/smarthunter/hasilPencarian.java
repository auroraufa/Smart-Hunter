package com.example.smarthunter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.smarthunter.adapter.pencarianAdapter;
import com.example.smarthunter.model.pencarianEvent;

import java.util.ArrayList;

public class hasilPencarian extends AppCompatActivity implements pencarianAdapter.OnpencarianViewHolderClick{

    RecyclerView rvhasil_pencarian;
    pencarianAdapter pencarian_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_pencarian);

        pencarian_adapter = new pencarianAdapter();
        pencarian_adapter.setListpencarian(getDataListPencarian());
        pencarian_adapter.setListener(this);

        rvhasil_pencarian = findViewById(R.id.pencarian_list);
        rvhasil_pencarian.setAdapter(pencarian_adapter);
        LinearLayoutManager linearmanajer = new LinearLayoutManager(this);
        rvhasil_pencarian.setLayoutManager(linearmanajer);
    }

    public ArrayList<pencarianEvent> getDataListPencarian() {
        ArrayList<pencarianEvent> list = new ArrayList<>();
        list.add(new pencarianEvent("seminar", "finansial", "Tantangan dan Peluang perpajakan di Era Revolusi Indutri 4.0", "Event : 2020-01-23", R.drawable.poster_png));
        list.add(new pencarianEvent("seminar", "Enterpreneur", "Social Enterpreneurship", "Event : 2017-06-16", R.drawable.seminar1));
        list.add(new pencarianEvent("seminar", "bisnis", "Peluang Bisnis di Era Milenium", "Event : 2017-11-12", R.drawable.seminar2));
        list.add(new pencarianEvent("seminar", "religius", "Islamic youngpreneur in Milenium Era", "Event : 2019-11-15", R.drawable.seminar3));
        list.add(new pencarianEvent("seminar", "kesehatan", "Peran Contractor Safety Management System(CSMS) Pada Industri Migas & Konstruksi Untuk Meminimalisir Risiko Kecelakaan Kerja ", "Event : 2020-01-23", R.drawable.seminar4));

        return list;
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

    @Override
    public void onClick() {

    }
}