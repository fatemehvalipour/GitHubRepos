package com.example.testretrofit;

import com.google.gson.annotations.SerializedName;

public class RetroRepo {
    @SerializedName("name")
    private String name;

    public RetroRepo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
