package com.example.smarthunter.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smarthunter.R;
import com.example.smarthunter.model.webinarEvent;

import java.util.ArrayList;

public class webinarAdapter
        extends RecyclerView.Adapter<webinarAdapter.webinarViewHolder>{

    public class webinarViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView jenis_event_web,kategori_acara_web,judul_acara_web,tanggal_event_web;
        ImageView ImagePoster_web;

        public webinarViewHolder(@NonNull View itemView) {
            super(itemView);
            jenis_event_web = itemView.findViewById(R.id.jenisacara_web);
            kategori_acara_web =  itemView.findViewById(R.id.kategori_acara_web);
            judul_acara_web = itemView.findViewById(R.id.judul_acara_web);
            tanggal_event_web = itemView.findViewById(R.id.tanggal_event_web);
            ImagePoster_web = itemView.findViewById(R.id.image_poster_web);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (listener != null) {
                listener.onClick();
            }
        }
    }

    public interface OnWebinarViewHolderClick{
        void onClick();
    }

    public void setListener(webinarAdapter.OnWebinarViewHolderClick listener){
        this.listener = listener;
    }

    webinarAdapter.OnWebinarViewHolderClick listener = null;

    ArrayList <webinarEvent> listWebinar = new ArrayList<>();

    public void setListWebinar(ArrayList<webinarEvent> listWebinar) {
        this.listWebinar = listWebinar;
    }

    @NonNull
    @Override
    public webinarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_webinar, parent, false);
        webinarViewHolder viewHolder = new webinarViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull webinarViewHolder viewHolder, int position) {
        webinarEvent web = listWebinar.get(position);
        viewHolder.jenis_event_web.setText(web.jenis_web);
        viewHolder.judul_acara_web.setText(web.judul_web);
        viewHolder.tanggal_event_web.setText(web.event_web);
        viewHolder.kategori_acara_web.setText(web.kategori_web);
        viewHolder.ImagePoster_web.setImageResource(web.poster_web.intValue());

    }

    @Override
    public int getItemCount() {

        return listWebinar.size();
    }
}
