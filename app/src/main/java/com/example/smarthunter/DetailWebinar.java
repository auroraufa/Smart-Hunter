package com.example.smarthunter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.smarthunter.model.DetailEvent;
import com.example.smarthunter.model.EventDetail;
import com.example.smarthunter.retrofit.EventClient;
import com.example.smarthunter.retrofit.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailWebinar extends AppCompatActivity {

    ImageView back_detailwebinar, ImagePoster_pen;
    TextView jenis,kategori_event,nama_event, tanggal, waktu, tanggal_dl, tiket, penyelenggara, deskripsi, syarat, benefit;
    Integer eventId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_webinar);

        ImagePoster_pen = findViewById(R.id.ImagePoster_pen);
        jenis = findViewById(R.id.jenis);
        kategori_event = findViewById(R.id.kategori_event);
        nama_event = findViewById(R.id.nama_event);
        tanggal = findViewById(R.id.tanggal);
        waktu = findViewById(R.id.waktu);
        tanggal_dl = findViewById(R.id.tanggal_dl);
        tiket = findViewById(R.id.tiket);
        penyelenggara = findViewById(R.id.penyelenggara);
        deskripsi = findViewById(R.id.deskripsi);
        syarat = findViewById(R.id.syarat);
        benefit = findViewById(R.id.benefit);

        back_detailwebinar = (ImageView) findViewById(R.id.back_detailwebinar);

        eventId = getIntent().getIntExtra("eventId",0);

        SharedPreferences preferences = getSharedPreferences("com.example.smarthunter",MODE_PRIVATE);
        String token = preferences.getString("TOKEN","");

        EventClient eventClient = RetrofitClient.getEventClient();

        Call<EventDetail> call = eventClient.getDetail(token,1);
        call.enqueue(new Callback<EventDetail>() {
            @Override
            public void onResponse(Call<EventDetail> call, Response<EventDetail> response) {
                EventDetail eventDetail = response.body();
                if(eventDetail!=null){
                    DetailEvent detailEvent = eventDetail.getDetailEvent();
                    nama_event.setText(detailEvent.getNamaEvent());

                }
            }

            @Override
            public void onFailure(Call<EventDetail> call, Throwable t) {

            }
        });

        back_detailwebinar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}