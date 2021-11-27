package com.example.smarthunter.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smarthunter.R;
import com.example.smarthunter.model.seminarEvent;

import java.util.ArrayList;

public class seminarAdapter
        extends RecyclerView.Adapter<seminarAdapter.seminarViewHolder>{

    public class seminarViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView jenis_event_sem,kategori_acara_sem,judul_acara_sem,tanggal_event_sem;
        ImageView ImagePoster_sem;

        public seminarViewHolder(@NonNull View itemView) {
            super(itemView);
            jenis_event_sem = itemView.findViewById(R.id.jenisacara_sem);
            kategori_acara_sem =  itemView.findViewById(R.id.kategori_acara_sem);
            judul_acara_sem = itemView.findViewById(R.id.judul_acara_sem);
            tanggal_event_sem = itemView.findViewById(R.id.tanggal_event_sem);
            ImagePoster_sem = itemView.findViewById(R.id.image_poster_sem);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (listener != null){
                listener.onClick();
            }
        }
    }

    public interface OnSeminarViewHolderClick{
        void onClick();
    }

    public void setListener(OnSeminarViewHolderClick listener){
        this.listener = listener;
    }

    OnSeminarViewHolderClick listener = null;

        ArrayList <seminarEvent> listSeminar = new ArrayList<>();

        public void setListSeminar(ArrayList<seminarEvent> listSeminar) {
            this.listSeminar = listSeminar;
    }

    @NonNull
    @Override
    public seminarAdapter.seminarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_seminar, parent, false);
        seminarViewHolder viewHolder = new seminarViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull seminarViewHolder viewHolder, int position) {
        seminarEvent sem = listSeminar.get(position);
        viewHolder.jenis_event_sem.setText(sem.jenis_sem);
        viewHolder.judul_acara_sem.setText(sem.judul_sem);
        viewHolder.tanggal_event_sem.setText(sem.event_sem);
        viewHolder.kategori_acara_sem.setText(sem.kategori_sem);
        viewHolder.ImagePoster_sem.setImageResource(sem.poster_sem.intValue());
    }

    @Override
    public int getItemCount() {
        return listSeminar.size();
    }
}
