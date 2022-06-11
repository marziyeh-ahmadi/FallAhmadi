package com.example.fall.retrofit.response;

import com.google.gson.annotations.SerializedName;

public class GetResponse {
    @SerializedName("error")
    public boolean error;
    @SerializedName("error_msg")
    public String error_msg = "خطایی رخ داده است";

}
