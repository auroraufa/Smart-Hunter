package com.example.smarthunter.model;

public class event {

    public String nama_event;
    public String jenis_event;
    public String detail_event;
    public String judul_event;
    public String tanggal_event;
    public Integer image_save;

    public event(String nama_event, String jenis_event, String detail_event,String judul_event, String tanggal_event, Integer image_save) {
        this.nama_event = nama_event;
        this.jenis_event = jenis_event;
        this.detail_event = detail_event;
        this.judul_event = judul_event;
        this.tanggal_event = tanggal_event;
        this.image_save = image_save;
    }
}
