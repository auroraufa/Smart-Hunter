package com.example.smarthunter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.smarthunter.adapter.eventAdapter;
import com.example.smarthunter.adapter.saveAdapter;
import com.example.smarthunter.model.MessageLogOut;
import com.example.smarthunter.model.event;
import com.example.smarthunter.model.saved;
import com.example.smarthunter.retrofit.RetrofitClient;
import com.example.smarthunter.retrofit.eventClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Account extends AppCompatActivity {

    RecyclerView rvevent_list;
    eventAdapter event_adapt;

    RecyclerView rvsaved_list;
    saveAdapter save_adapt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        event_adapt = new eventAdapter();
        event_adapt.setListEvent(getDataEvent());

        save_adapt = new saveAdapter();
        save_adapt.setListSaved(getDataSaved());

        rvevent_list = findViewById(R.id.event_list);
        rvevent_list.setAdapter(event_adapt);
        GridLayoutManager gridmanajer = new GridLayoutManager(this, 2,GridLayoutManager.HORIZONTAL, false);
        rvevent_list.setLayoutManager(gridmanajer);

        rvsaved_list = findViewById(R.id.saved_list);
        rvsaved_list.setAdapter(save_adapt);
        GridLayoutManager gridmanage= new GridLayoutManager(this, 2,GridLayoutManager.HORIZONTAL, false);
        rvsaved_list.setLayoutManager(gridmanage);
    }

    public ArrayList<saved> getDataSaved() {
        ArrayList<saved> list = new ArrayList<>();
        list.add(new saved("Seminar", "Pendidikan", "Detail","Pendidikan Di Zaman Sekarang","Event : 30-12-2021",R.drawable.sem1));
        list.add(new saved("Seminar", "Pendidikan", "Detail","Pentingnya Teknologi Di Era 4.0","Event : 2-10-2021",R.drawable.sem2));
        list.add(new saved("Seminar", "Kesehatan", "Detail","Menjaga Kesehatan Dengan Berolahraga","Event : 3-2-2021",R.drawable.sem3));
        list.add(new saved("Seminar", "Technopreneur", "Detail","Berbisnis Dengan Modal Kecil","Event : 10-10-2021",R.drawable.web1));
        list.add(new saved("Seminar", "Pendidikan", "Detail","Pendidikan Di Zaman Sekarang","Event : 10-8-2021",R.drawable.sem4));
        return list;
    }

    public ArrayList<event> getDataEvent() {
        ArrayList<event> list = new ArrayList<>();
        list.add(new event("Seminar", "Pendidikan", "Detail","Pendidikan Di Zaman Sekarang","Event : 7-10-2021", R.drawable.sem1));
        list.add(new event("seminar", "Teknologi", "Detail","Pentingnya Teknologi Di Zaman Sekarang","Event : 8-10-2021", R.drawable.sem2));
        list.add(new event("Webinar", "Pendidikan", "Detail","Sosialisasi Jaringan Komputer", "Event : 10-10-2021", R.drawable.sem3));
        list.add(new event("Webinar", "Pendidikan", "Detail","Menjaga Kesehatan Mata","Event : 1-10-2021", R.drawable.web1));
        list.add(new event("Webinar", "Technopreneur", "Detail","Kembangkan Bisnis Dari Sekarang","Event : 10-12-2021", R.drawable.sem4));

        return list;
    }

    public void cusedit(View view) {
        Intent mainIntent =new Intent(Account.this, Edit.class);
        startActivity(mainIntent);
    }

    public void posting(View view) {
        Intent posting = new Intent(Account.this, Posting.class);
        startActivity(posting);
    }

    public void main(View view) {
        Intent main= new Intent(Account.this, MainActivity.class);
        startActivity(main);
    }

    public void toLogout(View view) {
//        eventClient EventClient = RetrofitClient.getEventClient();
//
//        Call<MessageLogOut> call = EventClient.getOut();
//        call.enqueue(new Callback<MessageLogOut>() {
//            @Override
//            public void onResponse(Call<MessageLogOut> call, Response<MessageLogOut> response) {
//                MessageLogOut pesan = response.body();
//                if(pesan != null) {
//                    Intent in = new Intent(getApplicationContext(), Login.class);
//                    startActivity(in);
//                }else {
//                    Toast.makeText(getApplicationContext(), "Logout Gagal", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<MessageLogOut> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), "Gagal Mengakses Server", Toast.LENGTH_SHORT).show();
//            }
//        });

    }

}