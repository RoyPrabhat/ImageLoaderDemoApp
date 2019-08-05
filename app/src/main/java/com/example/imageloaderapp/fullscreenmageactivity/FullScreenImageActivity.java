package com.example.imageloaderapp.fullscreenmageactivity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.imageloaderapp.R;
import com.example.imageloaderapp.constants.Constants;

public class FullScreenImageActivity extends AppCompatActivity {

    private Toolbar myToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_image);
        setUp();
    }

    private void setUp() {
        setUpToolBar();
        setUpFragment();
    }

    public void setUpToolBar() {
        myToolbar = findViewById(R.id.my_full_screen_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setUpFragment() {

        String imageId = getIntent().getStringExtra(Constants.IMAGE_ID);

        FullScreenImageFragment fullScreenImageFragment = new FullScreenImageFragment();
        Bundle args = new Bundle();
        args.putString(Constants.IMAGE_ID, imageId);
        fullScreenImageFragment.setArguments(args);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.full_screen_image, fullScreenImageFragment);
        transaction.commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
