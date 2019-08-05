package com.example.imageloaderapp.api;

import com.example.imageloaderapp.constants.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ImagesApiClient {

    private static ImagesApiClient instance;


    private ImagesService imagesService;

    public static ImagesApiClient getInstance() {
        if (instance == null) {
            instance = new ImagesApiClient();
        }

        return instance;
    }

    private ImagesApiClient() {
        buildRetrofit();
    }

    private void buildRetrofit() {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        imagesService = retrofit.create(ImagesService.class);
    }

    public ImagesService getImagesService() {
        return imagesService;
    }

}
