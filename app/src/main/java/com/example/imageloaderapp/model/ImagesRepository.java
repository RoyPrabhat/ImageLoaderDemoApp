package com.example.imageloaderapp.model;

import androidx.lifecycle.MutableLiveData;

import com.example.imageloaderapp.constants.Constants;
import com.example.imageloaderapp.api.ImagesApiClient;
import com.example.imageloaderapp.api.ImagesService;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ImagesRepository {

    private static ImagesRepository imagesRepository;
    private ImagesService imagesService;

    public static ImagesRepository getInstance() {
        if (imagesRepository == null) {
            imagesRepository = new ImagesRepository();
        }
        return imagesRepository;
    }


    public ImagesRepository() {
        imagesService = ImagesApiClient.getInstance().getImagesService();
    }

    public MutableLiveData<List<Image>> getImages() {

        final MutableLiveData<List<Image>> imageList = new MutableLiveData<>();
        imagesService.getImagesList(Constants.ACCESS_KEY).enqueue(new Callback<List<Image>>() {
            @Override
            public void onResponse(Call<List<Image>> call,
                                   Response<List<Image>> response) {
                if (response.isSuccessful()) {
                    imageList.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Image>> call, Throwable t) {
                imageList.setValue(null);
            }
        });
        return imageList;

    }

    public MutableLiveData<Image> getImagesById(String imageId) {

        final MutableLiveData<Image> image = new MutableLiveData<>();
        imagesService.getImageById(imageId, Constants.ACCESS_KEY).enqueue(new Callback<Image>() {
            @Override
            public void onResponse(Call<Image> call,
                                   Response<Image> response) {
                if (response.isSuccessful()) {
                    image.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<Image> call, Throwable t) {
                image.setValue(null);
            }
        });
        return image;

    }
}
