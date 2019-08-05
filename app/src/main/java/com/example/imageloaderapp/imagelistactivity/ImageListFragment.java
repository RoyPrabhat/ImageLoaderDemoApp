package com.example.imageloaderapp.imagelistactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.imageloaderapp.R;
import com.example.imageloaderapp.adapter.ImageListAdapter;
import com.example.imageloaderapp.constants.Constants;
import com.example.imageloaderapp.fullscreenmageactivity.FullScreenImageActivity;
import com.example.imageloaderapp.model.Image;

import java.util.ArrayList;
import java.util.List;

public class ImageListFragment extends Fragment {


    ArrayList<Image> images = new ArrayList<>();
    private ImageLisViewModel mViewModel;
    private RecyclerView imageListView;
    private ImageListAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_image_list, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setUp();
    }

    private void setUp() {
        imageListView = getView().findViewById(R.id.image_list);
        initializeViewModel();
        initializeRecyclerView();
        initializeObserver();
    }

    private void initializeViewModel() {
        mViewModel = ViewModelProviders.of(this).get(ImageLisViewModel.class);
        mViewModel.init();
    }

    private void initializeObserver() {
        mViewModel.getImagesList().observe(this, new Observer<List<Image>>() {
            @Override
            public void onChanged(List<Image> imagesList) {
                List<Image> list = imagesList;
                images.addAll(list);
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void initializeRecyclerView() {
        adapter = new ImageListAdapter(getActivity(), images, new ImageListAdapter.ImageClickListener() {

            @Override
            public void onClick(Image item) {
                Intent intent = new Intent(getActivity(), FullScreenImageActivity.class);
                intent.putExtra(Constants.IMAGE_ID, item.getId());
                startActivity(intent);
            }
        });
        imageListView.setAdapter(adapter);
        imageListView.setLayoutManager(new GridLayoutManager(getActivity(), Constants.COLOUMN_COUNT));
    }

}
