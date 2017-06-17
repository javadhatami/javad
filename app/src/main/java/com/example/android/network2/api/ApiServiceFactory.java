package com.example.android.network2.api;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by javad on 6/15/2017 AD.
 */
public class ApiServiceFactory {

    public Retrofit createService(){

        //khate paieen haman ghesmate aval ya sabete requestemun hastesh
        String baseUrl = "https://api.github.com/";


        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        //j
        Retrofit.Builder builder =
                new Retrofit.Builder()
                        .baseUrl(baseUrl)
                        .addConverterFactory(GsonConverterFactory.create());
        //h
        Retrofit retrofit = builder.client(okHttpClient.build()).build();

        return retrofit;

    }
}
