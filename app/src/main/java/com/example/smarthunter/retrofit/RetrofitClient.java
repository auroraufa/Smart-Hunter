package com.example.smarthunter.retrofit;

import androidx.annotation.NonNull;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    @NonNull
    public static eventClient getEventClient() {
        //Buat object client retrofit
        String API_BASE_URL = "https://smart-hunter.herokuapp.com/";

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        eventClient eventClient = retrofit.create(com.example.smarthunter.retrofit.eventClient.class);
        return eventClient;
    }
}
