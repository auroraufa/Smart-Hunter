package com.example.smarthunter.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smarthunter.R;
import com.example.smarthunter.model.pencarianEvent;

import java.util.ArrayList;

public class pencarianAdapter
        extends RecyclerView.Adapter<pencarianAdapter.pencarianViewHolder>{
    private pencarianViewHolder viewHolder;

    public class pencarianViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView jenis_event_pen,kategori_acara_pen,judul_acara_pen,tanggal_event_pen;
        ImageView ImagePoster_pen;

        public pencarianViewHolder(@NonNull View itemView) {
            super(itemView);
            jenis_event_pen = itemView.findViewById(R.id.jenis_event_pen);
            kategori_acara_pen =  itemView.findViewById(R.id.kategori_acara_pen);
            judul_acara_pen = itemView.findViewById(R.id.judul_acara_pen);
            tanggal_event_pen = itemView.findViewById(R.id.tanggal_event_pen);
            ImagePoster_pen = itemView.findViewById(R.id.ImagePoster_pen);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (listener != null){
                listener.onClick();
            }
        }
    }
    public interface OnpencarianViewHolderClick{
        void onClick();
    }

    public void setListener(pencarianAdapter.OnpencarianViewHolderClick listener){
        this.listener = listener;
    }

    pencarianAdapter.OnpencarianViewHolderClick listener = null;

    ArrayList<pencarianEvent> listpencarian= new ArrayList<>();

    public void setListpencarian(ArrayList<pencarianEvent> listpencarian) {
        this.listpencarian = listpencarian;
    }


    @NonNull
    @Override
    public pencarianAdapter.pencarianViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_pencarian, parent, false);
        pencarianAdapter.pencarianViewHolder viewHolder = new pencarianAdapter.pencarianViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull pencarianViewHolder holder, int position) {
        pencarianEvent pen = listpencarian.get(position);
        viewHolder.jenis_event_pen.setText(pen.jenis_pen);
        viewHolder.judul_acara_pen.setText(pen.judul_pen);
        viewHolder.tanggal_event_pen.setText(pen.event_pen);
        viewHolder.kategori_acara_pen.setText(pen.kategori_pen);
        viewHolder.ImagePoster_pen.setImageResource(pen.poster_pen.intValue());

    }

    @Override
    public int getItemCount() {
        return listpencarian.size();
    }
}

