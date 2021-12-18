package com.example.smarthunter.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class EventJenisList{

    @SerializedName("event")
    private List<EventItem> event;

    public List<EventItem> getEvent(){
        return event;
    }
}