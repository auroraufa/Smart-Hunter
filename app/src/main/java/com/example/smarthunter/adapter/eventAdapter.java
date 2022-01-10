package com.example.smarthunter.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smarthunter.R;
import com.example.smarthunter.model.event;

import java.util.ArrayList;

public class eventAdapter
        extends RecyclerView.Adapter<eventAdapter.eventViewHolder>{

    public class eventViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView myevent_nama,myevent_jenis,myevent_judul,myevent_tanggal;
        ImageView myevent_poster;

        public eventViewHolder(@NonNull View itemView) {
            super(itemView);
            myevent_nama = itemView.findViewById(R.id.nama_sv);
            myevent_jenis =  itemView.findViewById(R.id.kategori_event);
            myevent_judul = itemView.findViewById(R.id.judul_sv);
            myevent_tanggal = itemView.findViewById(R.id.tanggal_sv);
            myevent_poster = itemView.findViewById(R.id.image_saved);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick (View view) {
            if (listener != null) {
                listener.onClick();
            }
        }
    }

    public interface  OnEventViewHolderClick {
        void onClick();
    }

    public void setListener (OnEventViewHolderClick listener) {
        this.listener = listener;
    }

    OnEventViewHolderClick listener = null;

    ArrayList<event> listEvent = new ArrayList<>();
    public void setListEvent(ArrayList<event> listEvent) {
        this.listEvent = listEvent;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public eventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_event, parent, false);
        eventViewHolder viewHolder = new eventViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull eventViewHolder viewHolder, int position) {
        event myev = listEvent.get(position);
        viewHolder.myevent_nama.setText(myev.nama_event);
        viewHolder.myevent_jenis.setText(myev.jenis_event);
        viewHolder.myevent_judul.setText(myev.judul_event);
        viewHolder.myevent_tanggal.setText(myev.tanggal_event);
//        viewHolder.myevent_poster.setImageResource(myev.image_save.intValue());

    }

    @Override
    public int getItemCount() {
        return listEvent.size(); }

}

