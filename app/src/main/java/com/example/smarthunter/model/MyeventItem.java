package com.example.smarthunter.model;

import com.google.gson.annotations.SerializedName;

public class MyeventItem{

    @SerializedName("date")
    private String date;

    @SerializedName("nama")
    private String nama;

    @SerializedName("jenis")
    private Integer jenis;

    @SerializedName("nama_event")
    private String namaEvent;

    public void setDate(String date){
        this.date = date;
    }

    public String getDate(){
        return date;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public String getNama(){
        return nama;
    }

    public void setJenis(Integer jenis){
        this.jenis = jenis;
    }

    public Integer getJenis(){
        return jenis;
    }

    public void setNamaEvent(String namaEvent){
        this.namaEvent = namaEvent;
    }

    public String getNamaEvent(){
        return namaEvent;
    }
}