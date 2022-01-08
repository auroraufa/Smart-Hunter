package com.example.smarthunter.retrofit;

import androidx.annotation.NonNull;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    public String API_BASE_URL = "https://smart-hunter.herokuapp.com/";

    @NonNull
    public static EventClient getEventClient() {
        //Buat object client retrofit
        String API_BASE_URL = "https://smart-hunter.herokuapp.com/";

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        EventClient eventClient = retrofit.create(EventClient.class);
        return eventClient;
    }
}
