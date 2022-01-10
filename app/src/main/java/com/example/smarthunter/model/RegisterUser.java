package com.example.smarthunter.model;

import com.google.gson.annotations.SerializedName;

public class RegisterUser{

    @SerializedName("message")
    private String message;

    @SerializedName("token")
    private String token;

    @SerializedName("idUser")
    private Integer idUser;

    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    public String getToken() {
        return token;
    }

    public Integer getIdUser() {
        return idUser;
    }
}