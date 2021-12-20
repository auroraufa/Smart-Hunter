package com.example.smarthunter.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smarthunter.R;
import com.example.smarthunter.model.favoriteEvent;

import java.util.ArrayList;

public class favoriteAdapter
        extends RecyclerView.Adapter<favoriteAdapter.favoriteViewHolder>{

    public class favoriteViewHolder extends RecyclerView.ViewHolder {

        TextView jenis_event_fav,kategori_acara_fav,judul_acara_fav,tanggal_event_fav;
        ImageView ImagePoster_fav;

        public favoriteViewHolder(@NonNull View itemView) {
            super(itemView);
            jenis_event_fav = itemView.findViewById(R.id.jenisacara_fav);
            kategori_acara_fav =  itemView.findViewById(R.id.kategori_acara_fav);
            judul_acara_fav = itemView.findViewById(R.id.judul_acara_fav);
            tanggal_event_fav = itemView.findViewById(R.id.tanggal_event_fav);
            ImagePoster_fav = itemView.findViewById(R.id.image_poster_fav);
        }
    }

    ArrayList<favoriteEvent> listFavorite = new ArrayList<>();

    public void setListFavorite(ArrayList<favoriteEvent> listFavorite) {
        this.listFavorite = listFavorite;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public favoriteAdapter.favoriteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_favorite, parent, false);
        favoriteViewHolder viewHolder = new favoriteViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull favoriteViewHolder viewHolder, int position) {
        favoriteEvent fav = listFavorite.get(position);
        viewHolder.jenis_event_fav.setText(fav.jenis_fav);
        viewHolder.judul_acara_fav.setText(fav.judul_fav);
        viewHolder.tanggal_event_fav.setText(fav.event_fav);
        viewHolder.kategori_acara_fav.setText(fav.kategori_fav);
//        viewHolder.ImagePoster_fav.setImageResource(fav.poster_fav.intValue());

    }

    @Override
    public int getItemCount() {
        return listFavorite.size();
    }
}
