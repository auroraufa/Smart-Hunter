package com.example.smarthunter.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class KategoriList{

    @SerializedName("kategori")
    private List<KategoriItem> kategori;

    public List<KategoriItem> getKategori(){
        return kategori;
    }
}