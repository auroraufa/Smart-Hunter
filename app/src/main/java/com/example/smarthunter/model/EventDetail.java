package com.example.smarthunter.model;

import com.google.gson.annotations.SerializedName;

public class EventDetail{

    @SerializedName("detail_event")
    private DetailEvent detailEvent;

    public DetailEvent getDetailEvent(){
        return detailEvent;
    }
}