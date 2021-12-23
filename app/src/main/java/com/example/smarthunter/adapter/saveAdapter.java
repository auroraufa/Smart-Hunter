package com.example.smarthunter.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smarthunter.R;
import com.example.smarthunter.model.saved;

import java.util.ArrayList;

public class saveAdapter
        extends RecyclerView.Adapter<saveAdapter.savedViewHolder>{

    public class savedViewHolder extends RecyclerView.ViewHolder{

        TextView mysave_nama,mysave_jenis,mysave_tanggal,mysave_judul,mysave_detail;
        ImageView mysave_post;

        public savedViewHolder(@NonNull View itemView){
            super(itemView);
            mysave_nama= itemView.findViewById(R.id.nama_sv);
            mysave_jenis =  itemView.findViewById(R.id.jenis_sv);
            mysave_judul = itemView.findViewById(R.id.judul_sv);
            mysave_tanggal = itemView.findViewById(R.id.tanggal_sv);
            mysave_post = itemView.findViewById(R.id.image_saved);

        }
    }
    ArrayList<saved> listSaved = new ArrayList<>();
    public void setListSaved(ArrayList<saved> listSaved) {
        this.listSaved = listSaved;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public savedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_saved, parent, false);
        saveAdapter.savedViewHolder viewHolder = new saveAdapter.savedViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull savedViewHolder viewHolder, int position) {
        saved mysv = listSaved.get(position);
        viewHolder.mysave_nama.setText(mysv.nama_save);
        viewHolder.mysave_jenis.setText(mysv.jenis_save);
        viewHolder.mysave_judul.setText(mysv.judul_save);
        viewHolder.mysave_tanggal.setText(mysv.tanggal_save);
//        viewHolder.mysave_post.setImageResource(mysv.image_save.intValue());

    }

    @Override
    public int getItemCount() {
        return listSaved.size(); }
}
