package com.example.imageloaderapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.example.imageloaderapp.R;
import com.example.imageloaderapp.model.Image;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ImageListAdapter extends RecyclerView.Adapter<ImageListAdapter.MyViewHolder> {

    public interface ImageClickListener {
        void onClick(Image item);
    }

    private LayoutInflater inflater;
    private ArrayList<Image> imageList;
    private final ImageClickListener listener;
    private FragmentActivity context;


    public ImageListAdapter(FragmentActivity context, ArrayList<Image> imageList, ImageClickListener listener) {
        inflater = LayoutInflater.from(context);
        this.imageList = imageList;
        this.listener = listener;
        this.context = context;
    }

    @Override
    public ImageListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.layout_image_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ImageListAdapter.MyViewHolder holder, int position) {
        Picasso.with(context).load(imageList.get(position).getUrls().getThumb())
                .placeholder(R.drawable.loading)
                .error(R.drawable.error)
                .fit().into(holder.movieImage);
        holder.bind(imageList.get(position), listener);
    }

    @Override
    public int getItemCount() {
        if (imageList == null) {
            return 0;
        } else {
            return imageList.size();
        }
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView movieName;
        ImageView movieImage;

        public MyViewHolder(View itemView) {
            super(itemView);
            movieImage = itemView.findViewById(R.id.image);
        }


        public void bind(final Image item, final ImageClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(item);
                }
            });
        }
    }
}