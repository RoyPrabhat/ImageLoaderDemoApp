package com.example.imageloaderapp.api;

import com.example.imageloaderapp.model.Image;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ImagesService {

    @Headers("Accept-Version: v1")
    @GET("/photos")
    Call<List<Image>> getImagesList(@Query("client_id") String clientId);

    @Headers("Accept-Version: v1")
    @GET("/photos/{id}")
    Call<Image> getImageById(@Path("id") String imageId, @Query("client_id") String clientId);

}
