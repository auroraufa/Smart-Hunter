package com.example.smarthunter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.MenuItem;
import android.view.View;
import android.os.Bundle;
import android.content.Intent;

import com.example.smarthunter.adapter.favoriteAdapter;
import com.example.smarthunter.model.favoriteEvent;
import com.example.smarthunter.retrofit.RetrofitClient;
import com.example.smarthunter.retrofit.eventClient;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvfavorite_list;
    favoriteAdapter favorite_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        favorite_adapter = new favoriteAdapter();
        favorite_adapter.setListFavorite(getDataMainActivity());

        rvfavorite_list = findViewById(R.id.favorite_list);
        rvfavorite_list.setAdapter(favorite_adapter);
        GridLayoutManager gridmanajer = new GridLayoutManager(this, 2,GridLayoutManager.HORIZONTAL, false);
        rvfavorite_list.setLayoutManager(gridmanajer);

        SharedPreferences preferences = getApplicationContext()
                .getSharedPreferences(
                        "com.example.smarthunter.PREFRENCES",
                        Context.MODE_PRIVATE
                );

        String token = preferences.getString("ACCESS_TOKEN", null);
    }

    public ArrayList<favoriteEvent> getDataMainActivity() {
        ArrayList<favoriteEvent> list = new ArrayList<>();
        list.add(new favoriteEvent("webinar", "technopreneur", "The Making Of Creative Video Profile ", "Event : 2020-10-16", R.drawable.webinar1));
        list.add(new favoriteEvent("seminar", "Enterpreneur", "Social Enterpreneurship", "Event : 2017-06-16", R.drawable.seminar1 ));
        list.add(new favoriteEvent("seminar", "bisnis", "Peluang Bisnis di Era Milenium", "Event : 2017-11-12", R.drawable.seminar2));
        return list;
    }

    public void notifikasi(View view) {
        Intent notifikasi= new Intent(MainActivity.this, Notifikasi.class);
        startActivity(notifikasi);
    }

    public void posting(View view) {
        Intent posting= new Intent(MainActivity.this, Posting.class);
        startActivity(posting);
    }

    public void list_seminar(View view) {
        Intent list_seminar= new Intent(MainActivity.this, List_seminar.class);
        startActivity(list_seminar);
    }

    public void list_webinar(View view) {
        Intent list_webinar= new Intent(MainActivity.this, List_webinar.class);
        startActivity(list_webinar);
    }

    public void account(View view) {
        Intent account= new Intent(MainActivity.this, Account.class);
        startActivity(account);
    }

    public void pencarian(View view) {
        Intent cari= new Intent(MainActivity.this, hasilPencarian.class);
        startActivity(cari);
    }




}