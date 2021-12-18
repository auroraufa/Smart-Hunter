package com.example.smarthunter.retrofit;

import com.example.smarthunter.model.DataLogin;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface eventClient {

    @POST("login")
    Call<DataLogin> checkLogin(@Field("username") String username, @Field("password") String password);
}
