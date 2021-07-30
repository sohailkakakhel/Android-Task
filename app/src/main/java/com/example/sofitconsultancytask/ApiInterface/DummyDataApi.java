package com.example.sofitconsultancytask.ApiInterface;

import com.example.sofitconsultancytask.ApiResponse.DumyDataResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DummyDataApi {
    @GET("/posts")
    Call<List<DumyDataResponse>> getDumyData();
}
