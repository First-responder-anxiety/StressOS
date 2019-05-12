package com.example.stressos.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroFitClient {
    private static final String BASE_URL = "http://10.13.179.113/MyApi/public/";
    private static RetroFitClient mInstance;
    private static Retrofit retrofit;

     private RetroFitClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized RetroFitClient getInstance() {
        if (mInstance == null) {
            mInstance = new RetroFitClient();
        }
        return mInstance;
    }

    public Api getApi() {
        return retrofit.create(Api.class);
    }
}
