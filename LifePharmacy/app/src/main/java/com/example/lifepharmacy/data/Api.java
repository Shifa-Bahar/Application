package com.example.lifepharmacy.data;

import com.example.lifepharmacy.ModelResponse.MyOrderResponse;
import com.example.lifepharmacy.ModelResponse.SearchProductResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {

    String BASE_URL = "https://lifedev.healthlineme.com/api/bot/";

    @GET("product/search/")
    Call<SearchProductResponse> getProducts(
                   @Query("term") String term ,@Header("Authorization") String auth);


    @GET("recent-orders/971526050392")
    Call<MyOrderResponse> getOrder(@Header("Authorization") String auth);

}