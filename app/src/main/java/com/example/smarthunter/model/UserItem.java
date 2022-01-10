package com.example.smarthunter.model;

import com.google.gson.annotations.SerializedName;

public class UserItem{

    @SerializedName("nama")
    private String nama;

    public void setNama(String nama){
        this.nama = nama;
    }

    public String getNama(){
        return nama;
    }
}