package com.example.fall.retrofit.api_interface;

import com.example.fall.retrofit.response.Faal;
import com.example.fall.retrofit.response.Poet;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {


    @GET("hafez/faal")
    Call<Faal> showFaal();

    @GET("poets")
    Call<List<Poet>> getPoetList();
}
