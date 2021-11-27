package com.example.smarthunter.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smarthunter.R;
import com.example.smarthunter.model.notifikasiEvent;

import java.util.ArrayList;

public class NotifikasiAdapter
        extends RecyclerView.Adapter<NotifikasiAdapter.NotifikasiViewHolder >{

    public class NotifikasiViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView jenis_event,kategori_acara,judul_acara,tanggal_event;
        ImageView ImagePoster;

        public NotifikasiViewHolder(@NonNull View itemView) {
            super(itemView);
            jenis_event = itemView.findViewById(R.id.jenisacara);
            kategori_acara =  itemView.findViewById(R.id.kategori_acara);
            judul_acara = itemView.findViewById(R.id.judul_acara);
            tanggal_event = itemView.findViewById(R.id.tanggal_event);
            ImagePoster = itemView.findViewById(R.id.image_poster);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            if (listener != null){
                listener.onClick();
            }
        }
    }

    public interface OnNotifikasiViewHolderClick{
        void onClick();
    }

    public void setListener(NotifikasiAdapter.OnNotifikasiViewHolderClick listener){
        this.listener = listener;
    }

    OnNotifikasiViewHolderClick listener = null;

    ArrayList<notifikasiEvent> listNotifikasi = new ArrayList<>();

    public void setListNotifikasi(ArrayList<notifikasiEvent> listNotifikasi) {
        this.listNotifikasi = listNotifikasi;
    }

    @NonNull
    @Override
    public NotifikasiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_notifikasi, parent, false);
        NotifikasiViewHolder viewHolder = new NotifikasiViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NotifikasiViewHolder viewHolder, int position) {
        notifikasiEvent notif = listNotifikasi.get(position);
        viewHolder.jenis_event.setText(notif.jenis);
        viewHolder.judul_acara.setText(notif.judul);
        viewHolder.tanggal_event.setText(notif.event);
        viewHolder.kategori_acara.setText(notif.kategori);
        viewHolder.ImagePoster.setImageResource(notif.poster.intValue());

    }

    @Override
    public int getItemCount() {

        return listNotifikasi.size();
    }


}
