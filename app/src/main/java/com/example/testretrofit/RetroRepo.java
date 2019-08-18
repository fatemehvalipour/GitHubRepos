package com.example.testretrofit;

import com.google.gson.annotations.SerializedName;

public class RetroRepo {
    @SerializedName("name")
    private String name;
    @SerializedName("language")
    private String language;

    public RetroRepo(String name, String language) {
        this.name = name;
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public String getLanguage() {
        return language;
    }
}
