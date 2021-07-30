package com.example.sofitconsultancytask.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sofitconsultancytask.R;

public class ServicesAdapter extends RecyclerView.Adapter<ServicesAdapter.MyViewholder> {

    Context context;

    public ServicesAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.services_item, parent, false);
        return new MyViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class MyViewholder extends RecyclerView.ViewHolder{
        public MyViewholder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
