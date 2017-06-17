package com.example.android.network2.data;

import com.example.android.network2.api.ApiServiceFactory;
import com.example.android.network2.api.GitHubJsonModel;
import com.example.android.network2.api.GitHubService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * Created by javad on 6/15/2017 AD.
 */
public class GitHubData {
    public Call<List<GitHubJsonModel>> getRepo(){
        //j
        ApiServiceFactory serviceFactory = new ApiServiceFactory();
        //h
        Retrofit retrofit = serviceFactory.createService();
        //k
        GitHubService service = retrofit.create(GitHubService.class);

        return service.getRepo("fs-opensource");
    }
}
