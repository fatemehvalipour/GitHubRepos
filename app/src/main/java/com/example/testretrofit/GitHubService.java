package com.example.testretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubService {
    @GET("/users/{user}/repos")
    Call<List<RetroRepo>> listRepos(@Path("user") String user);
}
