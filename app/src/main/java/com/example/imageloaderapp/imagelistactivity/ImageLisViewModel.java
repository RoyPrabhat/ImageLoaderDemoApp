package com.example.imageloaderapp.imagelistactivity;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.imageloaderapp.model.Image;
import com.example.imageloaderapp.model.ImagesRepository;

import java.util.List;

public class ImageLisViewModel extends ViewModel {

    private MutableLiveData<List<Image>> imageList;
    private ImagesRepository imagesRepository;

    public void init() {
        if (imageList != null) {
            return;
        }
        imagesRepository = ImagesRepository.getInstance();
        imageList = imagesRepository.getImages();
    }

    public LiveData<List<Image>> getImagesList() {
        return imageList;
    }

}
