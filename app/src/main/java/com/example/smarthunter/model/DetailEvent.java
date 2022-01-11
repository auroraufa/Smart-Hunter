package com.example.smarthunter.model;

import android.net.Uri;

import com.google.gson.annotations.SerializedName;

public class DetailEvent{

    @SerializedName("persyaratan")
    private String persyaratan;

    @SerializedName("date")
    private String date;

    @SerializedName("ticket")
    private int ticket;

    @SerializedName("latitude")
    private String latitude;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("benefit")
    private String benefit;

    @SerializedName("pihak_penyelenggara")
    private String pihakPenyelenggara;

    @SerializedName("kategori_id")
    private int kategoriId;

    @SerializedName("harga")
    private int harga;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("nama")
    private String nama;

    @SerializedName("foto")
    private String foto;

    @SerializedName("link_pendaftaran")
    private String linkPendaftaran;

    @SerializedName("waktu")
    private Object waktu;

    @SerializedName("jenis")
    private int jenis;

    @SerializedName("id")
    private int id;

    @SerializedName("deskripsi")
    private String deskripsi;

    @SerializedName("deadline")
    private Object deadline;

    @SerializedName("nama_event")
    private String namaEvent;

    @SerializedName("longitude")
    private String longitude;

    public String getPersyaratan(){
        return persyaratan;
    }

    public String getDate(){
        return date;
    }

    public int getTicket(){
        return ticket;
    }

    public String getLatitude(){
        return latitude;
    }

    public String getCreatedAt(){
        return createdAt;
    }

    public String getBenefit(){
        return benefit;
    }

    public String getPihakPenyelenggara(){
        return pihakPenyelenggara;
    }

    public int getKategoriId(){
        return kategoriId;
    }

    public int getHarga(){
        return harga;
    }

    public String getUpdatedAt(){
        return updatedAt;
    }

    public String getNama(){
        return nama;
    }

    public String getFoto(){
        return foto;
    }

    public String getLinkPendaftaran(){
        return linkPendaftaran;
    }

    public Object getWaktu(){
        return waktu;
    }

    public int getJenis(){
        return jenis;
    }

    public int getId(){
        return id;
    }

    public String getDeskripsi(){
        return deskripsi;
    }

    public Object getDeadline(){
        return deadline;
    }

    public String getNamaEvent(){
        return namaEvent;
    }

    public String getLongitude(){
        return longitude;
    }
}