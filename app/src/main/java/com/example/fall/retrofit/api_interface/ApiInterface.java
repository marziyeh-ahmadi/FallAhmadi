package com.example.fall.retrofit.api_interface;

import com.example.fall.retrofit.response.GetResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiInterface {

    @Multipart
    @POST("get.php")
    Call<GetResponse> get(
            @Part("email") RequestBody email, @Part("password") RequestBody password
    );
}
