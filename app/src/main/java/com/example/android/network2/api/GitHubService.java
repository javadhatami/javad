package com.example.android.network2.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubService {
    @GET("users/{user}/repos")
    Call<List<GitHubJsonModel>> getRepo(
            @Path("user") String user
    );
}
//methode getRepo listi az GitHubJsonModel barmigardanad