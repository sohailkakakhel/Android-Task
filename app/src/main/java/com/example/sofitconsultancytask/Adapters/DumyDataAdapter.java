package com.example.sofitconsultancytask.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sofitconsultancytask.ApiResponse.DumyDataResponse;
import com.example.sofitconsultancytask.R;

import java.util.List;

public class DumyDataAdapter extends RecyclerView.Adapter<DumyDataAdapter.ViewHolder> {
    List<DumyDataResponse> dumyDataResponseList;
    Context context;

    public DumyDataAdapter(List<DumyDataResponse> dumyDataResponseList, Context context) {
        this.dumyDataResponseList = dumyDataResponseList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dumydatalist, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        DumyDataResponse dumyDataResponse = dumyDataResponseList.get(position);
        holder.tv_userId.setText("User Id: " + dumyDataResponse.getUserId().toString());
        holder.tv_Id.setText("Id: " + dumyDataResponse.getId().toString());
        holder.tv_title.setText("Title: " + dumyDataResponse.getTitle());
        holder.tv_body.setText("Body: " + dumyDataResponse.getBody());

    }

    @Override
    public int getItemCount() {
        return dumyDataResponseList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tv_userId;
        TextView tv_Id;
        TextView tv_title;
        TextView tv_body;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_userId = itemView.findViewById(R.id.tv_userId);
            tv_Id = itemView.findViewById(R.id.tv_Id);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_body = itemView.findViewById(R.id.tv_body);
        }
    }
}
