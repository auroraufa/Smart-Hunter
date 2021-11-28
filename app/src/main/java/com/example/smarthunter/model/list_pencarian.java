package com.example.smarthunter.model;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smarthunter.Account;
import com.example.smarthunter.DetailSeminar;
import com.example.smarthunter.List_seminar;
import com.example.smarthunter.MainActivity;
import com.example.smarthunter.Posting;
import com.example.smarthunter.R;
import com.example.smarthunter.adapter.pencarianAdapter;
import com.example.smarthunter.adapter.seminarAdapter;

import java.util.ArrayList;

public class list_pencarian {
    RecyclerView rvpencarian_list;
    pencarianAdapter pencarian_adapter;

    ImageButton back_listpencarian;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_hasil_pencarian);
//
//        back_listpencarian= (ImageButton) findViewById(R.id.back_pencarian);
//
//        back_listpencarian.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onBackPressed();
//            }
//        });
//
//        pencarian_adapter = new pencarianAdapter();
//        pencarian_adapter.setListpencarian(getDatalist_pencarian());
//        pencarian_adapter.setListener(this);
//
//        rvpencarian_list = findViewById(R.id.pencarian_list);
//        rvpencarian_list.setAdapter(pencarian_adapter);
//        LinearLayoutManager linearmanajer = new LinearLayoutManager(this);
//        rvpencarian_list.setLayoutManager(linearmanajer);
//
//    }
//
//    private ArrayList<pencarianEvent> getDatalist_pencarian() {
//
//    public ArrayList<pencarianEvent> getDataList_seminar() {
//        ArrayList<seminarEvent> list = new ArrayList<>();
//        list.add(new pencarianEvent("seminar","Social Enterpreneurship","Event : 2017-06-16", "Enterpreneur",R.drawable.seminar1));
//
//        return list;
//    }
//    public void posting(View view) {
//        Intent posting = new Intent(List_seminar.this, Posting.class);
//        startActivity(posting);
//    }
//
//    public void main(View view) {
//        Intent main= new Intent(List_seminar.this, MainActivity.class);
//        startActivity(main);
//    }
//
//    public void account(View view) {
//        Intent account= new Intent(this, Account.class);
//        startActivity(account);
//    }
//
//    @Override
//    public void onClick() {
//        Intent detailSeminar = new Intent(this, DetailSeminar.class);
//        startActivity(detailSeminar);
//    }
}
