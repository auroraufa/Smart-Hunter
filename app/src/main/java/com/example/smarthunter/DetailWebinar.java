package com.example.smarthunter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailWebinar extends AppCompatActivity {

    ImageView back_detailwebinar, ImagePoster_pen;
    TextView jenis,kategori_event,nama_event, tanggal, waktu, tanggal_dl, tiket, penyelenggara, deskripsi, syarat, benefit;

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

        back_detailwebinar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}