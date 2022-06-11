package com.example.fall.retrofit;

public class UnsuccessfulException extends Exception {

    @Override
    public String getMessage() {
        return "Unsuccessful exception";
    }

}