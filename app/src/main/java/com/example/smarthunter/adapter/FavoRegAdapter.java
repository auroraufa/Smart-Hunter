package com.example.smarthunter.adapter;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smarthunter.R;
import com.example.smarthunter.model.FavoReg;
import com.example.smarthunter.model.KategoriItem;
import com.google.android.gms.common.util.ArrayUtils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class FavoRegAdapter extends RecyclerView.Adapter<FavoRegAdapter.FavoRegViewHolder> {

    Integer count = 0;
    ArrayList<FavoReg> list = new ArrayList<>();
    List<Integer> kategoris = new ArrayList<>();

    public class FavoRegViewHolder extends RecyclerView.ViewHolder{
        ImageView icon;
        TextView nama;
        FrameLayout frameBg;

        public FavoRegViewHolder(@NonNull View itemView) {
            super(itemView);

            icon = itemView.findViewById(R.id.icon_kategori);
            nama = itemView.findViewById(R.id.nama_kategori);
            frameBg = itemView.findViewById(R.id.frameBg);
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if (count<3){
//                        if (frameBg.getVisibility()==View.GONE){
//                            frameBg.setVisibility(View.VISIBLE);
//                            count = count +1;
//                        }else{
//                            frameBg.setVisibility(View.GONE);
//                            count = count -1;
//                        }
//                    }else{
//                        if(frameBg.getVisibility()==View.VISIBLE){
//                            frameBg.setVisibility(View.GONE);
//                            count = count -1;
//                        }
//                    }
//
//
//                }
//            });
        }

//        public void onClick(View v) {
//            if (clickObject != null){
//                clickObject.onClick();
//            }
//        }
    }

    public interface OnFavoRegViewHolderClick{
        void onClick(List<Integer> kategorilist);
    }

    OnFavoRegViewHolderClick clickObject = null;

    public void setClickObject(OnFavoRegViewHolderClick clickObject){
        this.clickObject =clickObject;
    }

    public void setList(ArrayList<FavoReg> list){
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FavoRegViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_favorite_register,parent,false);
        FavoRegAdapter.FavoRegViewHolder viewHolder =new FavoRegAdapter.FavoRegViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FavoRegViewHolder holder, int position) {
        FavoReg favoReg =list.get(position);
        holder.nama.setText(favoReg.name);
//        holder.itemView.setBackgroundColor(Color.WHITE);
//        holder.itemView.setBackgroundColor(favoReg.isSelected() ? Color.GRAY : Color.WHITE);
        Picasso.get().
                load(favoReg.icon).
                into(holder.icon);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                favoReg.setSelected(!favoReg.isSelected());
                if (count<3){
                    if (holder.frameBg.getVisibility()==View.GONE){
                        holder.frameBg.setVisibility(View.VISIBLE);
                        count = count +1;
                        kategoris.add(favoReg.id);
                    }else{
                        holder.frameBg.setVisibility(View.GONE);
                        count = count -1;
                        kategoris = removeItem(kategoris,favoReg.id);
                    }
                }else{
                    if(holder.frameBg.getVisibility()==View.VISIBLE){
                        holder.frameBg.setVisibility(View.GONE);
                        count = count -1;
                        kategoris = removeItem(kategoris,favoReg.id);
                    }
                }
//                kategoris.add(favoReg.id,favoReg.id);
                Log.i("kategoris",kategoris.toString());
                clickObject.onClick(kategoris);
            }
        });
//        if (holder.count<=3){
//            holder.itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    favoReg.setSelected(!favoReg.isSelected());
//                    holder.itemView.setBackgroundColor(favoReg.isSelected() ? Color.GRAY : Color.WHITE);
//                    holder.count = (favoReg.isSelected() ? holder.count+1 : holder.count-1) ;
//                }
//            });
//        }else{
//
//        }


    }

    public static List<Integer> removeItem(List<Integer> list,Integer value){
        Integer index = list.indexOf(value);
        List<Integer> result = new ArrayList<>();

        for (Integer item : list){
            if (value!=item){
                result.add(item);
            }
        }
        return result;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
