package com.example.imageloaderapp.fullscreenmageactivity;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.imageloaderapp.model.Image;
import com.example.imageloaderapp.model.ImagesRepository;


public class FullScreenViewModel extends ViewModel {

    private MutableLiveData<Image> image;
    private ImagesRepository imagesRepository;
    private String imageId;

    public void init() {
        if (image != null) {
            return;
        }
        imagesRepository = ImagesRepository.getInstance();
        image = imagesRepository.getImagesById(this.imageId);
    }

    public LiveData<Image> getImageById() {
        return image;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }
}
