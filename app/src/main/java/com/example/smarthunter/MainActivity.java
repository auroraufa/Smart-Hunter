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
import android.widget.Toast;

import com.example.smarthunter.adapter.favoriteAdapter;
import com.example.smarthunter.model.DataFavorite;
import com.example.smarthunter.model.EventJenisList;
import com.example.smarthunter.model.FavoriteItem;
import com.example.smarthunter.model.favoriteEvent;
import com.example.smarthunter.retrofit.RetrofitClient;
import com.example.smarthunter.retrofit.eventClient;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Path;

public class MainActivity extends AppCompatActivity implements favoriteAdapter.OnFavoriteViewHolderClick{
    RecyclerView rvfavorite_list;
    favoriteAdapter favorite_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        favorite_adapter = new favoriteAdapter();

        SharedPreferences preferences = getSharedPreferences(
                "com.example.smarthunter",
                MODE_PRIVATE
        );

        String token = preferences.getString("TOKEN", null);
        Integer userId = preferences.getInt("USERID",0);

        eventClient eventClient = RetrofitClient.getEventClient();
        Call<DataFavorite> call = eventClient.getDataFav(token, userId);
        call.enqueue(new Callback<DataFavorite>() {
            @Override
            public void onResponse(Call<DataFavorite> call, Response<DataFavorite> response) {
                DataFavorite dataFavorite = response.body();
                ArrayList<favoriteEvent> list = new ArrayList<>();
                if(dataFavorite != null) {
                    List<FavoriteItem> favoriteItems = dataFavorite.getFavorite();
                    for(FavoriteItem item:favoriteItems) {
                        String jenis;
                        if(item.getJenis()==1){
                            jenis = "Seminar";
                        }else{
                            jenis = "Webinar";
                        }

                        favoriteEvent favEvent = new favoriteEvent(jenis,
                                item.getNama(),
                                item.getNamaEvent(),
                                "Event : " +item.getDate(),
                                R.drawable.poster_png);
                        list.add(favEvent);
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "Cek Koneksi Internet Anda", Toast.LENGTH_SHORT).show();
                }
                favorite_adapter.setListFavorite(list);
            }

            @Override
            public void onFailure(Call<DataFavorite> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Gagal ke server", Toast.LENGTH_SHORT).show();
            }
        });


//        favorite_adapter.setListFavorite(getDataMainActivity());

        rvfavorite_list = findViewById(R.id.favorite_list);
        rvfavorite_list.setAdapter(favorite_adapter);
        GridLayoutManager gridmanajer = new GridLayoutManager(this, 2,GridLayoutManager.HORIZONTAL, false);
        rvfavorite_list.setLayoutManager(gridmanajer);


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


    @Override
    public void onClick() {

    }
}