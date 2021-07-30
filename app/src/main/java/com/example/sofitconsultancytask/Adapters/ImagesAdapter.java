package com.example.sofitconsultancytask.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sofitconsultancytask.ModelClasses.ImagesModel;
import com.example.sofitconsultancytask.R;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;

public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.MyViewHolder> {

    ArrayList<ImagesModel> arrayList;
    Context context;

    public ImagesAdapter(ArrayList<ImagesModel> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.images_layout, parent, false);
        return new ImagesAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        ImagesModel model = arrayList.get(position);
        holder.iv_image.setImageResource(model.getImageId());
        holder.tv_description.setText(model.getDescription());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        RoundedImageView iv_image;
        TextView tv_description;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
           iv_image = itemView.findViewById(R.id.iv_image);
           tv_description = itemView.findViewById(R.id.tv_description);
        }
    }
}
