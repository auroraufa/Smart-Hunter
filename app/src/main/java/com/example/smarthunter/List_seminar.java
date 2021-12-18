package com.example.smarthunter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.smarthunter.adapter.seminarAdapter;
import com.example.smarthunter.model.EventItem;
import com.example.smarthunter.model.EventJenisList;
import com.example.smarthunter.model.seminarEvent;
import com.example.smarthunter.retrofit.RetrofitClient;
import com.example.smarthunter.retrofit.eventClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

        SharedPreferences preferences = getSharedPreferences("com.example.smarthunter",MODE_PRIVATE);
        String token = preferences.getString("TOKEN","");

        eventClient eventClient = RetrofitClient.getEventClient();
        Call<EventJenisList> call = eventClient.getEventJenis(token, 1);
        call.enqueue(new Callback<EventJenisList>() {
            @Override
            public void onResponse(Call<EventJenisList> call, Response<EventJenisList> response) {
                EventJenisList jenisList = response.body();
                ArrayList<seminarEvent> list = new ArrayList<>();
                if (jenisList != null) {
                    List<EventItem> eventItems = jenisList.getEvent();
                    for (EventItem item:eventItems) {
                        seminarEvent semEvent = new seminarEvent("Seminar",
                                item.getNama(),
                                item.getNamaEvent(),
                                "Event : " + item.getDate(),
                                R.drawable.poster_png );
                        list.add(semEvent);
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "Cek Koneksi Internet Anda", Toast.LENGTH_SHORT).show();
                }
                seminar_adapter.setListSeminar(list);
            }

            @Override
            public void onFailure(Call<EventJenisList> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Gagal ke server", Toast.LENGTH_SHORT).show();
            }
        });


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