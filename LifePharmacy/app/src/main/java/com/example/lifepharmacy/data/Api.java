package com.example.lifepharmacy.data;

import com.example.lifepharmacy.ModelResponse.CreatePres.CreatePrescriptionResponse;
import com.example.lifepharmacy.ModelResponse.CreatePresRequest;
import com.example.lifepharmacy.ModelResponse.ImageResponse.ImageResponseBody;
import com.example.lifepharmacy.ModelResponse.MyOrder.MyOrderResponse;
import com.example.lifepharmacy.ModelResponse.SearchProduct.SearchProductResponse;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface Api {

    String BASE_URL = "https://lifedev.healthlineme.com/api/bot/";

    @GET("product/search/")
    Call<SearchProductResponse> getProducts(
                   @Query("term") String term ,@Header("Authorization") String auth);


    @GET("recent-orders/971526050392")
    Call<MyOrderResponse> getOrder(@Header("Authorization") String auth);


    @Multipart
    @POST("files/upload")
    Call<ImageResponseBody> uploadImage(
            @Part MultipartBody.Part part,
            @Header("Authorization") String auth);

    @POST("prescription/create")
    Call<CreatePrescriptionResponse> createRequest(@Body CreatePresRequest createPresRequest,
                                                   @Header("Authorization") String auth);
}