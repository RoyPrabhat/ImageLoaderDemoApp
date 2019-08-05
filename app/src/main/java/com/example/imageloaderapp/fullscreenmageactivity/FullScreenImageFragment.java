package com.example.imageloaderapp.fullscreenmageactivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.example.imageloaderapp.R;
import com.example.imageloaderapp.constants.Constants;
import com.example.imageloaderapp.model.Image;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

public class FullScreenImageFragment extends Fragment {

    private FullScreenViewModel mViewModel;
    private ImageView imageView;
    private Button cancel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_full_screen, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setUp();
    }

    private void setUp() {
        Bundle args = getArguments();
        final String imageId = args.getString(Constants.IMAGE_ID, Constants.EMPTY_STRING);
        imageView = getView().findViewById(R.id.full_screen_image_view);
        setUpVieModel(imageId);
        setUpObservers();
        setUpClickListeners();

    }

    private void setUpVieModel(String imageId) {
        mViewModel = ViewModelProviders.of(this).get(FullScreenViewModel.class);
        mViewModel.setImageId(imageId);
        mViewModel.init();
    }

    private void setUpObservers() {
        mViewModel.getImageById().observe(this, new Observer<Image>() {
            @Override
            public void onChanged(Image response) {
                Picasso.with(getActivity()).load(response.getUrls().getFull())
                        .placeholder(R.drawable.loading)
                        .error(R.drawable.error)
                        .fit().into(imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        cancel.setEnabled(false);
                    }

                    @Override
                    public void onError() {
                        Toast.makeText(getContext(), Constants.ERROR_MESSAGE, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    private void setUpClickListeners() {
        cancel = getView().findViewById(R.id.cancel_btn);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Picasso.with(getContext())
                        .cancelRequest(imageView);
                imageView.setImageDrawable(getResources().getDrawable( R.drawable.cancel));
            }
        });
    }


}
