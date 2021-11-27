package com.example.smarthunter.model;

public class notifikasiEvent {

    public String jenis;
    public String kategori;
    public String judul;
    public String event;
    public Integer poster;

    public notifikasiEvent(String jenis, String kategori, String judul, String event, Integer poster) {
        this.jenis = jenis;
        this.kategori = kategori;
        this.judul = judul;
        this.event = event;
        this.poster = poster;
    }

}
