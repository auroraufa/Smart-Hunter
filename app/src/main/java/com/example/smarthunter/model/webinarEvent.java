package com.example.smarthunter.model;

public class webinarEvent {

    public String jenis_web;
    public String kategori_web;
    public String judul_web;
    public String event_web;
    public Integer poster_web;

    public webinarEvent(String jenis_web, String kategori_web, String judul_web, String event_web, Integer poster_web) {
        this.jenis_web = jenis_web;
        this.kategori_web = kategori_web;
        this.judul_web = judul_web;
        this.event_web = event_web;
        this.poster_web = poster_web;
    }


}
