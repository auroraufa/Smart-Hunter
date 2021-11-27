package com.example.smarthunter.model;

public class event {

    public String nama_event;
    public String jenis_event;
    public String detail_event;
    public Integer image_poster;

    public event(String nama_event, String jenis_event, String detail_event, Integer image_poster) {
        this.nama_event = nama_event;
        this.jenis_event = jenis_event;
        this.detail_event = detail_event;
        this.image_poster = image_poster;
    }
}
