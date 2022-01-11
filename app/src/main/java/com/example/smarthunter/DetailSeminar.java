package com.example.smarthunter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.lang.UCharacter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.smarthunter.model.DetailEvent;
import com.example.smarthunter.model.EventDetail;
import com.example.smarthunter.retrofit.EventClient;
import com.example.smarthunter.retrofit.RetrofitClient;

import java.awt.font.NumericShaper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailSeminar extends AppCompatActivity {

    ImageView back_detailseminar, Poster;
    Button daftarSeminar;
    TextView jenis,kategori_event,nama_event, tanggal, waktu, tanggal_dl, tiket, harga, penyelenggara, deskripsi, syarat, benefit;
    Integer eventId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_seminar);

        Poster = findViewById(R.id.Poster);
        jenis = findViewById(R.id.jenis);
        kategori_event = findViewById(R.id.kategori_event);
        nama_event = findViewById(R.id.nama_event);
        tanggal = findViewById(R.id.tanggal);
        waktu = findViewById(R.id.waktu);
        tanggal_dl = findViewById(R.id.tanggal_dl);
        tiket = findViewById(R.id.tiket);
        harga = findViewById(R.id.harga);
        penyelenggara = findViewById(R.id.penyelenggara);
        deskripsi = findViewById(R.id.deskripsi);
        syarat = findViewById(R.id.syarat);
        benefit = findViewById(R.id.benefit);
        daftarSeminar = findViewById(R.id.daftarSeminar);

        back_detailseminar= (ImageView) findViewById(R.id.back_detailseminar);

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
//                    ImagePoster_pen.setImageURI(detailEvent.getFoto());
//                    jenis.setText(detailEvent.getJenis());
//                    kategori_event.setText(detailEvent.getKategoriId());
                    nama_event.setText(detailEvent.getNamaEvent());
                    tanggal.setText(detailEvent.getDate());
//                    waktu.setText((Integer) detailEvent.getWaktu());
//                    tanggal_dl.setText((Integer) detailEvent.getDeadline());
//                    tiket.setText(detailEvent.getTicket());
//                    harga.setText(detailEvent.getHarga());
                    penyelenggara.setText(detailEvent.getPihakPenyelenggara());
                    deskripsi.setText(detailEvent.getDeskripsi());
                    syarat.setText(detailEvent.getPersyaratan());
                    benefit.setText(detailEvent.getBenefit());
//                    daftarWebinar.setLinksClickable(detailEvent.getLinkPendaftaran());
                }
            }

            @Override
            public void onFailure(Call<EventDetail> call, Throwable t) {

            }
        });

        back_detailseminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}