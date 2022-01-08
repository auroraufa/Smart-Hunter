package com.example.smarthunter.model;

import com.google.gson.annotations.SerializedName;

public class KategoriItem {

    @SerializedName("nama")
    private String nama;

    @SerializedName("id")
    private int id;

    @SerializedName("foto")
    private String foto;


    public String getNama() {
        return nama;
    }

    public int getId() {
        return id;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }


}