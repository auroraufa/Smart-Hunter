package com.example.smarthunter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.smarthunter.adapter.eventAdapter;
import com.example.smarthunter.adapter.saveAdapter;
import com.example.smarthunter.model.EventAccount;
import com.example.smarthunter.model.Message;
import com.example.smarthunter.model.MyeventItem;
import com.example.smarthunter.model.event;
import com.example.smarthunter.model.saved;
import com.example.smarthunter.retrofit.RetrofitClient;
import com.example.smarthunter.retrofit.EventClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Account extends AppCompatActivity implements  eventAdapter.OnEventViewHolderClick {

    RecyclerView rvevent_list;
    eventAdapter event_adapt;

    RecyclerView rvsaved_list;
    saveAdapter save_adapt;

    EventClient eventClient = RetrofitClient.getEventClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        SharedPreferences preferences = getSharedPreferences(
                "com.example.smarthunter",
                MODE_PRIVATE
        );

        String token = preferences.getString("TOKEN", null);
        Integer userId = preferences.getInt("USERID",0);

        event_adapt = new eventAdapter();

        Call<EventAccount> call = eventClient.getEvent(token, userId, 1);
        call.enqueue(new Callback<EventAccount>() {
            @Override
            public void onResponse(Call<EventAccount> call, Response<EventAccount> response) {
                EventAccount myevent = response.body();
                ArrayList<event> list = new ArrayList<>();
                if(myevent != null) {
                    List<MyeventItem> myeventItems = myevent.getMyevent();
                    for (MyeventItem item:myeventItems) {
                        String jenis;
                        if(item.getJenis()==1) {
                            jenis = "Seminar";
                        } else {
                            jenis = "Webinar";
                        }
                        event event_account = new event(jenis,
                                item.getNama(),
                                item.getNamaEvent(),
                                "Event : " +item.getDate(),
                                R.drawable.sem2);
                        list.add(event_account);

                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "Cek Koneksi Internet Anda", Toast.LENGTH_SHORT).show();
                }
                event_adapt.setListEvent(list);

                }

            @Override
            public void onFailure(Call<EventAccount> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Gagal ke server", Toast.LENGTH_SHORT).show();
            }
        });

//        event_adapt.setListEvent(getDataEvent());

        rvevent_list = findViewById(R.id.event_list);
        rvevent_list.setAdapter(event_adapt);
        GridLayoutManager gridmanajer = new GridLayoutManager(this, 2,GridLayoutManager.HORIZONTAL, false);
        rvevent_list.setLayoutManager(gridmanajer);


        save_adapt = new saveAdapter();
        Call<EventAccount> call_saved = eventClient.getEvent(token, userId, 2);
        call_saved.enqueue(new Callback<EventAccount>() {
            @Override
            public void onResponse(Call<EventAccount> call, Response<EventAccount> response) {
                EventAccount mysaved = response.body();
                ArrayList<saved> list = new ArrayList<>();
                if(mysaved != null) {
                    List<MyeventItem> myeventItems = mysaved.getMyevent();
                    for (MyeventItem item:myeventItems) {
                        String jenis;
                        if (item.getJenis() == 1) {
                            jenis = "Seminar";
                        } else {
                            jenis = "Webinar";
                        }
                        saved saved_account = new saved(jenis,
                                item.getNama(),
                                item.getNamaEvent(),
                                "Event : " + item.getDate(),
                                R.drawable.sem2);
                        list.add(saved_account);
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "Cek Koneksi Internet Anda", Toast.LENGTH_SHORT).show();
                }
                save_adapt.setListSaved(list);
            }

            @Override
            public void onFailure(Call<EventAccount> call, Throwable t) {

            }
        });
//        save_adapt.setListSaved(getDataSaved());

        rvsaved_list = findViewById(R.id.saved_list);
        rvsaved_list.setAdapter(save_adapt);
        GridLayoutManager gridmanage= new GridLayoutManager(this, 2,GridLayoutManager.HORIZONTAL, false);
        rvsaved_list.setLayoutManager(gridmanage);
    }
    public ArrayList<event> getDataEvent() {
        ArrayList<event> list = new ArrayList<>();
        list.add(new event("seminar", "Teknologi", "Pentingnya Teknologi Di Zaman Sekarang","Event : 8-10-2021", R.drawable.sem2));
        list.add(new event("Webinar", "Pendidikan", "Sosialisasi Jaringan Komputer", "Event : 10-10-2021", R.drawable.sem3));
        list.add(new event("Webinar", "Pendidikan", "Menjaga Kesehatan Mata","Event : 1-10-2021", R.drawable.web1));
        list.add(new event("Webinar", "Technopreneur", "Kembangkan Bisnis Dari Sekarang","Event : 10-12-2021", R.drawable.sem4));

        return list;
    }
    public ArrayList<saved> getDataSaved() {
        ArrayList<saved> list = new ArrayList<>();
        list.add(new saved("Seminar", "Pendidikan", "Pentingnya Teknologi Di Era 4.0","Event : 2-10-2021",R.drawable.sem2));
        list.add(new saved("Seminar", "Kesehatan", "Menjaga Kesehatan Dengan Berolahraga","Event : 3-2-2021",R.drawable.sem3));
        list.add(new saved("Seminar", "Technopreneur", "Berbisnis Dengan Modal Kecil","Event : 10-10-2021",R.drawable.web1));
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
        SharedPreferences preferences = getSharedPreferences(
                "com.example.smarthunter",
                MODE_PRIVATE
        );

        String token = preferences.getString("TOKEN", null);

        EventClient EventClient = RetrofitClient.getEventClient();

        Call<Message> call = EventClient.getOut(token);
        call.enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                Message pesan = response.body();
                if(pesan != null) {
                    Intent in = new Intent(getApplicationContext(), Login.class);
                    startActivity(in);
                    Toast.makeText(getApplicationContext(), "Anda berhasil logout", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "Logout Gagal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Message> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Gagal Mengakses Server", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onClick() {
        Intent detailseminar_upload = new Intent(this, DetailSeminarUpload.class);
        startActivity(detailseminar_upload);
    }


}