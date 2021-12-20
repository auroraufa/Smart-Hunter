package com.example.smarthunter.model;

import com.google.gson.annotations.SerializedName;

public class FavoriteItem{

    @SerializedName("date")
    private String date;

    @SerializedName("nama")
    private String nama;

    @SerializedName("jenis")
    private Integer jenis;

    @SerializedName("nama_event")
    private String namaEvent;

    public String getDate(){
        return date;
    }

    public String getNama(){
        return nama;
    }

    public Integer getJenis(){
        return jenis;
    }

    public String getNamaEvent(){
        return namaEvent;
    }
}