package com.example.smarthunter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.smarthunter.adapter.NotifikasiAdapter;
import com.example.smarthunter.adapter.seminarAdapter;
import com.example.smarthunter.model.notifikasiEvent;

import java.util.ArrayList;

public class Notifikasi extends AppCompatActivity implements NotifikasiAdapter.OnNotifikasiViewHolderClick{

    RecyclerView rvListNotifikasi;
    NotifikasiAdapter notifikasiAdapter;

    ImageButton back_notifikasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifikasi);

        back_notifikasi = (ImageButton) findViewById(R.id.Button_back_notifikasi);

        back_notifikasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        notifikasiAdapter = new NotifikasiAdapter();
        notifikasiAdapter.setListNotifikasi(getDataNotifikasi());
        notifikasiAdapter.setListener(this);

        rvListNotifikasi = findViewById(R.id.list_notifikasi);
        rvListNotifikasi.setAdapter(notifikasiAdapter);
        LinearLayoutManager linearmanajer = new LinearLayoutManager(this);
        rvListNotifikasi.setLayoutManager(linearmanajer);

    }

    public ArrayList<notifikasiEvent> getDataNotifikasi() {
        ArrayList<notifikasiEvent> list = new ArrayList<>();
        list.add(new notifikasiEvent("seminar", "finansial", "Tantangan dan Peluang perpajakan di Era Revolusi Indutri 4.0", "Event : 2020-01-23", R.drawable.poster_png ));
        list.add(new notifikasiEvent("seminar", "Enterpreneur", "Social Enterpreneurship", "Event : 2017-06-16", R.drawable.seminar1 ));
        list.add(new notifikasiEvent("seminar", "bisnis", "Peluang Bisnis di Era Milenium", "Event : 2017-11-12", R.drawable.seminar2));
        list.add(new notifikasiEvent("seminar", "religius", "Islamic youngpreneur in Milenium Era", "Event : 2019-11-15", R.drawable.seminar3 ));
        list.add(new notifikasiEvent("seminar", "kesehatan", "Peran Contractor Safety Management System(CSMS) Pada Industri Migas & Konstruksi Untuk Meminimalisir Risiko Kecelakaan Kerja ", "Event : 2020-01-23", R.drawable.seminar4));

        return list;
    }

    public void posting(View view) {
        Intent posting= new Intent(Notifikasi.this, Posting.class);
        startActivity(posting);
    }

    public void main(View view) {
        Intent main= new Intent(Notifikasi.this, MainActivity.class);
        startActivity(main);
    }

    public void account(View view) {
        Intent account= new Intent(this, Account.class);
        startActivity(account);
    }


    @Override
    public void onClick() {
        Intent detailnotifikasi = new Intent(this,DetailNotifikasi.class);
        startActivity(detailnotifikasi);
    }
}
