package com.example.smarthunter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.smarthunter.adapter.FavoRegAdapter;
import com.example.smarthunter.model.FavoReg;
import com.example.smarthunter.model.KategoriItem;
import com.example.smarthunter.model.KategoriList;
import com.example.smarthunter.model.Message;
import com.example.smarthunter.retrofit.RetrofitClient;
import com.example.smarthunter.retrofit.EventClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FavoriteRegister extends AppCompatActivity implements FavoRegAdapter.OnFavoRegViewHolderClick{

    RecyclerView rvFavReg;
    FavoRegAdapter favoRegAdapter;
    String token;
    List<Integer> kategoris;
    EventClient eventClient;
    Button buttonFav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_register);

        rvFavReg = findViewById(R.id.rvFavoriteRegister);
        buttonFav = findViewById(R.id.buttonRegist2);
        buttonFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save();
            }
        });

        SharedPreferences preferences = getSharedPreferences(
                "com.example.smarthunter",
                MODE_PRIVATE
        );

        token = preferences.getString("TOKEN", null);
        eventClient = RetrofitClient.getEventClient();

        RetrofitClient a = new RetrofitClient();

        favoRegAdapter = new FavoRegAdapter();
        Call<KategoriList> call = eventClient.getKategori(token);
        call.enqueue(new Callback<KategoriList>() {
            @Override
            public void onResponse(Call<KategoriList> call, Response<KategoriList> response) {
//                Toast.makeText(getApplicationContext(), "Cek Koneksi Internet Anda", Toast.LENGTH_SHORT).show();
                KategoriList kategoriList = response.body();
                ArrayList<FavoReg> favoRegs = new ArrayList<>();
                if(kategoriList !=null){
                    List<KategoriItem> kategoriItems = kategoriList.getKategori();
                    for (KategoriItem item: kategoriItems){
                        FavoReg favoReg = new FavoReg(item.getId(), "https://smart-hunter.herokuapp.com/"+item.getFoto(), item.getNama());
//                        Toast.makeText(getApplicationContext(), a.API_BASE_URL+item.getFoto(), Toast.LENGTH_SHORT).show();
                        favoRegs.add(favoReg);
                    }
                    favoRegAdapter.setList(favoRegs);
                }else{
                    Toast.makeText(getApplicationContext(), "Tidak ada response", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<KategoriList> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Cek Koneksi Internet Anda", Toast.LENGTH_SHORT).show();
            }
        });

        favoRegAdapter.setClickObject(this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);

        rvFavReg.setAdapter(favoRegAdapter);
        rvFavReg.setLayoutManager(gridLayoutManager);

    }

    public void save(){

        Call<Message> call = eventClient.addKategori(token,kategoris);
        call.enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                Message messageOut = response.body();
                if(messageOut !=null){
                    String message = messageOut.getMessage();

                    Intent main = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(main);
                    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Ada yang salah", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Message> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Cek Koneksi Internet Anda", Toast.LENGTH_SHORT).show();
            }
        });


    }


    @Override
    public void onClick(List<Integer> kategorilist) {
        kategoris = kategorilist;
        Toast.makeText(getApplicationContext(), kategoris.toString(), Toast.LENGTH_SHORT).show();
    }
}