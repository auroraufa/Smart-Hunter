package com.example.smarthunter.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class EventAccount{

    @SerializedName("myevent")
    private List<MyeventItem> myevent;

    public void setMyevent(List<MyeventItem> myevent){
        this.myevent = myevent;
    }

    public List<MyeventItem> getMyevent(){
        return myevent;
    }
}