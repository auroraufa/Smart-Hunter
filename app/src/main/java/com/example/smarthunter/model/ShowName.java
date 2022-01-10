package com.example.smarthunter.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ShowName{

    @SerializedName("user")
    private List<UserItem> user;

    public List<UserItem> getUser(){
        return user;
    }
}