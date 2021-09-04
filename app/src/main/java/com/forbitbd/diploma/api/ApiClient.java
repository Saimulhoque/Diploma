package com.forbitbd.diploma.api;


import com.forbitbd.diploma.model.Result;

import retrofit2.Call;
import retrofit2.http.Body;

import retrofit2.http.POST;

public interface ApiClient {

    @POST("/bteb/result")
    Call<Result> getResult(@Body Result data);


}
