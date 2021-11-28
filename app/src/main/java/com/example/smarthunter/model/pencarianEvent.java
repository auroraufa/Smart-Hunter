package com.example.smarthunter.model;

public class pencarianEvent {
    public String jenis_pen;
    public String judul_pen;
    public String event_pen;
    public String kategori_pen;
    public Integer poster_pen;

    public pencarianEvent(String jenis_pen, String judul_pen, String event_pen, String kategori_pen, Integer poster_pen) {
        this.jenis_pen = jenis_pen;
        this.judul_pen = judul_pen;
        this.event_pen = event_pen;
        this.kategori_pen = kategori_pen;
        this.poster_pen = poster_pen;
    }
}
