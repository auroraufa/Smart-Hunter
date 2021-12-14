package com.example.smarthunter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.smarthunter.adapter.eventAdapter;
import com.example.smarthunter.adapter.saveAdapter;
import com.example.smarthunter.model.event;
import com.example.smarthunter.model.saved;

import java.util.ArrayList;

public class Account extends AppCompatActivity {

    RecyclerView rvevent_list;
    eventAdapter event_adapt;

    RecyclerView rvsaved_list;
    saveAdapter save_adapt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        SharedPreferences preferences = getApplicationContext()
                .getSharedPreferences(
                        "com.example.smarthunter.PREFRENCES",
                        Context.MODE_PRIVATE
                );

        String token = preferences.getString("ACCESS_TOKEN", null);

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
        list.add(new saved("Seminar", "Pendidikan", "Detail", R.drawable.sem1));
        list.add(new saved("seminar", "Teknologi", "Detail", R.drawable.sem2));
        list.add(new saved("Webinar", "Pendidikan", "Detail", R.drawable.sem3));
        list.add(new saved("Webinar", "Pendidikan", "Detail", R.drawable.web1));
        list.add(new saved("Webinar", "Technopreneur", "Detail", R.drawable.sem4));
        return list;
    }

    public ArrayList<event> getDataEvent() {
        ArrayList<event> list = new ArrayList<>();
        list.add(new event("Seminar", "Pendidikan", "Detail", R.drawable.sem1));
        list.add(new event("seminar", "Teknologi", "Detail", R.drawable.sem2));
        list.add(new event("Webinar", "Pendidikan", "Detail", R.drawable.sem3));
        list.add(new event("Webinar", "Pendidikan", "Detail", R.drawable.web1));
        list.add(new event("Webinar", "Technopreneur", "Detail", R.drawable.sem4));

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

    public void logout(View view) {
        Intent out= new Intent(Account.this, Login.class);
        startActivity(out);
    }
}